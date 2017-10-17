package shift.mceconomy3.packet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import shift.mceconomy3.event.MPManager;

public class PlayerLoginHandler  implements IMessageHandler<PacketPlayerLogin, IMessage>{

	@Override
	public IMessage onMessage(PacketPlayerLogin message, MessageContext ctx) {

		EntityPlayerMP player = ctx.getServerHandler().player;

		MPManager.loadProxyData((EntityPlayer) player);


		return null;
	}

}