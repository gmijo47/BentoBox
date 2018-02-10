package us.tastybento.bskyblock.lists;

import org.bukkit.Bukkit;
import us.tastybento.bskyblock.BSkyBlock;
import us.tastybento.bskyblock.api.placeholders.Placeholder;
import us.tastybento.bskyblock.api.placeholders.PlaceholderBuilder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Placeholders {

    public static final Placeholder PLUGIN_NAME = new PlaceholderBuilder().identifier("bsb_plugin_name").value((user) -> BSkyBlock.getInstance().getDescription().getName()).build();

    /**
     * @return List of all the flags in this class
     */
    public static List<Placeholder> values() {
        return Arrays.asList(Placeholders.class.getFields()).stream().map(field -> {
            try {
                return (Placeholder)field.get(null);
            } catch (IllegalArgumentException | IllegalAccessException e) {
                Bukkit.getLogger().severe("Could not get Placeholders values " + e.getMessage());
            }
            return null;
        }).collect(Collectors.toList());
    }
}
