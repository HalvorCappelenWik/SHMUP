package inf112.shmup.core.ui;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.utils.Align;

import inf112.shmup.core.utilities.Assets;

public abstract class DrawableActor extends Actor{
    
    

    //defult sprite - missing
    Sprite sprite = Assets.sprite("no_sprite.png");

    static final float defaultScale = 3;

	

// ----------------------- Sprite assignment methods -------------------------

    /**
     * Sets the sprite of the current actor with correct orgin and bounds.
     * Only using a file path. Default scale
     * @param file_location location of image file
     */
    public void setSprite(String file_location) {
        setSprite(new Sprite(new Texture(new FileHandle(file_location))));
    }
    /**
     * Sets the sprite of the current actor with correct orgin and bounds.
     * Using a sprite object
     * @param sprite sprite object to assign
     */
    public void setSprite(Sprite sprite) {
        setSpriteScaled(sprite, defaultScale);
    }

	/**
     * Sets the sprite of the current actor with correct orgin and bounds.
     * Using a file path. Custom scale
     * @param file_location location location of image file
	 * @param scale scale to render sprite in
     */
	public void setSpriteScaled(String file_location, float scale){
		Sprite s = new Sprite(new Texture(new FileHandle(file_location)));
		setSpriteScaled(s , scale);
	}

    /**
     * Sets the sprite of the current actor with correct orgin and bounds.
     * Using a sprite object
     * @param new_sprite sprite object to assign
	 * @param scale scale to render sprite in
     */
    public void setSpriteScaled(Sprite new_sprite, float scale){
		
		sprite = new_sprite;
		sprite.setOriginCenter();
		sprite.setScale(scale, scale);
		setBounds(getX(), getY(), sprite.getWidth() * scale, sprite.getHeight() * scale);

		positionChanged(); //as to not draw the sprite in an inapropreate location
    }

// --------------------- override actor method --------------------

	@Override
    protected void positionChanged() {
		//if you override this method, without the code below. The sprite may not be rendered correctly
        sprite.setX(getX(Align.center) - sprite.getWidth()/2);
		sprite.setY(getY(Align.center) - sprite.getHeight()/2);
        super.positionChanged();
    }

// --------------------------- Uility -----------------------------

    /**
     * @return current sprite
     */
    public Sprite getSprite() {
		return sprite;
	}

    /** 
     * Sets the rotation of the sprite to downward, used for enemy objects
     */
    public void setEnemyRotation(Sprite sprite){
        sprite.setRotation(180f);
    }
}
