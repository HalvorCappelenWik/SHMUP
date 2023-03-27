package inf112.shmup.view.actors;

import static com.badlogic.gdx.scenes.scene2d.actions.Actions.fadeOut;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.removeActor;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.sequence;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.app.ShmupGame;
import inf112.shmup.util.GameScore;

public class Enemy extends DrawableActor{ //might be a good idea to make an abstract class if we want enemy variety

    public boolean killed = false;

    int dir = -1;
    float speed = 100;

    private final float _secondsBetweenBullets = 1f;
	private float _secondsSinceLastBullet = 0f;

    public Enemy(float x, float y){
        
		setPosition(x, y, Align.center);
        setSprite("src/assets/ships/ship_red1.png");
       
		setEnemyRotation(sprite);
    }

// ------------------------------- Override actor methods -----------------------------------

    @Override
    public void act(float delta) {
		
    	if(killed) return;
        //move
        this.moveBy(dir * speed * delta, 0);
		Rectangle bounds = new Rectangle(0, 0, ShmupGame.V_WIDTH, ShmupGame.V_HEIGHT); 
		if (!bounds.contains(sprite.getBoundingRectangle())) {
			dir = -dir;
		}

		moveIntoBounds(getX(), getY());

        //shoot
        if(_secondsSinceLastBullet > _secondsBetweenBullets) {
			Bullet newBullet = new EnemyBullet(this.getX(Align.center), this.getY());
			this.getStage().addActor(newBullet);
			_secondsSinceLastBullet = 0f;
		}
		else {
			_secondsSinceLastBullet += delta;
		}

    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
    	//if(killed) return;
        sprite.draw(batch, parentAlpha);
    }

// ------------------------ Other/Utility methods ---------------------------

	/**
	 * Set the killed field to true
	 * Fade out actor then remove from stage
	 */
	public void kill() {
		this.killed = true;
		GameScore.addScore(100);
		this.remove();
	}

		/**
	 * Method that keeps the object within the scene 
	 * @param x current X coordinate
	 * @param y current Y coordinate
	 */
	private void moveIntoBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0, ShmupGame.V_WIDTH, ShmupGame.V_WIDTH); 
	
		setX(Math.max(gameBounds.x, getX()));
		setX(Math.min(gameBounds.x + gameBounds.width - getWidth(), getX()));
		setY(Math.max(gameBounds.y, getY()));
		setY(Math.min(gameBounds.y + gameBounds.height - getHeight(), getY()));
	}

}
