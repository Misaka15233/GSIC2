package com.misaka15233.gsic2.client.gui.overlay;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import org.lwjgl.opengl.GL11;

import java.util.function.Function;

public abstract class LayerTiledOverlay<T extends EntityLivingBase> implements LayerRenderer<T> {

    private final RenderLivingBase<?> renderer;

    private final int textureWidth;
    private final int textureHeight;

    public LayerTiledOverlay(RenderLivingBase<?> renderer, int textureWidth, int textureHeight){
        this.textureWidth = textureWidth;
        this.textureHeight = textureHeight;
        this.renderer = renderer;
    }

    public LayerTiledOverlay(RenderLivingBase<?> renderer){
        this(renderer, 16, 16);
    }

    public abstract boolean shouldRender(T entity, float partialTicks);

    public abstract ResourceLocation getTexture(T entity, float partialTicks);

    public ModelBase getModel(T entity, float partialTicks){
        return renderer.getMainModel();
    }

    public boolean renderSecondLayer(T entity, float partialTicks){
        return false;
    }

    protected void applyTextureSpaceTransformations(T entity, float partialTicks){}

    @Override
    public void doRenderLayer(T entity, float limbSwing, float limbSwingAmount, float partialTicks,
                              float ageInTicks, float netHeadYaw, float headPitch, float scale){

        if(shouldRender(entity, partialTicks)){
            this.renderer.bindTexture(getTexture(entity, partialTicks));
            this.renderEntityModel(entity, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch, scale);
        }
    }

    @Override
    public boolean shouldCombineTextures(){
        return false;
    }

    protected static int getBlockBrightnessForEntity(Entity entity){

        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos(MathHelper.floor(entity.posX), 0,
                MathHelper.floor(entity.posZ));

        if(entity.world.isBlockLoaded(pos)){
            pos.setY(MathHelper.floor(entity.posY + (double)entity.getEyeHeight()));
            return entity.world.getCombinedLight(pos, 0);
        }else{
            return 0;
        }
    }

    private void renderEntityModel(T entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale){

        GlStateManager.pushMatrix();
        GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_S, GL11.GL_REPEAT);
        GlStateManager.glTexParameteri(GL11.GL_TEXTURE_2D, GL11.GL_TEXTURE_WRAP_T, GL11.GL_REPEAT);

        GlStateManager.depthMask(true);

        GlStateManager.matrixMode(GL11.GL_TEXTURE);
        GlStateManager.loadIdentity();

        ModelBase model = getModel(entity, partialTicks);

        double scaleX = 1, scaleY = 1;

        if(model.boxList != null && model.boxList.size() >= 1 && model.boxList.get(0) != null){
            scaleX = (double)model.boxList.get(0).textureWidth / textureWidth;
            scaleY = (double)model.boxList.get(0).textureHeight / textureHeight;
        }else{
            scaleX = (double)model.textureWidth / textureWidth;
            scaleY = (double)model.textureHeight / textureHeight;
        }

        GlStateManager.scale(scaleX, scaleY, 1);

        applyTextureSpaceTransformations(entity, partialTicks);

        GlStateManager.matrixMode(GL11.GL_MODELVIEW);

        boolean headWearHidden = false;
        boolean bodyWearHidden = false;
        boolean leftArmWearHidden = false;
        boolean rightArmWearHidden = false;
        boolean leftLegWearHidden = false;
        boolean rightLegWearHidden = false;

        if(!renderSecondLayer(entity, partialTicks)){
            if(model instanceof ModelBiped){
                headWearHidden = ((ModelBiped)model).bipedHeadwear.isHidden;
                ((ModelBiped)model).bipedHeadwear.isHidden = true;
            }

            if(model instanceof ModelPlayer){
                bodyWearHidden = ((ModelPlayer)model).bipedBodyWear.isHidden;
                leftArmWearHidden = ((ModelPlayer)model).bipedLeftArmwear.isHidden;
                rightArmWearHidden = ((ModelPlayer)model).bipedRightArmwear.isHidden;
                leftLegWearHidden = ((ModelPlayer)model).bipedLeftLegwear.isHidden;
                rightLegWearHidden = ((ModelPlayer)model).bipedRightLegwear.isHidden;
                ((ModelPlayer)model).bipedBodyWear.isHidden = true;
                ((ModelPlayer)model).bipedLeftArmwear.isHidden = true;
                ((ModelPlayer)model).bipedRightArmwear.isHidden = true;
                ((ModelPlayer)model).bipedLeftLegwear.isHidden = true;
                ((ModelPlayer)model).bipedRightLegwear.isHidden = true;
            }
        }

        model.setLivingAnimations(entity, limbSwing, limbSwingAmount, partialTicks);
        model.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);

        if(!renderSecondLayer(entity, partialTicks)){
            if(model instanceof ModelBiped){
                ((ModelBiped)model).bipedHeadwear.isHidden = headWearHidden;
            }

            if(model instanceof ModelPlayer){
                ((ModelPlayer)model).bipedBodyWear.isHidden = bodyWearHidden;
                ((ModelPlayer)model).bipedLeftArmwear.isHidden = leftArmWearHidden;
                ((ModelPlayer)model).bipedRightArmwear.isHidden = rightArmWearHidden;
                ((ModelPlayer)model).bipedLeftLegwear.isHidden = leftLegWearHidden;
                ((ModelPlayer)model).bipedRightLegwear.isHidden = rightLegWearHidden;
            }
        }

        GlStateManager.matrixMode(GL11.GL_TEXTURE);
        GlStateManager.loadIdentity();
        GlStateManager.matrixMode(GL11.GL_MODELVIEW);

        GlStateManager.popMatrix();
    }

    @SuppressWarnings("unchecked")
    public static <T extends EntityLivingBase> void initialiseLayers(Class<T> entityType, Function<RenderLivingBase<T>, LayerRenderer<? extends T>> layerFactory){

        for(Class<? extends Entity> c : Minecraft.getMinecraft().getRenderManager().entityRenderMap.keySet()){
            if(entityType.isAssignableFrom(c)){
                Render<T> renderer = Minecraft.getMinecraft().getRenderManager().getEntityClassRenderObject(c);
                if(renderer instanceof RenderLivingBase<?>){
                    ((RenderLivingBase<T>)renderer).addLayer(layerFactory.apply((RenderLivingBase<T>)renderer));
                }
            }
        }

        if(entityType.isAssignableFrom(EntityPlayer.class)){
            for(RenderPlayer renderer : Minecraft.getMinecraft().getRenderManager().getSkinMap().values()){
                renderer.addLayer(layerFactory.apply((RenderLivingBase<T>)renderer));
            }
        }
    }

    public static void initialiseLayers(Function<RenderLivingBase<EntityLivingBase>, LayerRenderer<? extends EntityLivingBase>> layerFactory){
        initialiseLayers(EntityLivingBase.class, layerFactory);
    }

}

