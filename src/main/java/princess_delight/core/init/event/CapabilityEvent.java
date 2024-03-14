package princess_delight.core.init.event;

import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.StringTextComponent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.network.PacketDistributor;
import princess_delight.Princess_Delight;
import princess_delight.common.capability.Mana;
import princess_delight.common.capability.ManaProvider;
import princess_delight.common.capability.Tp;
import princess_delight.common.capability.TpProvider;
import princess_delight.core.registry.CapabilityRegistryHandler;
import princess_delight.network.ManaNet;
import princess_delight.network.NetworkRegistryHandler;
import princess_delight.network.TpNet;

@Mod.EventBusSubscriber
public class CapabilityEvent {
    @SubscribeEvent
    public static void onAttackCapabilityEvent(AttachCapabilitiesEvent<Entity> event){
        Entity object = event.getObject();
        if(object instanceof  PlayerEntity){
            event.addCapability(new ResourceLocation(Princess_Delight.MODID, "mana"), new ManaProvider());
            event.addCapability(new ResourceLocation(Princess_Delight.MODID, "tp"), new TpProvider());
        }
    }



    @SubscribeEvent
    public static void onPlayerJoin(EntityJoinWorldEvent event){        //玩家加入游戏事件
        Entity entity = event.getEntity();
        if (!event.getWorld().isClientSide && entity instanceof PlayerEntity){
            PlayerEntity playerEntity = (PlayerEntity) entity;
            LazyOptional<Mana> capability_mana = playerEntity.getCapability(CapabilityRegistryHandler.MANA_CAP);
            capability_mana.ifPresent((c)->{
                NetworkRegistryHandler.CHANNELMANA.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) playerEntity), new ManaNet(c.getMana()));
            });
            LazyOptional<Tp> capability_tp = playerEntity.getCapability(CapabilityRegistryHandler.TP_CAP);
            capability_tp.ifPresent((c)->{
                NetworkRegistryHandler.CHANNELTP.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) playerEntity), new TpNet(c.getTp()));
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event){          //玩家死亡或穿越末地传送门事件
        PlayerEntity player = event.getPlayer();
        PlayerEntity original = event.getOriginal();

        LazyOptional<Mana> capability_mana = player.getCapability(CapabilityRegistryHandler.MANA_CAP);
        LazyOptional<Mana> original_Mana = original.getCapability(CapabilityRegistryHandler.MANA_CAP);

        if(capability_mana.isPresent() && original_Mana.isPresent()){
            capability_mana.ifPresent((cap_mana)->{
                original_Mana.ifPresent(originalCap->{
                    cap_mana.setMana(originalCap.getMana());
                    NetworkRegistryHandler.CHANNELMANA.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) player), new ManaNet(cap_mana.getMana()));
                });
            });
        }
        LazyOptional<Tp> capability_tp = player.getCapability(CapabilityRegistryHandler.TP_CAP);
        LazyOptional<Tp> original_Tp = original.getCapability(CapabilityRegistryHandler.TP_CAP);

        if(capability_tp.isPresent() && original_Tp.isPresent()){
            capability_tp.ifPresent((cap_tp)->{
                original_Tp.ifPresent(originalCap->{
                    cap_tp.setTp(0);
                    NetworkRegistryHandler.CHANNELTP.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) player), new TpNet(0));
                });
            });
        }
    }

    @SubscribeEvent
    public static void onLivingDeath(LivingDeathEvent event){           //被攻击生物死亡事件
        LivingEntity entityLiving = event.getEntityLiving();
            int amount = (int) entityLiving.getMaxHealth() / 10;
            Entity trueSource = event.getSource().getDirectEntity();
            if(trueSource instanceof PlayerEntity){
                PlayerEntity playerEntity = (PlayerEntity) trueSource;
                LazyOptional<Mana> capability_mana = playerEntity.getCapability(CapabilityRegistryHandler.MANA_CAP);
                LazyOptional<Tp> capability_tp = playerEntity.getCapability(CapabilityRegistryHandler.TP_CAP);
                capability_mana.ifPresent((c)->{
                    c.setMana(c.getMana() + amount);
                    NetworkRegistryHandler.CHANNELMANA.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) playerEntity), new ManaNet(c.getMana()));
                });
                capability_tp.ifPresent((c)->{
                    c.setTp(c.getTp() + 2);
                    NetworkRegistryHandler.CHANNELTP.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) playerEntity), new TpNet(c.getTp()));
                });
            }
    }
    @SubscribeEvent
    public static void playerUnderAttack(LivingHurtEvent event){        //玩家受击事件
        LivingEntity playerEntity = event.getEntityLiving();
        float amount = (playerEntity.getMaxHealth() - playerEntity.getHealth()) / playerEntity.getMaxHealth() / 2;
        if(playerEntity instanceof PlayerEntity){
            LazyOptional<Tp> capability_tp = playerEntity.getCapability(CapabilityRegistryHandler.TP_CAP);
            capability_tp.ifPresent((c)->{
                c.setTp(c.getTp() + amount);
                NetworkRegistryHandler.CHANNELTP.send(PacketDistributor.PLAYER.with(()-> (ServerPlayerEntity) playerEntity), new TpNet(c.getTp()));
            });
        }
    }
}
