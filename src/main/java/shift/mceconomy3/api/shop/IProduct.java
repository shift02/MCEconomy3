package shift.mceconomy3.api.shop;

import javax.annotation.Nullable;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * 商品データクラス <br>
 * {@link IShop}で使用する
 *
 * @version 1.0.2
 * @author Shift02
 *
 */
public interface IProduct {

    /**
     * 商品自体
     * @return ItemStack
     */
    public ItemStack getItem(IShop shop, @Nullable World world, @Nullable EntityPlayer player);

    /**
     * 商品の値段 <br>
     * プレイヤーによって値段を変更したり出来る
     * @param player 購入しようとしているプレイヤー
     * @return 値段
     */
    public int getCost(IShop shop, @Nullable World world, @Nullable EntityPlayer player);

    /**
     * 商品を買えるかどうか
     * @param player 購入しようとしているプレイヤー
     * @return trueの時は購入できる
     */
    public boolean canBuy(IShop shop, @Nullable World world, @Nullable EntityPlayer player);

}
