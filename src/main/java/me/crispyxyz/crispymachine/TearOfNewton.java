package me.crispyxyz.crispymachine;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class TearOfNewton extends SlimefunItem {

    public TearOfNewton(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void preRegister() {
        ItemUseHandler handler = this::onItemRightClick;
        addItemHandler(handler);
    }

    public void onItemRightClick(PlayerRightClickEvent event) {
        event.cancel();
        Player player = event.getPlayer();
        player.setGravity(!player.hasGravity());
    }
}
