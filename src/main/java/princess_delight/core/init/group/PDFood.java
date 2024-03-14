package princess_delight.core.init.group;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import princess_delight.core.init.ItemInit;

public class PDFood extends ItemGroup {
    public static final PDFood PD_FOOD = new PDFood();
    public PDFood() {
        super("princess_delight_food");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.MIX_PULP_CAKE.get());
    }
}
