package inf112.shmup.core.utilities;

import com.badlogic.gdx.utils.JsonValue;

import inf112.shmup.core.Game;
import inf112.shmup.core.enemies.EnemyFactory;

public class WaveFactory {
	private static final JsonValue _waves = Game.CONFIG.get("waves");
	private static final JsonValue _endgameWaves = Game.CONFIG.get("endgameWaves");
	private static String[] _wave = null;
	private static int _index = -1;

	public static void spawnNextWave() {
		loadNextWave();

		float gridWidth = Game.V_WIDTH / _wave.length;
		float gridOffset = gridWidth / 2;

		for (int i = 0; i < _wave.length; i++) {
			if (_wave[i] != null) {
				float x = gridOffset + gridWidth * i;
				EnemyFactory.spawnEnemy(x, Game.V_HEIGHT - 100, _wave[i]);
			}
		}
	}

	public static int getCurrentWave() {
		return _index;
	}

	public static void reset() {
		_index = -1;
	}

	private static void loadNextWave() {
		_index++;

		if (_index < _waves.size) {
			_wave = _waves.get(_index).asStringArray();
		}
		else {
			int index = (_index - _waves.size) % _endgameWaves.size;
			_wave = _endgameWaves.get(index).asStringArray();
		}
	}
}