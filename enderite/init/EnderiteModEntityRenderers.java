package enderite.init;

import enderite.client.renderer.EndwandererRenderer;
import net.minecraft.world.entity.EntityType;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;

@EventBusSubscriber(
   bus = Bus.MOD,
   value = {Dist.CLIENT}
)
public class EnderiteModEntityRenderers {
   @SubscribeEvent
   public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
      event.registerEntityRenderer((EntityType)EnderiteModEntities.ENDWANDERER.get(), EndwandererRenderer::new);
   }
}
