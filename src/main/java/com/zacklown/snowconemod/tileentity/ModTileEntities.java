package com.zacklown.snowconemod.tileentity;

import com.zacklown.snowconemod.SnowconeMod;
import com.zacklown.snowconemod.block.ModBlocks;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModTileEntities {
    public static DeferredRegister<TileEntityType<?>> TILE_ENTITIES =
            DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, SnowconeMod.MOD_ID);

    //Declare Tile Entities Here
    //-----------------------------------------------------------------------------------------------------------------
    public static final RegistryObject<TileEntityType<IceShaverTile>> ICE_SHAVER_TILE =
            TILE_ENTITIES.register("ice_shaver_tile", ()-> TileEntityType.Builder.create(
                    IceShaverTile::new, ModBlocks.ICE_SHAVER.get()).build(null));

    //-----------------------------------------------------------------------------------------------------------------
    public static void register(IEventBus eventBus){
        TILE_ENTITIES.register(eventBus);
    }


}
