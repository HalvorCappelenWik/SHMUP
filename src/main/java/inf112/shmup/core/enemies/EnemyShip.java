package inf112.shmup.core.enemies;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Game;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.utilities.Damageable;
import inf112.shmup.core.utilities.ScoreManager;

public abstract class EnemyShip extends Ship implements Damageable {
	
	private final Color DAMAGE_COLOR = Color.RED;
	private final int DAMAGE_FRAMES = 3;
	private int _damageFrames = 0;
	
    public EnemyShip(float x, float y, Sprite shipSprite, int maxHealth) {
        super(shipSprite, maxHealth);
        setRotationDownwards();
        setPosition(x, Game.V_HEIGHT * 1.5f);

        Action sequence = new SequenceAction(
            Actions.moveTo(x, y+25, 2.2f), 
            Actions.moveTo(x, y+5, 0.2f),
            Actions.moveTo(x, y, 0.4f));
											
		this.addAction(sequence);
    }

    @Override
    public void takeDamage(int damage) {
        super.takeDamage(damage);
        _damageFrames = DAMAGE_FRAMES;
        
        if(getHealth() <= 0) {
        	ScoreManager.addScore(100);
        }
    }

    @Override
    public Rectangle getBounds() {
        return getBoundingRectangle();
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
    
    
}