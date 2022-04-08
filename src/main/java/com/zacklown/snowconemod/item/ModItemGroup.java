package com.zacklown.snowconemod.item;

import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;

public class ModItemGroup {

    public static final ItemGroup SNOWCONE_MOD_GROUP = new ItemGroup("snowconeModGroup") {
        @Override
        public ItemStack createIcon() {
            return new ItemStack(ModItems.TIN.get());//Sets the tab photo
        }
    };



}
