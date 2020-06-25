package com.Silver2040.OtherUtilities.items;

import com.Silver2040.OtherUtilities.OtherUtilities;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;

public class ItemBase extends Item {
    public ItemBase() {
        super(new Item.Properties().group(OtherUtilities.TAB));
    }
}
