package com.Silver2040.OtherUtilities.objects.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.Items;
import net.minecraftforge.common.ToolType;

public class InsanityBlock extends Block{
    public InsanityBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(1.0f,9.0f)
                .sound(SoundType.METAL)
                .harvestLevel(2)
                .harvestTool(ToolType.PICKAXE)
                .func_235838_a_((p_235470_0_) -> {
                    return 14;
                }));


    }


}
