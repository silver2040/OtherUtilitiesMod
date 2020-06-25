package com.Silver2040.OtherUtilities.init;

import com.Silver2040.OtherUtilities.OtherUtilities;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.util.LazyValue;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber.Bus;
import net.minecraftforge.registries.ObjectHolder;

import java.util.function.Supplier;

@Mod.EventBusSubscriber(modid = OtherUtilities.MOD_ID, bus = Bus.MOD)
@ObjectHolder(OtherUtilities.MOD_ID)
public class ItemInit {

    public static final Item axle = null;
    public static final Item circuit_board = null;
    public static final Item plastic = null;
    public static final Item gear = null;
    public static final Item motor = null;
    public static final Item silicon = null;
    public static final Item caliber = null;
    public static final Item vibranium = null;
    public static final Item beskar_steel = null;
    //tools
    public static final Item vibranium_sword = null;
    public static final Item vibranium_pickaxe = null;
    public static final Item vibranium_shovel = null;
    public static final Item vibranium_axe = null;
    public static final Item caliber_sword = null;
    public static final Item caliber_pickaxe = null;
    public static final Item caliber_shovel = null;
    public static final Item caliber_axe = null;



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

    }
    public enum CaliberItemTier implements IItemTier {
        CALIBER(4, 2000, 13.0F,7.0F, 250, () -> {
           return Ingredient.fromItems(ItemInit.caliber);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;
        CaliberItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
        this.harvestLevel = harvestLevel;
        this.maxUses = maxUses;
        this.efficiency = efficiency;
        this.attackDamage = attackDamage;
        this.enchantability = enchantability;
        this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
    public enum VibraniumItemTier implements IItemTier {
        VIBRANIUM(5, 10000, 80.0F,40.0F, 250, () -> {
            return Ingredient.fromItems(ItemInit.vibranium);
        });

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final LazyValue<Ingredient> repairMaterial;
        VibraniumItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Supplier<Ingredient> repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = new LazyValue<>(repairMaterial);
        }

        @Override
        public int getMaxUses() {
            return this.maxUses;
        }

        @Override
        public float getEfficiency() {
            return this.efficiency;
        }

        @Override
        public float getAttackDamage() {
            return this.attackDamage;
        }

        @Override
        public int getHarvestLevel() {
            return this.harvestLevel;
        }

        @Override
        public int getEnchantability() {
            return this.enchantability;
        }

        @Override
        public Ingredient getRepairMaterial() {
            return this.repairMaterial.getValue();
        }
    }
}
