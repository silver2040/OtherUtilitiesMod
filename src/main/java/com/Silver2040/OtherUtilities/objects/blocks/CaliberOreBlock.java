package com.Silver2040.OtherUtilities.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class CaliberOreBlock extends Block {
    public CaliberOreBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f,9.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
        
    }
}
