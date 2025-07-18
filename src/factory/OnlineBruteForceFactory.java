package factory;

import cracker.BruteForceCracker;
import cracker.Cracker;
import target.OnlineTarget;

public class OnlineBruteForceFactory extends CrackerFactory {
    @Override
    public Cracker createCracker() {
        return new BruteForceCracker(new OnlineTarget("http://localhost/login.php"), 5);
    }
}
