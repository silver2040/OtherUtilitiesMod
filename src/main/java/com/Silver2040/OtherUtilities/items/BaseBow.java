package com.Silver2040.OtherUtilities.items;

import com.Silver2040.OtherUtilities.OtherUtilities;
import net.minecraft.item.*;
import net.minecraft.util.ResourceLocation;


public class BaseBow extends BowItem {

    public BaseBow(int damage) {
        super((new Item.Properties()).group(OtherUtilities.TAB)
                .maxStackSize(1)
                .maxDamage(damage));


        this.addPropertyOverride(new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return 0F;
                } else {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                }
            }
        });

        this.addPropertyOverride(new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

    }

    @Override
    public int getItemEnchantability() {
        return 10;
    }


    private boolean isArrow(ItemStack stack) {
        return stack.getItem() instanceof ArrowItem;
    }


}
