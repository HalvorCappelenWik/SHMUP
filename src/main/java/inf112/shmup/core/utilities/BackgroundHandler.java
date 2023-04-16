package inf112.shmup.core.utilities;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class BackgroundHandler{
    
    //background variables
	private int bgOffset = 0;
	private int bgScale = 2;
    private int bgSpeed = -250;
    private float width;
    private float height;

	//background texture
	Sprite bg;


    public BackgroundHandler(String texture_file){
        bg = new Sprite(new Texture(Gdx.files.internal(texture_file)));
        bg.setScale(bgScale);
        bg.setOriginCenter();

        width = bg.getWidth() * bgScale;
        height = bg.getHeight() * bgScale;
    }


    public void render(float delta){
        
		SpriteBatch batch = new SpriteBatch();
	
		batch.begin();
		renderSingle(batch, 0, bgOffset);
        renderSingle(batch, 0, bgOffset + height);
        batch.end();
		
		//increment background offset
		bgOffset += bgSpeed*delta;

		if(bgOffset > height){
			bgOffset -= height;
		}

        if(bgOffset < -height){
			bgOffset += height;
		}

        
    }


    private void renderSingle(SpriteBatch batch, float x, float y){
        bg.setCenterX(x + width/2);
        bg.setCenterY(y + height/2);
        bg.draw(batch);
    }

	
}


