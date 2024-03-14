package princess_delight.common.item.tool;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;
import princess_delight.core.init.EffectInit;
import princess_delight.core.init.group.PDWeapon;

public class KnightSword extends SwordItem {
    public KnightSword() {
        super(PDTier.BasicKnightSword, 20, -2.4f, new Item.Properties().tab(PDWeapon.PD_WEAPON).fireResistant());
    }

    public ActionResult<ItemStack> use(World world, PlayerEntity player, Hand hand){
        ItemStack heldItem = player.getItemInHand(hand);
        Effect EmblemPower = EffectInit.EMBLEMPOWER.get();
        if (!world.isClientSide) {
            player.addEffect(new EffectInstance(EmblemPower, 5 * 60 * 20, 0));
            player.getCooldowns().addCooldown(heldItem.getItem(), 20);
        }
        return ActionResult.success(heldItem);
    }
}