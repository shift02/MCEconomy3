package shift.mceconomy3.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import shift.mceconomy3.EntityPropertieMP;
import shift.mceconomy3.MCEconomy3;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.packet.PacketHandler;
import shift.mceconomy3.packet.PacketPlayerLogin;

public class CommonEventManager {

    /*
    @SubscribeEvent
    public void onEntityConstructing(EntityConstructing event) {

    	if (event.getEntity() instanceof EntityPlayer) {
    		event.getEntity().registerExtendedProperties(MPManager.STATUS,
    				new EntityPropertieMP());
    	}

    }*/

    @SubscribeEvent
    public void onEntityConstructing(AttachCapabilitiesEvent<Entity> event) {

        if (event.getObject() instanceof EntityPlayer) {

            event.addCapability(MPManager.r, new EntityPropertieMP((EntityPlayer) event.getObject()));
            //event.getEntity().registerExtendedProperties(MPManager.STATUS,new EntityPropertieMP());
        }

    }

    @SubscribeEvent
    /* ワールドに入った時に呼ばれるイベント。 */
    public void onEntityJoinWorld(EntityJoinWorldEvent event) {

    	if(event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer){
    		PacketHandler.INSTANCE.sendToServer(new PacketPlayerLogin());
    	}

        if (!event.getEntity().world.isRemote && event.getEntity() instanceof EntityPlayer) {

            MPManager.loadProxyData((EntityPlayer) event.getEntity());

        }
    }

    @SubscribeEvent
    /* ログインした時に呼ばれるイベント。 */
    public void onPlayerLoggedInEvent(PlayerLoggedInEvent event) {

        if (!event.player.world.isRemote) {

            MPManager.loadProxyData((EntityPlayer) event.player);

        }
    }



    @SubscribeEvent
    public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
        // プレイヤーがディメンション間を移動したときの処理

        if (!event.player.world.isRemote) {
            MPManager.loadProxyData((EntityPlayer) event.player);

            // this.sendOtherPlayer(event.player);
        }

    }

    @SubscribeEvent
    public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
        // プレイヤーがリスポーンした時の処理
        // System.out.println("onPlayerRespawn");
        if (!event.player.world.isRemote) {

            MPManager.loadProxyData((EntityPlayer) event.player);

            // this.sendOtherPlayer(event.player);
        }

    }

    @SubscribeEvent
    public void onLivingDeath(LivingDeathEvent event) {

        // 別のMOD等でキャンセル済みの場合はなにもしない
        if (event.isCancelable() && event.isCanceled()) {
            return;
        }

        // 別のMOD等で不可とされた場合はなにもしない
        if (event.getResult() == Result.DENY) {
            return;
        }

        // なぜかダメージソースがnullだった場合はなにもしない
        if (event.getSource().getImmediateSource() == null || event.getSource().getTrueSource() == null) {
            return;
        }

        // ダメージソースがプレイヤーの場合はMP加算する
        if (event.getSource().getImmediateSource() instanceof EntityPlayerMP) {

            EntityPlayerMP entityPlayer = (EntityPlayerMP) event.getSource().getImmediateSource();

            if (MCEconomyAPI.ShopManager.hasEntityPurchase(event.getEntityLiving())) {
                MCEconomyAPI.addPlayerMP(entityPlayer, MCEconomyAPI.ShopManager.getEntityPurchase(event.getEntityLiving()), false);
                //if (Config.sound) entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "mceconomy2:coin", 0.6f, 0.8f);
            }

        } else if (event.getSource().getTrueSource() instanceof EntityPlayerMP) {
            EntityPlayerMP entityPlayer = (EntityPlayerMP) event.getSource().getTrueSource();

            if (MCEconomyAPI.ShopManager.hasEntityPurchase(event.getEntityLiving())) {
                MCEconomyAPI.addPlayerMP(entityPlayer, MCEconomyAPI.ShopManager.getEntityPurchase(event.getEntityLiving()), false);
                //if (Config.sound) entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "mceconomy2:coin", 0.6f, 0.8f);
            }
        }
    }

    @SubscribeEvent
    public void EntityInteract(PlayerInteractEvent.EntityInteract event) {

        if (!MCEconomy3.shopTest) return;

        MCEconomyAPI.openShopGui(MCEconomy3.testShop, event.getEntityPlayer(), event.getWorld(), (int) event.getEntityPlayer().posX,
                (int) event.getEntityPlayer().posY, (int) event.getEntityPlayer().posZ);

    }

}
