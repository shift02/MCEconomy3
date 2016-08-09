package shift.mceconomy3.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.fml.common.eventhandler.Event.Result;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import shift.mceconomy3.Config;
import shift.mceconomy3.EntityPropertieMP;
import shift.mceconomy3.api.MCEconomyAPI;

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
	public void onEntityConstructing(AttachCapabilitiesEvent.Entity event) {

		if (event.getEntity() instanceof EntityPlayer) {

			event.addCapability(MPManager.r, new EntityPropertieMP());
			//event.getEntity().registerExtendedProperties(MPManager.STATUS,new EntityPropertieMP());
		}

	}

	@SubscribeEvent
	/* ワールドに入った時に呼ばれるイベント。 */
	public void onEntityJoinWorld(EntityJoinWorldEvent event) {

		if (!event.getEntity().worldObj.isRemote && event.getEntity() instanceof EntityPlayer) {

			MPManager.loadProxyData((EntityPlayer) event.getEntity());

		}
	}

	@SubscribeEvent
	public void onPlayerChangedDimension(PlayerEvent.PlayerChangedDimensionEvent event) {
		// プレイヤーがディメンション間を移動したときの処理

		if (!event.player.worldObj.isRemote) {
			MPManager.loadProxyData((EntityPlayer) event.player);

			// this.sendOtherPlayer(event.player);
		}

	}

	@SubscribeEvent
	public void onPlayerRespawn(PlayerEvent.PlayerRespawnEvent event) {
		// プレイヤーがリスポーンした時の処理
		// System.out.println("onPlayerRespawn");
		if (!event.player.worldObj.isRemote) {

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
		if (event.getSource().getSourceOfDamage() == null || event.getSource().getEntity() == null) {
			return;
		}

		// ダメージソースがプレイヤーの場合はMP加算する
		if (event.getSource().getSourceOfDamage() instanceof EntityPlayerMP) {

			EntityPlayerMP entityPlayer = (EntityPlayerMP) event.getSource().getSourceOfDamage();

			if (MCEconomyAPI.ShopManager.hasEntityPurchase(event.getEntityLiving())) {
				MCEconomyAPI.addPlayerMP(entityPlayer, MCEconomyAPI.ShopManager.getEntityPurchase(event.getEntityLiving()), false);
				//if (Config.sound) entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "mceconomy2:coin", 0.6f, 0.8f);
			}

		} else if (event.getSource().getEntity() instanceof EntityPlayerMP) {
			EntityPlayerMP entityPlayer = (EntityPlayerMP) event.getSource().getEntity();

			if (MCEconomyAPI.ShopManager.hasEntityPurchase(event.getEntityLiving())) {
				MCEconomyAPI.addPlayerMP(entityPlayer, MCEconomyAPI.ShopManager.getEntityPurchase(event.getEntityLiving()), false);
				//if (Config.sound) entityPlayer.worldObj.playSoundAtEntity(entityPlayer, "mceconomy2:coin", 0.6f, 0.8f);
			}
		}
	}

}
