package me.rimm;

import co.aikar.commands.PaperCommandManager;
import fr.mrmicky.fastinv.FastInvManager;
import lombok.Getter;
import me.rimm.commands.WarpCommand;
import me.rimm.utils.ConfigFile;
import org.bukkit.plugin.java.JavaPlugin;


@Getter
public class zWarp extends JavaPlugin {

    private static zWarp instance;
    private ConfigFile configFile;
    public static PaperCommandManager commandManager;

    @Override
    public void onEnable() {
        instance = this;
        this.saveDefaultConfig();

        configFile = new ConfigFile(getDataFolder(), "config.yml");

        FastInvManager.register(this);
        registerCommands();
        getServer().getLogger().info("zWarp Successfully loaded");
    }

    private void registerCommands() {
        commandManager = new PaperCommandManager(this);

        commandManager.registerCommand(new WarpCommand());

    }

    public static zWarp getInstance() {
        return instance;
    }
}