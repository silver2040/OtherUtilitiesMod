package com.Silver2040.OtherUtilities.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class MagmiumOreBlock extends Block {
    public MagmiumOreBlock() {
     super(Block.Properties.create(Material.ROCK)
            .hardnessAndResistance(3.0f,9.0f)
                .sound(SoundType.METAL)
                .harvestLevel(3)
                .harvestTool(ToolType.PICKAXE)

        );

}
}
