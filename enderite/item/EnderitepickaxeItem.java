package enderite.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.ToolMaterial;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;

public class EnderitepickaxeItem extends PickaxeItem {
   private static final ToolMaterial TOOL_MATERIAL;

   public EnderitepickaxeItem(Item.Properties properties) {
      super(TOOL_MATERIAL, 4.0F, 3.5F, properties.fireResistant());
   }

   @OnlyIn(Dist.CLIENT)
   public boolean isFoil(ItemStack itemstack) {
      return true;
   }

   static {
      TOOL_MATERIAL = new ToolMaterial(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 100000, 100.0F, 0.0F, 100000, TagKey.create(Registries.ITEM, ResourceLocation.parse("enderite:enderitepickaxe_repair_items")));
   }
}
