package enderite.init;

import enderite.block.EnderiteblockBlock;
import enderite.block.EnderiteoreBlock;
import enderite.block.EnderplantBlock;
import java.util.function.Function;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderiteModBlocks {
   public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks("enderite");
   public static final DeferredBlock<Block> ENDERITEORE = register("enderiteore", EnderiteoreBlock::new);
   public static final DeferredBlock<Block> ENDERITEBLOCK = register("enderiteblock", EnderiteblockBlock::new);
   public static final DeferredBlock<Block> ENDERPLANT = register("enderplant", EnderplantBlock::new);

   private static <B extends Block> DeferredBlock<B> register(String name, Function<BlockBehaviour.Properties, ? extends B> supplier) {
      return REGISTRY.registerBlock(name, supplier, Properties.of());
   }
}
