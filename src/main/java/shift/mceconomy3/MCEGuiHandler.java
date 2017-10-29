package shift.mceconomy3;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.api.shop.IShop;
import shift.mceconomy3.gui.ContainerShop;
import shift.mceconomy3.gui.GuiShop;

public class MCEGuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        IShop shop = MCEconomyAPI.SHOP_MANAGER.getShop(ID);

        if (shop != null) {

            //Event用ラッパークラスに差し替え
            //VariableProductList list = new VariableProductList(player, p);

            return new ContainerShop(player, shop, world);
        }
        return null;

    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {

        IShop shop = MCEconomyAPI.SHOP_MANAGER.getShop(ID);

        if (shop != null) {

            //Event用ラッパークラスに差し替え
            //VariableProductList list = new VariableProductList(player, p);

            return new GuiShop(player, shop, ID, world);
        }
        return null;

    }

}
