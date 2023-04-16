package com.apples;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Hashtable;

public final class ApplesSpigotPlugin extends JavaPlugin {
    public class CommandKit implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Hashtable<String, String[]> kitItems = new Hashtable<String, String[]>();
            // base kit
            kitItems.put("base", new java.lang.String[]{
                    "minecraft:stone_pickaxe{Enchantments:[{id:unbreaking,lvl:1}]} 1",
                    "minecraft:stone_axe{Enchantments:[{id:unbreaking,lvl:2}]} 1",
                    "minecraft:stone_sword{Enchantments:[{id:sharpness,lvl:2}, {id:unbreaking,lvl:1}]} 1",
                    "minecraft:stone_shovel{Enchantments:[{id:efficiency,lvl:1}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:cooked_beef 16",
                    "minecraft:leather_helmet{Enchantments:[{id:protection,lvl:2}, {id:unbreaking,lvl:1}]} 1",
                    "minecraft:leather_chestplate{Enchantments:[{id:protection,lvl:2}, {id:unbreaking,lvl:1}]} 1",
                    "minecraft:leather_leggings{Enchantments:[{id:protection,lvl:2}, {id:unbreaking,lvl:1}]} 1",
                    "minecraft:leather_boots{Enchantments:[{id:protection,lvl:2}, {id:unbreaking,lvl:1}]} 1"
            });
            // default kit
            kitItems.put("default", new java.lang.String[]{
                    "minecraft:iron_pickaxe{Enchantments:[{id:efficiency,lvl:2}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:iron_axe{Enchantments:[{id:efficiency,lvl:2}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:iron_sword{Enchantments:[{id:sharpness,lvl:3}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:iron_shovel{Enchantments:[{id:efficiency,lvl:3}, {id:unbreaking,lvl:3}]} 1",
                    "minecraft:cooked_beef 32",
                    "minecraft:iron_helmet{Enchantments:[{id:protection,lvl:3}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:iron_chestplate{Enchantments:[{id:protection,lvl:3}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:iron_leggings{Enchantments:[{id:protection,lvl:3}, {id:unbreaking,lvl:2}]} 1",
                    "minecraft:iron_boots{Enchantments:[{id:protection,lvl:3}, {id:unbreaking,lvl:2}]} 1"
            });
            // god kit
            kitItems.put("god", new java.lang.String[]{
                    "minecraft:netherite_pickaxe{Enchantments:[{id:efficiency,lvl:5}, {id:unbreaking,lvl:3}, {id:fortune,lvl:3}]} 1",
                    "minecraft:netherite_axe{Enchantments:[{id:efficiency,lvl:5}, {id:unbreaking,lvl:3}, {id:sharpness,lvl:5}]} 1",
                    "minecraft:netherite_sword{Enchantments:[{id:sharpness,lvl:5}, {id:looting,lvl:3}, {id:unbreaking,lvl:3}, {id:sweeping,lvl:3}]} 1",
                    "minecraft:netherite_shovel{Enchantments:[{id:efficiency,lvl:5}, {id:unbreaking,lvl:3}]} 1",
                    "minecraft:cooked_beef 64",
                    "minecraft:netherite_helmet{Enchantments:[{id:protection,lvl:4}, {id:unbreaking,lvl:3}]} 1",
                    "minecraft:netherite_chestplate{Enchantments:[{id:protection,lvl:4}, {id:unbreaking,lvl:3}]} 1",
                    "minecraft:netherite_leggings{Enchantments:[{id:protection,lvl:4}, {id:unbreaking,lvl:3}]} 1",
                    "minecraft:netherite_boots{Enchantments:[{id:protection,lvl:4}, {id:unbreaking,lvl:3}]} 1"
            });


            String playerSenderStr = null;
            String chosenKit = null;
            boolean dothething = true;
            if (args.length >= 2) {
                playerSenderStr = args[0];
                chosenKit = args[1];
            } else if (args.length == 1) {
                playerSenderStr = args[0];
                chosenKit = "default";
            } else {
                if (sender instanceof Player) {
                    playerSenderStr = sender.getName();
                    chosenKit = "default";
                } else {
                    Bukkit.getLogger().info("When running from console, you *must* use a player name argument.");
                    dothething = false;
                }

            }

            if (dothething) {
                for (String kitItem : kitItems.get(chosenKit)) {
                    Bukkit.dispatchCommand(sender, "give " + playerSenderStr + " " + kitItem);
                }
            }
//            Bukkit.dispatchCommand(sender, "give " + playerSenderStr + " minecraft:brick 20");
//            Bukkit.dispatchCommand(sender, "give " + playerSenderStr + " minecraft:diamond");
//            if (sender instanceof Player) {
//                Player player = (Player) sender;
//
//                ItemStack diamond = new ItemStack(Material.DIAMOND);
//
//                ItemStack bricks = new ItemStack(Material.BRICK, 20);
//
//                player.getInventory().addItem(bricks, diamond);
//            }

            return true;

        }


    }
    
    public class DiscordLink implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
            Bukkit.dispatchCommand(sender, "tellraw @s [\"\",{\"text\":\">>\",\"bold\":true,\"color\":\"#00D1F3\"},{\"text\":\" Discord\",\"color\":\"#0BAEEB\"},{\"text\":\" Link \"},{\"text\":\"<<\",\"bold\":true,\"color\":\"#00D1F3\"},{\"text\":\":\\n\"},{\"text\":\"https://discord.gg\",\"clickEvent\":{\"action\":\"open_url\",\"value\":\"https://discord.gg\"},\"hoverEvent\":{\"action\":\"show_text\",\"contents\":\"Click to open link\"}}]");

            return true;
        }
    }

    public class Smite implements CommandExecutor {
        @Override
        public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args) {
            Player player = (Player) sender;
            World world = player.getWorld();
            if (args.length >= 1) {
                if (player.getServer().getPlayer(args[0]) != null) {
                    Player targetplayer = player.getServer().getPlayer(args[0]);
                    Location location = targetplayer.getLocation();
                }
            }
            return false;
        }
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getCommand("kit").setExecutor(new CommandKit());

        // commands for discord linking
        this.getCommand("dc").setExecutor(new DiscordLink());
        this.getCommand("discord").setExecutor(new DiscordLink());
        Bukkit.getLogger().info("Server fully initialized on port: " + Bukkit.getPort());
        Bukkit.getLogger().info("On Bukkit version: " + Bukkit.getBukkitVersion());
        Bukkit.getLogger().info("On Minecraft Version: " + Bukkit.getVersion());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
