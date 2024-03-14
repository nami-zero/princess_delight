package princess_delight.network;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.network.NetworkRegistry;
import net.minecraftforge.fml.network.simple.SimpleChannel;
import princess_delight.Princess_Delight;

public class NetworkRegistryHandler {
    public static SimpleChannel CHANNELMANA;
    public static SimpleChannel CHANNELTP;
    private static final String VERSIONMANA = "0.0.1";
    private static final String VERSIONTP = "0.1.0";
    private static int ID = 0;
    public static int nextID(){return ID++; }
    public static void registerMessage(){
        CHANNELMANA = NetworkRegistry.newSimpleChannel(new ResourceLocation(Princess_Delight.MODID, "mana"),
                ()-> VERSIONMANA,
                (version)-> version.equals(VERSIONMANA),
                (version)-> version.equals(VERSIONMANA));
        CHANNELMANA.registerMessage(nextID(),ManaNet.class, ManaNet::encode,ManaNet::decode, ManaNet::handlePacket);
        CHANNELTP = NetworkRegistry.newSimpleChannel(new ResourceLocation(Princess_Delight.MODID, "TP"),
                ()-> VERSIONTP,
                (version)-> version.equals(VERSIONTP),
                (version)-> version.equals(VERSIONTP));
        CHANNELTP.registerMessage(nextID(),TpNet.class, TpNet::encode,TpNet::decode, TpNet::handlePacket);

    }
}
