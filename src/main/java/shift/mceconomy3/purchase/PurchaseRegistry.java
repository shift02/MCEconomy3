package shift.mceconomy3.purchase;

import net.minecraft.item.ItemStack;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.api.purchase.IPurchase;
import shift.mceconomy3.api.purchase.IPurchaseFluid;
import shift.mceconomy3.api.purchase.IPurchaseItem;
import shift.mceconomy3.api.purchase.IPurchaseRegistry;

public class PurchaseRegistry implements IPurchaseRegistry {

	@Override
	public void addPurchaseItem(IPurchaseItem purchaseItem) {

		MCEconomyAPI.addPurchaseItem(purchaseItem);

	}

	@Override
	public void addPurchaseItem(ItemStack PurchaseItem, int amount) {

		MCEconomyAPI.addPurchaseItem(PurchaseItem, amount);

	}

	@Override
	public void addPurchaseItem(String oreName, int amount) {

		MCEconomyAPI.addPurchaseItem(oreName, amount);

	}

	@Override
	public void addPurchase(IPurchase purchase) {

	}

	@Override
	public int getPurchase(Object object) {
		// TODO 自動生成されたメソッド・スタブ
		return 0;
	}

	@Override
	public void addPurchaseFluid(IPurchaseFluid purchaseFluid) {
		// TODO 自動生成されたメソッド・スタブ

	}

}
