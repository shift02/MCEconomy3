package shift.mceconomy3.gui;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import shift.mceconomy3.api.MCEconomyAPI;
import shift.mceconomy3.api.shop.IProduct;
import shift.mceconomy3.api.shop.IShop;

public class InventoryShop implements IInventory {

    private final IShop theShop;
    private final ItemStack[] theInventory = new ItemStack[1];
    private final EntityPlayer thePlayer;
    private IProduct currentRecipe;
    int currentRecipeIndex;

    public InventoryShop(EntityPlayer par1EntityPlayer, IShop par2IMerchant) {
        this.thePlayer = par1EntityPlayer;
        this.theShop = par2IMerchant;
        theInventory[0] = ItemStack.EMPTY;
    }

    @Override
    public int getSizeInventory() {
        return this.theInventory.length;
    }

    @Override
    public ItemStack getStackInSlot(int par1) {
        return this.theInventory[par1];
    }

    @Override
    public ItemStack decrStackSize(int par1, int par2) {

        if (!this.theInventory[par1].isEmpty()) {
            ItemStack itemstack;

            if (this.theInventory[par1].getCount() <= par2) {
                itemstack = this.theInventory[par1];
                this.theInventory[par1] = ItemStack.EMPTY;
                this.markDirty();
                return itemstack;
            } else {
                itemstack = this.theInventory[par1].splitStack(par2);

                if (this.theInventory[par1].getCount() == 0) {
                    this.theInventory[par1] = ItemStack.EMPTY;
                }

                this.markDirty();
                return itemstack;
            }
        } else {
            return ItemStack.EMPTY;
        }
    }

    @Override
    public ItemStack removeStackFromSlot(int par1) {

        if (!this.theInventory[par1].isEmpty()) {
            ItemStack itemstack = this.theInventory[par1];
            this.theInventory[par1] = ItemStack.EMPTY;
            this.resetSlots();
            return itemstack;

        } else {
            this.resetSlots();
            return ItemStack.EMPTY;

        }

    }

    @Override
    public void setInventorySlotContents(int par1, ItemStack par2ItemStack) {
        this.theInventory[par1] = par2ItemStack;

        if (!par2ItemStack.isEmpty() && par2ItemStack.getCount() > this.getInventoryStackLimit()) {
            par2ItemStack.setCount(this.getInventoryStackLimit());
        }

        /*
        if (this.inventoryResetNeededOnSlotChange(par1))
        {
            this.resetRecipeAndSlots();
        }*/
    }

    @Override
    public String getName() {
        return theShop.getShopName(thePlayer.world, thePlayer);
    }

    @Override
    public boolean hasCustomName() {
        return false;
    }

    @Override
    public ITextComponent getDisplayName() {
        return (ITextComponent) (this.hasCustomName() ? new TextComponentString(this.getName())
                : new TextComponentTranslation(this.getName(), new Object[0]));
    }

    @Override
    public int getInventoryStackLimit() {
        return 64;
    }

    @Override
    public boolean isUsableByPlayer(EntityPlayer par1EntityPlayer) {
        return true;//this.theMerchant.getCustomer() == par1EntityPlayer;
    }

    @Override
    public void openInventory(EntityPlayer player) {
    }

    @Override
    public void closeInventory(EntityPlayer player) {
    }

    @Override
    public boolean isItemValidForSlot(int par1, ItemStack par2ItemStack) {
        return true;
    }

    @Override
    public void markDirty() {
        this.resetSlots();
    }

    //public EntityClientPlayerMP thePlayer2 = FMLClientHandler.instance().getClient().thePlayer;

    public void resetSlots() {

        IProduct item = theShop.getProductList(thePlayer.world, thePlayer).get(currentRecipeIndex);

        int money = MCEconomyAPI.getPlayerMP(thePlayer);

        /*if(thePlayer!=null){
        	NBTTagCompound nbt = thePlayer.getEntityData();
        	money = nbt.getInteger("money");
        	//System.out.println("resetSlots0"+money);
        }/*else if(thePlayer2!=null){
        	NBTTagCompound nbt = thePlayer2.getEntityData();
        	money = nbt.getInteger("money");
        	System.out.println("resetSlots0"+money);
        }*/

        if (money >= item.getCost(theShop, thePlayer.world, thePlayer)
                && item.canBuy(theShop, thePlayer.world, thePlayer)) {
            this.setInventorySlotContents(0, item.getItem(theShop, thePlayer.world, thePlayer).copy());
            //System.out.println("resetSlots");
        } else {
            this.setInventorySlotContents(0, ItemStack.EMPTY);

            //System.out.println("resetSlots2");
        }
        //System.out.println("resetSlots");

    }

    public void setCurrentRecipeIndex(int par1) {
        this.currentRecipeIndex = par1;
        this.resetSlots();
    }

    @Override
    public int getField(int id) {
        return 0;
    }

    @Override
    public void setField(int id, int value) {

    }

    @Override
    public int getFieldCount() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean isEmpty() {
        return false;
    }

}
