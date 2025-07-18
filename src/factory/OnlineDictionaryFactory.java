package factory;

import cracker.Cracker;
import cracker.DictionaryCracker;
import target.OnlineTarget;

public class OnlineDictionaryFactory extends CrackerFactory {
    @Override
    public Cracker createCracker() {
        return new DictionaryCracker(new OnlineTarget("http://localhost/login.php"), "dico.txt");
    }
}
