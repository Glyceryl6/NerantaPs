package com.nerantaps.utils;

import com.nerantaps.NerantaPs;
import com.nerantaps.registry.NPItems;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.ForgeTier;
import net.minecraftforge.common.TierSortingRegistry;

import java.util.List;

public class NPItemTiers {

    public static final Tier CHROMITE = TierSortingRegistry.registerTier(
            new ForgeTier(2, 500, 7.0F, 2.5F, 14, BlockTags.create(NerantaPs.prefix("needs_chromite_tool")),
                    () -> Ingredient.of(NPItems.CHROMITE_INGOT.get())), NerantaPs.prefix("chromite"), List.of(Tiers.IRON), List.of(Tiers.DIAMOND));

    public static final Tier ETERNAL = TierSortingRegistry.registerTier(
            new ForgeTier(2, 3000, 10.0F, 2.5F, 12, BlockTags.create(NerantaPs.prefix("needs_eternal_tool")),
                    Ingredient::of), NerantaPs.prefix("eternal"), List.of(Tiers.DIAMOND), List.of(Tiers.NETHERITE));

}