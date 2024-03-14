package princess_delight.client.gui;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.AbstractGui;
import net.minecraft.util.ResourceLocation;
import princess_delight.Princess_Delight;

public class ManaHud extends AbstractGui {
    private static final ResourceLocation TEXTURE_MANA = new ResourceLocation(Princess_Delight.MODID, "textures/gui/mana_hud.png");

    private final int width;
    private final int height;
    private final Minecraft minecraft;
    private MatrixStack matrixStack;

    public ManaHud(MatrixStack matrixStack) {
        this.width = Minecraft.getInstance().getWindow().getWidth();
        this.height = Minecraft.getInstance().getWindow().getHeight();
        this.minecraft = Minecraft.getInstance();
        this.matrixStack = matrixStack;
    }

    public void setMatrixStack(MatrixStack matrixStack) {
        this.matrixStack = matrixStack;
    }

    public void render(int mana){
        RenderSystem.color4f(1.0f, 1.0f, 1.0f, 1.0f);
        this.minecraft.getTextureManager().bind(TEXTURE_MANA);
        int mana_price = (mana * 200) / 100000;
        blit(matrixStack,10,10,0, 15, 200, 10);
        blit(matrixStack,10,10,0, 0, mana_price, 10);

        drawCenteredString(matrixStack, minecraft.font, String.valueOf(mana), 20, 11, 0xFFFFFF);
    }

}
