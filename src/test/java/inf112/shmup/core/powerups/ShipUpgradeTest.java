package inf112.shmup.core.powerups;

import static org.junit.jupiter.api.Assertions.assertInstanceOf;

import org.junit.jupiter.api.Test;

import inf112.shmup.core.GameTestBase;
import inf112.shmup.core.Player;
import inf112.shmup.core.ships.*;

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
    
    private void setShip(Ship ship) {
        new Player(0, 0).setShip(ship);
    }

    private void upgrade(String type) {
        new ShipUpgrade(0, 0, type).activate();
    }

    private void assertShipType(Class<?> type) {
        assertInstanceOf(type, Player.getInstance().getShip());
    }
}
