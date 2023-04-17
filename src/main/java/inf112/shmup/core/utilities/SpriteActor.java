package inf112.shmup.core.utilities;

import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Game;

public abstract class SpriteActor extends Actor {
    protected static final Rectangle SCREEN_BOUNDS = new Rectangle(0,0, Game.V_WIDTH, Game.V_WIDTH);

	public final Sprite sprite;

    protected SpriteActor(Sprite sprite) {
        this(sprite, 3);
    }

    protected SpriteActor(Sprite sprite, float scale) {
		this.sprite = sprite;
		this.sprite.setOriginCenter();
		this.sprite.setScale(scale, scale);
		setBounds(
            getX(), getY(), 
            this.sprite.getWidth() * scale, this.sprite.getHeight() * scale);
    }

	@Override
    protected void positionChanged() {
		//if you override this method, without the code below. The sprite may not be rendered correctly
        sprite.setX(getX(Align.center) - sprite.getWidth()/2);
		sprite.setY(getY(Align.center) - sprite.getHeight()/2);
        super.positionChanged();
    }

    @Override
	public void draw(Batch batch, float parentAlpha) {
		positionChanged();
		sprite.draw(batch);

        this.setRotation(parentAlpha);
	}

    @Override 
    public void setRotation(float degrees) {
        sprite.setRotation(180f);
    }

    public boolean isOnScreen() {
        return SCREEN_BOUNDS.overlaps(sprite.getBoundingRectangle());
    }

    public void clampToScreen() {
        clampToBounds(SCREEN_BOUNDS);
    }

    public void clampToBounds(Rectangle bounds) {
        if (getX() < bounds.x)
            setX(bounds.x);
        else if (getX() + getWidth() > bounds.x + bounds.width)
            setX(bounds.x + bounds.width - getWidth());

        if (getY() < bounds.y)
            setY(bounds.y);
        else if (getY() + getHeight() > bounds.y + bounds.height)
            setY(bounds.y + bounds.height - getHeight());
    }

    public Rectangle getBoundingRectangle() {
        return sprite.getBoundingRectangle();
    }

    /** 
     * Sets the rotation of the sprite to downward, used for enemy objects
     */
    public void setEnemyRotation(){
        sprite.setRotation(180f);
    }
}