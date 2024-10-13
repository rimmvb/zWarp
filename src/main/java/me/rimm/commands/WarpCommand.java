package me.rimm.commands;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Default;
import co.aikar.commands.annotation.Subcommand;
import me.rimm.menu.WarpMenu;
import me.rimm.utils.CC;
import me.rimm.zWarp;
import org.bukkit.entity.Player;

@CommandAlias("warp|warps")
public class WarpCommand extends BaseCommand {

    @Default
    public void onWarp(Player player) {
        try {
            new WarpMenu().open(player);

        } catch (Exception e) {
            player.sendMessage(CC.translate("&cThere was a error while running this command."));
            throw new RuntimeException(e);
        }


    }

    @Subcommand("reload")
    @CommandPermission("zWarp.reload")
    public void onReload(Player player) {
        try {
            zWarp.getInstance().getConfigFile().reloadConfig();
            player.sendMessage(CC.translate("&aConfig reloaded"));

        } catch (Exception e) {
            player.sendMessage(CC.translate("&cThere was a error when reloading the conifg."));
            throw new RuntimeException(e);
        }


    }
}
