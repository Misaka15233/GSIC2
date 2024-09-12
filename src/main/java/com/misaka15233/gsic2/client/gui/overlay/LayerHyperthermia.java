package com.misaka15233.gsic2.client.gui.overlay;

import asmodeuscore.core.registers.potions.ACPotions;
import com.misaka15233.gsic2.GSIC2;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.GlStateManager.DestFactor;
import net.minecraft.client.renderer.GlStateManager.SourceFactor;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class LayerHyperthermia extends LayerTiledOverlay<EntityLivingBase> {

    private static final ResourceLocation TEXTURE = new ResourceLocation(GSIC2.ASSET_PREFIX, "textures/gui/overlay/hyperthermia_overlay.png");

    public LayerHyperthermia(RenderLivingBase<?> renderer){
        super(renderer);
    }

    @Override
    public boolean shouldRender(EntityLivingBase entity, float partialTicks){
        return !entity.isInvisible() && entity.isPotionActive(ACPotions.overheat);
    }

    @Override
    public ResourceLocation getTexture(EntityLivingBase entity, float partialTicks){
        return TEXTURE;
    }

    @Override
    public void doRenderLayer(EntityLivingBase entity, float limbSwing, float limbSwingAmount, float partialTicks,
                              float ageInTicks, float netHeadYaw, float headPitch, float scale){

        GlStateManager.enableBlend();
        GlStateManager.blendFunc(SourceFactor.SRC_ALPHA, DestFactor.ONE_MINUS_SRC_ALPHA);

        super.doRenderLayer(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);

        GlStateManager.disableBlend();
    }

}