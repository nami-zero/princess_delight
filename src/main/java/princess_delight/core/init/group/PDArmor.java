package princess_delight.core.init.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import princess_delight.core.init.ItemInit;

public class PDArmor extends ItemGroup {
    public static final PDArmor PD_ARMOR = new PDArmor();
    public PDArmor() {
        super("princess_delight_armor");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.ROYALE_QUIPMENT_CROWN.get());
    }
}
