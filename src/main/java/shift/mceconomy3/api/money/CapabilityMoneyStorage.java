package shift.mceconomy3.api.money;

import java.util.concurrent.Callable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import shift.mceconomy3.Config;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityMoneyStorage {

	@CapabilityInject(IMoneyStorage.class)
    public static Capability<IMoneyStorage> MONEY = null;

    public static void register()
    {
        CapabilityManager.INSTANCE.register(IMoneyStorage.class, new IStorage<IMoneyStorage>()
        {
            @Override
            public NBTBase writeNBT(Capability<IMoneyStorage> capability, IMoneyStorage instance, EnumFacing side)
            {
            	if (!(instance instanceof MoneyStorage))
                    throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");

            	NBTTagCompound nbt = new NBTTagCompound();
            	nbt.setInteger("money", (instance.getMoneyStored()));
            	nbt.setInteger("capacity", (((MoneyStorage)instance).capacity));
                return nbt;
            }

            @Override
            public void readNBT(Capability<IMoneyStorage> capability, IMoneyStorage instance, EnumFacing side, NBTBase nbt)
            {
                if (!(instance instanceof MoneyStorage))
                    throw new IllegalArgumentException("Can not deserialize to an instance that isn't the default implementation");

                ((MoneyStorage)instance).money = ((NBTTagCompound)nbt).getInteger("money");
                ((MoneyStorage)instance).capacity = ((NBTTagCompound)nbt).getInteger("capacity");
            }

        },
        new Callable<IMoneyStorage>()
        {
            @Override
            public IMoneyStorage call() throws Exception
            {
                return new MoneyStorage(Config.maxMP);
            }
        });
    }

}
