package shift.mceconomy3.packet;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import shift.mceconomy3.MCEconomy3;
import shift.mceconomy3.event.MPManager;

public class MessagePlayerProperties implements IMessage, IMessageHandler<MessagePlayerProperties, IMessage>{

	private NBTTagCompound data;

    public MessagePlayerProperties(){}

    public MessagePlayerProperties(EntityPlayer entityPlayer) {
    	this(entityPlayer,false);
    }

    public MessagePlayerProperties(EntityPlayer entityPlayer,boolean init) {
    	this.data = MPManager.getEntityPropertieMP(entityPlayer).serializeNBT();
        data.setBoolean("init", init);
        //MPManager.getEntityPropertieMP(entityPlayer).saveNBTData(data);
    }

    @Override
    public void fromBytes(ByteBuf buf) {
        data = ByteBufUtils.readTag(buf);
    }

    @Override
    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeTag(buf, data);
    }

    @Override
    public IMessage onMessage(MessagePlayerProperties message, MessageContext ctx) {
        //Client側にIExtendedEntityPropertiesを渡す。
    	MPManager.getEntityPropertieMP(MCEconomy3.proxy.getClientPlayer()).deserializeNBT(message.data);
    	//MPManager.getEntityPropertieMP(MCEconomy3.proxy.getClientPlayer()).loadNBTData(message.data);
        //REPLYは送らないので、nullを返す。
        return null;
    }

}
