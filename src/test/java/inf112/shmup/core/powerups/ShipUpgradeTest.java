package inf112.shmup.core.powerups;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.Player;
import inf112.shmup.core.ships.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

public class ShipUpgradeTest extends GameTestBase {
    
    @Test
    public void should_upgrade_gunship_from_other_to_1() {
        setShip(new Racer1());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship1.class);
    }
    
    @Test
    public void should_upgrade_gunship_from_1_to_2() {
        setShip(new Gunship1());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship2.class);
    }
    
    @Test
    public void should_upgrade_gunship_from_2_to_3() {
        setShip(new Gunship2());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship3.class);
    }
    
    @Test
    public void should_not_upgrade_gunship_from_3() {
        setShip(new Gunship3());
        upgrade(ShipUpgrade.GUNSHIP_TYPE);
        assertShipType(Gunship3.class);
    }

    @Test
    public void should_upgrade_tank_from_other_to_1() {
        setShip(new Gunship1());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank1.class);
    }

    @Test
    public void should_upgrade_tank_from_1_to_2() {
        setShip(new Tank1());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank2.class);
    }

    @Test
    public void should_upgrade_tank_from_2_to_3() {
        setShip(new Tank2());
        upgrade(ShipUpgrade.TANK_TYPE);
        assertShipType(Tank3.class);
    }

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

    @Test
public void should_upgrade_rocketeer_from_other_to_1() {
    setShip(new Gunship1());
    upgrade(ShipUpgrade.ROCKET_TYPE);
    assertShipType(Rocketeer1.class);
}
 
@Test
public void should_upgrade_rocketeer_from_1_to_2() {
    setShip(new Rocketeer1());
    upgrade(ShipUpgrade.ROCKET_TYPE);
    assertShipType(Rocketeer2.class);
}
    
@Test
public void should_upgrade_rocketeer_from_2_to_3() {
    setShip(new Rocketeer2());
    upgrade(ShipUpgrade.ROCKET_TYPE);
    assertShipType(Rocketeer3.class);
}
   
@Test
public void should_not_upgrade_rocketeer_from_3() {
    setShip(new Rocketeer3());
    upgrade(ShipUpgrade.ROCKET_TYPE);
    assertShipType(Rocketeer3.class);
}
}
