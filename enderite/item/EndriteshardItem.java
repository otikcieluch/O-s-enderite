package enderite.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class EndriteshardItem extends Item {
   public EndriteshardItem(Item.Properties properties) {
      super(properties.rarity(Rarity.RARE).stacksTo(64).fireResistant());
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }
}
