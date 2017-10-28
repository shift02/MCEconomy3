package shift.mceconomy3.gui;

import java.util.Random;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.api.event.ShopBuyEvent;
import shift.mceconomy3.api.shop.IShop;
import shift.mceconomy3.event.MPManager;

public class SlotShopResult extends Slot {

    private final EntityPlayer thePlayer;
    private final InventoryShop theShopInventory;
    private final IShop theShop;
    protected Random rand = new Random();

    public SlotShopResult(EntityPlayer par1EntityPlayer, IShop par2IProductList, InventoryShop par1iInventory, int par2, int par3, int par4) {
        super(par1iInventory, par2, par3, par4);
        theShopInventory = par1iInventory;
        thePlayer = par1EntityPlayer;
        theShop = par2IProductList;
    }

    @Override
    public boolean isItemValid(ItemStack par1ItemStack) {
        return false;
    }

    @Override
    protected void onCrafting(ItemStack par1ItemStack) {
        //par1ItemStack.onCrafting(this.thePlayer.worldObj, this.thePlayer, 0);
        //this.field_75231_g = 0;
        theShopInventory.resetSlots();

    }

    @Override
    public ItemStack onTake(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack) {

        this.onCrafting(par2ItemStack);
        //System.out.println("onPickupFromSlot");
        int cost = theShop.getProductList(par1EntityPlayer.world, par1EntityPlayer).get(theShopInventory.currentRecipeIndex).getCost(theShop, par1EntityPlayer.world, par1EntityPlayer);

        if (par1EntityPlayer.world.isRemote) {
            MPManager.getInstance().reduceShopPlayerMP(par1EntityPlayer, cost, false);
        } else {
            MCEconomyAPI.reducePlayerMP(par1EntityPlayer, cost, false);
        }

        MinecraftForge.EVENT_BUS.post(new ShopBuyEvent(par1EntityPlayer, par2ItemStack));
        //par1EntityPlayer.playSound(ISoundManager.COIN_SOUND, 0.1F, 0.5F * ((this.rand.nextFloat() - this.rand.nextFloat()) * 0.7F + 1.8F));

        theShopInventory.resetSlots();

        this.onSlotChanged();

        return par2ItemStack;


    }

}
