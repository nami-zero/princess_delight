package princess_delight.network;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.player.ClientPlayerEntity;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.network.NetworkEvent;
import princess_delight.common.capability.Tp;
import princess_delight.core.registry.CapabilityRegistryHandler;

import java.util.function.Supplier;

public class TpNet {public float tp;
    public TpNet(){}

    public TpNet(float tp){
        this.tp = tp;
    }

    public float getTp(){
        return tp;
    }

    public static void encode(TpNet tpNetwork, PacketBuffer buffer){
        buffer.writeFloat(tpNetwork.tp);
    }

    public static TpNet decode(PacketBuffer buffer){
        return new TpNet(buffer.readInt());
    }

    //服务端处理逻辑
    public static void handlePacket(TpNet tpN, Supplier<NetworkEvent.Context> content){
        NetworkEvent.Context context = content.get();
        context.enqueueWork(()->{
            onClientCustomPack(tpN);
        });
        context.setPacketHandled(true);
    }
    @OnlyIn(Dist.CLIENT)
    public static void onClientCustomPack(TpNet tpN){
        Minecraft mc = Minecraft.getInstance();
        ClientPlayerEntity player = mc.player;      //客户端对象
        LazyOptional<Tp> capability_tp = player.getCapability(CapabilityRegistryHandler.TP_CAP);
        capability_tp.ifPresent((tp -> {
            tp.setTp(tpN.getTp());
        }));
    }
}
