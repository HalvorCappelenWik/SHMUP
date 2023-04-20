package inf112.shmup.core.enemies;


import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;

public class Zig1 extends EnemyShip{
	private int _dir = 1;
	private float _angle = 260f;

	public Zig1(float x, float y) {
		super(x, y, AssetManager.sprite("ships/ship_9.png"), Integer.MAX_VALUE);
		
		float speed = 150f;
		setSpeedX((float)Math.sin(Math.toRadians(_angle)) * speed * -1);
		setSpeedY((float)Math.cos(Math.toRadians(_angle)) * speed);
		setRotation(_angle);
	}

	@Override
	protected void onHealed() {

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
		super.act(delta);
		
		moveBy(getSpeedX() * delta * _dir, getSpeedY() * delta);
		
		if (getX() < 0) {
            _dir = 1;
            setRotation(_angle);
        } else if (getX() + getWidth() > Game.V_WIDTH) {
            _dir = -1;
            setRotation(-_angle);
        }
        
        if(getY() <= 0) remove();
	}
	
	

}
