package shift.mceconomy3.packet;

import net.minecraft.inventory.Container;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import shift.mceconomy3.gui.ContainerShop;

public class ShopButtonHandler implements IMessageHandler<PacketShopButton, IMessage>{

	@Override
	public IMessage onMessage(PacketShopButton message, MessageContext ctx) {

		Container container = ctx.getServerHandler().playerEntity.openContainer;

    	if (container instanceof ContainerShop)
        {
            ((ContainerShop)container).setCurrentRecipeIndex(message.getCurrentRecipeIndex());
        }

		return null;
	}

}
