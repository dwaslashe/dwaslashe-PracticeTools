package xyz.dwaslashe.tools.configs;

import eu.okaeri.configs.OkaeriConfig;
import eu.okaeri.configs.annotation.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;

@Getter @Setter
@Header("#")
@Header("#By dwaslashe")
@Header("#Contact discord dwaslashe v2#5620")
@Header("#")
@Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
public class PluginConfig extends OkaeriConfig {

    private Core core = new Core();
    private Messages messages = new Messages();
    private Cooldown cooldown = new Cooldown();
    private Chat chat = new Chat();
    private Join join = new Join();
    private Auto auto = new Auto();
    private Commands commands = new Commands();

    //Core
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Core extends OkaeriConfig {

        @Comment("Your license:")
        private String license = "";

    }

    //Command
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Commands extends OkaeriConfig {

        private boolean broadcast = true;
        private boolean teleport = true;
        private boolean chat = true;
        private boolean clear = true;
        private boolean day = true;
        private boolean discord = true;
        private boolean enderchest = true;
        private boolean feed = true;
        private boolean fly = true;
        private boolean gamma = true;
        private boolean gamemode = true;
        private boolean hat = true;
        private boolean heal = true;
        private boolean help = true;
        private boolean invsee = true;
        private boolean more = true;
        private boolean item = true;
        private boolean list = true;
        private boolean me = true;
        private boolean punishment = true;
        private boolean socialmedia = true;
        private boolean msg = true;
        private boolean socialspy = true;
        private boolean reply = true;
        private boolean purchase = true;
        private boolean repair = true;
        private boolean rules = true;
        private boolean tnt = true;
        private boolean leave = true;
        private boolean abovename = true;
        private boolean teleporthere = true;
        private boolean uptime = true;
        private boolean wb = true;
        private boolean website = true;
        private boolean vanish = true;
        private boolean yt = true;
        private boolean night = true;
        private boolean sun = true;
        private boolean storm = true;
        private boolean particles = true;
        private boolean reward = true;
        private boolean rank = true;
        private boolean nickcolor = true;
        private boolean ignore = true;
        private boolean unignore = true;
    }

    //Messages
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Messages extends OkaeriConfig {

        @Comment("Messages")
        private String ip = " &c&lPVPPLAY.PL";
        private String prefix = " &8>> &7";
        private String discord = "dc.pvpplay.pl";
        private String website = "www.pvpplay.pl";
    }

    //Auto Tasks
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Auto extends OkaeriConfig {

        private MessagesAuto messages = new MessagesAuto();

        @Getter @Setter
        public static class MessagesAuto extends OkaeriConfig {

            private int time = 1;
            private List<String> messages = Arrays.asList("&c✉ &8>> &7Sprawdź nasz discord &bpvpplay/dc");

        }

        private BossBarAuto bossBarAuto = new BossBarAuto();

        @Getter @Setter
        public static class BossBarAuto extends OkaeriConfig {

            private int time = 1;
            private String message = "&dDISCORD: &fdc.pvplay.pl &dSTRONA: &fwww.pvpplay.pl";
        }
    }

    //Join
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Join extends OkaeriConfig {

        @Comment("Join message, permission core.join.vip")
        private String vipbroadcast = "{PREFIX}&8>> &aGracz &e{PLAYER} &adołączył na serwer! &bDziękujemy za wsparcie!";
        private String joinmessage = "&8&m-----------------------\n&7Witaj &c%player% &7na serwerze\n\n&c&lDiscord:&f dc.pvpplay.pl\n&c&lStrona: &fhttps://pvpplay.pl\n&8&m-----------------------";

    }

    //Chat
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Chat extends OkaeriConfig {

        private List<String> allowedcommands = Arrays.asList("leave", "discord", "duel", "party");

        private List<String> blocktabcommands = Arrays.asList("/br",
                "/brush",
                "/desel",
                "/deselect",
                "/sel",
                "/toggleplace",
                ";",
                "?",
                "alonsotags",
                "artp",
                "aspawner",
                "axerrnicknamer",
                "beastwithdraw",
                "xpbottle",
                "bwithdraw",
                "bellyflop",
                "bpl",
                "bplugins",
                "br",
                "brush",
                "bserverutils",
                "bsu",
                "cc",
                "ccreate",
                "cmil",
                "cmilib",
                "command",
                "insaneshops",
                "core",
                "crate",
                "crates",
                "crazycrate",
                "crazycrates",
                "gbellyflop",
                "gcrawl",
                "glay",
                "gsit",
                "gspin",
                "hd",
                "hdv",
                "holo",
                "hologram",
                "holograms",
                "holographicdisplays",
                "icanhasbukkit",
                "jday",
                "key",
                "keys",
                "lbans",
                "listwarn",
                "listwarnings",
                "litebans",
                "lbans",
                "warninglist",
                "warnlist",
                "lwarning",
                "mineeconomy",
                "intace",
                "iac",
                "minemarriages",
                "minephysics",
                "mineplots",
                "minerandomtp",
                "none",
                "papi",
                "placeholderapi",
                "playerkits",
                "reg",
                "regions",
                "region",
                "rg",
                "shopgui",
                "shopguiplus",
                "viaver",
                "viaversion",
                "vulcan",
                "vvbukkit",
                "worldedit",
                "zauction",
                "about");

        @Comment("Chat")
        private String format = "{PREFIX}&7{PLAYER} &8>>&f{SUFFIX} {MESSAGE}";
        private String on = "&a&lCZAT ZOSTAŁ WŁĄCZONY";
        private String off = "&c&LCZAT ZOSTAŁ WYŁĄCZONY";
        private String clear = "&b&lCZAT ZOSTAŁ WYCZYSZCZONY";

        private BlockWordsChat blockwords = new BlockWordsChat();

        @Getter @Setter
        public static class BlockWordsChat extends OkaeriConfig {

            private List<String> words = Arrays.asList("kutas", "kurwa", "chuj");
            private String command = "mute {PLAYER} 15m Słowa";

        }

    }

    //Cooldown
    @Getter @Setter
    @Names(strategy = NameStrategy.HYPHEN_CASE, modifier = NameModifier.TO_LOWER_CASE)
    public static class Cooldown extends OkaeriConfig {

        @Comment("Cooldown")
        private String message = " &8>> &7Nastepna wiadomosc mozesz wyslac za &f{TIME}";
        private String time = "3s";

    }
}
