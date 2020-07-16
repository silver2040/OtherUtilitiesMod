package com.Silver2040.OtherUtilities.util;

import com.Silver2040.OtherUtilities.init.ItemInit;
import com.Silver2040.OtherUtilities.objects.items.bows.BaseBow;
import net.minecraft.item.ItemModelsProperties;
import net.minecraft.util.ResourceLocation;

public class ItemPropertyOverrides {

    public static void doStuff() {
        ItemModelsProperties.func_239418_a_(ItemInit.diamond_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(ItemInit.diamond_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

        ItemModelsProperties.func_239418_a_(ItemInit.iron_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(ItemInit.iron_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

        ItemModelsProperties.func_239418_a_(ItemInit.gold_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(ItemInit.gold_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);

        ItemModelsProperties.func_239418_a_(ItemInit.netherite_bow.get(), new ResourceLocation("pull"), (stack, world, entity) -> {
            if (entity == null) {
                return 0F;
            } else {
                if (entity.getActiveItemStack().getItem() instanceof BaseBow) {
                    return (float)(stack.getUseDuration() - entity.getItemInUseCount()) / 20F;
                } else {
                    return 0F;
                }
            }
        });

        ItemModelsProperties.func_239418_a_(ItemInit.netherite_bow.get(), new ResourceLocation("pulling"), (stack, world, entity) -> entity != null && entity.isHandActive() && entity.getActiveItemStack() == stack ? 1F : 0F);
    }
}
