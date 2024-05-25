package fr.midahe.testMod.instances.items;

import fr.midahe.testMod.main;
import net.minecraft.command.server.CommandBroadcast;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class CoalSword extends net.minecraft.item.ItemSword {

    public CoalSword(String name, ToolMaterial material) {
        super(material);
        this.setRegistryName(name);
        this.setUnlocalizedName(name);
        this.setCreativeTab(main.creativeTab);
    }



    @Override
    public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {


        player.jump();
        CommandBroadcast.buildString(new String[]{"hey!"}, 0);

        return super.onItemRightClick(stack, world, player, hand);
    }
}
