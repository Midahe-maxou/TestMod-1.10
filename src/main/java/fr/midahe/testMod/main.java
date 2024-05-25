package fr.midahe.testMod;

import fr.midahe.testMod.proxy.Common;
import fr.midahe.testMod.utils.references;
import fr.midahe.testMod.instances.items.Blocks;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = references.MODID, name = references.NAME,version = references.VERSION)
public class main {

    public static final CreativeTabs creativeTab = new CreativeTabs("Mod") {
        @Override
        public Item getTabIconItem() {
            return Item.getItemFromBlock(Blocks.basicalBlock);
        }
    };

    @SidedProxy(clientSide = references.CLIENT_PROXY, serverSide = references.SERVER_PROXY)
    public static Common proxy;

    @Mod.Instance(references.MODID)
    public static main instance;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
        proxy.preInit();
    }

    @Mod.EventHandler
    public void Init(FMLInitializationEvent e)
    {
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.postInit();
    }
}