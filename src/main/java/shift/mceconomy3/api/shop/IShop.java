package shift.mceconomy3.api.shop;

import java.util.ArrayList;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import shift.mceconomy3.api.MCEconomyAPI;

/**
 *
 * MCE2仕様のショップを作成する時に使うクラス <br>
 * MCEconomyAPIクラスで登録する
 *
 * @author Shift02
 * @see MCEconomyAPI
 *
 */
public interface IShop {

    /**
     * ユニーク名
     * @return
     */
    public ResourceLocation getRegistryName();

    /**
     * ショップの名前 <br>
     * GUIで表示する時はI18n.format()を使ってローカライズされます
     * @return ショップの名前
     */
    public String getShopName(@Nullable World world, @Nullable EntityPlayer player);

    /**
     * ショップに商品を追加する
     * @param product 商品
     */
    public void addProduct(IProduct product);

    /**
     * ショップの商品一覧を取得
     * @param world
     * @param player
     * @return
     */
    public ArrayList<IProduct> getProductList(@Nullable World world, @Nullable EntityPlayer player);

}
