package inf112.shmup.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import inf112.shmup.app.ShmupGame;

public class BackgroundHandler{
    
    //background variables
	private int bgOffset = 0;
	private int bgScale = 2;
    private int bgSpeed = -250;

	//background texture
	Texture bg;


    public BackgroundHandler(String texture_file){
        bg = new Texture(Gdx.files.internal(texture_file));
    }


    public void render(float delta){
        
		SpriteBatch batch = new SpriteBatch();
	
		batch.begin();
		renderSingle(batch, 0, bgOffset);
        renderSingle(batch, 0, bgOffset + (bg.getHeight() * bgScale));
		batch.end();

		//increment background offset
		bgOffset += bgSpeed*delta;

		if(bgOffset > bg.getHeight() * bgScale){
			bgOffset -= bg.getHeight() * bgScale;
		}

        if(bgOffset < -bg.getHeight() * bgScale){
			bgOffset += bg.getHeight() * bgScale;
		}
    }


    private void renderSingle(SpriteBatch batch, int x, int y){
        batch.draw(bg, x, y, bg.getWidth() * bgScale, bg.getHeight() * bgScale);
    }

	
}


