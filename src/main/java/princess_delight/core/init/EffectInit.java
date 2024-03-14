package princess_delight.core.init;

import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectType;
import net.minecraft.util.registry.Registry;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import princess_delight.Princess_Delight;
import princess_delight.common.potion.EmblemPower;

public class EffectInit {
    public static final DeferredRegister<Effect> POTIONS = DeferredRegister.create(ForgeRegistries.POTIONS, Princess_Delight.MODID);

    public static final RegistryObject<Effect> EMBLEMPOWER = POTIONS.register("emblem_power", EmblemPower::new);

}
