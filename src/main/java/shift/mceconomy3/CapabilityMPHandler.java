package shift.mceconomy3;

import java.util.concurrent.Callable;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;

public class CapabilityMPHandler {

	@CapabilityInject(EntityPropertieMP.class)
    public static Capability<EntityPropertieMP> MP_HANDLER_CAPABILITY = null;

    public static void register()
    {

        CapabilityManager.INSTANCE.register(EntityPropertieMP.class, new Capability.IStorage<EntityPropertieMP>()
        {
            @Override
            public NBTBase writeNBT(Capability<EntityPropertieMP> capability, EntityPropertieMP instance, EnumFacing side)
            {
            	NBTTagCompound tags = new NBTTagCompound();
                return tags;
            }

            @Override
            public void readNBT(Capability<EntityPropertieMP> capability, EntityPropertieMP instance, EnumFacing side, NBTBase nbt)
            {


            }
        }, new Callable<EntityPropertieMP>()
        {
            @Override
            public EntityPropertieMP call() throws Exception
            {
                return new EntityPropertieMP();
            }
        });

    }
}
