package princess_delight.common.item.armor;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import princess_delight.core.init.ItemInit;

public class RoyaleQuipmentCrown extends ArmorItem {
    public RoyaleQuipmentCrown() {
        super(PDArmor.BasicRoyaleQuipment, EquipmentSlotType.HEAD, new Item.Properties().tab(princess_delight.core.init.group.PDArmor.PD_ARMOR).fireResistant());
    }
    public void onArmorTick(ItemStack stack, World world, PlayerEntity player ){
        Item item = stack.getItem();
        if(item == ItemInit.ROYALE_QUIPMENT_CROWN.get()){
            //player.addEffect(new EffectInstance(Effects.HUNGER, 5 * 20, 4));
            //player.addEffect(new EffectInstance(Effects.HEALTH_BOOST, 5 * 20, 4));
            player.addEffect(new EffectInstance(Effects.DAMAGE_BOOST, 5 * 20, 9));
            //player.setHealth(player.getHealth() + 20);
        }
    }
    public static void healthSet(LivingHurtEvent event){
        DamageSource source = event.getSource();
        LivingEntity entityLiving = event.getEntityLiving();
        event.setAmount(event.getAmount());
    }
}
