package me.crispyxyz.crispymachine;

import io.github.thebusybiscuit.slimefun4.api.events.PlayerRightClickEvent;
import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.handlers.ItemUseHandler;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

public class ExpGiver extends SlimefunItem {

    public final int reward;

    public ExpGiver(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe, int lvl) {
        super(itemGroup, item, recipeType, recipe);
        this.reward = (int) Math.pow(2,lvl-1);
    }

    @Override
    public void preRegister() {
        ItemUseHandler handler = this::onItemRightClick;
        addItemHandler(handler);
    }

    public void onItemRightClick(PlayerRightClickEvent event) {
        event.cancel();
        Player player = event.getPlayer();
        player.giveExp(reward);
    }
}
