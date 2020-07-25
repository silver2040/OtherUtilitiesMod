package com.Silver2040.OtherUtilities.objects.items.rightClickItems;


import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.world.World;

public class WeatherItem extends Item {
    public int NumberClicked = 1;
    public WeatherItem(Properties properties) {
        super(properties);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, PlayerEntity playerIn, Hand handIn) {

        if (NumberClicked == 2){
            worldIn.setRainStrength(2);
        }
        if (NumberClicked == 3){
            worldIn.setThunderStrength(5);
        }
        if(NumberClicked == 4){
            worldIn.setThunderStrength(0);
            worldIn.setRainStrength(0);
            NumberClicked = 1;


        }
        NumberClicked++;

        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}
