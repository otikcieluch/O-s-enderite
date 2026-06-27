package enderite.item;

import enderite.init.EnderiteModItems;
import java.util.Map;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.EventBusSubscriber.Bus;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.registries.DeferredHolder;

@EventBusSubscriber(
   bus = Bus.MOD
)
public abstract class EnderitearmorItem extends ArmorItem {
   public static ArmorMaterial ARMOR_MATERIAL;

   @SubscribeEvent
   public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
      event.registerItem(new IClientItemExtensions() {
         public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
            return ResourceLocation.parse("enderite:textures/models/armor/hfghgh_layer_1.png");
         }
      }, new Item[]{(Item)EnderiteModItems.ENDERITEARMOR_HELMET.get()});
      event.registerItem(new IClientItemExtensions() {
         public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
            return ResourceLocation.parse("enderite:textures/models/armor/hfghgh_layer_1.png");
         }
      }, new Item[]{(Item)EnderiteModItems.ENDERITEARMOR_CHESTPLATE.get()});
      event.registerItem(new IClientItemExtensions() {
         public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
            return ResourceLocation.parse("enderite:textures/models/armor/hfghgh_layer_2.png");
         }
      }, new Item[]{(Item)EnderiteModItems.ENDERITEARMOR_LEGGINGS.get()});
      event.registerItem(new IClientItemExtensions() {
         public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
            return ResourceLocation.parse("enderite:textures/models/armor/hfghgh_layer_1.png");
         }
      }, new Item[]{(Item)EnderiteModItems.ENDERITEARMOR_BOOTS.get()});
   }

   private EnderitearmorItem(ArmorType type, Item.Properties properties) {
      super(ARMOR_MATERIAL, type, properties);
   }

   static {
      ARMOR_MATERIAL = new ArmorMaterial(150, Map.of(ArmorType.BOOTS, 15, ArmorType.LEGGINGS, 25, ArmorType.CHESTPLATE, 30, ArmorType.HELMET, 20, ArmorType.BODY, 30), 100000, DeferredHolder.create(Registries.SOUND_EVENT, ResourceLocation.parse("item.armor.equip_netherite")), 20.0F, 1.0F, TagKey.create(Registries.ITEM, ResourceLocation.parse("enderite:enderitearmor_repair_items")), ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("enderite:enderitearmor")));
   }

   public static class Helmet extends EnderitearmorItem {
      public Helmet(Item.Properties properties) {
         super(ArmorType.HELMET, properties.fireResistant());
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }
   }

   public static class Chestplate extends EnderitearmorItem {
      public Chestplate(Item.Properties properties) {
         super(ArmorType.CHESTPLATE, properties.fireResistant());
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }
   }

   public static class Leggings extends EnderitearmorItem {
      public Leggings(Item.Properties properties) {
         super(ArmorType.LEGGINGS, properties.fireResistant());
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }
   }

   public static class Boots extends EnderitearmorItem {
      public Boots(Item.Properties properties) {
         super(ArmorType.BOOTS, properties.fireResistant());
      }

      public boolean makesPiglinsNeutral(ItemStack itemstack, LivingEntity entity) {
         return true;
      }
   }
}
