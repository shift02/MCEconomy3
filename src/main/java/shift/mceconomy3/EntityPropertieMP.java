package shift.mceconomy3;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class EntityPropertieMP implements ICapabilitySerializable<NBTTagCompound> {


	@CapabilityInject(EntityPropertieMP.class)
    static Capability<EntityPropertieMP> MP_CAPABILITY = null;

    private int mp=0;
    private int mpDisplay ;
    private int mpCount;
    //private boolean init= false;

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
    			mpDisplay = addMP - mp + mpDisplay;
    			this.mpCount = 20;

    		}

    		setMp(nbt.getInteger("mp"));

    	}

	}


	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
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




}
