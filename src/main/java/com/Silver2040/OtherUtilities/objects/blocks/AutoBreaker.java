package com.Silver2040.OtherUtilities.objects.blocks;

import com.Silver2040.OtherUtilities.init.BlockInit;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraftforge.common.ToolType;

public class AutoBreaker extends Block {
    public AutoBreaker() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(3.0f,9.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
        );
    //onBlockActivated(BlockInit.Beskar_Steel_Block.get().getDefaultState(), )
    }
}
