package com.misaka15233.gsic2;

import com.misaka15233.gsic2.init.GSIC2OreDictionary;
import com.misaka15233.gsic2.init.GSIC2Recipes;
import micdoodle8.mods.galacticraft.core.util.CompatibilityManager;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = GSIC2.MODID,
        name = GSIC2.NAME,
        version = GSIC2.VERSION,
        dependencies = GSIC2.PREMOD,
        acceptedMinecraftVersions = GSIC2.MCVERSION
)

public class GSIC2
{
    public static final String MODID = "gsic2";
    public static final String NAME = "GSIC2";
    public static final String VERSION = "1.0";
    public static final String PREMOD = "required-after:forge@[14.23.5.2847,); required-after:galacticraftcore@[4.0.2.282,); required-after:galacticraftplanets; required-after:asmodeuscore@[1.0.2,); required-after:galaxyspace@[1.0.2,); required-after:ic2";
    public static final String MCVERSION = "[1.12.2]";
    public static final String ASSET_PREFIX = MODID;
    public static final String TEXTURE_PREFIX = ASSET_PREFIX + ":";

    private static Logger logger;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        logger = event.getModLog();
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        GSIC2OreDictionary.oreDictRegistration();
        GSIC2Recipes.addRecipes();
    }
}
