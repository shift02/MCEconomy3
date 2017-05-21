package shift.mceconomy3.api.money;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import shift.mceconomy3.Config;

/**
 * Capabilityを持つことが出来るほぼ全てのインスタンスに実装できる。
 * @author Shift02
 *
 */
public class MoneyStorageProvider implements ICapabilitySerializable<NBTTagCompound>{

	@CapabilityInject(IMoneyStorage.class)
    public static Capability<IMoneyStorage> MONEY = null;

	IMoneyStorage money;

	public MoneyStorageProvider(int amount){
		money = new MoneyStorage(Config.maxMP);
		money.setMoneyStored(amount);
	}

	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {

		if(MONEY == capability && facing == null){
			return true;
		}

		return false;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {

		if(MONEY == capability && facing == null){
			return (T) money;
		}

		return null;
	}

	@Override
	public NBTTagCompound serializeNBT() {

		return (NBTTagCompound) MONEY.writeNBT(money, null);

	}

	@Override
	public void deserializeNBT(NBTTagCompound nbt) {

		MONEY.readNBT(money, null, nbt);

	}

}
