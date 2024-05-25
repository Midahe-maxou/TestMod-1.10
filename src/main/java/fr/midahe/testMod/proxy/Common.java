package fr.midahe.testMod.proxy;

import fr.midahe.testMod.instances.Items;
import fr.midahe.testMod.instances.Recipies;
import fr.midahe.testMod.instances.items.Blocks;

public class Common {

    public void preInit()
    {
        new Items();
        new Blocks();
    }

    public void init()
    {
        new Recipies();
    }

    public void postInit()
    {

    }
}
