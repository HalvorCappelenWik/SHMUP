package inf112.shmup.core.bullets;

import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Player;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.SpriteActor;

public abstract class Bullet extends SpriteActor {

	private final float _speed;

	/**
	 * Constructor for the Bullet class.
	 * @param speed The speed of the bullet
	 * @param bulletSprite The sprite of the bullet
	 */
	public Bullet(float speed, String bulletSprite) {
		super(AssetManager.sprite("bullets/" + bulletSprite));
		_speed = speed;
	}

	@Override
	public void act(float delta) {
		float x = (float)Math.sin(Math.toRadians(getRotation())) * _speed * delta;
		float y = (float)Math.cos(Math.toRadians(getRotation())) * _speed * delta;

		moveBy(x, y);

		if (!isOnScreen()) {
			this.remove();
			return;
		}

		Player playerHit = hasHitPlayer();
		if(playerHit != null){
			onHitPlayer(playerHit);		
		}

		Damageable enemyHit = hasHitEnemy();
		if(enemyHit != null){
			onHitEnemy(enemyHit);
		}
	}

	/**
	 * Detects if the bullet is colliding with a player.
	 * @return the player instance
	 */
	protected Player hasHitPlayer(){
		Player player = Player.getInstance();
        if (player == null) return null;
       
        if (sprite.getBoundingRectangle().overlaps(player.getShip().getCollisionBox())) {
            return player;
        }
		else {
			return null;
		}
	}

	/**
	 * Detects if the bullet is colliding with an enemy.
	 * @return an damageable instance
	 */
	protected Damageable hasHitEnemy(){
		
		Rectangle bounds = sprite.getBoundingRectangle();

		if (getStage() == null)
			return null;
		
		Damageable actorHit = null;

		for (Actor actor : getStage().getActors()) {
			if (actor instanceof Damageable) {
				Damageable damageable = (Damageable) actor;

				if (bounds.overlaps(damageable.getBounds())) {
					actorHit = damageable;
				}
			}
		}
		return actorHit;
	}

	/**
	 * Code to be executed when colliding with a player.
	 * @param player The player instance collided with
	 */
	public abstract void onHitPlayer(Player player);

	/**
	 * Code to be executed when colliding with an enemy.
	 * @param enemy The enemy instance collided with
	 */
	public abstract void onHitEnemy(Damageable enemy);
}