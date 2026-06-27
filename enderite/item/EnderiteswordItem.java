package enderite.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class EnderiteswordItem extends SwordItem {
   private static final ToolMaterial TOOL_MATERIAL;

   public EnderiteswordItem(Item.Properties properties) {
      super(TOOL_MATERIAL, 16.5F, 1.0F, properties.fireResistant());
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   static {
      TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 100000, 10.0F, 0.0F, 10000, TagKey.create(Registries.ITEM, ResourceLocation.parse("enderite:enderitesword_repair_items")));
   }
}
