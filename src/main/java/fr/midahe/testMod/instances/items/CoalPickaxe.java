package fr.midahe.testMod.instances.items;

import com.google.common.collect.ImmutableSet;
import fr.midahe.testMod.instances.Items;
import fr.midahe.testMod.main;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Set;

public class CoalPickaxe extends net.minecraft.item.ItemTool {


    public CoalPickaxe(String name, ToolMaterial material, Set<Block> EffectiveBlocks) {
        super(material, EffectiveBlocks);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(main.creativeTab);

    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        return ImmutableSet.of("pickaxe");
    }

    @Override
    public float getStrVsBlock(ItemStack stack, IBlockState state) {
        return (Items.EffectiveBlocksWithCoalTools.contains(state.getBlock()) || state.getMaterial() == Material.ROCK) ? this.efficiencyOnProperMaterial : 1f;
    }

    @Override
    public boolean canHarvestBlock(IBlockState block) {
        return (Items.EffectiveBlocksWithCoalTools.contains(block.getBlock()) || block.getMaterial() == Material.ROCK) ? true : false;
    }

    @Override
    public boolean onBlockDestroyed(ItemStack stack, World world, IBlockState state, BlockPos pos, EntityLivingBase player) {

        int i = 0;

        for(Block b : Items.EffectiveBlocksWithCoalTools)
        {
            i++;
            Minecraft.getMinecraft().getIntegratedServer().getCommandManager().executeCommand(Minecraft.getMinecraft().getIntegratedServer(), "/say " + b.getLocalizedName() + i);
        }

        return super.onBlockDestroyed(stack, world, state, pos, player);
    }
}
