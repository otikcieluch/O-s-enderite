package enderite.client.renderer;

import enderite.entity.EndwandererEntity;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.resources.ResourceLocation;

public class EndwandererRenderer extends HumanoidMobRenderer<EndwandererEntity, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
   private EndwandererEntity entity = null;

   public EndwandererRenderer(EntityRendererProvider.Context context) {
      super(context, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER)), 0.5F);
      this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
   }

   public HumanoidRenderState createRenderState() {
      return new HumanoidRenderState();
   }

   public void extractRenderState(EndwandererEntity entity, HumanoidRenderState state, float partialTicks) {
      super.extractRenderState(entity, state, partialTicks);
      this.entity = entity;
   }

   public ResourceLocation getTextureLocation(HumanoidRenderState state) {
      return ResourceLocation.parse("enderite:textures/entities/nepojmenovane.png");
   }
}
