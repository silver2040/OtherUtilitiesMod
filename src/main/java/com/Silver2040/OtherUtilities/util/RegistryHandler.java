package com.Silver2040.OtherUtilities.util;

import com.Silver2040.OtherUtilities.OtherUtilities;
import com.Silver2040.OtherUtilities.blocks.*;
import com.Silver2040.OtherUtilities.items.*;
import net.minecraft.block.Block;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistryEntry;

import javax.imageio.spi.RegisterableService;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OtherUtilities.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, OtherUtilities.MOD_ID);

    public static void  init(){
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());

    }

    //public static final RegistryObject<Item> Caliber_Helmet = ITEMS.register("caliber_helmet", ItemBase::new);
    public static final RegistryObject<Block> Caliber_Block = BLOCKS.register("caliber_block", CaliberBlock::new);
    public static final RegistryObject<Item> Caliber_Block_Item = ITEMS.register("caliber_block", () -> new BlockItemBase(Caliber_Block.get()));
    public static final RegistryObject<Block> Vibranium_Block = BLOCKS.register("vibranium_block", VibraniumBlock::new);
    public static final RegistryObject<Item> Vibranium_Block_Item = ITEMS.register("vibranium_block", () -> new BlockItemBase(Vibranium_Block.get()));
    public static final RegistryObject<Block> Vibranium_Ore_Block = BLOCKS.register("vibranium_ore_block", VibraniumOreBlock::new);
    public static final RegistryObject<Item> Vibranium_Ore_Block_Item = ITEMS.register("vibranium_ore_block", () -> new BlockItemBase(Vibranium_Ore_Block.get()));
    public static final RegistryObject<Block> Caliber_Ore_Block = BLOCKS.register("caliber_ore_block", CaliberOreBlock::new);
    public static final RegistryObject<Item> Caliber_Ore_Block_Item = ITEMS.register("caliber_ore_block", () -> new BlockItemBase(Caliber_Ore_Block.get()));
    public static final RegistryObject<Block> Beskar_Steel_Block = BLOCKS.register("beskar_steel_block", BeskarSteelBlock::new);
    public static final RegistryObject<Item> Beskar_Steel_Block_Item = ITEMS.register("beskar_steel_block", () -> new BlockItemBase(Beskar_Steel_Block.get()));
    public static final RegistryObject<Item> Netherite_Bow = ITEMS.register("netherite_bow", NetheriteBow::new);
    public static final RegistryObject<Item> Diamond_Bow = ITEMS.register("diamond_bow", DiamondBow::new);
    public static final RegistryObject<Item> Iron_Bow = ITEMS.register("iron_bow", IronBow::new);
    public static final RegistryObject<Item> Gold_Bow =  ITEMS.register("gold_bow", GoldBow::new);



}
