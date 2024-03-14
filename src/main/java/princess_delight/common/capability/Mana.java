package princess_delight.common.capability;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.nbt.INBT;
import net.minecraftforge.common.util.INBTSerializable;

public class Mana implements INBTSerializable {
    private int mana;
    public Mana(){
        this.mana = 0;
    }

    public int getMana() {return mana;}

    public void setMana(int mana) {
        this.mana = mana;
    }

    @Override
    public CompoundNBT serializeNBT() {
        CompoundNBT nbt_mana = new CompoundNBT();
        nbt_mana.putFloat("mana_", mana);
        return nbt_mana;
    }

    @Override
    public void deserializeNBT(INBT nbt_mana) {
        if (nbt_mana instanceof CompoundNBT){
            CompoundNBT compoundNBT_mana = (CompoundNBT) nbt_mana;
            this.mana = compoundNBT_mana.getInt("mana_");
        }
    }
}
