package inf112.shmup.core.enemies;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.utils.Align;
import inf112.shmup.core.Game;
import inf112.shmup.core.bullets.Bullet;
import inf112.shmup.core.bullets.EnemyBullet;
import inf112.shmup.core.powerups.PowerUp;
import inf112.shmup.core.powerups.PowerUpFactory;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;
import inf112.shmup.core.utilities.DrawableActor;
import inf112.shmup.core.utilities.ScoreManager;

/*
    Will be used after we implement our first Enemy type!
 */
public abstract class AbstractEnemy extends DrawableActor implements Damageable {
    public boolean killed = false;

    int dir = -1;
    float speed = 100;

    final String spriteName;

    int health;
    int maxHealth;

    private final float _secondsBetweenBullets = 1f;
    private float _secondsSinceLastBullet = 0f;

    public AbstractEnemy(float x, float y, String spriteName){
        this.spriteName = spriteName;
        setSprite(AssetManager.sprite(spriteName));
        setPosition(x, y, Align.center);
        setEnemyRotation(sprite);

        this.health = this.maxHealth = 3;
    }

// ------------------------------- Override actor methods -----------------------------------

    @Override
    public void act(float delta) {

        if(killed) return;
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

        setX(Math.max(gameBounds.x, getX()));
        setX(Math.min(gameBounds.x + gameBounds.width - getWidth(), getX()));
        setY(Math.max(gameBounds.y, getY()));
        setY(Math.min(gameBounds.y + gameBounds.height - getHeight(), getY()));
    }

    @Override
    public void takeDamage(int damage) {
        health -= damage;
        AudioPlayer.playEffect("enemy_killed");

        if (health > 0) {
            if (health > maxHealth) health = maxHealth;
            return;
        }

        health = 0;
        killed = true;
        PowerUp pp = PowerUpFactory.nextPowerUp(new Enemy(getX(), getY())); // Only temporary! Should be "this" as parameter...
        if (pp != null) getStage().addActor(pp);
        ScoreManager.addScore(100);
        remove();
    }

    @Override
    public Rectangle getBounds() {
        return getSprite().getBoundingRectangle();
    }

}