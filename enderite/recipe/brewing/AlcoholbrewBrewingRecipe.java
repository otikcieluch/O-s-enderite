package enderite.recipe.brewing;

import enderite.init.EnderiteModPotions;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.common.brewing.IBrewingRecipe;
import net.neoforged.neoforge.event.brewing.RegisterBrewingRecipesEvent;

@EventBusSubscriber
public class AlcoholbrewBrewingRecipe implements IBrewingRecipe {
   @SubscribeEvent
   public static void init(RegisterBrewingRecipesEvent event) {
      event.getBuilder().addRecipe(new AlcoholbrewBrewingRecipe());
   }

   public boolean isInput(ItemStack input) {
      return Ingredient.of(Items.GLASS_BOTTLE).test(input);
   }

   public boolean isIngredient(ItemStack ingredient) {
      return Ingredient.of(Items.PUFFERFISH).test(ingredient);
   }

   public ItemStack getOutput(ItemStack input, ItemStack ingredient) {
      return this.isInput(input) && this.isIngredient(ingredient) ? PotionContents.createItemStack(Items.POTION, EnderiteModPotions.ALCOHOL) : ItemStack.EMPTY;
   }
}
