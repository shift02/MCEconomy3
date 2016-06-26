package shift.mceconomy3.packet;

import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

	/*
	 * MOD固有のSimpleNetworkWrapperを取得。 文字列は他のMODと被らないようにMOD_IDを指定しておくと良い
	 */
	public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("mceconomy2");

	public static void init(FMLPreInitializationEvent event) {
		/*
		 * Messageクラスの登録。 第一引数：IMessageHandlerクラス 第二引数：送るMessageクラス
		 * 第三引数：登録番号。255個まで 第四引数：ClientとServerのどちらに送るか。送り先
		 */
		INSTANCE.registerMessage(MessagePlayerProperties.class,MessagePlayerProperties.class, 0, Side.CLIENT);
		INSTANCE.registerMessage(ShopButtonHandler.class,PacketShopButton.class, 1, Side.SERVER);
		INSTANCE.registerMessage(MessageGuiId.class,PacketGuiId.class, 2, Side.SERVER);

	}

}
