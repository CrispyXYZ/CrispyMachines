package me.crispyxyz.crispymachine;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

import dev.j3fftw.extrautils.interfaces.InventoryBlock;
import dev.j3fftw.extrautils.utils.Utils;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config;
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;

import javax.annotation.Nonnull;

public class Copier extends SlimefunItem implements EnergyNetComponent, InventoryBlock {


    public Copier(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
        createPreset(this, "&e复制机", preset -> {
            for(int i = 0; i < 27; i++){
                if(i==10||i==11) continue;
                preset.addItem(i, ChestMenuUtils.getBackground(), ChestMenuUtils.getEmptyClickHandler());
            }
            Utils.putOutputSlot(preset, 15);
            preset.addItem(13, new ItemStack(Material.IRON_BLOCK));
            preset.addMenuClickHandler(13, ChestMenuUtils.getEmptyClickHandler());
        });
    }

    @Override
    public void preRegister() {
        this.addItemHandler(new BlockTicker(){

            @Override
            public boolean isSynchronized() {
                return false;
            }

            @Override
            public void tick(Block block, SlimefunItem item, Config config) {
                Copier.this.tick(block);
            }
        });
    }

    protected synchronized void tick(Block block){
        final BlockMenu inv = BlockStorage.getInventory(block);
                if(inv==null) return;
                
                ItemStack input1 = inv.getItemInSlot(10);
                ItemStack input2 = inv.getItemInSlot(11);
                ItemStack output = inv.getItemInSlot(15);

                if(!Items.GENERAL_TEMPLATE.getItem().isItem(input2)) input2=null;
                if(input1==null||input2==null) return;
                if("AIR".equalsIgnoreCase(input1.getType().name())) return;
                if(output!=null&&(output.getType() != input1.getType()
                || output.getAmount() >= (output.getMaxStackSize() == 1 ? 1 : output.getMaxStackSize()-1)
                )) return;

                if(!takePower(block)) return;

                ItemStack clone = input1.clone();
                inv.consumeItem(10);
                inv.consumeItem(11);
                if(output != null && output.getAmount() > 0) {
                    output.setAmount(output.getAmount()+2);
                } else {
                    clone.setAmount(2);
                    inv.replaceExistingItem(15, clone);
                }
    }

    private boolean takePower(Block block){
        if(getCharge(block.getLocation()) < 4000000) return false;
        removeCharge(block.getLocation(), 4000000);
        return true;
    }

    @Override
    public int getCapacity() {
        return 4000000;
    }

    @Nonnull
    @Override
    public EnergyNetComponentType getEnergyComponentType() {
        return EnergyNetComponentType.CONSUMER;
    }


    @Override
    public int[] getInputSlots() {
        return new int[]{10,11};
    }


    @Override
    public int[] getOutputSlots() {
        return new int[]{15};
    }
}
