package princess_delight.core.init.group;

import princess_delight.core.init.ItemInit;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class PDItem extends ItemGroup {
    public static final PDItem PD_ITEM = new PDItem();
    public PDItem() {
        super("princess_delight_item");
    }

    @Override
    public ItemStack makeIcon() {
        return new ItemStack(ItemInit.JEWELSTORE_ITEM.get());
    }

}
