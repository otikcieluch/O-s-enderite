package enderite.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.Potion;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderiteModPotions {
   public static final DeferredRegister<Potion> REGISTRY;
   public static final DeferredHolder<Potion, Potion> POTIONOFTHEGODMODE;
   public static final DeferredHolder<Potion, Potion> ALCOHOL;

   static {
      REGISTRY = DeferredRegister.create(Registries.POTION, "enderite");
      POTIONOFTHEGODMODE = REGISTRY.register("potionofthegodmode", () -> new Potion("potionofthegodmode", new MobEffectInstance[]{new MobEffectInstance(MobEffects.LUCK, 3600, 100, false, true), new MobEffectInstance(MobEffects.DAMAGE_BOOST, 3600, 10, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 3600, 2, false, true), new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 10, false, true), new MobEffectInstance(MobEffects.ABSORPTION, 3600, 20, false, true)}));
      ALCOHOL = REGISTRY.register("alcohol", () -> new Potion("alcohol", new MobEffectInstance[]{new MobEffectInstance(MobEffects.DARKNESS, 3600, 0, false, true), new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 3600, 0, false, true), new MobEffectInstance(MobEffects.CONFUSION, 3600, 0, false, true), new MobEffectInstance(MobEffects.WEAKNESS, 3600, 2, false, true)}));
   }
}
