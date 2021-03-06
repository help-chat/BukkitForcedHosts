package at.helpch.bukkitforcedhosts;

import at.helpch.bukkitforcedhosts.annotations.Hosts;
import at.helpch.bukkitforcedhosts.registerables.BStatsRegisterable;
import at.helpch.bukkitforcedhosts.registerables.hooks.authme.AuthMeBooleanRegisterable;
import at.helpch.bukkitforcedhosts.registerables.hooks.authme.AuthMeEventRegisterable;
import me.piggypiglet.framework.Framework;
import me.piggypiglet.framework.bootstrap.BootPriority;
import me.piggypiglet.framework.utils.annotations.files.Lang;
import me.piggypiglet.framework.utils.annotations.registerable.RegisterableData;
import org.bukkit.plugin.java.JavaPlugin;

// ------------------------------
// Copyright (c) PiggyPiglet 2019
// https://www.piggypiglet.me
// ------------------------------
public final class BukkitForcedHosts extends JavaPlugin {
    @Override
    public void onEnable() {
        Framework.builder()
                .main(JavaPlugin.class, this)
                .commandPrefixes("bfh", "bukkitforcedhosts")
                .pckg("at.helpch.bukkitforcedhosts", "at.helpch.bukkitforcedhosts.events.hooks")
                .startup(new RegisterableData(BStatsRegisterable.class), new RegisterableData(AuthMeBooleanRegisterable.class),
                        new RegisterableData(AuthMeEventRegisterable.class, BootPriority.AFTER_ADDONS))
                .fileDir(getDataFolder().getPath())
                .file(true, "hosts", "/hosts.yml", "hosts.yml", Hosts.class)
                .file(true, "lang", "/lang.yml", "lang.yml", Lang.class)
                .customLang("lang", at.helpch.bukkitforcedhosts.lang.Lang.values())
                .build()
                .init();
    }
}
