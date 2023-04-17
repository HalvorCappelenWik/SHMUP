package inf112.shmup.core.ships;

import java.util.function.Supplier;
import com.badlogic.gdx.scenes.scene2d.Actor;
import inf112.shmup.core.bullets.Bullet;

public class Rifle extends Actor {

    private final Actor _origin;
    private final float _shootCooldown;
    private final Supplier<Bullet> _bulletSupplier;

    private int _bulletsPerBurst;
    private float _burstCooldown;
    private float[] _angles;
    private boolean _autoShoot;

    private float _timeSinceLastShot;
    private float _timeSinceLastBurst;
    private int _remainingBurst;

    public Rifle(Actor origin, float cooldown, Supplier<Bullet> bulletSupplier) {
        _bulletSupplier = bulletSupplier;
        _shootCooldown = cooldown;
        _origin = origin;
        _angles = new float[] { 0f };
        _bulletsPerBurst = 1;
        _burstCooldown = cooldown / 5;
        _autoShoot = true;
    }

    public Rifle setBurst(int bulletsPerBurst, float cooldown) {
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

            bullet.setRotation(angle + _origin.getRotation());
            bullet.setX(_origin.getX());
            bullet.setY(_origin.getY());
        }
    }
}