package princess_delight.common.item.tool;

import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EntityDamageSource;
import princess_delight.core.init.ItemInit;

public class PrincessKnightInherentAbility extends EntityDamageSource{

    private static final String type = "princessKnightSlash";
    public PrincessKnightInherentAbility(LivingEntity living){
        super(type, living);
        bypassArmor();
        bypassMagic();
        bypassInvul();
        isCreativePlayer();
    }

    public ItemStack getKnightWeapon(LivingEntity living){
        ItemStack mainItem = living.getMainHandItem();
        ItemStack offItem = living.getOffhandItem();
        return isKnightWeapon(mainItem) ? mainItem : isKnightWeapon(offItem) ? offItem : ItemStack.EMPTY;
    }

    public boolean isKnightWeapon(ItemStack stack){
        Item item = stack.getItem();
        return item == ItemInit.KNIGHT_SWORD_COMPLETE.get();
    }
}
