package inf112.shmup.core.utilities;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Player;
import inf112.shmup.core.powerups.PowerUp;

public class Explosion extends Actor {
    private final HashSet<Damageable> _damaged = new HashSet<>();
    private final float _explosionSpeed = 300;
    private final float _maxRadius;
    private final int _damage;
    private float currentRadius = 0;
    private boolean playerDamaged = false;
    private boolean _canKillPlayer;

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

    private void tryDamage(Damageable damageable, Circle blastArea)
    {
        if (_damaged.contains(damageable))
            return;

        if (!Intersector.overlaps(blastArea, damageable.getBounds()))
            return;

        damageable.takeDamage(_damage);
        _damaged.add(damageable);
    }
    
    private void tryDamage(Player damageable, Circle blastArea)
    {
    	if (playerDamaged) return;
    	
    	if (!_canKillPlayer) return;

        if (!Intersector.overlaps(blastArea, damageable.getShip().getCollisionBox()))
            return;

        damageable.getShip().takeDamage(_damage);
        playerDamaged = true;
    }
}
