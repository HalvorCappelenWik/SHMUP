package inf112.shmup.core.ships;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;
import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.Bullet;
import inf112.shmup.core.utilities.AudioPlayer;
import inf112.shmup.core.utilities.DrawShape;

import java.util.function.Supplier;

public class Rifle extends Actor {

    private final Actor _origin;
    private final float _shootCooldown;
    private final Supplier<Bullet> _bulletSupplier;

    private int _bulletsPerBurst;
    private float _burstCooldown;
    private float[] _angles;
    private boolean _autoShoot;
    private String _sound;
    private float _offset;

    private float _timeSinceLastShot;
    private float _timeSinceLastBurst;
    private int _remainingBurst;

    public Rifle(Actor origin, float cooldown, Supplier<Bullet> bulletSupplier) {
        _bulletSupplier = bulletSupplier;
        _shootCooldown = cooldown;
        _origin = origin;
        _angles = new float[] { 0f };
        _offset = 45f;
        _bulletsPerBurst = 1;
        _burstCooldown = cooldown / 5;
        _autoShoot = true;
    }

    public Rifle useBurst(int bulletsPerBurst, float cooldown) {
        _bulletsPerBurst = bulletsPerBurst;
        _burstCooldown = cooldown;
        return this;
    }

    public Rifle useAngles(float ...angles) {
        _angles = angles;
        return this;
    }

    public Rifle setAutoShoot(boolean shootAutomatically) {
        _autoShoot = shootAutomatically;
        return this;
    }

    public Rifle useSound(String sound) {
        _sound = sound;
        return this;
    }

    public Rifle useOffset(float offset) {
        _offset = offset;
        return this;
    }
    
    public void shoot() {
        if (_timeSinceLastShot < _shootCooldown)
            return;

        _timeSinceLastShot = 0f;
        _timeSinceLastBurst = 0f;
        _remainingBurst = _bulletsPerBurst;
    }

    @Override
    public void act(float delta) {
        _timeSinceLastShot += delta;
        _timeSinceLastBurst += delta;

        if (_autoShoot) {
            shoot();
        }

        shootBurst();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        if (Game.DEBUG_ENABLED) {
            for (float angle : _angles) {
                DrawShape.line(batch, Color.GREEN, _origin.getX(Align.center), _origin.getY(Align.center), getBulletX(angle), getBulletY(angle));
            }
        }
    }

    private void shootBurst() {
        if (_remainingBurst <= 0)
            return;

        if (_timeSinceLastBurst < _burstCooldown)
            return;

        _timeSinceLastBurst = 0;
        _remainingBurst--;

        for (float angle : _angles) {

            Bullet bullet = _bulletSupplier.get();
            getStage().addActor(bullet);

            bullet.setRotation(getBulletAngle(angle));
            bullet.setPosition(getBulletX(angle), getBulletY(angle), Align.center);
        }

        if (_sound != null) {
            AudioPlayer.playEffect(_sound);
        }
    }

    private float getBulletAngle(float angle) {
        return angle + _origin.getRotation();
    }

    private float getBulletX(float angle) {
        return _origin.getX(Align.center) + (float)Math.sin(Math.toRadians(getBulletAngle(angle))) * _offset;
    }

    private float getBulletY(float angle) {
        return _origin.getY(Align.center) + (float)Math.cos(Math.toRadians(getBulletAngle(angle))) * _offset;
    }

}