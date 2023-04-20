package inf112.shmup.core.ships;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;

import inf112.shmup.core.bullets.Bullet;
import inf112.shmup.core.utilities.HealthPool;
import inf112.shmup.core.utilities.SpriteActor;

public abstract class Ship extends SpriteActor {
    private final HealthPool _health;
    private final List<Rifle> _rifles;
    private float _speedX = 5f;
    private float _speedY = 5f;

    public Ship(Sprite shipSprite, int maxHealth) {
        super(shipSprite);
        _health = new HealthPool(maxHealth);
        _rifles = new ArrayList<>();
    }

    protected Rifle addRifle(float cooldown, Supplier<Bullet> bulletSupplier) {
        Rifle rifle = new Rifle(this, cooldown, bulletSupplier);
        _rifles.add(rifle);
        return rifle;
    }

    public int getHealth() {
        return _health.getCurrent();
    }

    public int getMaxHealth() {
        return _health.getMax();
    }
    
    public float getSpeedX() {
    	return _speedX;
    }
    
    public float getSpeedY() {
    	return _speedY;
    }
    
    public void setSpeedX(float speedX) {
    	this._speedX = speedX;
    }
    
    public void setSpeedY(float speedY) {
    	this._speedY = speedY;
    }

    public boolean isDead() {
        return _health.isDead();
    }

    public void takeDamage(int damage) {

        if (damage > 0) onDamaged();
        else if (damage < 0) onHealed();

        _health.takeDamage(damage);

        if (isDead()) {
            onDead();
			remove();
        }
    }

    protected abstract void onHealed();
    protected abstract void onDamaged();
    protected abstract void onDead();

    @Override
    protected void setStage(Stage stage) {
        if (stage == null)
            return;

        for (Rifle rifle : _rifles) {
            stage.addActor(rifle);
        }
    }

    @Override
    public boolean remove() {
        for (Rifle rifle : _rifles)
            rifle.remove();
        return super.remove();
    }
}
