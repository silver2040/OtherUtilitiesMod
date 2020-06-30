package com.Silver2040.OtherUtilities.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class VibraniumBlock extends Block {
    public VibraniumBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(100.0f,1500.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)
        );
    }
}
