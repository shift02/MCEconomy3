package shift.mceconomy3;

import java.io.File;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.api.money.CapabilityMoneyStorage;
import shift.mceconomy3.api.shop.IShop;
import shift.mceconomy3.api.shop.ProductBase;
import shift.mceconomy3.api.shop.ShopBase;
import shift.mceconomy3.event.CommonEventManager;
import shift.mceconomy3.event.MPManager;
import shift.mceconomy3.gui.HUDMP;
import shift.mceconomy3.item.MCEItems;
import shift.mceconomy3.packet.PacketHandler;
import shift.mceconomy3.proxy.CommonProxy;
import shift.mceconomy3.purchase.PurchaseManager;

@Mod(modid = MCEconomy3.MODID, version = MCEconomy3.VERSION, dependencies = MCEconomy3.DEPENDENCY, updateJSON = MCEconomy3.UPDATE_JSON)
public class MCEconomy3 {

    public static final String MODID = "mceconomy3";
    public static final String VERSION = "1.0.4";

    public static final String UPDATE_JSON = "https://shift02.github.io/MCEconomy3/Update.json";

    public static final String DEPENDENCY = "";//"before:SextiarySector";

    @Mod.Instance(MCEconomy3.MODID)
    public static MCEconomy3 instance;

    @SidedProxy(clientSide = "shift.mceconomy3.proxy.ClientProxy", serverSide = "shift.mceconomy3.proxy.CommonProxy")
    public static CommonProxy proxy;

    public static int testShop;

    public static boolean shopTest = false;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {

        MCEconomyAPI.MODID = MCEconomy3.MODID;

        Config.ConfigRead(event);

        MinecraftForge.EVENT_BUS.register(new CommonEventManager());

        CapabilityMPHandler.register();

        CapabilityMoneyStorage.register();

        if (event.getSide().isClient()) {
            MinecraftForge.EVENT_BUS.register(new HUDMP());
        }
        PacketHandler.init(event);

        MCEconomyAPI.MPManager = MPManager.getInstance();
        MCEconomyAPI.SoundManager = new MCESoundManager();
        MCEconomyAPI.SHOP_MANAGER = new ShopManager();
        MCEconomyAPI.registerPurchaseItem();



        PurchaseManager.setPurchaseItems(event.getAsmData());

    }

    @EventHandler
    public void init(FMLInitializationEvent event) {

        MCEItems.initItem();

        /*
        MCEconomyAPI.MPManager = MPManager.getInstance();
        MCEconomyAPI.SoundManager = new MCESoundManager();
        MCEconomyAPI.ShopManager = new ShopManager();
        MCEconomyAPI.registerPurchaseItem();
        */

        //		int i = MCEconomyAPI.ShopManager.registerProductList(
        //
        //				new ProductList() {
        //
        //					@Override
        //					public String getProductListName() {
        //						return "[MCEconomy] Sample";
        //					}
        //
        //				});
        //
        //		MCEconomyAPI.ShopManager.getProductList(i).addItemProduct(new ProductItem(new ItemStack(Items.stick, 1), 10));
        //		MCEconomyAPI.ShopManager.getProductList(i).addItemProduct(new ProductItem(new ItemStack(Items.iron_ingot, 1), 30));
        //		MCEconomyAPI.ShopManager.getProductList(i).addItemProduct(new ProductItem(new ItemStack(Blocks.iron_block, 1), 130));

        IShop shop = new ShopBase("test");
        testShop = MCEconomyAPI.registerShop(shop);
        shop.addProduct(new ProductBase(new ItemStack(Items.APPLE), 500));
        shop.addProduct(new ProductBase(new ItemStack(Items.STICK), 500));

        NetworkRegistry.INSTANCE.registerGuiHandler(this, new MCEGuiHandler());

    }

    @EventHandler
    public void init(FMLPostInitializationEvent event) {
        PurchaseManager.registryPurchaseItems();
    }

}
