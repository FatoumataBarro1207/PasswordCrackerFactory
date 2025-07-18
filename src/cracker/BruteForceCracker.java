package cracker;

import target.Target;

public class BruteForceCracker implements Cracker {
    private Target target;
    private int maxLength;
    private static final char[] ALPHABET = "abcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    public BruteForceCracker(Target target, int maxLength) {
        this.target = target;
        this.maxLength = maxLength;
    }

    @Override
    public void crack(String login) {
        crackRecursive(login, "", 0);
    }

    private void crackRecursive(String login, String current, int depth) {
        if (depth > maxLength) return;

        if (!current.isEmpty() && target.authenticate(login, current)) {
            System.out.println("[SUCCESS] Mot de passe trouvé : " + current);
            System.exit(0);
        }

        for (char c : ALPHABET) {
            crackRecursive(login, current + c, depth + 1);
        }
    }
}