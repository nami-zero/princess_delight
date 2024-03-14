package princess_delight.core.init.event.client;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import princess_delight.client.gui.ManaHud;
import princess_delight.common.capability.Mana;
import princess_delight.core.registry.CapabilityRegistryHandler;

@Mod.EventBusSubscriber
public class ClientRenderEvent {
    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onRenderGameOverlayPost(RenderGameOverlayEvent event){
        if (!RenderGameOverlayEvent.ElementType.ALL.equals(event.getType())){
            return;
        }
        Minecraft minecraft = Minecraft.getInstance();
        Entity renderViewEntity = minecraft.getCameraEntity();
        if(renderViewEntity instanceof PlayerEntity){
            PlayerEntity playerEntity = (PlayerEntity) renderViewEntity;
            LazyOptional<Mana> capability_mana = playerEntity.getCapability(CapabilityRegistryHandler.MANA_CAP);
            capability_mana.ifPresent((c)->{
                int mana = c.getMana();
                ManaHud manaHud = new ManaHud(event.getMatrixStack());
                manaHud.render(mana);
            });
        }
    }

}
