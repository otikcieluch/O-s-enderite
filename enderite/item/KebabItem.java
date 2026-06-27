package enderite.item;

import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;

public class KebabItem extends Item {
   public KebabItem(Item.Properties properties) {
      super(properties.rarity(Rarity.EPIC).stacksTo(64).food((new FoodProperties.Builder()).nutrition(15).saturationModifier(2.5F).alwaysEdible().build()));
   }
}
