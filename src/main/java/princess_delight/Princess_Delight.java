package princess_delight;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.network.NetworkRegistry;
import princess_delight.core.init.EffectInit;
import princess_delight.core.init.ItemInit;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import princess_delight.core.init.BlocksInit;
import princess_delight.network.NetworkRegistryHandler;

@Mod(Princess_Delight.MODID)
public class Princess_Delight
{
    private static final Logger LOGGER = LogManager.getLogger();
    public static final String MODID = "princess_delight";

    public Princess_Delight() {
        MinecraftForge.EVENT_BUS.register(this);
        ItemInit.ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BlocksInit.BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        EffectInit.POTIONS.register(FMLJavaModLoadingContext.get().getModEventBus());

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::onCommonSetup);
    }
    public void onCommonSetup(FMLCommonSetupEvent event){
        NetworkRegistryHandler.registerMessage();
    }
}
