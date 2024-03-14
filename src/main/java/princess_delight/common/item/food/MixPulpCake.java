package princess_delight.common.item.food;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import princess_delight.core.init.group.PDFood;

public class MixPulpCake extends Item{
    private static final Food MIX_PULP_CAKE = (new Food.Builder())
            .saturationMod(14)                   // 饱腹度
            .nutrition(16)                       // 饱食度
            .effect(()-> new EffectInstance(Effects.REGENERATION,9 * 20,1),1)   // 效果
            .build();

    public MixPulpCake()
    {
        super(new Item.Properties().tab(PDFood.PD_FOOD).food(MIX_PULP_CAKE));
    }
}
