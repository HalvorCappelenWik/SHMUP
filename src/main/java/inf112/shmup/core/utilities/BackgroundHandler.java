package inf112.shmup.core.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.Viewport;

public class BackgroundHandler {
    
    // Background variables
	private static int bgOffset = 0;
	private float bgScale = 2;
    private int bgSpeed = -250;
    private float width;
    private float height;
    private Viewport viewport;

	// Background texture
	Sprite bg;

    /**
     *
     * @param texture_file
     * @param viewport
     */
    public BackgroundHandler(String texture_file, Viewport viewport){
        bg = AssetManager.sprite(texture_file);
        bg.setScale(bgScale);
        bg.setOriginCenter();

        this.viewport = viewport;

        width = bg.getWidth() * bgScale;
        height = bg.getHeight() * bgScale;
    }

    /**
     *
     * @param delta
     */
    public void render(float delta) {
        
		SpriteBatch batch = new SpriteBatch();
        
        batch.setProjectionMatrix(viewport.getCamera().combined);

		batch.begin();
		renderSingle(batch, 0, bgOffset);
        renderSingle(batch, 0, bgOffset + height);
        batch.end();
		
		// Increment background offset
		bgOffset += bgSpeed * delta;

		if (bgOffset > height) {
			bgOffset -= height;
		}

        if (bgOffset < -height) {
			bgOffset += height;
		}
    }

    /**
     *
     * @param scale
     */
    public void setScale(float scale) {
    	this.bgScale = scale;
    	bg.setScale(bgScale);
        width = bg.getWidth() * bgScale;
        height = bg.getHeight() * bgScale;
    }

    /**
     *
     * @return
     */
    public float getScale() {
    	return bgScale;
    }

    private void renderSingle(SpriteBatch batch, float x, float y){
        bg.setCenterX(x + width/2);
        bg.setCenterY(y + height/2);
        bg.draw(batch);
    }

}