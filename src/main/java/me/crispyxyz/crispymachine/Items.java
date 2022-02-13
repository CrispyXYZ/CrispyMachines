package me.crispyxyz.crispymachine;

import lombok.SneakyThrows;
import org.bukkit.Material;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;

import java.lang.reflect.Field;

public final class Items {
    public static final SlimefunItemStack DIESEL_OIL = new SlimefunItemStack("DIESEL_OIL", Material.LAVA_BUCKET, "&b柴油桶", "&3一种燃料");
    public static final SlimefunItemStack GASOLINE = new SlimefunItemStack("GASOLINE", Material.LAVA_BUCKET, "&b汽油桶", "&3一种燃料");
    public static final SlimefunItemStack CRISPY_MACHINE_CORE = new SlimefunItemStack("CRISPY_MACHINE_CORE", Material.FURNACE, "&d酥脆机器核心", "&3用于合成机器");
    public static final SlimefunItemStack DIESEL_GENERATOR = new SlimefunItemStack("DIESEL_GENERATOR", Material.BLAST_FURNACE, "&e柴油发电机", "&7 400 J 缓存", "&7 100 J/s");
    public static final SlimefunItemStack GASOLINE_GENERATOR = new SlimefunItemStack("GASOLINE_GENERATOR", Material.BLAST_FURNACE, "&e汽油发电机", "&7 200 J 缓存", "&7 50 J/s");
    public static final SlimefunItemStack CRISPY_MACHINE_SHELL = new SlimefunItemStack("CRISPY_MACHINE_SHELL", Material.PAPER, "&d酥脆机器外壳", "&3用于合成机器");
    public static final SlimefunItemStack PRINTER = new SlimefunItemStack("PRINTER", Material.PISTON, "&e打印机", "&3用于打印通用模板", "&7 20,000 J 缓存", "&7 500 J/s");
    public static final SlimefunItemStack GENERAL_TEMPLATE = new SlimefunItemStack("GENERAL_TEMPLATE", Material.PAPER, "&b通用模板", "&3用于复制物品");
    public static final SlimefunItemStack COPIER = new SlimefunItemStack("COPIER", Material.IRON_BLOCK, "&e复制机", "&3用于复制物品", "&7 200,000 J 缓存", "&7 200,000 J 每次使用");
    public static final SlimefunItemStack MENU = new SlimefunItemStack("MENU", Material.PAPER, "&e&l服务器菜单");
    public static final SlimefunItemStack TEAR_OF_NEWTON = new SlimefunItemStack("TEAR_OF_NEWTON",Material.GHAST_TEAR,"&4牛顿的眼泪","&3右键消除重力");

    public static final SlimefunItemStack EXP_GIVER_I = new SlimefunItemStack("EXP_GIVER_I",Material.EXPERIENCE_BOTTLE,"&e经验I","&3右键获取1点经验");
    public static final SlimefunItemStack EXP_GIVER_II = new SlimefunItemStack("EXP_GIVER_II",Material.EXPERIENCE_BOTTLE,"&e经验II","&3右键获取2点经验");
    public static final SlimefunItemStack EXP_GIVER_III = new SlimefunItemStack("EXP_GIVER_III",Material.EXPERIENCE_BOTTLE,"&e经验III","&3右键获取4点经验");
    public static final SlimefunItemStack EXP_GIVER_IV = new SlimefunItemStack("EXP_GIVER_IV",Material.EXPERIENCE_BOTTLE,"&e经验IV","&3右键获取8点经验");
    public static final SlimefunItemStack EXP_GIVER_V = new SlimefunItemStack("EXP_GIVER_V",Material.EXPERIENCE_BOTTLE,"&e经验V","&3右键获取16点经验");
    public static final SlimefunItemStack EXP_GIVER_VI = new SlimefunItemStack("EXP_GIVER_VI",Material.EXPERIENCE_BOTTLE,"&e经验VI","&3右键获取32点经验");
    public static final SlimefunItemStack EXP_GIVER_VII = new SlimefunItemStack("EXP_GIVER_VII",Material.EXPERIENCE_BOTTLE,"&e经验VII","&3右键获取64点经验");
    public static final SlimefunItemStack EXP_GIVER_VIII = new SlimefunItemStack("EXP_GIVER_VIII",Material.EXPERIENCE_BOTTLE,"&e经验VIII","&3右键获取128点经验");
    public static final SlimefunItemStack EXP_GIVER_IX = new SlimefunItemStack("EXP_GIVER_IX",Material.EXPERIENCE_BOTTLE,"&e经验IX","&3右键获取256点经验");
    public static final SlimefunItemStack EXP_GIVER_X = new SlimefunItemStack("EXP_GIVER_X",Material.EXPERIENCE_BOTTLE,"&e经验X","&3右键获取512点经验");

    public static SlimefunItemStack get(String name) throws NoSuchFieldException {
        Field field = Items.class.getField(name);
        SlimefunItemStack item = null;
        try {
            item = (SlimefunItemStack) field.get(null);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return item;
    }

}
