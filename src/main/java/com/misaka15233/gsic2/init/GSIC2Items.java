package com.misaka15233.gsic2.init;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.misaka15233.gsic2.items.ItemBase;
import com.misaka15233.gsic2.items.ItemMusicDiscFTLBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber(
        modid = "gsic2"
)

public class GSIC2Items {
    public static final List<Item> ITEM_LIST = new ArrayList();

    public static final ItemBase ALUMINUM_NUGGET = new ItemBase("aluminum_nugget");
    
    public static final ItemBase NICKEL_CRUSHED = new ItemBase("nickel_crushed");
    public static final ItemBase COBALT_CRUSHED = new ItemBase("cobalt_crushed");
    public static final ItemBase MAGNESIUM_CRUSHED = new ItemBase("magnesium_crushed");

    public static final ItemBase NICKEL_PURIFIED = new ItemBase("nickel_purified");
    public static final ItemBase COBALT_PURIFIED = new ItemBase("cobalt_purified");
    public static final ItemBase MAGNESIUM_PURIFIED = new ItemBase("magnesium_purified");

    public static final ItemBase NICKEL_DUST = new ItemBase("nickel_dust");
    public static final ItemBase COBALT_DUST = new ItemBase("cobalt_dust");
    public static final ItemBase MAGNESIUM_DUST = new ItemBase("magnesium_dust");

    public static final ItemBase NICKEL_PILE = new ItemBase("nickel_pile");
    public static final ItemBase COBALT_PILE = new ItemBase("cobalt_pile");
    public static final ItemBase MAGNESIUM_PILE = new ItemBase("magnesium_pile");
    public static final ItemBase ALUMINUM_PILE = new ItemBase("aluminum_pile");

    public static final ItemMusicDiscFTLBase RECORD_FTL = new ItemMusicDiscFTLBase("faster_than_light");

    public GSIC2Items() {
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ITEM_LIST.toArray(new Item[ITEM_LIST.size()]));
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void registerModel(ModelRegistryEvent event) {
        Iterator var1 = ITEM_LIST.iterator();

        while(var1.hasNext()) {
            Item item = (Item)var1.next();
            ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
        }

    }
}
