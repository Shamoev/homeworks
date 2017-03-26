package edu.sourceit.homeworks.homework6.tanks;


public class Tank {
    private Gun gun;
    private int shellsQuantity;

    public Tank(int shellsQuantity) {
        this.gun = new Gun();
        this.shellsQuantity = shellsQuantity;
    }

    public void fire() throws GunNoShellInGunException, TankOutOfAmmoException {
        gun.fire();
    }

    public void load() throws GunAlreadyLoadedException, TankOutOfAmmoException {
            gun.load();
    }

    public void reload(int shells) {
        shellsQuantity += shells;
    }

    public class Gun {
        private boolean loaded;

        public Gun() {
            this.loaded = false;
        }

        public boolean isLoaded() {
            return loaded;
        }


        // I added one more check because when you do setLoaded(false), you decrease shellsQuantity
        private void setLoaded(boolean loaded) throws TankOutOfAmmoException {
            if (!loaded) {
                this.loaded = loaded;
            } else if (shellsQuantity > 0) {
                this.loaded = loaded;
                shellsQuantity--;
            } else {
                throw new TankOutOfAmmoException("Out of ammo! Go to the base!!!");
            }
        }


        public void load() throws GunAlreadyLoadedException, TankOutOfAmmoException {
            if (!isLoaded()) {
                setLoaded(true);
            } else {
                throw new GunAlreadyLoadedException("Already loaded, can't load!");
            }
        }

        public void fire() throws GunNoShellInGunException, TankOutOfAmmoException {
            if (isLoaded()) {
                System.out.println("Fire!!!!");
                setLoaded(false);
            } else {
                throw new GunNoShellInGunException("Have no shell in gun, please load!!");
            }
        }
    }

}
