package com.joekeen03.industria;

import com.joekeen03.industria.proxy.CommonProxy;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.logging.log4j.Logger;

@Mod(modid = IndustriaMod.MODID, name = IndustriaMod.NAME, version = IndustriaMod.VERSION,
dependencies = "required:cubicchunks@[0.0.1213.0,)")
public class IndustriaMod
{
    public static final String MODID = "industria";
    public static final String NAME = "Industria";
    public static final String VERSION = "0.0.0";

    private static Logger logger;

    @Mod.Instance
    public static IndustriaMod instance;

    @SidedProxy (clientSide="ClientProxy", serverSide="CommonProxy")
    public static CommonProxy proxy;

    public IndustriaMod()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
        proxy.preInit(event);
    }

    @EventHandler
    public void init(FMLInitializationEvent event)
    {
        proxy.init(event);
    }

    @SubscribeEvent
    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        proxy.registerBlocks(event);
    }

    @SubscribeEvent
    public void registerItems(RegistryEvent.Register<Item> event)
    {
        proxy.registerItems(event);
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event)
    {
        proxy.registerModels(event);
    }

    public static void info(String message) {
        logger.info(message);
    }

    public static void debug(String message) {
        logger.debug(message);
    }

    public static void error(String message) {
        logger.error(message);
    }

    public static void fatal(String message) {
        logger.fatal(message);
    }
}
