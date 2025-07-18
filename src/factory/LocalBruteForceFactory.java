package factory;

import cracker.BruteForceCracker;
import cracker.Cracker;
import target.LocalTarget;

public class LocalBruteForceFactory extends CrackerFactory {
    @Override
    public Cracker createCracker() {
        return new BruteForceCracker(new LocalTarget(), 5);
    }
}