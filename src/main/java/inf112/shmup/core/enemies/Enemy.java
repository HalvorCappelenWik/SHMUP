package inf112.shmup.core.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.Bullet;
import inf112.shmup.core.bullets.EnemyBullet;
import inf112.shmup.core.powerups.PowerUp;
import inf112.shmup.core.powerups.PowerUpFactory;
import inf112.shmup.core.utilities.DrawableActor;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;
import inf112.shmup.core.utilities.ScoreManager;

public class Enemy extends DrawableActor implements Damageable { //might be a good idea to make an abstract class if we want enemy variety

    public boolean killed = false;
	private boolean active = false;

    int dir = -1;
    float speed = 100;

    private final float _secondsBetweenBullets = 1f;
	private float _secondsSinceLastBullet = 0f;

    public Enemy(float x, float y){
        
        setSprite(AssetManager.sprite("ships/ship_red1.png"));
		setPosition(x, y + Game.V_HEIGHT);
		setEnemyRotation(sprite);
		
		//implement into abstract enemy instead
		//make a static sequence
		Action sequence = new SequenceAction(
											Actions.moveTo(x, y+25, 2.2f), 
											Actions.moveTo(x, y+5, 0.2f),
											Actions.moveTo(x, y, 0.4f));
											
		this.addAction(sequence);
    }

// ------------------------------- Override actor methods -----------------------------------

    @Override
    public void act(float delta) {
		
		super.act(delta);

		if(getActions().size <= 0){
			active = true;
		}
    	
		if(killed || !active) return;
        //move
        this.moveBy(dir * speed * delta, 0);
		Rectangle bounds = new Rectangle(0, 0, Game.V_WIDTH, Game.V_HEIGHT);
		if (!bounds.contains(sprite.getBoundingRectangle())) {
			dir = -dir;
		}

		moveIntoBounds(getX(), getY());

        //shoot
        if(_secondsSinceLastBullet > _secondsBetweenBullets) {
			Bullet newBullet = new EnemyBullet(this.getX(Align.center), this.getY(), 1);
			this.getStage().addActor(newBullet);
			_secondsSinceLastBullet = 0f;
			AudioPlayer.playEffect("shoot_2");
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
	 * Method that keeps the object within the scene 
	 * @param x current X coordinate
	 * @param y current Y coordinate
	 */
	private void moveIntoBounds(float x, float y) {
		Rectangle gameBounds = new Rectangle(0,0, Game.V_WIDTH, Game.V_WIDTH);
	
		setX(clampX(getX(), gameBounds));
		setX(Math.min(gameBounds.x + gameBounds.width - getWidth(), getX()));
		setY(clampY(getY(), gameBounds));
		setY(Math.min(gameBounds.y + gameBounds.height - getHeight(), getY()));
	}

	private float clampX(float x, Rectangle bounds){
		
		x = Math.max(bounds.x,x);
		x = Math.min(bounds.x + bounds.width - getWidth(), x);
		return x;
	}

	private float clampY(float y, Rectangle bounds){

		y = Math.max(bounds.y, y);
		y = Math.min(bounds.y + bounds.height - getHeight(), y);
		return y;
	}

	@Override
	public void takeDamage(int damage) {
		this.killed = true;
		ScoreManager.addScore(100);
		
		PowerUp pp = PowerUpFactory.nextPowerUp(this);
		
		if (pp != null) getStage().addActor(pp);
		
		this.remove();
		AudioPlayer.playEffect("enemy_killed");
	}

	@Override
	public Rectangle getBounds() {
		return getSprite().getBoundingRectangle();
	}

}
