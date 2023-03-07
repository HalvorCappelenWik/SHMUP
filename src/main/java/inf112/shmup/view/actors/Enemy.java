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

public class Enemy extends Actor{ //might be a good idea to make an abstract class if we want enemy variety

    Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/playerShip1_blue.png")));
    public boolean killed = false;

    int dir = 1;
    float speed = 100;

    private final float _secondsBetweenBullets = 0.3f;
	private float _secondsSinceLastBullet = 0f;
    

    public Enemy(float x, float y){
        setPosition(x, y);
        setBounds(x, y, getTotalWidth(), getTotalHeight());
        sprite.setOriginCenter();
        //setOrigin(sprite.getWidth()/2, sprite.getHeight()/2);
        sprite.rotate(180f);
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

        //shoot
        if(_secondsSinceLastBullet > _secondsBetweenBullets) {
			Bullet newBullet = new EnemyBullet(this.getX() + getTotalWidth()/2, this.getY());
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
	 * @return Sprite width with scale
	 */
	public float getTotalWidth(){
		return sprite.getWidth() * sprite.getScaleX();
	}

	/**
	 * @return Sprite height with scale
	 */
	public float getTotalHeight(){
		return sprite.getHeight() * sprite.getScaleY();
	}
	
	/**
	 * get the current sprite
	 * @return sprite
	 */
	public Sprite getSprite() {
		return sprite;
	}
	

	/**
	 * Set the killed field to true
	 * Fade out actor then remove from stage
	 */
	public void kill() {
		this.killed = true;
		this.remove();
	}

}
