package com.Silver2040.OtherUtilities.objects.blocks;

import com.Silver2040.OtherUtilities.init.BlockInit;
import com.Silver2040.OtherUtilities.init.FluidInit;
import com.Silver2040.OtherUtilities.init.ItemInit;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ToolType;

import javax.annotation.Nullable;

public class FakeWaterBlock extends Block {
    public FakeWaterBlock() {
        super(Block.Properties.create(Material.IRON)
                .hardnessAndResistance(0.1f,0.1f)
                .sound(SoundType.SLIME)

        );

    }
    public void harvestBlock(World worldIn, PlayerEntity player, BlockPos pos, BlockState state, @Nullable TileEntity te, ItemStack stack) {
        super.harvestBlock(worldIn, player, pos, state, te, stack);
        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, stack) == 0) {
            if (worldIn.func_230315_m_().func_236040_e_()) {
                worldIn.removeBlock(pos, false);
                return;
            }

            Material material = worldIn.getBlockState(pos.down()).getMaterial();
            if (material.blocksMovement() || material.isLiquid()) {
                worldIn.setBlockState(pos, FluidInit.FAKE_WATER_BLOCK.get().getDefaultState().getBlockState());

            }
        }

    }
}