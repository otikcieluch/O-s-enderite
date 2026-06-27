package enderite.block;

import enderite.init.EnderiteModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;

public class EnderiteblockBlock extends Block {
   public EnderiteblockBlock(BlockBehaviour.Properties properties) {
      super(properties.sound(SoundType.NETHERITE_BLOCK).strength(160.0F, 280.0F).lightLevel((s) -> 10).requiresCorrectToolForDrops().hasPostProcess((bs, br, bp) -> true).emissiveRendering((bs, br, bp) -> true));
   }

   public int getLightBlock(BlockState state) {
      return 15;
   }

   public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean includeData, Player entity) {
      return new ItemStack((ItemLike)EnderiteModBlocks.ENDERITEBLOCK.get());
   }
}
