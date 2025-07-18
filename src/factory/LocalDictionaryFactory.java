package factory;

import cracker.Cracker;
import cracker.DictionaryCracker;
import target.LocalTarget;

public class LocalDictionaryFactory extends CrackerFactory {
    @Override
    public Cracker createCracker() {
        return new DictionaryCracker(new LocalTarget(), "dico.txt");
    }
}
