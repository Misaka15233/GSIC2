package com.misaka15233.gsic2.client.renderer.overlay;

import asmodeuscore.core.registers.potions.ACPotions;
import com.misaka15233.gsic2.GSIC2;
import com.misaka15233.gsic2.Handlers.ClientEventHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import org.lwjgl.opengl.GL11;

@Mod.EventBusSubscriber(Side.CLIENT)
public class RenderHypothermiaOverlay {
    private static final ResourceLocation SCREEN_OVERLAY_TEXTURE = new ResourceLocation(GSIC2.ASSET_PREFIX, "textures/gui/overlay/hypothermia_overlay.png");

    @SubscribeEvent
    public static void onRenderGameOverlayEvent(RenderGameOverlayEvent.Post event){

        if(event.getType() == RenderGameOverlayEvent.ElementType.HELMET){

            if(Minecraft.getMinecraft().player.isPotionActive(ACPotions.hypothermia)){

                OpenGlHelper.glBlendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA, GL11.GL_ONE, GL11.GL_ZERO);
                GlStateManager.color(1, 1, 1, 1);
                GlStateManager.disableAlpha();

                ClientEventHandler.renderScreenOverlay(event.getResolution(), SCREEN_OVERLAY_TEXTURE);

                GlStateManager.enableAlpha();
                GlStateManager.color(1, 1, 1, 1);
            }
        }
    }
}
