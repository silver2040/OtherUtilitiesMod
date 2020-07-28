package com.Silver2040.OtherUtilities.world.gen;

import com.Silver2040.OtherUtilities.init.BlockInit;
import com.mojang.realmsclient.dto.WorldTemplate;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.Biomes;
import net.minecraft.world.gen.GenerationStage;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.OreFeatureConfig;
import net.minecraft.world.gen.placement.*;
import net.minecraftforge.registries.ForgeRegistries;

public class OreGen {
    public static void generateOre() {
        for (Biome biome : ForgeRegistries.BIOMES) {
                if ((biome == Biomes.SAVANNA)||(biome == Biomes.SAVANNA_PLATEAU)) {
                    ConfiguredPlacement<CountRangeConfig> VibraniumConfig = Placement.COUNT_RANGE
                            .configure(new CountRangeConfig(1, 5, 5, 20));
                    biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                            .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.Vibranium_Ore_Block.get().getDefaultState(), 8))
                            .withPlacement(VibraniumConfig));
                }
            ConfiguredPlacement<CountRangeConfig> CaliberConfig = Placement.COUNT_RANGE
                    .configure(new CountRangeConfig(7, 5, 5, 40));
            biome.addFeature(GenerationStage.Decoration.UNDERGROUND_ORES, Feature.ORE
                    .withConfiguration(new OreFeatureConfig(OreFeatureConfig.FillerBlockType.NATURAL_STONE, BlockInit.Caliber_Ore_Block.get().getDefaultState(), 8))
                    .withPlacement(CaliberConfig));
        }
    }
}
