package com.misaka15233.gsic2.items;

import com.misaka15233.gsic2.core.RegisterUtil;
import com.misaka15233.gsic2.init.GSIC2Tabs;
import galaxyspace.core.util.GSCreativeTabs;
import net.minecraft.item.ItemRecord;
import net.minecraft.util.*;

public class ItemMusicDiscFTLBase extends ItemRecord {
    public static SoundEvent SOUND_EVENT = new SoundEvent(new ResourceLocation("gsic2", "fasterthanlight"));

    public ItemMusicDiscFTLBase(String name) {
        super(name, SOUND_EVENT);
        setCreativeTab(GSIC2Tabs.GSIC2Tabs);
        RegisterUtil.initItem(this, name);
    }
}
