package princess_delight.common.item.armor;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.world.World;
import princess_delight.core.init.ItemInit;

public class RoyaleQuipmentShoulder extends ArmorItem {
    public RoyaleQuipmentShoulder() {
        super(PDArmor.BasicRoyaleQuipment, EquipmentSlotType.CHEST, new Properties().tab(princess_delight.core.init.group.PDArmor.PD_ARMOR).fireResistant());
    }

    public void onArmorTick(ItemStack stack, World world, PlayerEntity player){
        Item item = stack.getItem();
        if(item == ItemInit.ROYALE_QUIPMENT_SHOULDER.get()){
            player.addEffect(new EffectInstance(Effects.HUNGER, 5 * 20, 4));
            player.addEffect(new EffectInstance(Effects.REGENERATION, 5 * 20, 0));
            player.addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 5 * 20, 3));
        }

    }
}
