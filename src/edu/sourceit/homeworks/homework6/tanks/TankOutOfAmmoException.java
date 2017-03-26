package edu.sourceit.homeworks.homework6.tanks;

public class TankOutOfAmmoException extends Exception {
    public TankOutOfAmmoException() {
    }

    public TankOutOfAmmoException(String message) {
        super(message);
    }
}

