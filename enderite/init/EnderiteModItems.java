package enderite.init;

import enderite.item.EnderitearmorItem;
import enderite.item.EnderiteaxeItem;
import enderite.item.EnderitedaggerItem;
import enderite.item.EnderiteingotItem;
import enderite.item.EnderitepickaxeItem;
import enderite.item.EnderiteswordItem;
import enderite.item.EndriteshardItem;
import enderite.item.EneritehoeItem;
import enderite.item.KebabItem;
import java.util.function.Function;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class EnderiteModItems {
   public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems("enderite");
   public static final DeferredItem<Item> ENDERITEINGOT = register("enderiteingot", EnderiteingotItem::new);
   public static final DeferredItem<Item> ENDERITEORE;
   public static final DeferredItem<Item> ENDERITESWORD;
   public static final DeferredItem<Item> ENDERITEBLOCK;
   public static final DeferredItem<Item> ENDERITEARMOR_HELMET;
   public static final DeferredItem<Item> ENDERITEARMOR_CHESTPLATE;
   public static final DeferredItem<Item> ENDERITEARMOR_LEGGINGS;
   public static final DeferredItem<Item> ENDERITEARMOR_BOOTS;
   public static final DeferredItem<Item> ENDERITEPICKAXE;
   public static final DeferredItem<Item> ENDRITESHARD;
   public static final DeferredItem<Item> KEBAB;
   public static final DeferredItem<Item> ENDERPLANT;
   public static final DeferredItem<Item> ENDWANDERER_SPAWN_EGG;
   public static final DeferredItem<Item> ENDERITEAXE;
   public static final DeferredItem<Item> ENERITEHOE;
   public static final DeferredItem<Item> ENDERITEDAGGER;

   private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
      return REGISTRY.registerItem(name, supplier, new Item.Properties());
   }

   private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
      return REGISTRY.registerItem(block.getId().getPath(), (properties) -> new BlockItem((Block)block.get(), properties), new Item.Properties());
   }

   static {
      ENDERITEORE = block(EnderiteModBlocks.ENDERITEORE);
      ENDERITESWORD = register("enderitesword", EnderiteswordItem::new);
      ENDERITEBLOCK = block(EnderiteModBlocks.ENDERITEBLOCK);
      ENDERITEARMOR_HELMET = register("enderitearmor_helmet", EnderitearmorItem.Helmet::new);
      ENDERITEARMOR_CHESTPLATE = register("enderitearmor_chestplate", EnderitearmorItem.Chestplate::new);
      ENDERITEARMOR_LEGGINGS = register("enderitearmor_leggings", EnderitearmorItem.Leggings::new);
      ENDERITEARMOR_BOOTS = register("enderitearmor_boots", EnderitearmorItem.Boots::new);
      ENDERITEPICKAXE = register("enderitepickaxe", EnderitepickaxeItem::new);
      ENDRITESHARD = register("endriteshard", EndriteshardItem::new);
      KEBAB = register("kebab", KebabItem::new);
      ENDERPLANT = block(EnderiteModBlocks.ENDERPLANT);
      ENDWANDERER_SPAWN_EGG = register("endwanderer_spawn_egg", (properties) -> new SpawnEggItem((EntityType)EnderiteModEntities.ENDWANDERER.get(), properties));
      ENDERITEAXE = register("enderiteaxe", EnderiteaxeItem::new);
      ENERITEHOE = register("eneritehoe", EneritehoeItem::new);
      ENDERITEDAGGER = register("enderitedagger", EnderitedaggerItem::new);
   }
}
