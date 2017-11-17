package shift.mceconomy3.api.shop.purchase;

/**
 * ItemStackやEntityに値段設定をするクラス
 * TにItemStackとかを設定
 * @author shift02
 *
 * @param <T>
 */
public interface IPurchase<T> {

	/**
	 * 価格決定の優先度 <br>
	 * 0に近いほど優先される<br>
	 * デフォルト 5 <br>
	 * @return
	 */
	public int getPriority();

	/**
	 * 引数のObjectがこのインスタンスで扱っているかを返す
	 * @param object
	 * @return trueの場合、このクラスで処理できる
	 */
	public boolean isMatch(T object);

	/**
	 * 引数のobjectの売却価格を返す
	 * @param object
	 * @return 売却価格
	 */
	public int getPrice(T object);

}
