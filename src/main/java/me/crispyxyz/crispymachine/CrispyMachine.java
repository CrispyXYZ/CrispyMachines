package me.crispyxyz.crispymachine;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;

public class CrispyMachine extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        // Read something from your config.yml
        //Config cfg = new Config(this);

        /*
         * Creating a new Category
         */
        ItemStack categoryItem = new CustomItemStack(Material.BLAST_FURNACE, "&e酥脆机器", "", "&a> Click to open");

        // Give your Category a unique id.
        NamespacedKey categoryId = new NamespacedKey(this, "crispy_machine");
        ItemGroup category = new ItemGroup(categoryId, categoryItem);

        /*
         * Creating a Recipe
         */
        ItemStack[] oilRecipe = {SlimefunItems.OIL_BUCKET, SlimefunItems.OIL_BUCKET};
        ItemStack[] crispyMachineCoreRecipe = {
            SlimefunItems.STEEL_INGOT, new ItemStack(Material.LEVER), SlimefunItems.STEEL_INGOT,
            SlimefunItems.STEEL_INGOT, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.STEEL_INGOT, 
            SlimefunItems.STEEL_INGOT, SlimefunItems.SMALL_CAPACITOR, SlimefunItems.STEEL_INGOT 
        };
        ItemStack[] crispyMachineShellRecipe = {
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_PLATE,
            SlimefunItems.REINFORCED_ALLOY_INGOT, null, SlimefunItems.REINFORCED_ALLOY_INGOT, 
            SlimefunItems.REINFORCED_PLATE, SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.REINFORCED_PLATE
        };
        ItemStack[] dieselGeneratorRecipe = {
            new ItemStack(Material.IRON_TRAPDOOR), new ItemStack(Material.DISPENSER), new ItemStack(Material.IRON_TRAPDOOR),
            null, new ItemStack(Material.PISTON), null,
            null, Materials.CRISPY_MACHINE_CORE, null
        };
        ItemStack[] gasolineGeneratorRecipe = {
            new ItemStack(Material.IRON_TRAPDOOR), SlimefunItems.ELECTRO_MAGNET, new ItemStack(Material.IRON_TRAPDOOR),
            null, new ItemStack(Material.PISTON), null,
            null, Materials.CRISPY_MACHINE_CORE, null
        };
        ItemStack[] printerRecipe = {
            SlimefunItems.STEEL_INGOT, SlimefunItems.BATTERY, SlimefunItems.STEEL_INGOT,
            SlimefunItems.MAGNET, SlimefunItems.ELECTRIC_MOTOR, SlimefunItems.MAGNET,
            SlimefunItems.STEEL_INGOT, SlimefunItems.BATTERY, SlimefunItems.STEEL_INGOT
        };
        ItemStack[] copierRecipe = {
            Materials.CRISPY_MACHINE_SHELL, Materials.PRINTER, Materials.CRISPY_MACHINE_SHELL,
            Materials.CRISPY_MACHINE_SHELL, Materials.CRISPY_MACHINE_CORE, Materials.CRISPY_MACHINE_SHELL,
            Materials.CRISPY_MACHINE_SHELL, new ItemStack(Material.NETHERITE_BLOCK), Materials.CRISPY_MACHINE_SHELL
        };

        /*
         * Registering the Item
         */
        DieselOil dieselOil = new DieselOil(category, Materials.DIESEL_OIL, RecipeType.COMPRESSOR, oilRecipe);
        Gasoline gasoline = new Gasoline(category, Materials.GASOLINE, RecipeType.SMELTERY, oilRecipe);
        CrispyMachineCore crispyMachineCore = new CrispyMachineCore(category, Materials.CRISPY_MACHINE_CORE, RecipeType.ENHANCED_CRAFTING_TABLE, crispyMachineCoreRecipe);
        CrispyMachineShell crispyMachineShell = new CrispyMachineShell(category, Materials.CRISPY_MACHINE_SHELL, RecipeType.ENHANCED_CRAFTING_TABLE, crispyMachineShellRecipe);
        DieselGenerator dieselGenerator = new DieselGenerator(category, Materials.DIESEL_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, dieselGeneratorRecipe);
        GasolineGenerator gasolineGenerator = new GasolineGenerator(category, Materials.GASOLINE_GENERATOR, RecipeType.ENHANCED_CRAFTING_TABLE, gasolineGeneratorRecipe);
        Printer printer = new Printer(category, Materials.PRINTER, RecipeType.ENHANCED_CRAFTING_TABLE, printerRecipe);
        GeneralTemplate generalTemplate = new GeneralTemplate(category, Materials.GENERAL_TEMPLATE, new RecipeType(Materials.PRINTER, "PRINTER"), new ItemStack[]{SlimefunItems.REINFORCED_ALLOY_INGOT});
        Copier copier = new Copier(category, Materials.COPIER, RecipeType.ENHANCED_CRAFTING_TABLE, copierRecipe);

        dieselOil.register(this);
        gasoline.register(this);
        crispyMachineCore.register(this);
        crispyMachineShell.register(this);
        dieselGenerator.register(this);
        gasolineGenerator.register(this);
        printer.register(this);
        generalTemplate.register(this);
        copier.register(this);
    }

    @Override
    public void onDisable() {
        // Logic for disabling the plugin...
    }

    @Override
    public String getBugTrackerURL() {
        // You can return a link to your Bug Tracker instead of null here
        return null;
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        /*
         * You will need to return a reference to your Plugin here.
         * If you are using your main class for this, simply return "this".
         */
        return this;
    }

}
