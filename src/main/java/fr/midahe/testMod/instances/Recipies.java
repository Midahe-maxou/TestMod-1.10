package fr.midahe.testMod.instances;

import net.minecraft.item.ItemStack;
import net.minecraftforge.common.brewing.BrewingRecipeRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class Recipies {

    public Recipies() {
        registerCraft();
        registerFurnace();
        registerBrewing();
    }

    public void registerCraft()
    {
        GameRegistry.addShapedRecipe(new ItemStack(Items.coalPickaxe), new Object[]{"CCC"," S "," S ", 'C', net.minecraft.init.Items.COAL, 'S', net.minecraft.init.Items.STICK});
        GameRegistry.addRecipe(new ItemStack(Items.coalSword), "C","C","S", 'C', net.minecraft.init.Items.COAL, 'S', net.minecraft.init.Items.STICK);
    }

    public void registerFurnace()
    {
        GameRegistry.addSmelting(Items.coalSword, new ItemStack(net.minecraft.init.Items.COAL), 500f);
    }

    public void registerBrewing()
    {
        BrewingRecipeRegistry.addRecipe(new ItemStack(Items.coalPickaxe), new ItemStack(net.minecraft.init.Items.REDSTONE), new ItemStack(fr.midahe.testMod.instances.items.Blocks.basicalBlock));
    }

}
