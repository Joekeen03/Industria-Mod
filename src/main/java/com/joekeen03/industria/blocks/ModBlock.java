package com.joekeen03.industria.blocks;

import com.joekeen03.industria.IndustriaMod;
import com.joekeen03.industria.client.render.IHasModel;
import com.joekeen03.industria.items.IndustriaItems;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;

public class ModBlock extends Block implements IHasModel {
    public ModBlock(String name, Material material)
    {
        super(material);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);

        IndustriaBlocks.BLOCKS.add(this);
        IndustriaItems.ITEMS.add(new ItemBlock(this).setRegistryName(this.getRegistryName()));
    }

    @Override
    public void registerModels()
    {
        IndustriaMod.proxy.registerItemRenderer(Item.getItemFromBlock(this), 0, "inventory");
    }
}
