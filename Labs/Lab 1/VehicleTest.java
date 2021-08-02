import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VehicleTest {
    @Test
    void testFinalize() {
        Vehicle vehicle = new Vehicle();
        vehicle.finalize();
        assertEquals(0, vehicle.totalVehicle());
    }

    @Test
    void setSpeed() {
        Vehicle vehicle = new Vehicle(20, "south");
        vehicle.setSpeed(50);
        assertEquals(50, vehicle.getSpeed());
        vehicle.finalize();
    }

    @Test
    void setDir() {
        Vehicle vehicle = new Vehicle(20, "south");
        vehicle.setDir("west");
        assertEquals("west", vehicle.getDir());
        vehicle.finalize();
    }

    @Test
    void getSpeed() {
        Vehicle vehicle = new Vehicle();
        assertEquals(0, vehicle.getSpeed());
        vehicle.finalize();
    }

    @Test
    void getDir() {
        Vehicle vehicle = new Vehicle();
        assertEquals("north", vehicle.getDir());
        vehicle.finalize();
    }

    @Test
    void totalVehicle() {
        Vehicle vehicle = new Vehicle();
        assertEquals(1, vehicle.totalVehicle());
        vehicle.finalize();
    }
}