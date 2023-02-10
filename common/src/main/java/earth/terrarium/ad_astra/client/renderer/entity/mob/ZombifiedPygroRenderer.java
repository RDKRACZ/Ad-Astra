package earth.terrarium.ad_astra.client.renderer.entity.mob;

import earth.terrarium.ad_astra.AdAstra;
import earth.terrarium.ad_astra.client.renderer.entity.mob.model.PygroModel;
import earth.terrarium.ad_astra.client.renderer.entity.mob.model.ZombifiedPygroModel;
import earth.terrarium.ad_astra.common.entity.mob.ZombifiedPygro;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

@Environment(EnvType.CLIENT)
public class ZombifiedPygroRenderer extends MobRenderer<ZombifiedPygro, ZombifiedPygroModel> {
    public static final ResourceLocation TEXTURE = new ResourceLocation(AdAstra.MOD_ID, "textures/entity/zombified_pygro.png");

    public ZombifiedPygroRenderer(EntityRendererProvider.Context context) {
        super(context, new ZombifiedPygroModel(context.bakeLayer(PygroModel.LAYER_LOCATION)), 0.5f);
        this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
        this.addLayer(new HumanoidArmorLayer<>(this, new HumanoidModel<>(context.bakeLayer(ModelLayers.PIGLIN_INNER_ARMOR)), new HumanoidModel<>(context.bakeLayer(ModelLayers.PIGLIN_OUTER_ARMOR))));
    }

    @Override
    public ResourceLocation getTextureLocation(ZombifiedPygro mobEntity) {
        return TEXTURE;
    }
}
