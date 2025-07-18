package cracker;

import target.Target;
import java.io.*;

public class DictionaryCracker implements Cracker {
    private Target target;
    private String dictionaryPath;

    public DictionaryCracker(Target target, String dictionaryPath) {
        this.target = target;
        this.dictionaryPath = dictionaryPath;
    }

    @Override
    public void crack(String login) {
        try (BufferedReader reader = new BufferedReader(new FileReader(dictionaryPath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (target.authenticate(login, line)) {
                    System.out.println("[SUCCESS] Mot de passe trouvé : " + line);
                    return;
                }
            }
            System.out.println("Mot de passe non trouvé dans le dictionnaire.");
        } catch (IOException e) {
            System.err.println("Erreur de lecture du fichier dictionnaire : " + e.getMessage());
        }
    }
}