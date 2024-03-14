package princess_delight.common.item.tool;

import net.minecraft.item.IItemTier;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import princess_delight.core.init.ItemInit;

import java.util.function.Supplier;

public enum PDTier implements IItemTier {
    BasicKnightSword(4, -1, 10.0F, 0.0F, 50, () -> {
        return Ingredient.of(ItemInit.MANA.get());
    });

    private final int level;                //挖掘等级
    private final int uses;                 //耐久
    private final float speed;              //效率    指标+工具效率+方块硬度+药水效果
    private final float damage;             //攻击力+武器攻击+盔甲防御值
    private final int enchantmentValue;     //附魔等级
    private final LazyValue<Ingredient> repairIngredient;       //修复材料

    private PDTier(int p_i48458_3_, int p_i48458_4_, float p_i48458_5_, float p_i48458_6_, int p_i48458_7_, Supplier<Ingredient> p_i48458_8_) {
        this.level = p_i48458_3_;
        this.uses = p_i48458_4_;
        this.speed = p_i48458_5_;
        this.damage = p_i48458_6_;
        this.enchantmentValue = p_i48458_7_;
        this.repairIngredient = new LazyValue<>(p_i48458_8_);
    }


    public int getUses() {

        return this.uses;
    }

    public float getSpeed() {

        return this.speed;
    }

    public float getAttackDamageBonus() {

        return this.damage;
    }

    public int getLevel() {

        return this.level;
    }

    public int getEnchantmentValue() {

        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {

        return this.repairIngredient.get();
    }
}
