package shift.mceconomy3.api.shop;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.Event;

/**
 * ショップの商品を動的に操作するEvent <br>
 * ショップのGUIが表示されるタイミングで呼ばれる。
 * @version 1.0.0
 * @author Shift02
 */
@Deprecated
public class ProductEvent extends Event {

    public final EntityPlayer entityPlayer;

    private final IProductList list;

    /**
     * 新しい商品List これを操作すると商品が変わる
     */
    public final ArrayList<IProductItem> productList;

    public ProductEvent(EntityPlayer player, IProductList list) {
        this.entityPlayer = player;
        this.list = list;
        this.productList = (ArrayList<IProductItem>) list.getProductList().clone();
    }

    public IProductList getIProductList() {
        return this.list;
    }

}
