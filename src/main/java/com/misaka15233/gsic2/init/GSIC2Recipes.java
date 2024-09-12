package com.misaka15233.gsic2.init;

import galaxyspace.core.GSBlocks;
import galaxyspace.core.GSItems;
import galaxyspace.systems.BarnardsSystem.core.BRBlocks;
import ic2.api.item.IC2Items;
import ic2.api.recipe.Recipes;
import ic2.core.uu.UuIndex;
import micdoodle8.mods.galacticraft.core.GCBlocks;
import micdoodle8.mods.galacticraft.core.GCItems;
import micdoodle8.mods.galacticraft.planets.asteroids.items.AsteroidsItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;

public class GSIC2Recipes {
    public static void addRecipes() {
        //CRAFTING
        Recipes.advRecipes.addRecipe(new ItemStack(GSIC2Items.NICKEL_DUST, 1),
                new Object[] {
                        "XXX",
                        "XXX",
                        "XXX",
                        'X', new ItemStack(GSIC2Items.NICKEL_PILE, 1)
                });
        Recipes.advRecipes.addRecipe(new ItemStack(GSIC2Items.COBALT_DUST, 1),
                new Object[] {
                        "XXX",
                        "XXX",
                        "XXX",
                        'X', new ItemStack(GSIC2Items.COBALT_PILE, 1)
                });
        Recipes.advRecipes.addRecipe(new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1),
                new Object[] {
                        "XXX",
                        "XXX",
                        "XXX",
                        'X', new ItemStack(GSIC2Items.MAGNESIUM_PILE, 1)
                });
        Recipes.advRecipes.addRecipe(new ItemStack(GCItems.ic2compat, 1, 0),
                new Object[] {
                        "XXX",
                        "XXX",
                        "XXX",
                        'X', new ItemStack(GSIC2Items.ALUMINUM_PILE, 1)
                });
        Recipes.advRecipes.addRecipe(new ItemStack(GCItems.basicItem, 1,5),
                new Object[] {
                        "XXX",
                        "XXX",
                        "XXX",
                        'X', new ItemStack(GSIC2Items.ALUMINUM_NUGGET, 1)
                });
        Recipes.advRecipes.addShapelessRecipe(new ItemStack(GSIC2Items.ALUMINUM_NUGGET, 9),
                new Object[] {new ItemStack(GCItems.basicItem, 1,5)
                });

        Recipes.advRecipes.addRecipe(new ItemStack(GSIC2Items.RECORD_FTL),
                new Object[] {
                        "XXX",
                        "XRX",
                        "XXX",
                        'X', new ItemStack(Items.GOLD_INGOT, 1),
                        'R', new ItemStack(GCItems.basicItem, 1, 6)
                });

        //SMELTING
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.NICKEL_CRUSHED, 1), new ItemStack(GSItems.INGOTS, 1, 2), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.COBALT_CRUSHED, 1), new ItemStack(GSItems.INGOTS, 1, 0), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.MAGNESIUM_CRUSHED, 1), new ItemStack(GSItems.INGOTS, 1, 1), 0.5F);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.NICKEL_PURIFIED, 1), new ItemStack(GSItems.INGOTS, 1, 2), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.COBALT_PURIFIED, 1), new ItemStack(GSItems.INGOTS, 1, 0), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.MAGNESIUM_PURIFIED, 1), new ItemStack(GSItems.INGOTS, 1, 1), 0.5F);

        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.NICKEL_DUST, 1), new ItemStack(GSItems.INGOTS, 1, 2), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.COBALT_DUST, 1), new ItemStack(GSItems.INGOTS, 1, 0), 0.5F);
        FurnaceRecipes.instance().addSmeltingRecipe(new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1), new ItemStack(GSItems.INGOTS, 1, 1), 0.5F);

        //MACERATOR
        ItemStack dustCoal = IC2Items.getItem("dust", "coal");
        dustCoal.setCount(9);
        ItemStack dustIron = IC2Items.getItem("dust", "iron");
        dustCoal.setCount(1);

        Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("oreNickel", 1),
                null, false, new ItemStack(GSIC2Items.NICKEL_CRUSHED, 2));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("oreCobalt", 1),
                null, false, new ItemStack(GSIC2Items.COBALT_CRUSHED, 2));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forOreDict("oreMagnesium", 1),
                null, false, new ItemStack(GSIC2Items.MAGNESIUM_CRUSHED, 2));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSBlocks.MARS_ORES, 1, 5), 1),
                null, false, new ItemStack(GCItems.ic2compat, 2, 2));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSBlocks.EUROPA_BLOCKS, 1, 5), 1),
                null, false, new ItemStack(GCItems.ic2compat, 2, 2));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSBlocks.HAUMEA_BLOCKS, 1, 3), 1),
                null, false, new ItemStack(GCItems.ic2compat, 2, 2));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(BRBlocks.BARNARDA_C_ORES, 1, 9), 1),
                null, false, new ItemStack(GCItems.ic2compat, 2, 2));

        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.INGOTS, 1, 2), 1),
                null, false, new ItemStack(GSIC2Items.NICKEL_DUST, 1));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.INGOTS, 1, 0), 1),
                null, false, new ItemStack(GSIC2Items.COBALT_DUST, 1));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.INGOTS, 1, 1), 1),
                null, false, new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1));

        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.COMPRESSED_PLATES, 1, 3), 1),
                null, false, new ItemStack(GSIC2Items.NICKEL_DUST, 1));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.COMPRESSED_PLATES, 1, 1), 1),
                null, false, new ItemStack(GSIC2Items.COBALT_DUST, 1));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.COMPRESSED_PLATES, 1, 2), 1),
                null, false, new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.COMPRESSED_PLATES, 1, 0), 1),
                null, false, dustCoal);

        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(AsteroidsItems.basicItem, 1, 3), 1),
                null, false, dustIron);
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(AsteroidsItems.basicItem, 1, 4), 1),
                null, false, new ItemStack(AsteroidsItems.basicItem, 1, 9));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.BASIC, 1, 3), 1),
                null, false, new ItemStack(GSItems.BASIC, 6, 4));
        Recipes.macerator.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSBlocks.ENCELADUS_CRYSTAL, 1), 1),
                null, false, new ItemStack(GSItems.BASIC, 4, 8));

        //ORE_WASHING
        NBTTagCompound amountTag = new NBTTagCompound();
        amountTag.setInteger("amount", 1000);
        ItemStack dustSmallIron = IC2Items.getItem("dust", "small_iron");
        dustSmallIron.setCount(2);
        ItemStack dustStone = IC2Items.getItem("dust", "stone");
        dustStone.setCount(1);
        
        Recipes.oreWashing.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.NICKEL_CRUSHED, 1), 1), amountTag, false,
                new ItemStack[]{new ItemStack(GSIC2Items.NICKEL_PURIFIED, 1), dustSmallIron, dustStone});
        Recipes.oreWashing.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.COBALT_CRUSHED, 1), 1), amountTag, false,
                new ItemStack[]{new ItemStack(GSIC2Items.COBALT_PURIFIED, 1), dustSmallIron, dustStone});
        Recipes.oreWashing.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.MAGNESIUM_CRUSHED, 1), 1), amountTag, false,
                new ItemStack[]{new ItemStack(GSIC2Items.MAGNESIUM_PURIFIED, 1), new ItemStack(GSIC2Items.MAGNESIUM_PILE, 2), dustStone});

        //CENTRIFUGE
        NBTTagCompound heatTag1 = new NBTTagCompound();
        heatTag1.setInteger("minHeat", 2000);
        NBTTagCompound heatTag2 = new NBTTagCompound();
        heatTag2.setInteger("minHeat", 3500);
        NBTTagCompound heatTag3 = new NBTTagCompound();
        heatTag3.setInteger("minHeat", 750);
        NBTTagCompound heatTag4 = new NBTTagCompound();
        heatTag4.setInteger("minHeat", 1000);
        
        Recipes.centrifuge.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.NICKEL_PURIFIED, 1), 1), heatTag1, false,
                new ItemStack[]{new ItemStack(GSIC2Items.NICKEL_DUST, 1), new ItemStack(GSIC2Items.COBALT_PILE, 1)});
        Recipes.centrifuge.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.COBALT_PURIFIED, 1), 1), heatTag1, false,
                new ItemStack[]{new ItemStack(GSIC2Items.COBALT_DUST, 1), new ItemStack(GSIC2Items.NICKEL_PILE, 1)});
        Recipes.centrifuge.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.MAGNESIUM_PURIFIED, 1), 1), heatTag1, false,
                new ItemStack[]{new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1), new ItemStack(GSIC2Items.ALUMINUM_PILE, 1)});

        Recipes.centrifuge.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.NICKEL_CRUSHED, 1), 1), heatTag3, false,
                new ItemStack[]{new ItemStack(GSIC2Items.NICKEL_DUST, 1), new ItemStack(GSIC2Items.COBALT_PILE, 1), dustStone});
        Recipes.centrifuge.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.COBALT_CRUSHED, 1), 1), heatTag3, false,
                new ItemStack[]{new ItemStack(GSIC2Items.COBALT_DUST, 1), new ItemStack(GSIC2Items.NICKEL_PILE, 1), dustStone});
        Recipes.centrifuge.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.MAGNESIUM_CRUSHED, 1), 1), heatTag3, false,
                new ItemStack[]{new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1), new ItemStack(GSIC2Items.ALUMINUM_PILE, 1), dustStone});

        //COMPRESSOR
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotNickel", 9),
                null, false, new ItemStack(GSBlocks.DECO_METALS, 1,9));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotCobalt", 9),
                null, false, new ItemStack(GSBlocks.DECO_METALS, 1,8));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotMagnesium", 9),
                null, false, new ItemStack(GSBlocks.DECO_METALS, 1,10));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("ingotAluminum", 9),
                null, false, new ItemStack(GCBlocks.basicBlock,1,11));

        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("nuggetNickel", 9),
                null, false, new ItemStack(GSItems.INGOTS, 1, 2));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("nuggetCobalt", 9),
                null, false, new ItemStack(GSItems.INGOTS, 1, 0));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("nuggetMagnesium", 9),
                null, false, new ItemStack(GSItems.INGOTS, 1, 1));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forOreDict("nuggetAluminum", 9),
                null, false, new ItemStack(GCItems.basicItem, 1,5));

        Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.NICKEL_PILE, 9)),
                null, false, new ItemStack(GSIC2Items.NICKEL_DUST, 1));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.COBALT_PILE, 9)),
                null, false, new ItemStack(GSIC2Items.COBALT_DUST, 1));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.MAGNESIUM_PILE, 9)),
                null, false, new ItemStack(GSIC2Items.MAGNESIUM_DUST, 1));
        Recipes.compressor.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSIC2Items.ALUMINUM_PILE, 9)),
                null, false, new ItemStack(GCItems.ic2compat, 1, 0));

        //BLASTFURNACE
        NBTTagCompound blastfurnaceMeta = new NBTTagCompound();
        blastfurnaceMeta.setInteger("fluid", 4);
        blastfurnaceMeta.setInteger("duration", 1000);
        ItemStack ingotRefinedIron = IC2Items.getItem("ingot", "refined_iron");
        ingotRefinedIron.setCount(2);
        ItemStack slag = IC2Items.getItem("misc_resource", "slag");
        slag.setCount(1);

        Recipes.blastfurnace.addRecipe(Recipes.inputFactory.forStack(new ItemStack(GSItems.BASIC, 1, 6)), blastfurnaceMeta, false,
                new ItemStack[] {ingotRefinedIron, slag});

        //UU
        UuIndex.instance.add(new ItemStack(GSItems.INGOTS, 1, 2), 1e2);
        UuIndex.instance.add(new ItemStack(GSItems.INGOTS, 1, 0), 1e2);
        UuIndex.instance.add(new ItemStack(GSItems.INGOTS, 1, 1), 1e2);
        UuIndex.instance.add(new ItemStack(GCItems.basicItem, 1, 5), 1e2);
    }

}
