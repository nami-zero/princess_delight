package princess_delight.common.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class JewelBlocks extends Block {
    public JewelBlocks(){
        super(Properties.of(Material.METAL)
                .strength(6, 50)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops());
    }
}
