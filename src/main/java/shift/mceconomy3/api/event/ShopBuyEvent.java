package shift.mceconomy3.api.event;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.player.PlayerEvent;

public class ShopBuyEvent extends PlayerEvent{

	public ItemStack buy;

	public ShopBuyEvent(EntityPlayer player, ItemStack buy) {
		super(player);
		this.buy = buy;
	}

}
