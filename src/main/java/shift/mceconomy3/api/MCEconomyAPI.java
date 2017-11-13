package shift.mceconomy3.api;

import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntitySilverfish;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityBat;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import shift.mceconomy3.api.purchase.IPurchaseItem;
import shift.mceconomy3.api.purchase.IPurchaseRegistry;
import shift.mceconomy3.api.shop.IShop;
import shift.mceconomy3.api.shop.IShopManager;

/**
 * MCEconomyのAPI <br>
 * MCEconomyとのやりとりはこのClassのメソッドを使用する(他の場合は互換性の保証が出来ない)
 * @since 1.0.0
 * @version 2.0.0
 * @author Shift02
 */
public class MCEconomyAPI {

    public static String MODID = "mceconomy3";

    public static IMPManager MPManager;

    public static ISoundManager SoundManager;

    public static IShopManager SHOP_MANAGER;

    public static IPurchaseRegistry PurchaseRegistry;

    static {
        //registerPurchaseItem();
    }

    /*
     *--------------------------------------
     *  Minecraft Point
     *--------------------------------------
     */

    /**
     * addPlayerMP 指定したプレイヤーのMPを追加
     * @param entityPlayer MPを追加するプレイヤー
     * @param amount MPの額
     * @return 実際に追加できたMPの額
     */
    public static int addPlayerMP(EntityPlayer entityPlayer, int amount, boolean simulation) {
        return MPManager.addPlayerMP(entityPlayer, amount, simulation);
    }

    /**
     * reducePlayerMP 指定したプレイヤーのMPを削減
     * @param entityPlayer MPを削減するプレイヤー
     * @param amount MPの額
     * @return 実際に削減できたMPの額
     */
    public static int reducePlayerMP(EntityPlayer entityPlayer, int amount, boolean simulation) {
        return MPManager.reducePlayerMP(entityPlayer, amount, simulation);
    }

    /**
     * setPlayerMP  指定したプレイヤーのMPを設定
     * @param entityPlayer MPを設定するプレイヤー
     * @param amount MPの額
     */
    public static void setPlayerMP(EntityPlayer entityPlayer, int amount) {
        MPManager.setPlayerMP(entityPlayer, amount);
    }

    /**
     * getPlayerMP 指定したプレーヤーの所持金額を返す
     * @param entityPlayer MPを所持するプレイヤー
     * @return プレイヤーの所持しておるMP量
     */
    public static int getPlayerMP(EntityPlayer entityPlayer) {
        return MPManager.getPlayerMP(entityPlayer);
    }

    /*
     *--------------------------------------
     *  Shop
     *--------------------------------------
     */
    /**
     * registerProductList IShopを実装したClassを登録
     * @param shop 店屋データ
     * @see IShop
     * @return ShopID
     */
    public static int registerShop(IShop shop) {
        return SHOP_MANAGER.registerShop(shop);
    }

    /**
     * getProductList ShopIDからIShopを取得
     * @param id ShopID
     * @return IShop
     */
    public static IShop getShop(int id) {
        return SHOP_MANAGER.getShop(id);
    }

    /**
     * getShopID IShopからIDを取得
     * @param shop
     * @return ShopID
     */
    public static int getShopID(IShop shop) {
        return SHOP_MANAGER.getShopID(shop);
    }

    /**
     * openShopGui ShopのGUIを開く
     * @param id ShopID
     * @param player プレイヤー
     * @param world ワールド
     * @param x x軸
     * @param y y軸
     * @param z z軸
     */
    public static void openShopGui(int id, EntityPlayer player, World world, int x, int y, int z) {
        SHOP_MANAGER.openShopGui(id, player, world, x, y, z);
    }

    /**
     * addPurchaseItem アイテムの買い取り価格を判定するクラスを登録
     * @param purchaseItem 登録するIPurchaseItemクラス
     */
    public static void addPurchaseItem(IPurchaseItem purchaseItem) {
        PurchaseRegistry.addPurchaseItem(purchaseItem);
    }

    /**
     * addPurchaseItem Mobなどがアイテムを買い取る価格をItemStackで登録
     * @param PurchaseItem 買い取りアイテム
     * @param amount 価格  -1で非売品に設定出来ます
     */
    public static void addPurchaseItem(ItemStack PurchaseItem, int amount) {
        PurchaseRegistry.addPurchaseItem(PurchaseItem, amount);
    }

    /**
     * addPurchaseItem Mobなどがアイテムを買い取る価格を鉱石辞書名で登録
     * @param oreName 買い取り対象となる鉱石辞書名
     * @param amount 価格  -1で非売品に設定出来ます
     */
    public static void addPurchaseItem(String oreName, int amount) {
        PurchaseRegistry.addPurchaseItem(oreName, amount);
    }

    /**
     * getPurchase アイテムの買い取り額を取得
     * @param item 売るアイテム
     * @return 価格
     */
    public static int getPurchase(ItemStack item) {
        return SHOP_MANAGER.getPurchase(item);
    }

    /**
     * hasPurchase アイテムに価格が設定されているか
     * @param item 調べるアイテム
     * @return 設定されていればtrue 非売品はfalseになります.
     */
    public static boolean hasPurchase(ItemStack item) {
        return SHOP_MANAGER.hasPurchase(item);
    }

    /**
     * addPurchaseItem Mobなどが流体を買い取る価格を登録
     * @param fluid 買い取る流体
     * @param mp 価格(1mB)  -1で非売品に設定出来ます
     */
    public static void addPurchaseFluid(Fluid fluid, double mp) {
        SHOP_MANAGER.addPurchaseFluid(fluid, mp);
    }

    /**
     * getPurchase 流体の買い取り額を取得
     * @param fluid 売る流体
     * @return 価格(1mB)
     */
    public static double getFluidPurchase(Fluid fluid) {
        return SHOP_MANAGER.getFluidPurchase(fluid);
    }

    /**
     * hasPurchase 流体に価格が設定されているか
     * @param fluid 調べる流体
     * @return 設定されていればtrue 非売品はfalseになります.
     */
    public static boolean hasFluidPurchase(Fluid fluid) {
        return SHOP_MANAGER.hasFluidPurchase(fluid);
    }

    /**
     * registerPurchaseItem API読み込み時にバニラアイテムの価格が自動で設定される。
     * MODアイテムにMPを設定する時の参考にしてください。
     */
    public static void registerPurchaseItem() {

        //Itemは shift.mceconomy3.api.purchase.PurchaseVanilla に移動

        //液体
        addPurchaseFluid(FluidRegistry.WATER, 0.0001);
        addPurchaseFluid(FluidRegistry.LAVA, 0.01);

        //Entity
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityZombie.class, 2);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntitySkeleton.class, 5);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityCreeper.class, 6);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityEnderman.class, 13);

        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntitySilverfish.class, 40);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityWitch.class, 32);

        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityGhast.class, 24);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityBlaze.class, 8);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityPigZombie.class, 6);

        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityPlayer.class, -1);

        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityVillager.class, 22);

        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityBat.class, 300);

        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityDragon.class, 7400);
        MCEconomyAPI.SHOP_MANAGER.addPurchaseEntity(EntityWither.class, 3600);

    }

    /*
     *--------------------------------------
     *  Sound
     *--------------------------------------
     */
    public static void playCoinSoundEffect(World world, int x, int y, int z) {
        SoundManager.playCoinSoundEffect(world, x, y, z);
    }

}
