package StarTrek;

import Untouchables.WebGadget;

import java.util.Random;

public class Game {

	private int e = 10000;
	private int t = 8;

    public int EnergyRemaining() {
        return e;
    }

    public void setTorpedoes(int value) {
            t = value;
        }
    public int getTorpedoes() {
            return t;
        
    }

    public void fireWeapon(WebGadget wg) {
        fireWeapon(new Galaxy(wg));
    }

    public void fireWeapon(Galaxy wg) {
        String command = wg.parameter("command");
        if (command.equals("phaser")) {
            fireWeaponPhaser(wg);

		} else if (command.equals("photon")) {
            fireWeaponPhoton(wg);
		}
	}

    private void fireWeaponPhoton(Galaxy wg) {
        Klingon enemy = (Klingon) wg.variable("target");
        if (t  > 0) {
            int distance = enemy.distance();
            if ((rnd(4) + ((distance / 500) + 1) > 7)) {
                wg.writeLine("Torpedo missed Klingon at " + distance + " sectors...");
            } else {
                int damage = 800 + rnd(50);
                wg.writeLine("Photons hit Klingon at " + distance + " sectors with " + damage + " units");
                if (damage < enemy.getEnergy()) {
                    enemy.setEnergy(enemy.getEnergy() - damage);
                    wg.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
                } else {
                    wg.writeLine("Klingon destroyed!");
                    enemy.delete();
                }
            }
            t -= 1;

        } else {
            wg.writeLine("No more photon torpedoes!");
        }
    }

    private void fireWeaponPhaser(Galaxy wg) {
        int amount = Integer.parseInt(wg.parameter("amount"));
        Klingon enemy = (Klingon) wg.variable("target");
        if (e >= amount) {
            int distance = enemy.distance();
            if (distance > 4000) {
                wg.writeLine("Klingon out of range of phasers at " + distance + " sectors...");
            } else {
                int damage = amount - (((amount /20)* distance /200) + rnd(200));
                if (damage < 1)
                    damage = 1;
                wg.writeLine("Phasers hit Klingon at " + distance + " sectors with " + damage + " units");
                if (damage < enemy.getEnergy()) {
                    enemy.setEnergy(enemy.getEnergy() - damage);
                    wg.writeLine("Klingon has " + enemy.getEnergy() + " remaining");
                } else {
                    wg.writeLine("Klingon destroyed!");
                    enemy.delete();
                }
            }
            e -= amount;

        } else {
            wg.writeLine("Insufficient energy to fire phasers!");
        }
    }

    // note we made generator public in order to mock it
    // it's ugly, but it's telling us something about our *design!* ;-)
	public static Random generator = new Random();
	private static int rnd(int maximum) {
		return generator.nextInt(maximum);
	}


}
