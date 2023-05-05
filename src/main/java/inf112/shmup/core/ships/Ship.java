package inf112.shmup.core.ships;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Stage;
import inf112.shmup.core.bullets.Bullet;
import inf112.shmup.core.utilities.HealthPool;
import inf112.shmup.core.utilities.SpriteActor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public abstract class Ship extends SpriteActor {

    private final HealthPool _health;
    private final List<Rifle> _rifles;
    private float _speedX = 300f;
    private float _speedY = 300f;
    
    private final Color DAMAGE_COLOR = Color.RED;
	private final int DAMAGE_FRAMES = 4;
	private int _damageFrames = 0;

    /**
     * Constructor for the Ship class.
     * @param shipSprite The sprite of the ship
     * @param maxHealth The max health of the ship
     */
    public Ship(Sprite shipSprite, int maxHealth) {
        super(shipSprite);
        setCollisionScale(0.6f, 0.4f);
        _health = new HealthPool(maxHealth);
        _rifles = new ArrayList<>();
    }

    /**
     * Adds a rifle to the ship.
     * @param cooldown The cooldown between each shot
     * @param bulletSupplier The bullet supplier
     * @return a rifle to the ship according to the given parameters
     */
    protected Rifle addRifle(float cooldown, Supplier<Bullet> bulletSupplier) {
        Rifle rifle = new Rifle(this, cooldown, bulletSupplier);
        _rifles.add(rifle);
        return rifle;
    }

    /** Returns the current health of the ship. */
    public int getHealth() {
        return _health.getCurrent();
    }

    /** Returns the max health of the ship. */
    public int getMaxHealth() {
        return _health.getMax();
    }

    /** Returns the horizontal speed of the ship. */
    public float getSpeedX() {
    	return _speedX;
    }

    /** Returns the vertical speed of the ship. */
    public float getSpeedY() {
    	return _speedY;
    }

    /**
     * Sets the horizontal speed of the ship.
     * @param speedX The desired horizontal speed of the ship
     */
    public void setSpeedX(float speedX) {
    	this._speedX = speedX;
    }

    /**
     * Sets the vertical speed of the ship.
     * @param speedY The desired vertical speed of the ship
     */
    public void setSpeedY(float speedY) {
    	this._speedY = speedY;
    }

    /** Returns true if the ship is dead, false otherwise. */
    public boolean isDead() {
        return _health.isDead();
    }

    /**
     * Give damage to the ship.
     * @param damage The amount of damage to deal to the ship
     */
    public void takeDamage(int damage) {

        if (damage > 0) onDamaged();
        else if (damage < 0) onHealed();

        _health.takeDamage(damage);
        _damageFrames = DAMAGE_FRAMES;

        if (isDead()) {
            onDead();
			remove();
        }
    }
    
    @Override
	public void draw(Batch batch, float parentAlpha) {
		if (_damageFrames > 0) {
			_damageFrames--;
			sprite.setColor(DAMAGE_COLOR);
		}
		super.draw(batch, parentAlpha);
		sprite.setColor(Color.WHITE);
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