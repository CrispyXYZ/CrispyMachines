package me.crispyxyz.crispymachine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AContainer;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;


public class DeoxidationSmeltery extends AContainer {

    public DeoxidationSmeltery(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Nonnull
    @Override
    public String getMachineIdentifier() {
        return "DEOXIDATION_SMELTERY";
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.BLAZE_POWDER);
    }

    @Override
    public int getEnergyConsumption() {
        return 200;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int getCapacity() {
        return 800;
    }

    @Override
    protected void registerDefaultRecipes() {
        this.registerRecipe(10, new ItemStack(Material.DIAMOND), new SlimefunItemStack(SlimefunItems.COMPRESSED_CARBON, 4));
        this.registerRecipe(10, SlimefunItems.SYNTHETIC_DIAMOND, new SlimefunItemStack(SlimefunItems.COMPRESSED_CARBON, 4));
    }

}
