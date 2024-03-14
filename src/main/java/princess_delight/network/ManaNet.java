package princess_delight.network;

import com.sun.org.apache.xpath.internal.operations.Mod;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.entity.ai.attributes.ModifiableAttributeInstance;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.ModContainer;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.fml.ModLoader;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.network.NetworkEvent;
import org.jline.utils.InfoCmp;
import princess_delight.common.capability.Mana;
import princess_delight.core.registry.CapabilityRegistryHandler;

import java.util.function.Supplier;

public class ManaNet {
    public int mana;
    public ManaNet(){}

    public ManaNet(int mana){
        this.mana = mana;
    }

    public int getMana(){
        return mana;
    }

    public static void encode(ManaNet manaNetwork, PacketBuffer buffer){
        buffer.writeInt(manaNetwork.mana);
    }

    public static ManaNet decode(PacketBuffer buffer){
        return new ManaNet(buffer.readInt());
    }

    //服务端处理逻辑
    public static void handlePacket(ManaNet manaN, Supplier<NetworkEvent.Context> content){
        NetworkEvent.Context context = content.get();
        context.enqueueWork(()->{
            onClientCustomPack(manaN);
        });
        context.setPacketHandled(true);
    }
    @OnlyIn(Dist.CLIENT)
    public static void onClientCustomPack(ManaNet manaN){
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;      //客户端对象
        LazyOptional<Mana> capability_mana = player.getCapability(CapabilityRegistryHandler.MANA_CAP);
        capability_mana.ifPresent((mana -> {
            mana.setMana(manaN.getMana());
        }));
    }
}
