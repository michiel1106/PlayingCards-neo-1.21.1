package com.ombremoon.playingcards.tileentity;

import com.ombremoon.playingcards.init.InitTileEntityTypes;
import com.ombremoon.playingcards.tileentity.base.TileEntityBase;
import net.minecraft.core.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import java.util.UUID;

public class TileEntityPokerTable extends TileEntityBase {

    private UUID ownerID;
    private String ownerName;

    public TileEntityPokerTable(BlockEntityType<?> pType, BlockPos pPos, BlockState pBlockState) {
        super(pType, pPos, pBlockState);
    }

    public TileEntityPokerTable(BlockPos pPos, BlockState pBlockState) {
        super(InitTileEntityTypes.POKER_TABLE.get(), pPos, pBlockState);
    }

    public void setOwner(Player player) {
        this.ownerID = player.getUUID();
        this.ownerName = player.getDisplayName().getString();
    }

    public UUID getOwnerID() {
        return this.ownerID;
    }

    @Override
    protected void loadAdditional(CompoundTag tag, HolderLookup.Provider registries) {
        ownerID = tag.getUUID("OwnerID");
        ownerName = tag.getString("OwnerName");
        super.loadAdditional(tag, registries);
    }



    @Override
    public void saveAdditional(CompoundTag nbt, HolderLookup.Provider registries) {
        nbt.putUUID("OwnerID", ownerID);
        nbt.putString("OwnerName", ownerName);
        super.saveAdditional(nbt, registries);
    }

    @Override
    protected Component getDefaultName() {
        return null;
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return null;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> items) {

    }

    @Override
    protected AbstractContainerMenu createMenu(int pContainerId, Inventory pInventory) {
        return null;
    }

    @Override
    public int getContainerSize() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public ItemStack getItem(int pSlot) {
        return null;
    }

    @Override
    public ItemStack removeItem(int pSlot, int pAmount) {
        return null;
    }

    @Override
    public ItemStack removeItemNoUpdate(int pSlot) {
        return null;
    }

    @Override
    public void setItem(int pSlot, ItemStack pStack) {

    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }

    @Override
    public void clearContent() {

    }
}