package princess_delight.common.item.food;

import princess_delight.core.init.group.PDFood;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class HeartShapedDoughnut extends Item {
    private static final Food HEART_SHAPED_DOUGHNUT = (new Food.Builder())
            .saturationMod(4)                   // 饱腹度
            .nutrition(6)                       // 饱食度
            .effect(()-> new EffectInstance(Effects.REGENERATION,3 * 20,0),1)   // 效果
            .build();

    public HeartShapedDoughnut()
    {
        super(new Properties().tab(PDFood.PD_FOOD).food(HEART_SHAPED_DOUGHNUT));
    }
}