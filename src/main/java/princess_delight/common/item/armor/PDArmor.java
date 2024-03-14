package princess_delight.common.item.armor;

import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.IArmorMaterial;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.LazyValue;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import princess_delight.core.init.ItemInit;

import java.util.function.Supplier;

public enum PDArmor implements IArmorMaterial {

    BasicRoyaleQuipment("royalequipment", -1, new int[]{5, 8, 12, 8}, 20, SoundEvents.ARMOR_EQUIP_IRON, 10.0F, 1.0F, () -> {
        return Ingredient.of(ItemInit.MANA.get());
    });
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;                              //名字 -》渲染 身上装备有关
    private final int durabilityMultiplier;                 //耐久性乘数
    private final int[] slotProtections;                    //护甲值
    private final int enchantmentValue;                     //附魔能力
    private final SoundEvent sound;                         //声音
    private final float toughness;                          //盔甲韧性
    private final float knockbackResistance;                //击退抗性
    private final LazyValue<Ingredient> repairIngredient;   //修复材料

    private PDArmor(String p_i231593_3_, int p_i231593_4_, int[] p_i231593_5_, int p_i231593_6_, SoundEvent p_i231593_7_, float p_i231593_8_, float p_i231593_9_, Supplier<Ingredient> p_i231593_10_) {
        this.name = p_i231593_3_;
        this.durabilityMultiplier = p_i231593_4_;
        this.slotProtections = p_i231593_5_;
        this.enchantmentValue = p_i231593_6_;
        this.sound = p_i231593_7_;
        this.toughness = p_i231593_8_;
        this.knockbackResistance = p_i231593_9_;
        this.repairIngredient = new LazyValue<>(p_i231593_10_);
    }

    public int getDurabilityForSlot(EquipmentSlotType p_200896_1_) {
        return HEALTH_PER_SLOT[p_200896_1_.getIndex()] * this.durabilityMultiplier;
    }

    public int getDefenseForSlot(EquipmentSlotType p_200902_1_) {
        return this.slotProtections[p_200902_1_.getIndex()];
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public SoundEvent getEquipSound() {

        return this.sound;
    }

    public Ingredient getRepairIngredient() {

        return this.repairIngredient.get();
    }

    @OnlyIn(Dist.CLIENT)
    public String getName() {

        return this.name;
    }

    public float getToughness() {

        return this.toughness;
    }

    public float getKnockbackResistance() {

        return this.knockbackResistance;
    }

}
