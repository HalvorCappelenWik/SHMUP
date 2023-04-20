package inf112.shmup.core.powerups;

import com.badlogic.gdx.scenes.scene2d.Actor;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.Explosion;

import java.util.ArrayList;
import java.util.List;

public class AtomBomb extends PowerUp{

    public AtomBomb(float x, float y) {
        super(x, y, AssetManager.sprite("items/nuke.png"));
        sprite.setSize(20, 20);
    }

    @Override
    public void takeDamage(int damage) {
        List<Actor> damageable = new ArrayList<Actor>();

        for (Actor actor : getStage().getActors()) {
            if (actor instanceof Damageable) {
                damageable.add(actor);
            }
        }
        for (Actor actor : damageable) {
            actor.remove();
        }
        remove();
    }
}
