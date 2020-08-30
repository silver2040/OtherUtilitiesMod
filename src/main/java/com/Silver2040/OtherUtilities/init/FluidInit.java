package com.Silver2040.OtherUtilities.init;
import com.Silver2040.OtherUtilities.OtherUtilities;
import net.minecraft.block.Block;
import net.minecraft.block.FlowingFluidBlock;
import net.minecraft.block.material.Material;
import net.minecraft.fluid.FlowingFluid;
import net.minecraft.fluid.Fluid;
import net.minecraft.item.Rarity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fluids.FluidAttributes;
import net.minecraftforge.fluids.ForgeFlowingFluid;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
public class FluidInit {


    public static final ResourceLocation FAKE_WATER_STILL_RL = new ResourceLocation(OtherUtilities.MOD_ID, "blocks/fake_water_still");
    public static final ResourceLocation FAKE_WATER_FLOWING_RL = new ResourceLocation(OtherUtilities.MOD_ID,
            "blocks/fake_water_flowing");
    public static final ResourceLocation FAKE_WATER_OVERLAY_RL = new ResourceLocation(OtherUtilities.MOD_ID,
            "blocks/fake_water_overlay");

    public static final DeferredRegister<Fluid> FLUIDS = DeferredRegister.create(ForgeRegistries.FLUIDS, OtherUtilities.MOD_ID);

    public static void  init(IEventBus modEventBus){
        FLUIDS.register(modEventBus);

    }

    public static final RegistryObject<FlowingFluid> FAKE_WATER_FLUID = FLUIDS.register("fake_water_fluid",
            () -> new ForgeFlowingFluid.Source(FluidInit.FAKE_WATER_PROPERTIES));

    public static final RegistryObject<FlowingFluid> FAKE_WATER_FLOWING = FLUIDS.register("fake_water_flowing",
            () -> new ForgeFlowingFluid.Flowing(FluidInit.FAKE_WATER_PROPERTIES));

    public static final ForgeFlowingFluid.Properties FAKE_WATER_PROPERTIES = new ForgeFlowingFluid.Properties(
            () -> FAKE_WATER_FLUID.get(), () -> FAKE_WATER_FLOWING.get(),
            FluidAttributes.builder(FAKE_WATER_STILL_RL, FAKE_WATER_FLOWING_RL).density(1).luminosity(10).rarity(Rarity.RARE).viscosity(2)
                    .sound(SoundEvents.BLOCK_SHULKER_BOX_OPEN).overlay(FAKE_WATER_OVERLAY_RL))
            .block(() -> FluidInit.FAKE_WATER_BLOCK.get()).bucket(() -> ItemInit.bucket_of_fake_water.get());

    public static final RegistryObject<FlowingFluidBlock> FAKE_WATER_BLOCK = BlockInit.BLOCKS.register("fake_water_liquid",
            () -> new FlowingFluidBlock(() -> FluidInit.FAKE_WATER_FLUID.get(), Block.Properties.create(Material.WATER)
                    .doesNotBlockMovement().hardnessAndResistance(100.0f).noDrops()));
}