package com.zacklown.snowconemod.tileentity;

import com.zacklown.snowconemod.item.ModItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class IceShaverTile extends TileEntity {
    private final ItemStackHandler itemHandler = createHandler();
    private final LazyOptional<IItemHandler> handler = LazyOptional.of(() -> itemHandler );

    public IceShaverTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public IceShaverTile(){
        this(ModTileEntities.ICE_SHAVER_TILE.get());
    }

    private ItemStackHandler createHandler(){
        return new ItemStackHandler(2){
            @Override
            protected void onContentsChanged(int slot){
                markDirty();
            }

            @Override
            public boolean isItemValid(int slot, @Nonnull ItemStack stack) {
                switch (slot) {
                    case 0: return stack.getItem() == Items.ICE;
                    case 1: return stack.getItem() == ModItems.EMPTY_SNOWCONE.get();
                    default:
                        return false;
                }
            }//End of isItemValid

            @Override
            public int getSlotLimit(int slot){
                return 1; //Only allows one block to be placed in each
            }//End of getSlotLimit

            @Override
            public ItemStack insertItem(int slot, @Nonnull ItemStack stack, boolean simulate){
                if(!isItemValid(slot,stack)){
                    return stack;
                }
                return super.insertItem(slot, stack, simulate);
            }//End of insertItem
        };
    }//End if ItemStackHandler

    @Override
    public void read(BlockState state, CompoundNBT nbt) {
        itemHandler.deserializeNBT(nbt.getCompound("inv"));
        super.read(state, nbt);
    }

    @Override
    public CompoundNBT write(CompoundNBT compound) {
        compound.put("inv", itemHandler.serializeNBT());
        return super.write(compound);
    }

    @Nonnull
    @Override
    public <T> LazyOptional<T> getCapability(@Nonnull Capability<T> cap, @Nullable Direction side) {
        if(cap == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return handler.cast();
        }
        return super.getCapability(cap, side);
    }

    public void lightningHasStruct(){
        boolean hasIceInFirstSlot = this.itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(0).getItem() == Items.ICE;
        boolean hasEmptySnowconeInSecondSlot = this.itemHandler.getStackInSlot(0).getCount() > 0
                && this.itemHandler.getStackInSlot(1).getItem() == ModItems.EMPTY_SNOWCONE.get();
        if (hasIceInFirstSlot && hasEmptySnowconeInSecondSlot) {
            this.itemHandler.getStackInSlot(0).shrink(1);
            this.itemHandler.getStackInSlot(1).shrink(1);
            this.itemHandler.insertItem(2, new ItemStack(ModItems.EMPTY_SNOWCONE.get()),false);


        }
    }

}//End of Class
