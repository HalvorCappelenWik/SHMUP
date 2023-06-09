package inf112.shmup.core.enemies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;

import inf112.shmup.core.Game;
import inf112.shmup.core.powerups.PowerUpFactory;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.utilities.AudioPlayer;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.ScoreManager;

public abstract class EnemyShip extends Ship implements Damageable {

    private static final float ITEM_DROP_PROBABILITY = 0.8f;
	
	private final Color DAMAGE_COLOR = Color.RED;
	private final int DAMAGE_FRAMES = 3;
	private int _damageFrames = 0;
	protected int killPoints = 100;
    protected boolean hasInvincibleIntro = true;

     /**
     * The constructor for the EnemyShip class.
     * @param x The x-coordinate the EnemyShip starts at
     * @param y The y-coordinate the EnemyShip starts at
     * @param shipSprite The sprite of the enemy ship
     * @param maxHealth Max health of the enemy ship
     */
    public EnemyShip(float x, float y, Sprite shipSprite, int maxHealth) {
        super(shipSprite, maxHealth);
        setCollisionScale(0.8f);
        setRotationDownwards();
        setPosition(x, Game.V_HEIGHT * 1.5f);

        Action sequence = new SequenceAction(
            Actions.moveTo(x, y + 25, 2.2f),
            Actions.moveTo(x, y + 5, 0.2f),
            Actions.moveTo(x, y, 0.4f));
											
		this.addAction(sequence);
    }

    @Override
    public void takeDamage(int damage) {
        if(getActions().size > 0 && hasInvincibleIntro) return;
        
        super.takeDamage(damage);
        _damageFrames = DAMAGE_FRAMES;
        
        if(getHealth() <= 0) {
        	ScoreManager.addScore(killPoints);
        }
    }

    @Override
    public Rectangle getBounds() {
        return getCollisionBox();
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

    @Override
    protected void onDead() {
        AudioPlayer.playEffect("enemy_killed");
        if (PowerUpFactory.shouldSpawnPowerUp(ITEM_DROP_PROBABILITY)) {
            PowerUpFactory.spawnPowerUp(getX(), getY());
        }
    }

    /**
     * Disables the enemy invincibility.  
     * Use this for testing purposes only.
     * @param enemy The enemy to turn the invincibility off
     */
    public static void disableInvincibility(EnemyShip enemy) {
        enemy.hasInvincibleIntro = false;
    }

}