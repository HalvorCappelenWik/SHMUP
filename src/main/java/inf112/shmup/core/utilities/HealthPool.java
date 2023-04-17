package inf112.shmup.core.utilities;

public class HealthPool {
    private int _max;
    private int _current;

    public HealthPool(int max) {
        _current = _max = max;
    }

    public int getMax() {
        return _max;
    }

    public int getCurrent() {
        return _current;
    }

    public boolean isDead() {
        return _current == 0;
    }

    public void takeDamage(int damage) {
        _current -= damage;

        if (_current < 0)
            _current = 0;

        if (_current > _max)
            _current = _max;
    }
}