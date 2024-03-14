package princess_delight.core.init;

import net.minecraft.item.BlockItem;
import princess_delight.common.item.armor.RoyaleQuipmentCrown;
import princess_delight.core.init.group.PDItem;
import princess_delight.common.item.PrincessDelightItem;
import princess_delight.common.item.armor.RoyaleQuipmentShoulder;
import princess_delight.common.item.food.ApplePie;
import princess_delight.common.item.food.HeartShapedDoughnut;
import princess_delight.common.item.food.MixPulpCake;
import princess_delight.common.item.tool.KnightSword;
import princess_delight.common.item.tool.KnightSwordComplete;
import princess_delight.Princess_Delight;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ItemInit {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, Princess_Delight.MODID);

    //杂项
    public static final RegistryObject<PrincessDelightItem> JEWELSTORE_ITEM =
            ITEMS.register("jewel_store", PrincessDelightItem::new);
    public static final RegistryObject<PrincessDelightItem> MANA =
            ITEMS.register("mana", PrincessDelightItem::new);
    //食物
    public static final RegistryObject<HeartShapedDoughnut> HEART_SHAPED_DOUGHNUT =
            ITEMS.register("heart_shaped_doughnut", HeartShapedDoughnut::new);
    public static final RegistryObject<ApplePie> APPLE_PIE =
            ITEMS.register("apple_pie", ApplePie::new);
    public static final RegistryObject<MixPulpCake> MIX_PULP_CAKE =
            ITEMS.register("mix_pulp_cake", MixPulpCake::new);

    //武器
    public static final RegistryObject<KnightSword> KNIGHT_SWORD =
            ITEMS.register("knight_sword", KnightSword::new);
    public static final RegistryObject<KnightSwordComplete> KNIGHT_SWORD_COMPLETE =
            ITEMS.register("knight_sword_complete", KnightSwordComplete::new);

    //盔甲
    public static final RegistryObject<RoyaleQuipmentCrown> ROYALE_QUIPMENT_CROWN =
            ITEMS.register("royale_quipment_crown", RoyaleQuipmentCrown::new);
    public static final RegistryObject<RoyaleQuipmentShoulder> ROYALE_QUIPMENT_SHOULDER =
            ITEMS.register("royale_quipment_shoulder", RoyaleQuipmentShoulder::new);

    //方块
    public static final RegistryObject<Item> JEWEL_ORE =
            ITEMS.register("jewel_ore", ()->new BlockItem(BlocksInit.JewelOre.get(),
                    new Item.Properties().tab(PDItem.PD_ITEM)));

    public static final RegistryObject<Item> JEWEL_BLOCKS =
            ITEMS.register("jewel_blocks", ()->new BlockItem(BlocksInit.JewelBlocks.get(),
                    new Item.Properties().tab(PDItem.PD_ITEM)));

}
