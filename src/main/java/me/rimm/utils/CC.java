package me.rimm.utils;

import lombok.experimental.UtilityClass;
import org.bukkit.ChatColor;

import java.util.List;
import java.util.stream.Collectors;

@UtilityClass
public class CC {

    public String translate(String input) {
        return ChatColor.translateAlternateColorCodes('&', input);
    }

    public List<String> translate(List<String> strings) {
        return strings.stream().map(CC::translate).collect(Collectors.toList());
    }


}