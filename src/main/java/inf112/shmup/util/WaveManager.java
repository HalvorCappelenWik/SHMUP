package inf112.shmup.util;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonValue.JsonIterator;

import inf112.shmup.app.ShmupGame;
import inf112.shmup.view.actors.Enemy;

public class WaveManager {
	public int waveNums;
	JsonValue waves;
	JsonReader json;
	
	/**
	 * Takes in file path for level file
	 * Then reads json and setups so that getWave will return a list of enemies for that wave
	 * @param file the path to level json file
	 */
	public WaveManager(String file) {
		json = new JsonReader();
		waveNums = json.parse(new FileHandle(file)).getInt("waves");
		waves = json.parse(new FileHandle(file)).get("waveSetups");
	}
	
	/**
	 * Get the list of enemies for that wave
	 * Throws {@link IndexOutOfBoundsException} if wave is bigger than amount of waves or less than 0
	 * @param wave the index of wave
	 * @return the list of enemies for that wave
	 */
	public List<Enemy> getWave(int wave){
		if(wave >= waveNums || wave < 0) throw new IndexOutOfBoundsException();
		List<Enemy> enemies = new ArrayList<>();
		
		JsonValue levelInfo = waves.get(wave);
		int rows = levelInfo.getInt("rows");
		int cols = levelInfo.getInt("cols");
		JsonIterator enemyPositions = levelInfo.get("enemyPositions").iterator();
		
		float colWidth = ShmupGame.V_WIDTH / cols;
		float rowHeight = (ShmupGame.V_HEIGHT/2) / rows;
		
		while(enemyPositions.hasNext()) {
			int[] pos = enemyPositions.next().asIntArray();
			int row = pos[0];
			int col = pos[1];
			float ypos = (ShmupGame.V_HEIGHT - (row*rowHeight));
			if(row == 0) {
				ypos = ShmupGame.V_HEIGHT - (row*rowHeight) - 100;
			}
			enemies.add(new Enemy(col*colWidth, ypos));
		}
		
		return enemies;
	}

}