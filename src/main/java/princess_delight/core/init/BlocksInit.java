package princess_delight.core.init;

import net.minecraft.block.Block;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import princess_delight.Princess_Delight;

public class BlocksInit {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Princess_Delight.MODID);

    public static final RegistryObject<Block> JewelOre = BLOCKS.register("jewel_ore", princess_delight.common.blocks.JewelOre::new);
    public static final RegistryObject<Block> JewelBlocks = BLOCKS.register("jewel_blocks", princess_delight.common.blocks.JewelBlocks::new);


}
