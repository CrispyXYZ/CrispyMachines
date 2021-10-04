package me.crispyxyz.crispymachine;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.AGenerator;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.abstractItems.MachineFuel;

public class DieselGenerator extends AGenerator {

    protected DieselGenerator(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public String getInventoryTitle() {
        return "&e柴油发电机";
    }

    @Override
    public int getCapacity() {
        return 400;
    }

    @Override
    public int getEnergyProduction() {
        return 100;
    }

    @Override
    public ItemStack getProgressBar() {
        return new ItemStack(Material.DISPENSER);
    }

    @Override
    protected void registerDefaultFuelTypes() {
        this.registerFuel(new MachineFuel(40, Materials.DIESEL_OIL, new ItemStack(Material.BUCKET, 2)));
    };
    
}
