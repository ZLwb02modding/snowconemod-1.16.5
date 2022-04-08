package com.zacklown.snowconemod.screen;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.systems.RenderSystem;
import com.zacklown.snowconemod.SnowconeMod;
import com.zacklown.snowconemod.container.IceShaverContainer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.ITextComponent;

public class IceShaverScreen extends ContainerScreen<IceShaverContainer> {
    private final ResourceLocation GUI = new ResourceLocation(SnowconeMod.MOD_ID,"textures/gui/ice_shaver/ice_shaver_gui.png");
   //private final ResourceLocation GUI_SNOW_1 = new ResourceLocation(SnowconeMod.MOD_ID,"textures/gui/ice_shaver/ice_shaver_gui-snow-1.png");
   // private final ResourceLocation GUI_SNOW_2 = new ResourceLocation(SnowconeMod.MOD_ID,"textures/gui/ice_shaver/ice_shaver_gui-snow-2.png");
   //private final ResourceLocation GUI_SNOW_3 = new ResourceLocation(SnowconeMod.MOD_ID,"textures/gui/ice_shaver/ice_shaver_gui-snow-3.png");
   // private final ResourceLocation GUI_SNOW_4 = new ResourceLocation(SnowconeMod.MOD_ID,"textures/gui/ice_shaver/ice_shaver_gui-snow-4.png");
    private final ResourceLocation GUI_SNOW_5 = new ResourceLocation(SnowconeMod.MOD_ID,"textures/gui/ice_shaver/ice_shaver_gui-snow-5.png");

    public IceShaverScreen(IceShaverContainer screenContainer, PlayerInventory inv, ITextComponent titleIn) {
        super(screenContainer, inv, titleIn);
    }//End of IceShaverScreenMethod

    @Override
    public void render(MatrixStack matrixStack, int mouseX, int mouseY, float partialTicks) {
        this.renderBackground(matrixStack);
        super.render(matrixStack, mouseX, mouseY, partialTicks );
        this.renderHoveredTooltip(matrixStack, mouseX, mouseY);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(MatrixStack matrixStack, float partialTicks, int x, int y) {
        RenderSystem.color4f(1f,1f,1f,1f);
        this.minecraft.getTextureManager().bindTexture(GUI);
        int i = this.guiLeft;
        int j = this.guiTop;
        this.blit(matrixStack, i, j, 0,0,this.xSize, this.ySize);

        Minecraft.getInstance().getTextureManager().bindTexture(GUI_SNOW_5);
        this.blit(matrixStack, this.guiLeft + 51, this.guiTop + 34, 0, 0, 16, 16, 16, 16);
    }
}//End of IceShaverScreen Class
