package shift.mceconomy3.api.shop.purchase;

import net.minecraft.item.ItemStack;

/**
 * Created by plusplus_F on 2016/03/29.
 * アイテムの値段設定を処理するクラス <br>
 * このクラスによって基本の価格が決定された後にPriceEventが発生する
 */
public interface IPurchaseItem extends IPurchase<ItemStack>{

    /**
     * 価格決定の優先度 <br>
     * 0に近いほど優先される<br>
     * デフォルト 5 <br>
     * 鉱石辞書使用 8 <br>
     * @return
     */
    public int getPriority();

    /**
     * 引数のItemStackがこのインスタンスで扱っているかを返す
     * @param itemStack
     * @return trueの場合、このクラスで処理できる
     */
    public boolean isMatch(ItemStack itemStack);

    /**
     * 引数のItemStackの売却価格を返す
     * @param itemStack
     * @return 売却価格
     */
    public int getPrice(ItemStack itemStack);

}
