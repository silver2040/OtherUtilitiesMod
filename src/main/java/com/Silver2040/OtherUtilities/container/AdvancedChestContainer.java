package com.Silver2040.OtherUtilities.container;

import com.Silver2040.OtherUtilities.init.BlockInit;
import com.Silver2040.OtherUtilities.init.ContainerTypes;
import com.Silver2040.OtherUtilities.tileentity.AdvancedChestTileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.container.Container;
import net.minecraft.inventory.container.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketBuffer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IWorldPosCallable;

import java.util.Objects;

public class AdvancedChestContainer extends Container {
    public final AdvancedChestTileEntity tileEntity;
    private final IWorldPosCallable canInteractWithCallable;

    public AdvancedChestContainer(final int windowId, final PlayerInventory playerInventory, final AdvancedChestTileEntity tileEntity){
        super(ContainerTypes.Advanced_Chest.get(), windowId);
        this.tileEntity = tileEntity;
        this.canInteractWithCallable = IWorldPosCallable.of(tileEntity.getWorld(), tileEntity.getPos());

        int startX = 0;
        int startY = 0;
        int slotSize2 = 18;
        for (int row = 0; row < 8; ++row){
            for(int column = 0; column < 10; ++column){
                this.addSlot(new Slot(tileEntity, row * 9 + column, startX + (column * slotSize2), startY + (row * slotSize2)));
            }
        }
        int startPlayerInvY = startY * 8 + 12;
        for (int row = 0; row < 3; ++row) {
            for (int column = 0; column < 9; ++column) {
                this.addSlot(new Slot(playerInventory, 9 + (row * 9) + column, startX + (column * slotSize2),
                        startPlayerInvY + (row * slotSize2)));
            }
        }
        int hotbarY = startPlayerInvY + (startPlayerInvY / 2) + 7;
        for (int column = 0; column < 9; ++column) {
            this.addSlot(new Slot(playerInventory, column, startX + (column * slotSize2), hotbarY));
        }
    }
    private static AdvancedChestTileEntity getTileEntity(final PlayerInventory playerInventory,
                                                        final PacketBuffer data) {
        Objects.requireNonNull(playerInventory, "playerInventory can't be null");
        Objects.requireNonNull(data, "data can't be null");
        final TileEntity tileAtPos = playerInventory.player.world.getTileEntity(data.readBlockPos());
        if (tileAtPos instanceof AdvancedChestTileEntity) {
            return (AdvancedChestTileEntity) tileAtPos;
        }
        throw new IllegalStateException("The Tile Entity is Incorrect " + tileAtPos);
    }
    public AdvancedChestContainer(final int windowId, final PlayerInventory playerInventory, final PacketBuffer data) {
        this(windowId, playerInventory, getTileEntity(playerInventory, data));
    }

    @Override
    public boolean canInteractWith(PlayerEntity playerIn) {
        return isWithinUsableDistance(canInteractWithCallable, playerIn, BlockInit.Advanced_Chest.get());
    }

    @Override
    public ItemStack transferStackInSlot(PlayerEntity playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index < 64) {
                if (!this.mergeItemStack(itemstack1, 64, this.inventorySlots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 0, 64, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }
        }
        return itemstack;
    }
}

