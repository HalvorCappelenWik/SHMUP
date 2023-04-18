package inf112.shmup.core.enemies;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Game;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.utilities.Damageable;

public abstract class EnemyShip extends Ship implements Damageable {
    public EnemyShip(float x, float y, Sprite shipSprite, int maxHealth) {
        super(shipSprite, maxHealth);
        setRotationDownwards();
        setPosition(x, y + Game.V_HEIGHT);

        Action sequence = new SequenceAction(
            Actions.moveTo(x, y+25, 2.2f), 
            Actions.moveTo(x, y+5, 0.2f),
            Actions.moveTo(x, y, 0.4f));
											
		this.addAction(sequence);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
    }

    @Override
    public Rectangle getBounds() {
        return getBoundingRectangle();
    }
}