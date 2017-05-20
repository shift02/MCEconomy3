package shift.mceconomy3;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import shift.mceconomy3.api.money.IMoney;
import shift.mceconomy3.api.money.MoneyStorage;
import shift.mceconomy3.event.MPManager;

public class EntityPropertieMP implements IMoney, ICapabilitySerializable<NBTTagCompound> {


	@CapabilityInject(EntityPropertieMP.class)
    static Capability<EntityPropertieMP> MP_CAPABILITY = null;

    //private int mp=0;
    private int mpDisplay ;
    private int mpCount;
    //private boolean init= false;

    //IMoneyにブリッジ
    private MoneyStorage moneyStorage = new MoneyStorage(Config.maxMP);
    private EntityPlayer player;

    public EntityPropertieMP(){

    }

    public EntityPropertieMP(EntityPlayer player){
    	this.player = player;
    }

    @Override
	public NBTTagCompound serializeNBT() {

		NBTTagCompound nbt = new NBTTagCompound();
		nbt.setInteger("mp", getMp());

		return nbt;
	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {

		if(nbt.hasKey("mp")){

    		if(nbt.getBoolean("init")){
    			this.setMpDisplay(0);
    			this.mpCount = 0;
    		}else{

    			int addMP = nbt.getInteger("mp");
    			mpDisplay = addMP - getMp() + mpDisplay;
    			this.mpCount = 20;

    		}

    		setMp(nbt.getInteger("mp"));

    	}

	}


	public int getMp() {
		return moneyStorage.getMoneyStored();
	}

	public void setMp(int mp) {
		moneyStorage.setMoneyStored(mp);
	}

	public int getMpDisplay() {
		return mpDisplay;
	}

	public void setMpDisplay(int mpDisplay) {
		this.mpDisplay = mpDisplay;
	}

	public int getMpCount() {
		return mpCount;
	}

	public void setMpCount(int mpCount) {
		this.mpCount = mpCount;
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return MP_CAPABILITY == capability;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		if (MP_CAPABILITY != null && capability == MP_CAPABILITY) return MP_CAPABILITY.cast(this);
        return null;
	}

	@Override
	public int receiveMoney(int maxReceive, boolean simulate) {

		return MPManager.getInstance().addPlayerMP(player, maxReceive, simulate);

	}

	@Override
	public int extractMoney(int maxExtract, boolean simulate) {

		return MPManager.getInstance().reducePlayerMP(player, maxExtract, simulate);

	}

	@Override
	public int getMoneyStored() {
		return moneyStorage.getMoneyStored();
	}

	@Override
	public int getMaxMoneyStored() {
		return moneyStorage.getMaxMoneyStored();
	}

	@Override
	public boolean canReceive() {
		return moneyStorage.canReceive();
	}

	@Override
	public boolean canExtract() {
		return moneyStorage.canExtract();
	}

	@Override
	public void setMoneyStored(int money) {
		moneyStorage.setMoneyStored(money);

	}




}
