package princess_delight.common.item.tool;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.boss.WitherEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import princess_delight.core.init.EffectInit;
import princess_delight.core.init.group.PDWeapon;

public class KnightSwordComplete extends SwordItem{
    public KnightSwordComplete() {
        super(PDTier.BasicKnightSword, 0, -2.4f, new Item.Properties().tab(PDWeapon.PD_WEAPON).fireResistant());
    }

    @Override
    public boolean onLeftClickEntity(ItemStack stack, PlayerEntity player, Entity entity) {
        if (entity instanceof LivingEntity) {
            LivingEntity living = (LivingEntity) entity;
            boolean b = hitEntity(stack, living, player);
        }return false;
    }

    public boolean hitEntity(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        EffectInstance effect = target.getEffect(Effects.REGENERATION);
        DamageSource source = new PrincessKnightInherentAbility(attacker);
        if (effect != null) {
            int amplifier = effect.getAmplifier();
            if (amplifier >= 0) {
                target.removeEffect(Effects.REGENERATION);
            }
        }
         if (target instanceof WitherEntity) {
            WitherEntity wither = (WitherEntity) target;
            wither.setInvulnerableTicks(0);
        }
        float targetHealth = target.getHealth();
        if (target.getHealth() <= 20) {
            target.hurt(source, 20);
            if (target.getHealth() > 0){
                target.setHealth(target.getHealth() - 20);
            }
        } else {
            target.setHealth(target.getHealth() - 20);
            if (targetHealth - 20 < target.getHealth()) {
                target.hurt(source, 20);
            } else {
                return true;
            }
            return true;
        }return true;
    }



    //public ActionResult<ItemStack> onItemRightClick(World world,PlayerEntity player,Hand hand){
    public ActionResult<ItemStack> use(World world,PlayerEntity player,Hand hand){
        ItemStack heldItem = player.getItemInHand(hand);
        Effect EmblemPower = EffectInit.EMBLEMPOWER.get();
        if (!world.isClientSide) {
            player.addEffect(new EffectInstance(EmblemPower, 10 * 60 * 20, 1));
            player.getCooldowns().addCooldown(heldItem.getItem(), 20);
            //return ActionResult.success(playerIn.getItemInHand(handIn));
        }
        return ActionResult.success(heldItem);
    }
}