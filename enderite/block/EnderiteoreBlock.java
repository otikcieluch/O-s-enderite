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

public class EnderiteoreBlock extends Block {
   public EnderiteoreBlock(BlockBehaviour.Properties properties) {
      super(properties.sound(SoundType.NETHERITE_BLOCK).strength(30.0F, 60.0F).lightLevel((s) -> 5).requiresCorrectToolForDrops());
   }

   public int getLightBlock(BlockState state) {
      return 15;
   }

   public ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state, boolean includeData, Player entity) {
      return new ItemStack((ItemLike)EnderiteModBlocks.ENDERITEORE.get());
   }
}
