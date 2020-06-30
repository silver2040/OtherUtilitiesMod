package com.Silver2040.OtherUtilities.objects.blocks;

import com.Silver2040.OtherUtilities.OtherUtilities;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;

public class BlockItemBase extends BlockItem {

    public BlockItemBase(Block block) {
        super(block, new Item.Properties().group(OtherUtilities.TAB));
    }
}
