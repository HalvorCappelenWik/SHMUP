package inf112.shmup.core.powerups;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.Player;
import inf112.shmup.core.ships.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ShipUpgradeTest extends GameTestBase {
    
	/**
	 * Tests that when a ship of type other than Gunship is upgraded to a ship of type Gunship it is at level 1
	 */
    @Test
    public void should_upgrade_gunship_from_other_to_1() {
        setShip(new Racer1());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship1.class);
    }
    
    /**
     * Tests that when a ship is upgraded from type gunship, level 1, to type gunship it is at level 2 as ship type gunship
     */
    @Test
    public void should_upgrade_gunship_from_1_to_2() {
        setShip(new Gunship1());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship2.class);
    }
    
    /**
     * Tests that when a ship of type gunship, level 2, and upgraded to the same type, it is level 3 type gunship.
     */
    @Test
    public void should_upgrade_gunship_from_2_to_3() {
        setShip(new Gunship2());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship3.class);
    }
    
    /**
     * Tests that when a ship is at gunship level 3 it does not change when upgraded to the same type
     */
    @Test
    public void should_not_upgrade_gunship_from_3() {
        setShip(new Gunship3());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship3.class);
    }

    /**
     * Tests that when ship of type other than tank and upgraded to tank it is at level 1
     */
    @Test
    public void should_upgrade_tank_from_other_to_1() {
        setShip(new Gunship1());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank1.class);
    }

    /**
     * Tests that if a tank of level 1 is upgraded to a tank, it is upgraded to level 2
     */
    @Test
    public void should_upgrade_tank_from_1_to_2() {
        setShip(new Tank1());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank2.class);
    }

    /**
     * Tests that if a tank of level 2 is upgraded to a tank, it is upgraded to level 3
     */
    @Test
    public void should_upgrade_tank_from_2_to_3() {
        setShip(new Tank2());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank3.class);
    }

    /**
     * Tests that if a tank of level 3 is upgraded to a tank, it is still level 3
     */
    @Test
    public void should_not_upgrade_tank_from_3() {
        setShip(new Tank3());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank3.class);
    }
    
    private void setShip(Ship ship) {
        new Player(0, 0).setShip(ship);
    }

    private void upgrade(String type) {
        new ShipUpgrade(0, 0, type).activate();
    }

    private void assertShipType(Class<?> type) {
        assertInstanceOf(type, Player.getInstance().getShip());
    }

    /**
     * Tests that when ship of type other than Rocketeer and upgraded to Rocketeer it is at level 1
     */
    @Test
    public void should_upgrade_rocketeer_from_other_to_1() {
        setShip(new Gunship1());
        upgrade(ShipUpgrade.ROCKET_TYPE);
        assertShipType(Rocketeer1.class);
    }
    
    /**
     * Tests that if a Rocketeer of level 1 is upgraded to a Rocketeer, it is upgraded to level 2
     */
    @Test
    public void should_upgrade_rocketeer_from_1_to_2() {
        setShip(new Rocketeer1());
        upgrade(ShipUpgrade.ROCKET_TYPE);
        assertShipType(Rocketeer2.class);
    }

    /**
     * Tests that if a Rocketeer of level 2 is upgraded to a Rocketeer, it is upgraded to level 3
     */
    @Test
    public void should_upgrade_rocketeer_from_2_to_3() {
        setShip(new Rocketeer2());
        upgrade(ShipUpgrade.ROCKET_TYPE);
        assertShipType(Rocketeer3.class);
    }
    
    /**
     * Tests that if a Rocketeer of level 3 is upgraded to a Rocketeer, it is still level 3
     */
    @Test
    public void should_not_upgrade_rocketeer_from_3() {
        setShip(new Rocketeer3());
        upgrade(ShipUpgrade.ROCKET_TYPE);
        assertShipType(Rocketeer3.class);
    }

    /**
     * Tests that when ship of type other than Racer and upgraded to Racer it is at level 1
     */
    @Test
    public void should_upgrade_racer_from_other_to_1() {
        setShip(new Gunship1());
        upgrade(ShipUpgrade.RACER_TYPE);
        assertShipType(Racer1.class);
    }

    /**
     * Tests that if a Racer of level 1 is upgraded to a Racer, it is upgraded to level 2
     */
    @Test
    public void should_upgrade_racer_from_1_to_2() {
        setShip(new Racer1());
        upgrade(ShipUpgrade.RACER_TYPE);
        assertShipType(Racer2.class);
    }

    /**
     * Tests that if a Racer of level 2 is upgraded to a Racer, it is upgraded to level 3
     */
    @Test
    public void should_upgrade_racer_from_2_to_3() {
        setShip(new Racer2());
        upgrade(ShipUpgrade.RACER_TYPE);
        assertShipType(Racer3.class);
    }

    /**
     * Tests that if a Racer of level 3 is upgraded to a Racer, it is still level 3
     */
    @Test
    public void should_not_upgrade_racer_from_3() {
        setShip(new Racer3());
        upgrade(ShipUpgrade.RACER_TYPE);
        assertShipType(Racer3.class);
    }
}
