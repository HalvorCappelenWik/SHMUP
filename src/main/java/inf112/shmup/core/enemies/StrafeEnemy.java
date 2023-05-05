package inf112.shmup.core.enemies;

import inf112.shmup.core.Game;
import inf112.shmup.core.utilities.AssetManager;

public class StrafeEnemy extends EnemyShip {

    private static final int MAX_HEALTH = 6;

    private float _speed = 130;
    private int _dir = 1;

    /**
     * The constructor for the StrafeEnemy class.
     * @param x The x-coordinate the StrafeEnemy plane starts at
     * @param y The y-coordinate the StrafeEnemy plane starts at
     */
    public StrafeEnemy(float x, float y){
        super(x, 
             (float) Math.random() * Game.V_HEIGHT * 0.4f + Game.V_HEIGHT * 0.25f,
             AssetManager.sprite("ships/ship_5.png"), MAX_HEALTH);


        if(x < Game.V_WIDTH/2){
            _dir = 1;
        }
        else{
            _dir = -1;
        }
        
        this.killPoints = 50;
        this.hasInvincibleIntro = false;
    }

    @Override
    public void act(float delta) {
        super.act(delta);
        if(getActions().size != 0) return;
        clampToScreen();

        moveBy(_dir * _speed * delta, 0);

        if (getX() < 0) {
            _dir = 1;
            setRotation(270);
        } else if (getX() + getWidth() > Game.V_WIDTH) {
            _dir = -1;
            setRotation(90);
        }

        if(_dir == 1){
            setRotation(270);
        }
        else if(_dir == -1){
            setRotation(90);
        }
    }

    @Override
    protected void onHealed() {}

    @Override
    protected void onDamaged() {}

}