package fr.midahe.testMod.instances;

import com.google.common.collect.Sets;
import fr.midahe.testMod.instances.items.*;
import fr.midahe.testMod.main;
import fr.midahe.testMod.utils.references;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Set;


public class Items {

    public Items() {
        initItem();
        registerItems();
        registerRenders();
    }


    public static Item basicalItem, itemMeta, fuckingFood,
            stoneHelmet, stoneChest, stoneLeggings, stoneBoots,
            coalSword, coalPickaxe;

    public static Set<Block> EffectiveBlocksWithCoalTools = Sets.newHashSet();

    public void initItem() {

        Material.setToolsEfficienciness();

        basicalItem = new Item().setRegistryName("basicalItem").setUnlocalizedName("basicalItem").setCreativeTab(main.creativeTab);
        itemMeta = new ItemMeta("itemMeta", 1, 2, 3);
        fuckingFood = new Food(9, 10f, false).setRegistryName("fuckingFood").setUnlocalizedName("fuckingFood").setCreativeTab(main.creativeTab);
        stoneHelmet = new Armor("stoneHelmet", Material.STONE_ARMOR, 0, EntityEquipmentSlot.HEAD);
        stoneChest = new Armor("stoneChest", Material.STONE_ARMOR, 0, EntityEquipmentSlot.CHEST);
        stoneLeggings = new Armor("stoneLeggings", Material.STONE_ARMOR, 0, EntityEquipmentSlot.LEGS);
        stoneBoots = new Armor("stoneBoots", Material.STONE_ARMOR, 0, EntityEquipmentSlot.FEET);
        coalSword = new CoalSword("coalSword", Material.COAL_TOOL);
        coalPickaxe = new CoalPickaxe("coalPickaxe", Material.COAL_TOOL, Items.EffectiveBlocksWithCoalTools);
    }

    public void registerItems() {
        registerItem(Items.basicalItem);
        registerItem(Items.itemMeta);
        registerItem(Items.fuckingFood);
        registerItem(Items.stoneHelmet);
        registerItem(Items.stoneChest);
        registerItem(Items.stoneLeggings);
        registerItem(Items.stoneBoots);
        registerItem(Items.coalSword);
        registerItem(Items.coalPickaxe);
    }

    @SideOnly(Side.CLIENT)
    public void registerRenders() {
        registerRender(Items.basicalItem);
        registerRender(Items.itemMeta, 0);
        registerRender(Items.itemMeta, 1);
        registerRender(Items.itemMeta, 2);
        registerRender(Items.fuckingFood);

        registerRender(Items.stoneHelmet);
        registerRender(Items.stoneChest);
        registerRender(Items.stoneLeggings);
        registerRender(Items.stoneBoots);
    }

    private void registerItem(Item item) {
        GameRegistry.register(item);
    }

    private void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(new ResourceLocation(references.MODID, item.getUnlocalizedName().substring(5)), "inventory"));
    }


    private void registerRender(Item item, int meta) {
        ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(new ResourceLocation(references.MODID, item.getUnlocalizedName().substring(5) + meta), "inventory"));
    }


    public static class Material {

        public static final ItemArmor.ArmorMaterial STONE_ARMOR = EnumHelper.addArmorMaterial("StoneArmor", references.MODID + ":stoneArmor", 10, new int[]{1,3,4,2}, 0, SoundEvents.ITEM_ARMOR_EQUIP_IRON,0f);
        public static final Item.ToolMaterial COAL_TOOL = EnumHelper.addToolMaterial("coalTool", 2, 150, 10f, 2.5f, 2);

        public static void setToolsEfficienciness() {
            int[] coalId = {1, 3, 4, 7, 14, 15, 16, 23, 24, 44, 45, 48, 56, 57, 67, 73, 87,
                    108, 109, 121, 129, 133, 139, 145, 153, 155, 159, 168, 169, 179, 180, 182,
                    201, 202, 203, 205, 206, 213, 214, 216};

            for (int id : coalId) {
                Items.EffectiveBlocksWithCoalTools.add(Block.getBlockById(id));
            }
        }
    }
}