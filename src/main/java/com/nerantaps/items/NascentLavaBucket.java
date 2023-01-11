package com.nerantaps.items;

import com.nerantaps.registry.NPFluids;
import com.nerantaps.registry.NPTabs;
import net.minecraft.world.item.BucketItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.RecipeType;
import org.jetbrains.annotations.Nullable;

public class NascentLavaBucket extends BucketItem {

    public NascentLavaBucket() {
        super(NPFluids.NASCENT_LAVA, new Item.Properties().craftRemainder(Items.BUCKET)
                .stacksTo(1).tab(NPTabs.TAB_NERANTA_TAB_1));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return 18000;
    }

}