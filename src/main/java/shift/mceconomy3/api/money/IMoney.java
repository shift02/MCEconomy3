package shift.mceconomy3.api.money;

import net.minecraftforge.energy.EnergyStorage;

/**
 * MPを管理するインターフェイス。
 * <p>
 * ItemStackやTileEntity、EntityもWorldもすべてこれを持っている。
 * MCEconomyはEnumFacingをnullでセットしている
 * 実際の実装例は {@link MoneyStorage} を参考にする
 * @author Shift02
 *
 */
public interface IMoney {

	/**
	 * MPをストレージに追加する
	 *
	 * @param 追加する最大額
	 * @param シミュレーションかどうか。Trueなら実際に値は変化しない
	 *
	 * @return 実際に追加できた額
	 */
	int receiveMoney(int maxReceive, boolean simulate);

	/**
	 * MPをストレージから減らす
	 *
	 * @param 減らす最大額
	 * @param シミュレーションかどうか。Trueなら実際に値は変化しない
	 * @return 実際に減らせれた額
	 */
	int extractMoney(int maxExtract, boolean simulate);

	/**
	 * 現在持っているMPの額
	 */
	int getMoneyStored();

	/**
	 * 貯めれるMPの最大
	 */
	int getMaxMoneyStored();

	/**
	 * MPをストレージに設定する
	 * @deprecated 出来れば使用してほしくない(将来の更新で消すことはないです)
	 * @param money
	 */
	void setMoneyStored(int money);


	/**
	 * MPを追加することができるか。これがfalseの場合 receiveMoney() を呼んだ時に0を返す
	 */
	boolean canReceive();

	/**
	 * MPを減らすことができるか。これがfalseの場合 extractMoney() を呼んだ時に0を返す
	 */
	boolean canExtract();

}
