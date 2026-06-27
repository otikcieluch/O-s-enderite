package enderite.init;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.registries.DeferredRegister;

@EventBusSubscriber(
   bus = Bus.MOD
)
public class EnderiteModTabs {
   public static final DeferredRegister<CreativeModeTab> REGISTRY;

   @SubscribeEvent
   public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
      if (tabData.getTabKey() == CreativeModeTabs.INGREDIENTS) {
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEINGOT.get());
         tabData.accept(((Block)EnderiteModBlocks.ENDERITEORE.get()).asItem());
         tabData.accept(((Block)EnderiteModBlocks.ENDERITEBLOCK.get()).asItem());
         tabData.accept((ItemLike)EnderiteModItems.ENDRITESHARD.get());
      } else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
         tabData.accept(((Block)EnderiteModBlocks.ENDERITEORE.get()).asItem());
         tabData.accept(((Block)EnderiteModBlocks.ENDERITEBLOCK.get()).asItem());
      } else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
         tabData.accept((ItemLike)EnderiteModItems.ENDERITESWORD.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEARMOR_HELMET.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEARMOR_CHESTPLATE.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEARMOR_LEGGINGS.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEARMOR_BOOTS.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEAXE.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEDAGGER.get());
      } else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEPICKAXE.get());
         tabData.accept((ItemLike)EnderiteModItems.ENDERITEAXE.get());
         tabData.accept((ItemLike)EnderiteModItems.ENERITEHOE.get());
      } else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
         tabData.accept((ItemLike)EnderiteModItems.KEBAB.get());
      } else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
         tabData.accept(((Block)EnderiteModBlocks.ENDERPLANT.get()).asItem());
      } else if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
         tabData.accept((ItemLike)EnderiteModItems.ENDWANDERER_SPAWN_EGG.get());
      }

   }

   static {
      REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, "enderite");
   }
}
