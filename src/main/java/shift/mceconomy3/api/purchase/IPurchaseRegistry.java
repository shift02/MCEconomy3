package shift.mceconomy3.api.purchase;

import net.minecraft.item.ItemStack;

public interface IPurchaseRegistry {

    public <T> void addPurchase(IPurchase<T> purchase, Class<T> purchaseClass);

    /**
     * addPurchaseItem アイテムの買い取り価格を判定するクラスを登録
     * @param purchaseItem 登録するIPurchaseItemクラス
     */
    public void addPurchaseItem(IPurchaseItem purchaseItem);

    /**
     * addPurchaseItem Mobなどがアイテムを買い取る価格をItemStackで登録
     * @param PurchaseItem 買い取りアイテム
     * @param amount 価格  -1で非売品に設定出来ます
     */
    public void addPurchaseItem(ItemStack PurchaseItem, int amount);

    /**
     * addPurchaseItem Mobなどがアイテムを買い取る価格を鉱石辞書名で登録
     * @param oreName 買い取り対象となる鉱石辞書名
     * @param amount 価格  -1で非売品に設定出来ます
     */
    public void addPurchaseItem(String oreName, int amount);

    /**
     * addPurchaseItem 液体の買い取り価格を判定するクラスを登録
     * @param purchaseItem 登録するIPurchaseFluidクラス
     */
    public void addPurchaseFluid(IPurchaseFluid purchaseFluid);

    public int getPurchase(Object object);

}
