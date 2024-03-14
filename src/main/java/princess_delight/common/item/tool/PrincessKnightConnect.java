package princess_delight.common.item.tool;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.gen.feature.template.AxisAlignedLinearPosTest;
import net.minecraftforge.common.ForgeConfigSpec;

public class PrincessKnightConnect {
    public PrincessKnightConnect(PlayerEntity player){
        if (player.isSilent()) return;
        AxisAlignedBB center = player.getBoundingBox();
    }
}
