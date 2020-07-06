package com.Silver2040.OtherUtilities.init;

import com.Silver2040.OtherUtilities.OtherUtilities;
import com.Silver2040.OtherUtilities.tileentity.AdvancedChestTileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class TileEntityTypes {
    public static final DeferredRegister<TileEntityType<?>> TILE_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, OtherUtilities.MOD_ID);

    public static final RegistryObject<TileEntityType<AdvancedChestTileEntity>> ADVANCED_CHEST = TILE_ENTITY_TYPES.register("advanced_chest", () -> TileEntityType.Builder.create(AdvancedChestTileEntity::new, BlockInit.Advanced_Chest.get()).build(null) );
}
