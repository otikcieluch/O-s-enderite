package enderite.block;

import enderite.init.EnderiteModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.BlockBehaviour.OffsetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

public class EnderplantBlock extends FlowerBlock implements SimpleWaterloggedBlock {
   public static final BooleanProperty WATERLOGGED;

   public EnderplantBlock(BlockBehaviour.Properties properties) {
      super(MobEffects.DAMAGE_BOOST, 100.0F, properties.mapColor(MapColor.COLOR_YELLOW).sound(SoundType.AMETHYST_CLUSTER).strength(0.2F, 0.5F).hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true).lightLevel((s) -> 2).noCollission().offsetType(OffsetType.XZ).pushReaction(PushReaction.DESTROY));
      this.registerDefaultState((BlockState)((BlockState)this.stateDefinition.any()).setValue(WATERLOGGED, false));
   }

   protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
      super.createBlockStateDefinition(builder);
      builder.add(new Property[]{WATERLOGGED});
   }

   public BlockState getStateForPlacement(BlockPlaceContext context) {
      return (BlockState)super.getStateForPlacement(context).setValue(WATERLOGGED, context.getLevel().getFluidState(context.getClickedPos()).getType() == Fluids.WATER);
   }

   public FluidState getFluidState(BlockState state) {
      return (Boolean)state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
   }

   public BlockState updateShape(BlockState state, LevelReader world, ScheduledTickAccess scheduledTickAccess, BlockPos currentPos, Direction facing, BlockPos facingPos, BlockState facingState, RandomSource random) {
      if ((Boolean)state.getValue(WATERLOGGED)) {
         scheduledTickAccess.scheduleTick(currentPos, Fluids.WATER, Fluids.WATER.getTickDelay(world));
      }

      return super.updateShape(state, world, scheduledTickAccess, currentPos, facing, facingPos, facingState, random);
   }

   public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean includeData, Player entity) {
      return new ItemStack((ItemLike)EnderiteModBlocks.ENDERPLANT.get());
   }

   public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
      return groundState.is(Blocks.END_STONE);
   }

   public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
      BlockPos blockpos = pos.below();
      BlockState groundState = worldIn.getBlockState(blockpos);
      return this.mayPlaceOn(groundState, worldIn, blockpos);
   }

   static {
      WATERLOGGED = BlockStateProperties.WATERLOGGED;
   }
}
