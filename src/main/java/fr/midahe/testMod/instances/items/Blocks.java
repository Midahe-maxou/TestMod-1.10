package fr.midahe.testMod.instances.items;

import fr.midahe.testMod.utils.references;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Blocks {

	public static Block basicalBlock;

	public Blocks() {
		initBlock();
		registers();
		registerBlocks();
		registerRenders();
	}

	public void initBlock()
	{
		basicalBlock = new Block(Material.IRON).setRegistryName("basicalBlock").setUnlocalizedName("basicalBlock");
	}

	private void registers()
	{
		register(this.basicalBlock);
	}

	private void registerBlocks()
	{
		registerBlock(this.basicalBlock);
	}

	private void registerRenders()
	{
		registerRender(this.basicalBlock, 0);
	}


	private void register(Block block)
	{
		GameRegistry.register(block);
	}

	private void registerBlock(Block block)
	{
		ItemBlock ib = new ItemBlock(block);
		ib.setRegistryName(block.getRegistryName());
		GameRegistry.register(ib);
	}

	@SideOnly(Side.CLIENT)
	private void registerRender(Block block, int meta)
	{
		ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta, new ModelResourceLocation(new ResourceLocation(references.MODID, Item.getItemFromBlock(block).getUnlocalizedName().substring(5)), "inventory"));
	}

}
