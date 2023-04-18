package inf112.shmup.core.powerups;

import inf112.shmup.core.Player;
import inf112.shmup.core.ships.Gunship1;
import inf112.shmup.core.ships.Gunship2;
import inf112.shmup.core.ships.Gunship3;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class ShipUpgrade extends PowerUp {
    public static final String GUNSHIP_TYPE = "blue";
    public static final String NOT_IN_USE_1_TYPE = "yellow";
    public static final String NOT_IN_USE_2_TYPE = "green";
    public static final String NOT_IN_USE_3_TYPE = "red";

    private final String _type;

    public ShipUpgrade(float x, float y, String type) {
        super(x, y, AssetManager.sprite("items/upgrade_" + type + ".png"));
        _type = type;
    }

    @Override
    public void takeDamage(int damage) {
        AudioPlayer.playEffect("powerup");
        System.out.println("Upgraded ship:" + _type);

        if (GUNSHIP_TYPE.equals(_type)) {
            upgradeGunship();
        }
        else if (NOT_IN_USE_1_TYPE.equals(_type)) {
            
        }
        else if (NOT_IN_USE_2_TYPE.equals(_type)) {
            
        }
        else if (NOT_IN_USE_3_TYPE.equals(_type)) {
            
        }
        else {
            System.out.println("Unknown ship upgrade: " + _type);
        }

        remove();
    }

    private void upgradeGunship() {
        if (currentShip() instanceof Gunship1) {
            setShip(new Gunship2());
        }
        else if (currentShip() instanceof Gunship2) {
            setShip(new Gunship3());
        }
        else if (currentShip() instanceof Gunship3) {
            // The ship is upgraded to the maximum.
        }
        else {
            // The player had another ship-type.
            setShip(new Gunship1());
        }
    }

    private static Ship currentShip() {
        return Player.getInstance().getShip();
    }

    private static void setShip(Ship ship) {
        Player.getInstance().setShip(ship);
    }
}
