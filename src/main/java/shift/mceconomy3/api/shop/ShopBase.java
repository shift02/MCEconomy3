package shift.mceconomy3.api.shop;

import java.util.ArrayList;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.FMLContainer;
import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.common.InjectedModContainer;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.ModContainer;

public class ShopBase implements IShop {

    private ResourceLocation registryName;
    private String name;
    private ArrayList<IProduct> list;

    public ShopBase(String name) {
        this.name = name;
        this.list = new ArrayList<>();
        this.setRegistryName(name);
    }

    @Override
    public ResourceLocation getRegistryName() {
        return registryName;
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

    public final void setRegistryName(String name)
    {

        int index = name.lastIndexOf(':');
        String oldPrefix = index == -1 ? "" : name.substring(0, index);
        name = index == -1 ? name : name.substring(index + 1);
        ModContainer mc = Loader.instance().activeModContainer();
        String prefix = mc == null || (mc instanceof InjectedModContainer && ((InjectedModContainer)mc).wrappedContainer instanceof FMLContainer) ? "minecraft" : mc.getModId().toLowerCase();
        if (!oldPrefix.equals(prefix) && oldPrefix.length() > 0)
        {
            FMLLog.bigWarning("Dangerous alternative prefix `{}` for name `{}`, expected `{}` invalid registry invocation/invalid name?", oldPrefix, name, prefix);
            prefix = oldPrefix;
        }
        this.registryName = new ResourceLocation(prefix, name);
        return ;
    }

}
