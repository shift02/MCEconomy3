package shift.mceconomy3.api.purchase;

@PurchaseItems
public class PurchaseVanilla {

	@PurchaseItems.EventHandler
	public void registerPurchaseItems(IPurchaseRegistry registry) {

		//ここに登録処理
		//registry.addPurchaseItem(new ItemStack(Blocks.STONE), 1);

	}

}
