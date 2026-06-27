package enderite.entity;

import enderite.init.EnderiteModEntities;
import enderite.init.EnderiteModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.AreaEffectCloud;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.PathfinderMob;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.ThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.Vec3;
import net.neoforged.neoforge.common.NeoForgeMod;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent.Operation;

public class EndwandererEntity extends PathfinderMob {
   public EndwandererEntity(EntityType<EndwandererEntity> type, Level world) {
      super(type, world);
      this.xpReward = 50;
      this.setNoAi(false);
   }

   protected void registerGoals() {
      super.registerGoals();
      this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
         protected boolean canPerformAttack(LivingEntity entity) {
            return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (double)(this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
         }
      });
      this.goalSelector.addGoal(2, new RandomStrollGoal(this, (double)1.0F));
      this.targetSelector.addGoal(3, new HurtByTargetGoal(this, new Class[0]));
      this.goalSelector.addGoal(4, new RandomStrollGoal(this, 0.8));
      this.goalSelector.addGoal(5, new RandomLookAroundGoal(this));
      this.targetSelector.addGoal(6, new NearestAttackableTargetGoal(this, Player.class, false, false));
   }

   public Vec3 getPassengerRidingPosition(Entity entity) {
      return super.getPassengerRidingPosition(entity).add((double)0.0F, (double)-0.35F, (double)0.0F);
   }

   protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
      super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
      this.spawnAtLocation(serverLevel, new ItemStack((ItemLike)EnderiteModItems.ENDRITESHARD.get()));
   }

   public SoundEvent getAmbientSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.enderman.ambient"));
   }

   public void playStepSound(BlockPos pos, BlockState blockIn) {
      this.playSound((SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.endermite.step")), 0.15F, 1.0F);
   }

   public SoundEvent getHurtSound(DamageSource ds) {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.enderman.hurt"));
   }

   public SoundEvent getDeathSound() {
      return (SoundEvent)BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.enderman.scream"));
   }

   public boolean hurtServer(ServerLevel level, DamageSource damagesource, float amount) {
      if (damagesource.is(DamageTypes.IN_FIRE)) {
         return false;
      } else if (!(damagesource.getDirectEntity() instanceof ThrownPotion) && !(damagesource.getDirectEntity() instanceof AreaEffectCloud) && !damagesource.typeHolder().is(NeoForgeMod.POISON_DAMAGE)) {
         if (damagesource.is(DamageTypes.FALL)) {
            return false;
         } else {
            return damagesource.is(DamageTypes.LIGHTNING_BOLT) ? false : super.hurtServer(level, damagesource, amount);
         }
      } else {
         return false;
      }
   }

   public boolean fireImmune() {
      return true;
   }

   public static void init(RegisterSpawnPlacementsEvent event) {
      event.register((EntityType)EnderiteModEntities.ENDWANDERER.get(), SpawnPlacementTypes.ON_GROUND, Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random), Operation.REPLACE);
   }

   public static AttributeSupplier.Builder createAttributes() {
      AttributeSupplier.Builder builder = Mob.createMobAttributes();
      builder = builder.add(Attributes.MOVEMENT_SPEED, 0.3);
      builder = builder.add(Attributes.MAX_HEALTH, (double)20.0F);
      builder = builder.add(Attributes.ARMOR, (double)0.0F);
      builder = builder.add(Attributes.ATTACK_DAMAGE, (double)5.0F);
      builder = builder.add(Attributes.FOLLOW_RANGE, (double)16.0F);
      builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
      builder = builder.add(Attributes.KNOCKBACK_RESISTANCE, 0.4);
      builder = builder.add(Attributes.ATTACK_KNOCKBACK, (double)1.0F);
      return builder;
   }
}
