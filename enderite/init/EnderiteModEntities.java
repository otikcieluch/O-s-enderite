package enderite.init;

import enderite.entity.EndwandererEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType.Builder;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class EnderiteModEntities {
   public static final DeferredRegister<EntityType<?>> REGISTRY;
   public static final DeferredHolder<EntityType<?>, EntityType<EndwandererEntity>> ENDWANDERER;

   private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
      return REGISTRY.register(registryname, () -> entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath("enderite", registryname))));
   }

   @SubscribeEvent
   public static void init(RegisterSpawnPlacementsEvent event) {
      EndwandererEntity.init(event);
   }

   @SubscribeEvent
   public static void registerAttributes(EntityAttributeCreationEvent event) {
      event.put((EntityType)ENDWANDERER.get(), EndwandererEntity.createAttributes().build());
   }

   static {
      REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, "enderite");
      ENDWANDERER = register("endwanderer", Builder.of(EndwandererEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().sized(0.6F, 1.8F));
   }
}
