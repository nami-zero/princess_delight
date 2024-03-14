package princess_delight.core.registry;

import net.minecraft.nbt.INBT;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import princess_delight.common.capability.Mana;
import princess_delight.common.capability.Tp;

import javax.annotation.Nullable;
@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class CapabilityRegistryHandler {
    @CapabilityInject(Mana.class)
    public static Capability<Mana> MANA_CAP;

    @CapabilityInject(Tp.class)
    public static Capability<Tp> TP_CAP;

    @SubscribeEvent
    public static void onSetupEvent(FMLCommonSetupEvent event){
        event.enqueueWork(()->{
            CapabilityManager.INSTANCE.register(Mana.class,
                    new Capability.IStorage<Mana>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<Mana> capability, Mana instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<Mana> capability, Mana instance, Direction side, INBT nbt) {
                        }
                    },()->null);
            CapabilityManager.INSTANCE.register(Tp.class,
                    new Capability.IStorage<Tp>() {
                        @Nullable
                        @Override
                        public INBT writeNBT(Capability<Tp> capability, Tp instance, Direction side) {
                            return null;
                        }

                        @Override
                        public void readNBT(Capability<Tp> capability, Tp instance, Direction side, INBT nbt) {
                        }
                        },()->null);
        }
        );
    }
}
