package com.zacklown.snowconemod.item;

import com.zacklown.snowconemod.SnowconeMod;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, SnowconeMod.MOD_ID);

    //Declare Items Here Here
    //-----------------------------------------------------------------------------------------------------------------
    public static final RegistryObject<Item> TIN = ITEMS.register("tin",
            () -> new Item(new Item.Properties().group(ModItemGroup.SNOWCONE_MOD_GROUP)));

    public static final RegistryObject<Item> EMPTY_SNOWCONE = ITEMS.register("empty_snowcone",
            ()-> new Item(new Item.Properties().group(ModItemGroup.SNOWCONE_MOD_GROUP)));

    public static final RegistryObject<Item> PLAIN_SNOWCONE = ITEMS.register("plain_snowcone",
            ()-> new Item(new Item.Properties().group(ModItemGroup.SNOWCONE_MOD_GROUP)));


    //-----------------------------------------------------------------------------------------------------------------

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
