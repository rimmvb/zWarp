package me.rimm.menu;

import fr.mrmicky.fastinv.FastInv;
import fr.mrmicky.fastinv.ItemBuilder;
import me.rimm.utils.CC;
import me.rimm.utils.XMaterial;
import me.rimm.zWarp;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.List;

public class WarpMenu extends FastInv {

    public WarpMenu() {
        super(zWarp.getInstance().getConfigFile().getInt("warp-gui.size"), CC.translate(zWarp.getInstance().getConfigFile().getString("warp-gui.name")));

        ConfigurationSection buttonsSection = zWarp.getInstance().getConfigFile().getConfig().getConfigurationSection("warp-gui.buttons");

        if (buttonsSection != null) {
            for (String key : buttonsSection.getKeys(false)) {
                ConfigurationSection button = buttonsSection.getConfigurationSection(key);
                if (button != null) {
                    String name = button.getString(CC.translate("name"));
                    ItemStack material = XMaterial.matchXMaterial(button.getString("Material")).get().parseItem();
                    int slot = button.getInt("slot");
                    List<String> lore = button.getStringList(CC.translate("lore"));
                    int x = button.getInt("location.x");
                    int y = button.getInt("location.y");
                    int z = button.getInt("location.z");
                    String worldName = button.getString("location.world");

                    if (material != null) {
                        ItemStack item = new ItemBuilder(material)
                                .name(CC.translate(name))
                                .lore(CC.translate(lore))
                                .build();
                        setItem(slot, item, e -> {
                            Location teleportLocation = new Location(Bukkit.getWorld(worldName), x, y, z);
                            Player player = (Player) e.getWhoClicked();
                            player.teleport(teleportLocation);
                        });
                    }
                }
            }
        }
    }
}
