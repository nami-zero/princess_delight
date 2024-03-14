package princess_delight.core.init.group;

import princess_delight.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PDWeapon extends ItemGroup{
    public static final PDWeapon PD_WEAPON = new PDWeapon();
    public PDWeapon() {
        super("princess_delight_weapon");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.KNIGHT_SWORD.get());
    }
}
