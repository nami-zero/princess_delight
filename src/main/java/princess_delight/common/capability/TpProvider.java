package princess_delight.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.util.LazyOptional;
import princess_delight.core.registry.CapabilityRegistryHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class TpProvider implements ICapabilitySerializable<CompoundNBT> {
    private final Tp instance;

    public TpProvider(){
        this.instance = new Tp();
    }


    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap_tp, @Nullable Direction side) {
        return cap_tp == CapabilityRegistryHandler.TP_CAP ? LazyOptional.of(()->this.instance).cast() : LazyOptional.empty();
    }

    @Override
    public CompoundNBT serializeNBT(){
        return instance.serializeNBT();
    }

    @Override
    public void deserializeNBT(CompoundNBT nbt){
        this.instance.deserializeNBT(nbt);
    }
}