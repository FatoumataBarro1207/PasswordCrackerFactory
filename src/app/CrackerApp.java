package app;

import cracker.Cracker;
import factory.*;

public class CrackerApp {
    public static void main(String[] args) {
        if (args.length < 6) {
            System.out.println("Usage: java app.CrackerApp --type <dictionnary|bruteforce> --target <local|online> --login <login>");
            return;
        }

        String type = args[1];
        String target = args[3];
        String login = args[5];

        CrackerFactory factory = null;

        if (type.equals("dictionnary") && target.equals("local")) {
            factory = new LocalDictionaryFactory();
        } else if (type.equals("dictionnary") && target.equals("online")) {
            factory = new OnlineDictionaryFactory();
        } else if (type.equals("bruteforce") && target.equals("local")) {
            factory = new LocalBruteForceFactory();
        } else if (type.equals("bruteforce") && target.equals("online")) {
            factory = new OnlineBruteForceFactory();
        } else {
            System.out.println("Paramètres invalides.");
            return;
        }

        Cracker cracker = factory.createCracker();
        cracker.crack(login);
    }
}
