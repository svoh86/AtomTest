package ru.home.webservice.serice;

import javax.net.ssl.HttpsURLConnection;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Svistunov Mikhail
 * @version 1.0
 */
public class IsDayOffService implements ExternalService {
    public String getContent(String... args) throws IOException {
        String url = String.format("https://isdayoff.ru/api/getdata?year=%s&month=%s", args[0], args[1]);
        HttpsURLConnection connection = null;
        try {
            connection = (HttpsURLConnection) new URL(url).openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            try (BufferedReader reader =
                         new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                StringBuilder buf = new StringBuilder();
                String line;
                while ((line = reader.readLine()) != null) {
                    buf.append(line).append("\n");
                }
                return buf.toString();
            }
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }
}
