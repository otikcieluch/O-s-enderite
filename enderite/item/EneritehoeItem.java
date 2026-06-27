package enderite.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class EneritehoeItem extends HoeItem {
   private static final ToolMaterial TOOL_MATERIAL;

   public EneritehoeItem(Item.Properties properties) {
      super(TOOL_MATERIAL, 4.5F, -2.0F, properties.fireResistant());
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   static {
      TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_NETHERITE_TOOL, 118000, 7.5F, 0.0F, 56, TagKey.create(Registries.ITEM, ResourceLocation.parse("enderite:eneritehoe_repair_items")));
   }
}
