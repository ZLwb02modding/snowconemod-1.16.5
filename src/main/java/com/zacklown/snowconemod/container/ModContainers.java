package com.zacklown.snowconemod.container;

import com.zacklown.snowconemod.SnowconeMod;
import net.minecraft.inventory.container.ContainerType;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.extensions.IForgeContainerType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModContainers {

    public static DeferredRegister<ContainerType<?>> CONTAINERS =
            DeferredRegister.create(ForgeRegistries.CONTAINERS, SnowconeMod.MOD_ID);

    public static final RegistryObject<ContainerType<IceShaverContainer>> ICE_SHAVER_CONTAINER =
            CONTAINERS.register("ice_shaver_container", ()-> IForgeContainerType.create(((windowId, inv, data) -> {
                BlockPos pos = data.readBlockPos();
                World world = inv.player.getEntityWorld();
                return new IceShaverContainer(windowId,world,pos,inv, inv.player);
            })));

    public static void register(IEventBus eventBus){
        CONTAINERS.register(eventBus);
    }
}
