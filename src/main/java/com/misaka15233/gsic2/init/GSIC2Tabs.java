package com.misaka15233.gsic2.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GSIC2Tabs {
    public static final CreativeTabs GSIC2Tabs = new CreativeTabs(CreativeTabs.getNextID(), "GSIC2") {
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(GSIC2Items.RECORD_FTL);
        }
    };
}
