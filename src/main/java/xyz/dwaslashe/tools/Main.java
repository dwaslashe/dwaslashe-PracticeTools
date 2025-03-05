package xyz.dwaslashe.tools;

import eu.okaeri.configs.ConfigManager;
import eu.okaeri.configs.yaml.bukkit.YamlBukkitConfigurer;
import lombok.Getter;
import lombok.Setter;
import net.milkbowl.vault.economy.Economy;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;
import xyz.dwaslashe.tools.commands.*;
import xyz.dwaslashe.tools.commands.managers.CommandManager;
import xyz.dwaslashe.tools.configs.PluginCommands;
import xyz.dwaslashe.tools.configs.PluginConfig;
import xyz.dwaslashe.tools.helpers.InventoryHelper;
import xyz.dwaslashe.tools.listeners.*;
import xyz.dwaslashe.tools.tasks.AutoBossBarTask;
import xyz.dwaslashe.tools.tasks.AutoMessageTask;
import xyz.dwaslashe.tools.utils.Api;
import xyz.dwaslashe.tools.utils.LicenseApi;

import java.io.File;

@Getter @Setter
public class Main extends JavaPlugin {
    private static Economy vaultEconomy;
    public boolean placeholder = false;

    public static Economy getVaultEconomy() {
        return Main.vaultEconomy;
    }

    private boolean isVaultLoaded() {
        return Bukkit.getPluginManager().isPluginEnabled("Vault");
    }

    private boolean setupVault() {
        try {
            RegisteredServiceProvider<Economy> economy = Bukkit.getServer().getServicesManager().getRegistration(Economy.class);
            if (economy == null)
                throw new Throwable("Vault's Economy provider is not available");
            vaultEconomy = economy.getProvider();
            return true;
        } catch (Throwable throwable) {
            getServer().getPluginManager().disablePlugin(this);
            getLogger().severe("Could not enable plugin, error message: " + throwable.getMessage());
            return false;
        }
    }
    //Configs
    public static PluginConfig pluginConfig;

    public static PluginCommands pluginCommands;

    //Others
    public static Main plugin;

    public static Main getPlugin() {
        return plugin;
    }
    public Main() {
        plugin = this;
    }

    //Enable plugin
    @Override
    public void onEnable() {

        this.getServer().getMessenger().registerOutgoingPluginChannel(this, "BungeeCord");

        pluginConfig = ConfigManager.create(PluginConfig.class, it -> {
            it.withConfigurer(new YamlBukkitConfigurer());
            it.withBindFile(new File(this.getDataFolder(), "config.yml"));
            it.saveDefaults();
            it.load(true);
        });

        pluginCommands = ConfigManager.create(PluginCommands.class, it -> {
            it.withConfigurer(new YamlBukkitConfigurer());
            it.withBindFile(new File(this.getDataFolder(), "commands.yml"));
            it.saveDefaults();
            it.load(true);
        });

        pluginConfig.load();
        pluginCommands.load();

        //if (!new LicenseApi(pluginConfig.getCore().getLicense(), "https://buybrain.pl/license/verify.php", this).register()) return;

        loadTasks();
        loadCommands();
        loadEvents();

        Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable() {
            public void run() {
                for (Player all : Bukkit.getOnlinePlayers()) {
                    PlayerQuitListener.checkPlayer(all);
                }
            }
        }, 0, 20 * 60 * 4);
    }

    @Override
    public void onDisable() {
        //It's nothing to add
    }

    public void loadCommands() {
        CommandManager.register(new BcCommand(), pluginConfig.getCommands().isBroadcast());
        CommandManager.register(new TpCommand(), pluginConfig.getCommands().isTeleport());
        CommandManager.register(new ChatCommand(), pluginConfig.getCommands().isChat());
        CommandManager.register(new ClearCommand(), pluginConfig.getCommands().isClear());
        CommandManager.register(new DayCommand(), pluginConfig.getCommands().isDay());
        CommandManager.register(new DiscordCommand(), pluginConfig.getCommands().isDiscord());
        CommandManager.register(new EcCommand(), pluginConfig.getCommands().isEnderchest());
        CommandManager.register(new FeedCommand(), pluginConfig.getCommands().isFeed());
        CommandManager.register(new FlyCommand(), pluginConfig.getCommands().isFly());
        CommandManager.register(new GammaCommand(), pluginConfig.getCommands().isGamma());
        CommandManager.register(new GmCommand(), pluginConfig.getCommands().isGamemode());
        CommandManager.register(new HatCommand(), pluginConfig.getCommands().isHat());
        CommandManager.register(new HealCommand(), pluginConfig.getCommands().isHeal());
        CommandManager.register(new HelpCommand(), pluginConfig.getCommands().isHelp());
        CommandManager.register(new InvseeComand(), pluginConfig.getCommands().isInvsee());
        CommandManager.register(new MoreCommand(), pluginConfig.getCommands().isMore());
        CommandManager.register(new ItemCommand(), pluginConfig.getCommands().isItem());
        CommandManager.register(new ListCommand(), pluginConfig.getCommands().isList());
        CommandManager.register(new MeCommand(), pluginConfig.getCommands().isMe());
        CommandManager.register(new PunishmentCommand(), pluginConfig.getCommands().isPunishment());
        CommandManager.register(new MediaCommand(), pluginConfig.getCommands().isSocialmedia());
        CommandManager.register(new MsgCommand(), pluginConfig.getCommands().isMsg());
        CommandManager.register(new SocialSpyCommand(), pluginConfig.getCommands().isSocialspy());
        CommandManager.register(new ReplyCommand(), pluginConfig.getCommands().isReply());
        CommandManager.register(new PurchaseCommand(), pluginConfig.getCommands().isPurchase());
        CommandManager.register(new RepairCommand(), pluginConfig.getCommands().isRepair());
        CommandManager.register(new RulesCommand(), pluginConfig.getCommands().isRules());
        CommandManager.register(new TntCommand(), pluginConfig.getCommands().isTnt());
        CommandManager.register(new LeaveCommand(), pluginConfig.getCommands().isLeave());
        CommandManager.register(new CoreCommand(), true);
        CommandManager.register(new VerusCommand(), true);
        CommandManager.register(new NcpCommand(), true);
        CommandManager.register(new AlertsCommand(), true);
        CommandManager.register(new AboveNameShopCommand(), pluginConfig.getCommands().isAbovename());
        CommandManager.register(new TpHereCommand(), pluginConfig.getCommands().isTeleporthere());
        CommandManager.register(new UpTimeCommand(), pluginConfig.getCommands().isUptime());
        CommandManager.register(new WbCommand(), pluginConfig.getCommands().isWb());
        CommandManager.register(new WebsiteCommand(), pluginConfig.getCommands().isWebsite());
        CommandManager.register(new VanishCommand(), pluginConfig.getCommands().isVanish());
        CommandManager.register(new YTCommand(), pluginConfig.getCommands().isYt());
        CommandManager.register(new NightCommand(), pluginConfig.getCommands().isNight());
        CommandManager.register(new SunCommand(), pluginConfig.getCommands().isSun());
        CommandManager.register(new StormCommand(), pluginConfig.getCommands().isStorm());
        CommandManager.register(new ParticlesCommand(), pluginConfig.getCommands().isParticles());
        CommandManager.register(new RewardCommand(), pluginConfig.getCommands().isReward());
        CommandManager.register(new RankCommand(), pluginConfig.getCommands().isRank());
        CommandManager.register(new NickColorCommand(), pluginConfig.getCommands().isNickcolor());
        CommandManager.register(new IgnoreCommand(), pluginConfig.getCommands().isIgnore());
        CommandManager.register(new UnIgnoreCommand(), pluginConfig.getCommands().isUnignore());
    }

    public void loadTasks() {
        new AutoMessageTask(this);
        new AutoBossBarTask(this);
        new VanishCommand.VanishRunnable();
    }

    public void loadEvents() {
        registerEvent(new PlayerJoinListener(), true);
        registerEvent(new PlayerChatListener(), true);
        registerEvent(new OthersListener(), true);
        registerEvent(new RankCommand(), pluginConfig.getCommands().isRank());
        registerEvent(new NickColorCommand(), pluginConfig.getCommands().isNickcolor());
        registerEvent(new ParticlesCommand(), pluginConfig.getCommands().isParticles());
        registerEvent(new AboveNameShopCommand(), pluginConfig.getCommands().isAbovename());
        registerEvent(new PlayerQuitListener(), true);
        registerEvent(new VanishCommand.VanishEvent(), pluginConfig.getCommands().isVanish());
        InventoryHelper.implement(this);
    }

    private void registerEvent(Listener listener, boolean enable) {
        if (enable) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        } else Api.sendLog("&cEvent " + listener + " has disabled!");
    }
}
