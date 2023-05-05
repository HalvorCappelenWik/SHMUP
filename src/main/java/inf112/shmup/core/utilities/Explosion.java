package inf112.shmup.core.utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;
import inf112.shmup.core.Player;
import inf112.shmup.core.powerups.PowerUp;

import java.util.HashSet;

public class Explosion extends Actor {

    private final HashSet<Damageable> _damaged = new HashSet<>();
    private final float _explosionSpeed = 300;
    private final float _maxRadius;
    private final int _damage;
    private float currentRadius = 0;
    private boolean playerDamaged = false;
    private boolean _canKillPlayer;

    /**
     * Constructor for the Explosion class.
     * @param x The x-coordinate of the explosion
     * @param y The y-coordinate of the explosion
     * @param radius The radius of the explosion
     * @param damage The damage the explosion deals
     * @param canKillPlayer True if it can kill the player, false otherwise
     */
    public Explosion(float x, float y, float radius, int damage, boolean canKillPlayer) {
        setX(x);
        setY(y);
        _maxRadius = radius;
        _damage = damage;
        _canKillPlayer = canKillPlayer;
        AudioPlayer.playEffect("explosion");
    }

    @Override
    public void act(float delta) {
        currentRadius += _explosionSpeed * delta;
        if (currentRadius >= _maxRadius) {
            remove();
            _damaged.clear();
        } else {
            damageNewObjectsWithinRadius();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        DrawShape.circle(batch, Color.RED, getX(), getY(), currentRadius);
    }

    /**
     * Deals damage to damageables.
     * @param damageable The damagables to deal damage to
     */
    public void tryDamage(Damageable damageable) {
        if (_damaged.contains(damageable))
            return;

        damageable.takeDamage(_damage);
        _damaged.add(damageable);
    }

    /**
     * Deals damage to the player if the explosion can hurt him.
     * @param player The player to deal damage to
     */
    public void tryDamage(Player player) {
    	if (playerDamaged)
            return;
    	
    	if (!_canKillPlayer)
            return;

        player.getShip().takeDamage(_damage);
        playerDamaged = true;
    }

    private void damageNewObjectsWithinRadius() {
		Circle blastArea = new Circle(getX(), getY(), currentRadius);

        for (Actor actor : getStage().getActors()) {
            if (actor instanceof PowerUp) continue;
            if (actor instanceof Damageable) {
                Damageable damageable = (Damageable) actor;
                tryDamage(damageable, blastArea);
            }
            if(actor == Player.getInstance()) {
            	tryDamage((Player) actor, blastArea);
            }
        }
    }

    private void tryDamage(Damageable damageable, Circle blastArea) {
        if (!Intersector.overlaps(blastArea, damageable.getBounds()))
            return;
            
        tryDamage(damageable);
    }
    
    private void tryDamage(Player player, Circle blastArea) {
        if (!Intersector.overlaps(blastArea, player.getShip().getCollisionBox()))
            return;
        
        tryDamage(player);
    }

}