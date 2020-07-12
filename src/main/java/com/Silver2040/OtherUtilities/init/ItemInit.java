package com.Silver2040.OtherUtilities.init;

import com.Silver2040.OtherUtilities.OtherUtilities;
import com.Silver2040.OtherUtilities.objects.blocks.BlockItemBase;
import com.Silver2040.OtherUtilities.objects.items.ItemBase;
import com.Silver2040.OtherUtilities.objects.items.SpeedPickaxe;
import com.Silver2040.OtherUtilities.objects.items.SpeedSword;
import com.Silver2040.OtherUtilities.objects.items.bows.*;
import com.Silver2040.OtherUtilities.util.enums.CaliberItemTier;
import com.Silver2040.OtherUtilities.util.enums.EmeraldItemTier;
import com.Silver2040.OtherUtilities.util.enums.VibraniumItemTier;
import net.minecraft.fluid.Fluids;
import net.minecraft.item.*;
import net.minecraft.potion.Effect;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import static net.minecraft.item.Items.BUCKET;



public class ItemInit {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, OtherUtilities.MOD_ID);

    public static void init(IEventBus modEventBus) {
        ITEMS.register(modEventBus);
    }

    // misc
    public static final RegistryObject<Item> axle = ITEMS.register("axle", ItemBase::new);
    public static final RegistryObject<Item> circuit_board = ITEMS.register("circuit_board", ItemBase::new);
    public static final RegistryObject<Item> plastic = ITEMS.register("plastic", ItemBase::new);
    public static final RegistryObject<Item> gear = ITEMS.register("gear", ItemBase::new);
    public static final RegistryObject<Item> motor = ITEMS.register("motor", ItemBase::new);
    public static final RegistryObject<Item> silicon = ITEMS.register("silicon", ItemBase::new);
    public static final RegistryObject<Item> caliber = ITEMS.register("caliber", ItemBase::new);
    public static final RegistryObject<Item> vibranium = ITEMS.register("vibranium", ItemBase::new);
    public static final RegistryObject<Item> beskar_steel = ITEMS.register("beskar_steel", ItemBase::new);
    public static final RegistryObject<Item> netherite_bow = ITEMS.register("netherite_bow", NetheriteBow::new);
    public static final RegistryObject<Item> diamond_bow = ITEMS.register("diamond_bow", DiamondBow::new);
    public static final RegistryObject<Item> iron_bow = ITEMS.register("iron_bow", IronBow::new);
    public static final RegistryObject<Item> gold_bow =  ITEMS.register("gold_bow", GoldBow::new);
    public static final RegistryObject<Item> advanced_chest =  ITEMS.register("advanced_chest", ItemBase::new);
    public static final RegistryObject<Item> gear_and_axle = ITEMS.register("gear_and_axle",ItemBase::new);


    // block-items
    public static final RegistryObject<BlockItem> Caliber_Block_Item = ITEMS.register("caliber_block", () ->
            new BlockItemBase(BlockInit.Caliber_Block.get()));
    public static final RegistryObject<BlockItem> Vibranium_Block_Item = ITEMS.register("vibranium_block", () ->
            new BlockItemBase(BlockInit.Vibranium_Block.get()));
    public static final RegistryObject<BlockItem> Vibranium_Ore_Block_Item = ITEMS.register("vibranium_ore_block", () ->
            new BlockItemBase(BlockInit.Vibranium_Ore_Block.get()));
    public static final RegistryObject<BlockItem> Caliber_Ore_Block_Item = ITEMS.register("caliber_ore_block", () ->
            new BlockItemBase(BlockInit.Caliber_Ore_Block.get()));
    public static final RegistryObject<BlockItem> Beskar_Steel_Block_Item = ITEMS.register("beskar_steel_block", () ->
            new BlockItemBase(BlockInit.Beskar_Steel_Block.get()));
    public static final RegistryObject<BlockItem> Fake_Water_Item = ITEMS.register("fake_water_block", () ->
            new BlockItemBase(BlockInit.Fake_Water_Block.get()));
  //  public static final RegistryObject<BlockItem> Silicon_Ore_Block_Item = ITEMS.register("silicon_ore_block", () ->
     //       new BlockItemBase(BlockInit.SILICON_ORE_BLOCK.get()));


    // food
    public static final RegistryObject<Item> diamond_apple = ITEMS.register("diamond_apple", () ->
            new Item(new Item.Properties()
                    .group(OtherUtilities.TAB)
                    .food(new Food.Builder()
                            .hunger(10)
                            .saturation(5.0f)
                            .setAlwaysEdible().fastToEat()
                            .effect(() -> new EffectInstance(Effects.ABSORPTION, 5000, 2),1)
                            .effect(() -> new EffectInstance(Effects.REGENERATION, 5000, 2),1)
                            .effect(() -> new EffectInstance(Effects.SPEED,5000,2),1)
                            .effect(() -> new EffectInstance(Effects.FIRE_RESISTANCE, 5000, 2), 1)
                            .build())));
    public static final RegistryObject<Item> cupcake = ITEMS.register("cupcake", () ->
            new Item(new Item.Properties()
                    .group(OtherUtilities.TAB)
                    .food(new Food.Builder()
                            .hunger(10)
                            .saturation(5.0f)
                            .setAlwaysEdible()
                            .fastToEat()
                            .effect(() -> new EffectInstance(Effects.ABSORPTION, 500, 2),1)
                            .effect(() -> new EffectInstance(Effects.REGENERATION, 500, 2),1)
                            .effect(() -> new EffectInstance(Effects.SPEED,500,2),1)
                            .build())));
    public static final RegistryObject<Item> bread_and_cheese = ITEMS.register("bread_and_cheese", () ->
            new Item(new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> cheese = ITEMS.register("cheese", () ->
            new Item(new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> grilled_cheese = ITEMS.register("grilled_cheese", () ->
            new Item(new Item.Properties().group(OtherUtilities.TAB).food(new Food.Builder().hunger(10).saturation(10.0f).build())));

    //tools
    public static final RegistryObject<Item> vibranium_sword = ITEMS.register("vibranium_sword", () ->
            new SwordItem(VibraniumItemTier.VIBRANIUM, 59,0f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> vibranium_pickaxe = ITEMS.register("vibranium_pickaxe", () ->
            new PickaxeItem(VibraniumItemTier.VIBRANIUM,-36,-2.8f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> vibranium_shovel = ITEMS.register("vibranium_shovel", () ->
            new ShovelItem(VibraniumItemTier.VIBRANIUM,-36,-2.8f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> vibranium_axe = ITEMS.register("vibranium_axe", () ->
            new AxeItem(VibraniumItemTier.VIBRANIUM,64,-3.0f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> caliber_sword = ITEMS.register("caliber_sword", () ->
            new SwordItem(CaliberItemTier.CALIBER, 1,-1.5f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> caliber_pickaxe = ITEMS.register("caliber_pickaxe", () ->
            new PickaxeItem(CaliberItemTier.CALIBER,-3,-2.8f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> caliber_shovel = ITEMS.register("caliber_shovel", () ->
            new ShovelItem(CaliberItemTier.CALIBER,-3,-2.8f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> caliber_axe = ITEMS.register("caliber_axe", () ->
            new AxeItem(CaliberItemTier.CALIBER,-3,-2.8f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> speed_sword = ITEMS.register("speed_sword", () ->
            new SpeedSword(CaliberItemTier.CALIBER, 17,100f, new Item.Properties().group(OtherUtilities.TAB)));
    public static final RegistryObject<Item> speed_pickaxe = ITEMS.register("speed_pickaxe", () ->
            new SpeedPickaxe(CaliberItemTier.CALIBER, 17,100f, new Item.Properties().group(OtherUtilities.TAB)));
   // public static final RegistryObject<Item> Gun = ITEMS.register("gun", () -> new  );



    //public static final RegistryObject<Item> emerald_sword = ITEMS.register("emerald_sword", () ->
         //   new SwordItem(EmeraldItemTier.EMERALD, 0,2.0f, new Item.Properties().group(OtherUtilities.TAB)));
    /*
    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> event){

        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("axle"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("circuit_board"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("plastic"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("gear"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("motor"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("silicon"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("caliber"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("vibranium"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("beskar_steel"));
        //food
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB).food(new Food.Builder().hunger(10).saturation(5.0f).setAlwaysEdible().fastToEat().effect(new EffectInstance(Effects.ABSORPTION, 500, 2),1).effect(new EffectInstance(Effects.REGENERATION, 500, 2),1).effect(new EffectInstance(Effects.SPEED,500,2),1).build())).setRegistryName("cupcake"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB).food(new Food.Builder().hunger(10).saturation(10.0f).setAlwaysEdible().fastToEat().effect(new EffectInstance(Effects.ABSORPTION, 50000, 6),1).effect(new EffectInstance(Effects.REGENERATION, 5000, 5),1).effect(new EffectInstance(Effects.RESISTANCE, 5000,2),1).effect(new EffectInstance(Effects.SPEED,5000,2),1).effect(new EffectInstance(Effects.STRENGTH,4500, 3),1).effect(new EffectInstance(Effects.FIRE_RESISTANCE, 5000,3),1).build())).setRegistryName("diamond_apple"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("cheese"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("bread_and_cheese"));
        event.getRegistry().register(new Item(new Item.Properties().group(OtherUtilities.TAB).food(new Food.Builder().hunger(10).saturation(10.0f).build())).setRegistryName("grilled_cheese"));
        //tools
        event.getRegistry().register(new SwordItem(CaliberItemTier.CALIBER, 1,-1.5f, new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("caliber_sword"));
        event.getRegistry().register(new PickaxeItem(CaliberItemTier.CALIBER,-3,-2.8f,  new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("caliber_pickaxe"));
        event.getRegistry().register(new AxeItem(CaliberItemTier.CALIBER,-3,-2.8f,  new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("caliber_axe"));
        event.getRegistry().register(new ShovelItem(CaliberItemTier.CALIBER,-3,-2.8f,  new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("caliber_shovel"));

        event.getRegistry().register(new SwordItem(VibraniumItemTier.VIBRANIUM, 59,0f, new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("vibranium_sword"));
        event.getRegistry().register(new PickaxeItem(VibraniumItemTier.VIBRANIUM,-36,-2.8f,  new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("vibranium_pickaxe"));
        event.getRegistry().register(new ShovelItem(VibraniumItemTier.VIBRANIUM,-36,-2.8f,  new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("vibranium_shovel"));
        event.getRegistry().register(new AxeItem(VibraniumItemTier.VIBRANIUM,64,-3.0f,  new Item.Properties().group(OtherUtilities.TAB)).setRegistryName("vibranium_axe"));

    } */
}
