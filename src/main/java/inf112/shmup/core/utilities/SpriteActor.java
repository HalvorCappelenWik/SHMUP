package inf112.shmup.core.utilities;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.Game;

public abstract class SpriteActor extends Actor {
    private static final float SCALE_NORMALIZING = 3;
    protected static final Rectangle SCREEN_BOUNDS = new Rectangle(0,0, Game.V_WIDTH, Game.V_WIDTH);

	public final Sprite sprite;
    private float _collisionScaleX;
    private float _collisionScaleY;

    /**
     * Create a new SpriteActor
     * @param sprite
     */
    protected SpriteActor(Sprite sprite) {
        this.sprite = sprite;
        if (this.sprite != null)
		    this.sprite.setOriginCenter();

        this.setScale(_collisionScaleX, _collisionScaleY);

        this.setScale(1.0f);
        this.setCollisionScale(1.0f);
    }

    public void setCollisionScale(float scaleXY) {
        this.setCollisionScale(scaleXY, scaleXY);
    }

    /**
     * Set hitbox scale relative to sprite border
     * @param scaleX  scale of collision for x
     * @param scaleY  scale of collision for y
     */
    public void setCollisionScale(float scaleX, float scaleY) {
        this._collisionScaleX = scaleX;
        this._collisionScaleY = scaleY;
    }

    /**
     * Sets scale of sprite of x and y to param
     * @param scaleXY  the scale to set x and y
     */
    @Override
    public void setScale(float scaleXY) {
        this.setScale(scaleXY, scaleXY);
    }

    /**
     * Sets the scale of sprite for x and y seperate, scales are normalized
     * 
     * @param scaleX  The scale to set x
     * @param scaleY  The scale to set y
     */
    @Override
    public void setScale(float scaleX, float scaleY) {
        scaleX *= SCALE_NORMALIZING;
        scaleY *= SCALE_NORMALIZING;

        if (this.sprite == null)
            return;

		this.sprite.setScale(scaleX, scaleY);
        setBounds(
            getX(), getY(), 
            this.sprite.getWidth() * scaleX, this.sprite.getHeight() * scaleY);
    }

    /**
     * Method that is called when an actors position is changed
     * Updates the position of the sprite
     */
	@Override
    protected void positionChanged() {
        if (this.sprite == null)
            return;

		// If you override this method, without the code below. The sprite may not be rendered correctly
        sprite.setX(getX(Align.center) - sprite.getWidth() / 2);
		sprite.setY(getY(Align.center) - sprite.getHeight() / 2);
        super.positionChanged();
    }


    @Override
	public void draw(Batch batch, float parentAlpha) {
		positionChanged();

        if (sprite != null)
		    sprite.draw(batch);

        if (Game.DEBUG_ENABLED)
            DrawShape.rectangle(batch, Color.BLUE, getCollisionBox());
	}

    /**
     * Sets the rotation of the sprite to the given degrees, 0 is upwards
     * @param degrees  amount of degrees to rotate
     */
    @Override 
    public void setRotation(float degrees) {
        super.setRotation(-degrees);
        if (sprite != null)
            sprite.setRotation(degrees);
    }

    /**
     * returns if actor is within screen bounds
     * @return
     */
    public boolean isOnScreen() {
        return SCREEN_BOUNDS.overlaps(getCollisionBox());
    }

    /**
     * Clamps the actor to the screen bounds
     */
    public void clampToScreen() {
        clampToBounds(SCREEN_BOUNDS);
    }

    /**
     * Clams actor position to the bounds given
     * @param bounds  bound to clamp actor to
     */
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

    /**
     * Gets the bounding rectangle used for collisions.
     */
    public Rectangle getCollisionBox() {

        if (sprite == null)
            return new Rectangle(getX(), getY(), 10, 10);

        Rectangle spriteBox = sprite.getBoundingRectangle();

        float width = spriteBox.width * _collisionScaleX;
        float height = spriteBox.height * _collisionScaleY;

        float x = spriteBox.x + (spriteBox.width - width) * 0.5f;
        float y = spriteBox.y + (spriteBox.height - height) * 0.5f;

        return new Rectangle(x, y, width, height);
    }

    /** 
     * Sets the rotation of the sprite to downward, used for enemy objects
     */
    public void setRotationDownwards(){
        setRotation(180f);
    }

}