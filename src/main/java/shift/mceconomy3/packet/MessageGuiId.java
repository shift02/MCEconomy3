package shift.mceconomy3.packet;

import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import shift.mceconomy3.MCEconomy3;

public class MessageGuiId implements IMessageHandler<PacketGuiId, IMessage>{

	@Override
	public IMessage onMessage(PacketGuiId message, MessageContext ctx) {

		EntityPlayerMP p = ctx.getServerHandler().player;

		int i = message.getData().getInteger("gui");

		p.openGui(MCEconomy3.instance, i, p.world, (int)p.posX, (int)p.posY, (int)p.posZ);

		return null;

	}
}
