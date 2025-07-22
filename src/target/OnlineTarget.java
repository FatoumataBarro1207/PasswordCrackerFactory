package target;

import java.net.*;
import java.io.*;

public class OnlineTarget implements Target {
    private String url;

    public OnlineTarget(String url) {
        this.url = url;
    }

    @Override
    public boolean authenticate(String login, String password) {
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            String postParams = "login=" + URLEncoder.encode(login, "UTF-8") +
                                "&password=" + URLEncoder.encode(password, "UTF-8");
            OutputStream os = con.getOutputStream();
            os.write(postParams.getBytes());
            os.flush();
            os.close();

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();

            return response.toString().contains("Connexion reussie");

        } catch (Exception e) {
            System.err.println("Erreur de connexion : " + e.getMessage());
            return false;
        }
    }
}
