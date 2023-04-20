package inf112.shmup.core.utilities;

import java.util.HashSet;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Intersector;
import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.Player;

public class Explosion extends Actor {
    private final HashSet<Damageable> _damaged = new HashSet<>();
    private final ShapeRenderer _renderer = new ShapeRenderer();
    private final float _explosionSpeed = 300;
    private final float _maxRadius;
    private final int _damage;
    private float currentRadius = 0;
    private boolean playerDamaged = false;

    public Explosion(float x, float y, float radius, int damage) {
        setX(x);
        setY(y);
        _maxRadius = radius;
        _damage = damage;
        AudioPlayer.playEffect("explosion");
    }

    @Override
    public void act(float delta) {
        currentRadius += _explosionSpeed * delta;
        if (currentRadius >= _maxRadius) {
            remove();
            _renderer.dispose();
            _damaged.clear();
        } else {
            damageNewObjectsWithinRadius();
        }
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.end();
        
        _renderer.setProjectionMatrix(batch.getProjectionMatrix());
        _renderer.setTransformMatrix(batch.getTransformMatrix());

        _renderer.begin(ShapeType.Line);
        _renderer.setColor(Color.RED);
        _renderer.circle(getX(), getY(), currentRadius);
        _renderer.end();

        batch.begin();
    }

    private void damageNewObjectsWithinRadius() {
		Circle blastArea = new Circle(getX(), getY(), currentRadius);

        for (Actor actor : getStage().getActors()) {
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

        if (!Intersector.overlaps(blastArea, damageable.getShip().getBoundingRectangle()))
            return;

        damageable.getShip().takeDamage(_damage);
        playerDamaged = true;
    }
}
