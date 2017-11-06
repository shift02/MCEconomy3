package shift.mceconomy3.purchase;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import net.minecraft.item.ItemStack;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.api.purchase.IPurchase;
import shift.mceconomy3.api.purchase.IPurchaseFluid;
import shift.mceconomy3.api.purchase.IPurchaseItem;
import shift.mceconomy3.api.purchase.IPurchaseRegistry;

public class PurchaseRegistry implements IPurchaseRegistry {

    public Multimap<Class, IPurchase> purchases = ArrayListMultimap.create();

    @Override
    public void addPurchaseItem(IPurchaseItem purchaseItem) {

        MCEconomyAPI.SHOP_MANAGER.addPurchaseItem(purchaseItem);

    }

    @Override
    public void addPurchaseItem(ItemStack PurchaseItem, int amount) {

        MCEconomyAPI.SHOP_MANAGER.addPurchaseItem(PurchaseItem, amount);

    }

    @Override
    public void addPurchaseItem(String oreName, int amount) {

        MCEconomyAPI.SHOP_MANAGER.addPurchaseItem(oreName, amount);

    }

    @Override
    public <T> void addPurchase(IPurchase<T> purchase, Class<T> purchaseClass) {

        purchases.put(purchaseClass, purchase);

    }

    @Override
    public int getPurchase(Object object) {

        return -1;
    }

    @Override
    public void addPurchaseFluid(IPurchaseFluid purchaseFluid) {

    }

}
