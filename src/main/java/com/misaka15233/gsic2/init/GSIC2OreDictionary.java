package com.misaka15233.gsic2.init;

import galaxyspace.core.GSBlocks;
import galaxyspace.core.GSItems;
import galaxyspace.systems.BarnardsSystem.core.BRBlocks;
import micdoodle8.mods.galacticraft.core.util.CompatibilityManager;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class GSIC2OreDictionary {
    public static void oreDictRegistration()
    {
        //BLOCK
        OreDictionary.registerOre("blockNickel", new ItemStack(GSBlocks.DECO_METALS, 1,9));
        OreDictionary.registerOre("blockCobalt", new ItemStack(GSBlocks.DECO_METALS, 1,8));
        OreDictionary.registerOre("blockMagnesium", new ItemStack(GSBlocks.DECO_METALS, 1,10));
        //ALUMINIUM
        OreDictionary.registerOre("oreAluminum", new ItemStack(GSBlocks.MARS_ORES, 1, 5));
        OreDictionary.registerOre("oreAluminum", new ItemStack(GSBlocks.EUROPA_BLOCKS, 1, 5));
        OreDictionary.registerOre("oreAluminum", new ItemStack(GSBlocks.HAUMEA_BLOCKS, 1, 3));
        OreDictionary.registerOre("oreAluminum", new ItemStack(BRBlocks.BARNARDA_C_ORES, 1, 9));
        //NICKEL
        OreDictionary.registerOre("oreNickel", new ItemStack(GSBlocks.PHOBOS_BLOCKS,1, 4));
        //NUGGET
        OreDictionary.registerOre("nuggetNickel",new ItemStack(GSItems.NUGGETS, 1,2));
        OreDictionary.registerOre("nuggetCobalt",new ItemStack(GSItems.NUGGETS, 1,0));
        OreDictionary.registerOre("nuggetMagnesium",new ItemStack(GSItems.NUGGETS, 1,1));
        OreDictionary.registerOre("nuggetAluminum",new ItemStack(GSIC2Items.ALUMINUM_NUGGET, 1));
        //IC2
        if (CompatibilityManager.isIc2Loaded())
        {
            OreDictionary.registerOre("crushedNickel",new ItemStack(GSIC2Items.NICKEL_CRUSHED, 1));
            OreDictionary.registerOre("crushedCobalt",new ItemStack(GSIC2Items.COBALT_CRUSHED, 1));
            OreDictionary.registerOre("crushedMagnesium",new ItemStack(GSIC2Items.MAGNESIUM_CRUSHED, 1));

            OreDictionary.registerOre("crushedPurifiedNickel",new ItemStack(GSIC2Items.NICKEL_PURIFIED, 1));
            OreDictionary.registerOre("crushedPurifiedCobalt",new ItemStack(GSIC2Items.COBALT_PURIFIED, 1));
            OreDictionary.registerOre("crushedPurifiedMagnesium",new ItemStack(GSIC2Items.MAGNESIUM_PURIFIED, 1));

            OreDictionary.registerOre("dustNickel",new ItemStack(GSIC2Items.NICKEL_DUST, 1));
            OreDictionary.registerOre("dustCobalt",new ItemStack(GSIC2Items.COBALT_DUST, 1));
            OreDictionary.registerOre("dustMagnesium",new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1));

            OreDictionary.registerOre("dustTinyNickel",new ItemStack(GSIC2Items.NICKEL_PILE, 1));
            OreDictionary.registerOre("dustTinyCobalt",new ItemStack(GSIC2Items.COBALT_PILE, 1));
            OreDictionary.registerOre("dustTinyMagnesium",new ItemStack(GSIC2Items.MAGNESIUM_PILE, 1));
            OreDictionary.registerOre("dustTinyAluminum",new ItemStack(GSIC2Items.ALUMINUM_PILE, 1));
        }
        //RECORD
        OreDictionary.registerOre("record", new ItemStack(GSIC2Items.RECORD_FTL, 1));
    }
}
