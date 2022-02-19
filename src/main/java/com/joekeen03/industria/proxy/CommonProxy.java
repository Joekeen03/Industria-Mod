package com.joekeen03.industria.proxy;

import com.joekeen03.industria.IndustriaMod;
import com.joekeen03.industria.blocks.IndustriaBlocks;
import com.joekeen03.industria.client.render.IHasModel;
import com.joekeen03.industria.items.IndustriaItems;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class CommonProxy {
    public void registerItemRenderer(Item item, int meta, String id)
    {

    }


    public void preInit(FMLPreInitializationEvent event)
    {

    }

    public void init(FMLInitializationEvent event)
    {
        // some example code
        IndustriaMod.info(String.format("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName()));
    }

    public void registerBlocks(RegistryEvent.Register<Block> event)
    {
        event.getRegistry().registerAll(IndustriaBlocks.BLOCKS.toArray(new Block[0]));
        IndustriaMod.info("Registered blocks.");
    }

    public void registerItems(RegistryEvent.Register<Item> event)
    {
        event.getRegistry().registerAll(IndustriaItems.ITEMS.toArray(new Item[0]));
        IndustriaMod.info("Registered items.");
    }

    public void registerModels(ModelRegistryEvent event)
    {
        for (Block block : IndustriaBlocks.BLOCKS) {
            if (block instanceof IHasModel)
            {
                ((IHasModel) block).registerModels();
            }
        }
        for (Item item : IndustriaItems.ITEMS) {
            if (item instanceof IHasModel)
            {
                ((IHasModel) item).registerModels();
            }
        }
    }
}
