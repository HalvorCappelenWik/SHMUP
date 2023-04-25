package inf112.shmup.core.powerups;

import inf112.shmup.core.Player;
import inf112.shmup.core.ships.*;
import inf112.shmup.core.ships.Ship;
import inf112.shmup.core.utilities.AssetManager;
import inf112.shmup.core.utilities.AudioPlayer;

public class ShipUpgrade extends PowerUp {
    public static final String GUNSHIP_TYPE = "blue";
    public static final String TANK_TYPE = "yellow";
    public static final String RACER_TYPE = "green";
    public static final String ROCKET_TYPE = "red";

    private final String _type;

    public ShipUpgrade(float x, float y, String type) {
        super(x, y, AssetManager.sprite("items/powerup_" + type + ".png"));
        _type = type;
    }

    @Override
    public void activate() {
        AudioPlayer.playEffect("powerup");
        System.out.println("Upgraded ship:" + _type);

        if (GUNSHIP_TYPE.equals(_type)) {
            upgradeGunship();
        }
        else if (TANK_TYPE.equals(_type)) {
            upgradeTank();
        }
        else if (RACER_TYPE.equals(_type)) {
            upgradeRacer();
        }
        else if (ROCKET_TYPE.equals(_type)) {
            upgradeRocketeer();
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

    private void upgradeTank() {
        if (currentShip() instanceof Tank1) {
            setShip(new Tank2());
        }
        else if (currentShip() instanceof Tank2) {
            setShip(new Tank3());
        }
        else if (currentShip() instanceof Tank3) {
            // The ship is upgraded to the maximum.
        }
        else {
            // The player had another ship-type.
            setShip(new Tank1());
        }
    }

    private void upgradeRacer() {
        if (currentShip() instanceof Racer1) {
            setShip(new Racer2());
        }
        else if (currentShip() instanceof Racer2) {
            setShip(new Racer3());
        }
        else if (currentShip() instanceof Racer3) {
            // The ship is upgraded to the maximum.
        }
        else {
            // The player had another ship-type.
            setShip(new Racer1());
        }
    }

    private void upgradeRocketeer() {
        if (currentShip() instanceof Rocketeer1) {
            setShip(new Rocketeer2());
        }
        else if (currentShip() instanceof Rocketeer2) {
            setShip(new Rocketeer3());
        }
        else if (currentShip() instanceof Rocketeer3) {
            // The ship is upgraded to the maximum.
        }
        else {
            // The player had another ship-type.
            setShip(new Rocketeer1());
        }
    }

    private static Ship currentShip() {
        return Player.getInstance().getShip();
    }

    private static void setShip(Ship ship) {
        Player.getInstance().setShip(ship);
    }

	@Override
	public void takeDamage(int damage) { }
}
