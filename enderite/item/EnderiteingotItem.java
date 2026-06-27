package enderite.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class EnderiteingotItem extends Item {
   public EnderiteingotItem(Item.Properties properties) {
      super(properties.rarity(Rarity.EPIC).stacksTo(64).fireResistant());
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   public boolean isCorrectToolForDrops(ItemStack itemstack, BlockState state) {
      return true;
   }
}
