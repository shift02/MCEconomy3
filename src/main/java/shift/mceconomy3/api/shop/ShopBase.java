package shift.mceconomy3.api.shop;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;

public class ShopBase implements IShop {

    private String name;
    private ArrayList<IProduct> list;

    public ShopBase(String name) {
        this.name = name;
        this.list = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getShopName(World world, EntityPlayer player) {
        return name;
    }

    @Override
    public void addProduct(IProduct product) {
        list.add(product);

    }

    @Override
    public ArrayList<IProduct> getProductList(World world, EntityPlayer player) {
        return list;
    }

}
