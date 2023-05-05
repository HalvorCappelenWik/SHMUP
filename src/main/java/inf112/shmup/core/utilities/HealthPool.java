package inf112.shmup.core.utilities;

public class HealthPool {

    private int _max;
    private int _current;

    /**
     * Constructor for the HealthPool class.
     * @param max The max amount of health
     */
    public HealthPool(int max) {
        _current = _max = max;
    }

    /** Returns the maximum amount of health */
    public int getMax() {
        return _max;
    }

    /** Returns the current amount of health */
    public int getCurrent() {
        return _current;
    }

    /** Returns true if current health is zero, false otherwise */
    public boolean isDead() {
        return _current == 0;
    }

    /**
     * The health pool takes damage.
     * @param damage The damage dealt to the health pool
     */
    public void takeDamage(int damage) {
        _current -= damage;

        if (_current < 0)
            _current = 0;

        if (_current > _max)
            _current = _max;
    }

}