package princess_delight.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class JewelOre extends Block {
    public JewelOre(){
        super(Properties.of(Material.STONE)
                .strength(3, 20)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.STONE)
                .requiresCorrectToolForDrops());
    }
}
