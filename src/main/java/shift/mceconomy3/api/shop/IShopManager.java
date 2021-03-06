package shift.mceconomy3.api.shop;

import java.util.ArrayList;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import shift.mceconomy3.api.shop.purchase.IPurchaseItem;

/**
 * Shopを管理するClass
 * @author Shift02
 */
public interface IShopManager {

    public int registerShop(IShop list);

    public IShop getShop(int id);

    public int getShopID(IShop list);

    public ArrayList<IShop> getShops();

    public void openShopGui(int id, EntityPlayer player, World world, int x, int y, int z);

    public void openShopGui(IShop list, EntityPlayer player, World world, int x, int y, int z);

    public void addPurchaseItem(IPurchaseItem purchaseItem);

    public void addPurchaseItem(ItemStack par1ItemStack, Integer par2Integer);

    public void addPurchaseItem(String par1String, Integer par2Integer);

    public int getPurchase(ItemStack item);

    public boolean hasPurchase(ItemStack item);

    public void addPurchaseFluid(Fluid fluid, double mp);

    public double getFluidPurchase(Fluid fluid);

    public boolean hasFluidPurchase(Fluid fluid);

    public void addPurchaseEntity(Class<? extends Entity> class1, int mp);

    public int getEntityPurchase(Entity entity);

    public boolean hasEntityPurchase(Entity entity);

}
