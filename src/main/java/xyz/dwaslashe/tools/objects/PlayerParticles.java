package xyz.dwaslashe.tools.objects;

import net.minecraft.server.v1_8_R3.EnumParticle;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class PlayerParticles {
    public static List<PlayerParticles> particles = new ArrayList();

    public static boolean exists(String player){
        for (PlayerParticles particle : particles) {
            if(particle.getName().equals(player)){
                return true;
            }
        }
        return false;
    }
    public static PlayerParticles get(String name){
        for (PlayerParticles particle : particles) {
            if(particle.getName().equals(name)){
                return particle;
            }
        }
        return new PlayerParticles(name);
    }
    public static PlayerParticles get(Player player){
        return get(player.getName());
    }
    private String name;
    private EnumParticle particleType = null;
    private int amount = 1;

    public PlayerParticles(String name){
        this.name = name;
        if(!particles.contains(this)) particles.add(this);
    }

    public String getName( ) {
        return name;
    }

    public EnumParticle getParticleType( ) {
        return particleType;
    }

    public int getAmount( ) {
        return amount;
    }

    public void setParticleType(EnumParticle particleType) {
        this.particleType = particleType;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}