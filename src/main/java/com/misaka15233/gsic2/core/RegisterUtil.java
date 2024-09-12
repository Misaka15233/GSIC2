package com.misaka15233.gsic2.core;

import com.misaka15233.gsic2.init.GSIC2Items;
import net.minecraft.item.Item;

public class RegisterUtil {
    public RegisterUtil() {
    }

    public static void initItem(Item item, String name) {
        item.setRegistryName(name);
        item.setUnlocalizedName(name);
        GSIC2Items.ITEM_LIST.add(item);
    }
}
