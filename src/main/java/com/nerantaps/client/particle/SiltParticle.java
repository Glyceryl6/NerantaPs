package com.nerantaps.client.particle;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.particle.*;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class SiltParticle extends TextureSheetParticle {

    protected SiltParticle(ClientLevel world, double x, double y, double z, double vx, double vy, double vz, SpriteSet spriteSet) {
        super(world, x, y, z);
        this.setSize(0.2F, 0.2F);
        this.lifetime = Math.max(1, 40 + (this.random.nextInt(10) - 5));
        this.gravity = 1.0F;
        this.xd = vx * 0.3F;
        this.yd = vy * 0.3F;
        this.zd = vz * 0.3F;
        this.pickSprite(spriteSet);
    }

    @Override
    public ParticleRenderType getRenderType() {
        return ParticleRenderType.PARTICLE_SHEET_OPAQUE;
    }

    public record Provider(SpriteSet spriteSet) implements ParticleProvider<SimpleParticleType> {

        public static Provider provider(SpriteSet spriteSet) {
            return new Provider(spriteSet);
        }

        public Particle createParticle(SimpleParticleType type, ClientLevel level, double x, double y, double z, double xSpeed, double ySpeed, double zSpeed) {
            return new SiltParticle(level, x, y, z, xSpeed, ySpeed, zSpeed, this.spriteSet);
        }

    }

}