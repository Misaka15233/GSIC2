package com.misaka15233.gsic2.items;

import com.misaka15233.gsic2.core.RegisterUtil;
import com.misaka15233.gsic2.init.GSIC2Tabs;
import galaxyspace.core.util.GSCreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String name) {
        setCreativeTab(GSIC2Tabs.GSIC2Tabs);
        RegisterUtil.initItem(this, name);
    }
}
