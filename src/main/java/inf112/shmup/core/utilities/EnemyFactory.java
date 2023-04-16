package inf112.shmup.core.utilities;

import java.util.ArrayList;
import java.util.List;

import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.utils.JsonReader;
import com.badlogic.gdx.utils.JsonValue;
import com.badlogic.gdx.utils.JsonValue.JsonIterator;

import inf112.shmup.core.Game;
import inf112.shmup.core.enemies.Enemy;

public class EnemyFactory {
	private final int _waveCount;
	private final JsonValue _waves;
	private final JsonReader _json;
	
	/**
	 * Takes in file path for level file
	 * Then reads json and setups so that getWave will return a list of enemies for that wave
	 * @param file the path to level json file
	 */
	public EnemyFactory(String file) {
		_json = new JsonReader();
		_waveCount = _json.parse(new FileHandle(file)).getInt("waves");
		_waves = _json.parse(new FileHandle(file)).get("waveSetups");
	}
	
	/**
	 * Get the list of enemies for that wave
	 * Throws {@link IndexOutOfBoundsException} if wave is bigger than amount of waves or less than 0
	 * @param wave the index of wave
	 * @return the list of enemies for that wave
	 */
	public List<Enemy> createWave(int wave){
		if (wave < 0)
			wave = -wave;

		wave = wave % _waveCount;

		List<Enemy> enemies = new ArrayList<>();
		
		JsonValue levelInfo = _waves.get(wave);
		int rows = levelInfo.getInt("rows");
		int cols = levelInfo.getInt("cols");
		JsonIterator enemyPositions = levelInfo.get("enemyPositions").iterator();
		
		float colWidth = Game.V_WIDTH / cols;
		float rowHeight = (Game.V_HEIGHT/2) / rows;
		
		while(enemyPositions.hasNext()) {
			int[] pos = enemyPositions.next().asIntArray();
			int row = pos[0];
			int col = pos[1];
			float ypos = (Game.V_HEIGHT - (row*rowHeight));
			if(row == 0) {
				ypos = Game.V_HEIGHT - (row*rowHeight) - 100;
			}
			enemies.add(new Enemy(col*colWidth, ypos));
		}
		
		return enemies;
	}

}
