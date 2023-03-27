package inf112.shmup.view.actors;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;

public abstract class DrawableActor extends Actor{
    
    

    //defult sprite - missing
    Sprite sprite = new Sprite(new Texture(new FileHandle("src/assets/no_sprite.png")));

    float defaultScale = 3;
    
    /**
     * Sets the sprite of the current object with correct orgin.
     * Only using the file path
     * @param file_location location of image file
     */
    public void setSprite(String file_location) {
        setSprite(  new Sprite(new Texture(new FileHandle(file_location)))  );
    }

    /**
     * Sets the sprite of the current object with correct orgin.
     * Using a sprite object
     * @param new_sprite sprite object to assign
     */
    public void setSprite(Sprite new_sprite){
		
		sprite = new_sprite;
		sprite.setOriginCenter();
		sprite.setScale(defaultScale, defaultScale);
    }

    /**
	 * @return Total width with scale
	 */
	public float getTotalWidth(){
		return sprite.getWidth() * sprite.getScaleX();
	}

	/**
	 * @return Total height with scale
	 */
	public float getTotalHeight(){
		return sprite.getHeight() * sprite.getScaleY();
	}

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
