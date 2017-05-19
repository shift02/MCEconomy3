package shift.mceconomy3.packet;

import io.netty.buffer.ByteBuf;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;

public class PacketPlayerLogin implements IMessage {

	private int  ok;

	public PacketPlayerLogin()
	{
	}

	/*
	 * パケットの生成には通常こちらを用いる.
	 */
	public PacketPlayerLogin(int  ok)
	{
		this.ok = ok;
	}

	@Override
	public void fromBytes(ByteBuf buf) {

		/*DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(buf.array()));

        try {
        	currentRecipeIndex = datainputstream.readInt();
		} catch (IOException e) {
			e.printStackTrace();
		}*/
		ok = buf.readInt();


	}

	@Override
	public void toBytes(ByteBuf buf) {

		buf.writeInt(ok);

	}

	public int getOk() {
		return ok;
	}

	public void setOk(int ok) {
		this.ok = ok;
	}

}
