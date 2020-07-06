package com.Silver2040.OtherUtilities.tileentity;

import com.Silver2040.OtherUtilities.container.AdvancedChestContainer;
import com.Silver2040.OtherUtilities.init.TileEntityTypes;
import com.Silver2040.OtherUtilities.objects.blocks.AdvancedChestBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.container.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.LockableLootTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraft.util.NonNullList;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.IItemHandlerModifiable;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

import javax.annotation.Nonnull;

public class AdvancedChestTileEntity extends LockableLootTileEntity {

    private NonNullList<ItemStack> chestContents = NonNullList.withSize(64,ItemStack.EMPTY);
    protected int PlayersUsing;
    private IItemHandlerModifiable items = createHandler();
    private LazyOptional<IItemHandlerModifiable> itemHandler = LazyOptional.of(() -> items);

    public AdvancedChestTileEntity(TileEntityType<?> typeIn){
        super(typeIn);
    }
    public AdvancedChestTileEntity(){
        this(TileEntityTypes.ADVANCED_CHEST.get());
    }

    @Override
    public int getSizeInventory() {
        return 64;
    }
    @Override
    public NonNullList<ItemStack> getItems() {
        return this.chestContents;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> itemsIn) {
        this.chestContents = itemsIn;
    }

    @Override
    protected ITextComponent getDefaultName() {
        return new TranslationTextComponent("container.advanced_chest");
    }

    @Override
    protected Container createMenu(int id, PlayerInventory player) {
        return new AdvancedChestContainer(id, player, this);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        super.write(compound);
        if (!this.checkLootAndWrite(compound)) {
            ItemStackHelper.saveAllItems(compound, this.chestContents);
        }
        return compound;
    }

    @Override
    protected boolean checkLootAndRead(CompoundNBT compound) {
        super.checkLootAndRead(compound);
        this.chestContents = NonNullList.withSize(this.getSizeInventory(), ItemStack.EMPTY);
        if (!this.checkLootAndRead(compound)) {
            ItemStackHelper.loadAllItems(compound, this.chestContents);
        }
        return super.checkLootAndRead(compound);
    }
    private void playSound(SoundEvent sound) {
        double dx = (double) this.pos.getX() + 0.5D;
        double dy = (double) this.pos.getY() + 0.5D;
        double dz = (double) this.pos.getZ() + 0.5D;
        this.world.playSound((PlayerEntity) null, dx, dy, dz, sound, SoundCategory.BLOCKS, 0.5f,
                this.world.rand.nextFloat() * 0.1f + 0.9f);
    }

    @Override
    public boolean receiveClientEvent(int id, int type) {
        if (id == 1) {
            this.PlayersUsing = type;
            return true;
        } else {
            return super.receiveClientEvent(id, type);
        }
    }

    @Override
    public void openInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.PlayersUsing < 0) {
                this.PlayersUsing = 0;
            }

            ++this.PlayersUsing;
            this.onOpenOrClose();
        }
    }
    @Override
    public void closeInventory(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.PlayersUsing;
            this.onOpenOrClose();
        }
    }
    protected void onOpenOrClose() {
        Block block = this.getBlockState().getBlock();
        if (block instanceof AdvancedChestBlock) {
            this.world.addBlockEvent(this.pos, block, 1, this.PlayersUsing);
            this.world.notifyNeighborsOfStateChange(this.pos, block);
        }
    }
    public static int getPlayersUsing(IBlockReader reader, BlockPos pos) {
        BlockState blockstate = reader.getBlockState(pos);
        if (blockstate.hasTileEntity()) {
            TileEntity tileentity = reader.getTileEntity(pos);
            if (tileentity instanceof AdvancedChestTileEntity) {
                return ((AdvancedChestTileEntity) tileentity).PlayersUsing;
            }
        }
        return 0;
    }
    public static void swapContents(AdvancedChestTileEntity tileEntity, AdvancedChestTileEntity tileEntity2) {
        NonNullList<ItemStack> list = tileEntity.getItems();
        tileEntity.setItems(tileEntity2.getItems());
        tileEntity2.setItems(list);
    }
    @Override
    public void updateContainingBlockInfo() {
        super.updateContainingBlockInfo();
        if (this.itemHandler != null) {
            this.itemHandler.invalidate();
            this.itemHandler = null;
        }
    }
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nonnull Direction side) {
        if (cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return itemHandler.cast();
        }
        return super.getCapability(cap, side);
    }
    private IItemHandlerModifiable createHandler() {
        return new InvWrapper(this);
    }
    @Override
    public void remove() {
        super.remove();
        if(itemHandler != null) {
            itemHandler.invalidate();
        }
    }

}
