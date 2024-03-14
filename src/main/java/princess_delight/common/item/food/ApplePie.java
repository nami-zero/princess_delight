package princess_delight.common.item.food;

import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import princess_delight.core.init.group.PDFood;

public class ApplePie extends Item{
    private static final Food APPLE_PIE = (new Food.Builder())
            .saturationMod(8)                    // 饱腹度
            .nutrition(12)                       // 饱食度
            .effect(() -> new EffectInstance(Effects.REGENERATION, 6 * 20, 0), 1)   // 效果
            .build();

    public ApplePie()
    {
        super(new Item.Properties().tab(PDFood.PD_FOOD).food(APPLE_PIE));
    }
}
