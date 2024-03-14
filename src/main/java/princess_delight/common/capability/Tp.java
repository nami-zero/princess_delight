package princess_delight.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraftforge.common.util.INBTSerializable;

public class Tp implements INBTSerializable {
    private float tp;
    public Tp(){
        this.tp = 0f;
    }
    public float getTp() {
        return tp;
    }
    public void setTp(float tp) {
        this.tp = tp;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt_tp = new CompoundNBT();
        nbt_tp.putFloat("tp_", tp);
        return nbt_tp;
    }

    @Override
    public void deserializeNBT(INBT nbt_tp) {
        if (nbt_tp instanceof CompoundNBT){
            CompoundNBT compoundNBT_tp = (CompoundNBT) nbt_tp;
            this.tp = compoundNBT_tp.getFloat("tp_");
        }
    }
}
