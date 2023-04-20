package inf112.shmup.core.enemies;


import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;

public class Zig1 extends EnemyShip{

	public Zig1(float x, float y) {
		super(x, y, AssetManager.sprite("ships/ship_9.png"), Integer.MAX_VALUE);
		setSpeedX(100f);
		setSpeedY(-50f);
	}

	@Override
	protected void onHealed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void onDamaged() {
		
	}
	
	@Override
	protected void onDead() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		
		moveBy(getSpeedX() * delta, getSpeedY() * delta);
		
		if(getX() >= SCREEN_BOUNDS.width || getX() <= 0) {
			setSpeedX(-1 * getSpeedX());
			clampToBounds(SCREEN_BOUNDS);
		}
	}
	
	

}
