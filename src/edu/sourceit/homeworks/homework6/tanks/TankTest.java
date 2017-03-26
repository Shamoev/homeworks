package edu.sourceit.homeworks.homework6.tanks;

public class TankTest {
    public static void main(String[] args) {
        Tank tank = new Tank(2);
        try {
            tank.fire();
        } catch (GunNoShellInGunException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }

        try {
            tank.load();
        } catch (GunAlreadyLoadedException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }

        try {
            tank.load();
        } catch (GunAlreadyLoadedException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }

        try {
            tank.fire();
        } catch (GunNoShellInGunException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }

        try {
            tank.fire();
        } catch (GunNoShellInGunException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }

        try {
            tank.load();
        } catch (GunAlreadyLoadedException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());

        }
        try {
            tank.fire();
        } catch (GunNoShellInGunException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }

        try {
            tank.load();
        } catch (GunAlreadyLoadedException | TankOutOfAmmoException e) {
            System.out.println("Failed because: " + e.getMessage());
        }
    }
}
