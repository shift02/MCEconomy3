package shift.mceconomy3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

import com.google.common.collect.Maps;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.Fluid;
import shift.mceconomy3.api.event.PriceEvent;
import shift.mceconomy3.api.shop.IShop;
import shift.mceconomy3.api.shop.IShopManager;
import shift.mceconomy3.api.shop.purchase.IPurchaseItem;
import shift.mceconomy3.api.shop.purchase.PurchaseItemStack;
import shift.mceconomy3.api.shop.purchase.PurchaseOreDictionary;
import shift.mceconomy3.packet.PacketGuiId;
import shift.mceconomy3.packet.PacketHandler;

public class ShopManager implements IShopManager {

    //private final ArrayList<IProductList> ProductList = new ArrayList<IProductList>();

    private final ArrayList<IShop> shopList = new ArrayList<IShop>();
    private final HashMap<ResourceLocation, Integer> shopIDs = Maps.newHashMap();

    private static final ArrayList<IPurchaseItem> purchaseItems = new ArrayList<IPurchaseItem>();
    private static IPurchaseItem cachedItem;
    private static boolean hasSort = false;

    private static PurchaseComparable purchaseComparable = new PurchaseComparable();

    private static final HashMap<Integer, Double> purchaseFluidList = new HashMap<Integer, Double>();

    private static final HashMap<Class<? extends Entity>, Integer> purchaseEntityList = new HashMap<Class<? extends Entity>, Integer>();

    public ShopManager() {

        shopList.add(null);
        shopList.add(null);

    }

    //shop関係
    @Override
    public int registerShop(IShop list) {

        shopList.add(list);

        int index = shopList.indexOf(list);

        shopIDs.put(list.getRegistryName(), Integer.valueOf(index));

        return index;

    }

    @Override
    public IShop getShop(int id) {

        if (shopList.size() < id) {
            return null;
        }
        return shopList.get(id);
    }

    @Override
    public int getShopID(IShop list) {

        Integer id = shopIDs.get(list.getRegistryName());

        if (id == null) {
            throw new IllegalStateException("It is an unregistered shop! Name: " + list.getRegistryName());
        }

        return id;
    }

    @Override
    public ArrayList<IShop> getShops() {
        return shopList;
    }

    //ショップ関係

    @Override
    public void openShopGui(int id, EntityPlayer player, World world, int x, int y, int z) {

        /*OpenShopGuiEvent event = new OpenShopGuiEvent(player, id, world, x, y, z);
        
        if (MinecraftForge.EVENT_BUS.post(event))
        {
            return;
        }
        
        if (event.getResult() == Result.ALLOW)
        {
            return ;
        }*/

        if (world.isRemote) {
            PacketHandler.INSTANCE.sendToServer(new PacketGuiId(id));
        } else {
            player.openGui(MCEconomy3.instance, id, world, x, y, z);
        }

    }

    @Override
    public void openShopGui(IShop list, EntityPlayer player, World world, int x, int y, int z) {

        this.openShopGui(this.getShopID(list), player, world, x, y, z);

    }

    @Override
    public void addPurchaseItem(IPurchaseItem purchaseItem) {
        purchaseItems.add(purchaseItem);

        this.hasSort = true;

    }

    @Override
    public void addPurchaseItem(ItemStack par1ItemStack, Integer par2Integer) {
        this.addPurchaseItem(new PurchaseItemStack(par1ItemStack, par2Integer));
    }

    @Override
    public void addPurchaseItem(String par1String, Integer par2Integer) {
        this.addPurchaseItem(new PurchaseOreDictionary(par1String, par2Integer));
    }

    @Override
    public int getPurchase(ItemStack item) {

        if (item == null) {
            return -2;
        }

        IPurchaseItem purchaseItem = null;
        if (cachedItem != null && cachedItem.isMatch(item)) {

            purchaseItem = cachedItem;

        } else {

            if (this.hasSort) {
                Collections.sort(purchaseItems, new PurchaseComparable());
                hasSort = false;
            }

            for (IPurchaseItem it : purchaseItems) {

                if (it.isMatch(item)) {

                    purchaseItem = it;

                    if (it.getPriority() <= 5) {
                        cachedItem = it;
                    } else {
                        cachedItem = null;
                    }

                    break;
                }

            }

        }

        if (purchaseItem == null)
            return -2;

        int old = purchaseItem.getPrice(item);

        PriceEvent event = new PriceEvent(item, old);
        event.setNewPrice(old);

        MinecraftForge.EVENT_BUS.post(event);

        if (old != event.getNewPrice())
            return event.getNewPrice();

        return old;
    }

    @Override
    public boolean hasPurchase(ItemStack item) {
        int t = getPurchase(item);
        return t != -1 && t != -2;
    }

    @Override
    public void addPurchaseFluid(Fluid fluid, double mp) {
        if (fluid == null)
            return;
        //purchaseFluidList.put(fluid.getID(), mp);
    }

    @Override
    public double getFluidPurchase(Fluid fluid) {

        //if (fluid == null) {
        //    return -2;
        //}
        //if (!purchaseFluidList.containsKey(fluid.getID())) {
        //    return -2;
        //}

        return -1;

        //return purchaseFluidList.get(fluid.getID());
    }

    @Override
    public boolean hasFluidPurchase(Fluid fluid) {
        return (this.getFluidPurchase(fluid) != -1 && this.getFluidPurchase(fluid) != -2);
    }

    @Override
    public void addPurchaseEntity(Class<? extends Entity> class1, int mp) {

        purchaseEntityList.put(class1, mp);

    }

    @Override
    public int getEntityPurchase(Entity entity) {

        if (entity == null) {
            return -2;
        }
        if (!purchaseEntityList.containsKey(entity.getClass())) {
            return -2;
        }

        return purchaseEntityList.get(entity.getClass());

    }

    @Override
    public boolean hasEntityPurchase(Entity entity) {
        return (this.getEntityPurchase(entity) != -1 && this.getEntityPurchase(entity) != -2);
    }

    public static class PurchaseComparable implements Comparator<IPurchaseItem> {

        @Override
        public int compare(IPurchaseItem o1, IPurchaseItem o2) {

            if (o1.getPriority() > o2.getPriority()) {
                return 1;
            } else if (o1.getPriority() < o2.getPriority()) {
                return -1;
            } else {
                return 0;
            }
        }

    }

}
