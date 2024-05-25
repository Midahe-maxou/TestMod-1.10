package fr.midahe.testMod.instances.items;

import fr.midahe.testMod.main;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemMeta extends Item {

    public static int[] subTypes;


    public ItemMeta(String name, int... subType) {
        this.subTypes = subType;
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(main.creativeTab);
        this.setHasSubtypes(true);
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {

        int meta = stack.getItemDamage();


        if(meta < 0 || meta > subTypes.length)
        {
            meta = 0;
        }

        return super.getUnlocalizedName(stack) + subTypes[meta];
    }

    @Override
    public int getMetadata(ItemStack stack) {

        int meta = stack.getItemDamage();

        if(meta < 0 || meta > subTypes.length)
        {
            meta = 0;
        }

        return meta;
    }

    @Override
    public void getSubItems(Item itemIn, CreativeTabs tab, List<ItemStack> subItems) {
        for(int i=0;i<subTypes.length;i++)
        {
            subItems.add(new ItemStack(itemIn, 1, i));
        }
    }
}
