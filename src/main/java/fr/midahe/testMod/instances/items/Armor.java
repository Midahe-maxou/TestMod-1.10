package fr.midahe.testMod.instances.items;

import fr.midahe.testMod.main;
import net.minecraft.inventory.EntityEquipmentSlot;

public class Armor extends net.minecraft.item.ItemArmor {

    public Armor(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(main.creativeTab);
    }
}
