package xyz.dwaslashe.tools.utils;

import net.minecraft.server.v1_8_R3.*;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;
import xyz.dwaslashe.tools.Main;

import java.util.HashSet;
import java.util.concurrent.ConcurrentHashMap;

public class BossBarApi {
    private Player p;

    private EntityWither w;

    public BossBarApi(Player player) {
        this.p = player;
        update();
    }

    public void update() {
        Vector d = this.p.getLocation().getDirection();
        Block b = this.p.getTargetBlock((HashSet<Byte>) null, 5);
        Location loc = b.getLocation().add(d.multiply(10));
        WorldServer world = ((CraftWorld) loc.getWorld()).getHandle();
        this.w = new EntityWither((World) world);
        this.w.setLocation(loc.getX(), loc.getY() + 15, loc.getZ(), loc.getPitch(), loc.getYaw());
        this.w.setInvisible(true);
        this.w.setHealth(0.0F);
        this.w.setCustomName(Api.fixColor(Main.pluginConfig.getAuto().getBossBarAuto().getMessage()));
        PacketPlayOutSpawnEntityLiving packet = new PacketPlayOutSpawnEntityLiving((EntityLiving) this.w);
        (((CraftPlayer) this.p).getHandle()).playerConnection.sendPacket((Packet) packet);
    }


    public static void sendBossBar(final Player p) {
        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
            @Override
            public void run() {
                new BossBarApi(p);
                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                    @Override
                    public void run() {
                        new BossBarApi(p);
                        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                            @Override
                            public void run() {
                                new BossBarApi(p);
                                Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                                    @Override
                                    public void run() {
                                        new BossBarApi(p);
                                        Bukkit.getScheduler().runTaskLater(Main.getPlugin(), new Runnable() {
                                            @Override
                                            public void run() {
                                                new BossBarApi(p);
                                            }
                                        }, 15);
                                    }
                                }, 15);
                            }
                        }, 15);
                    }
                }, 15);
            }
        }, 15);
    }
}
