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

import inf112.shmup.app.ShmupGame;
import inf112.shmup.util.GameScore;

public class Enemy extends DrawableActor{ //might be a good idea to make an abstract class if we want enemy variety

    public boolean killed = false;

    int dir = 1;
    float speed = 100;

    private final float _secondsBetweenBullets = 0.3f;
	private float _secondsSinceLastBullet = 0f;
    

    public Enemy(float x, float y){
        setPosition(x, y);
        setBounds(x, y, getTotalWidth(), getTotalHeight());
        setSprite("src/assets/ships/ship_red1.png");
		
		sprite.setOrigin(0,0);
        //setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
       
		setEnemyRotation(sprite);
    }

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
			Bullet newBullet = new EnemyBullet(this.getX(), this.getY());
			this.getStage().addActor(newBullet);
			_secondsSinceLastBullet = 0f;
		}
		else {
			_secondsSinceLastBullet += delta;
		}

    }

    @Override
    protected void positionChanged() {
        sprite.setPosition(getX(), getY());
        super.positionChanged();
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
    	//if(killed) return;
        sprite.draw(batch, parentAlpha);
    }

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
		Rectangle gameBounds = new Rectangle(0,0, ShmupGame.V_WIDTH, ShmupGame.V_WIDTH); //Gdx.graphics.getWidth(), Gdx.graphics.getHeight()
		
		setX(Math.max(gameBounds.x, getX()));
		setX(Math.min(gameBounds.x + gameBounds.width - getTotalWidth(), getX()));
		setY(Math.max(gameBounds.y, getY()));
		setY(Math.min(gameBounds.y + gameBounds.height - getTotalHeight(), getY()));
	}

}
