package inf112.shmup.core.powerups;

import com.badlogic.gdx.scenes.scene2d.Actor;

import inf112.shmup.core.enemies.EnemyShip;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.Explosion;

import java.util.ArrayList;
import java.util.List;

public class AtomBomb extends PowerUp {

    private static final int EXPLOSION_RADIUS = 500;

    public AtomBomb(float x, float y) {
        super(x, y, AssetManager.sprite("items/nuke.png"));
        sprite.setSize(20, 20);
    }

    @Override
    public void activate() {
    	Explosion explosion = new Explosion(getX(), getY(), EXPLOSION_RADIUS, 0, false);
        getStage().addActor(explosion);
        List<Actor> damageable = new ArrayList<Actor>();

        for (Actor actor : getStage().getActors()) {
            if (actor instanceof Damageable) {
                damageable.add(actor);
            }
        }

        for (Actor actor : damageable) {
        	if(actor instanceof EnemyShip) {
        		((EnemyShip) actor).takeDamage(Integer.MAX_VALUE);
        	}
            actor.remove();
        }
        
        remove();
    }

	@Override
	public void takeDamage(int damage) {}

}