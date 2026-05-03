package Facade_API;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class ApiFacade {
    public String getAttributeValueFromJson(String urlString, String attributeName) throws IllegalAccessException, IOException {
       String json = sendHttpRequest(urlString);
       return extractAttributeValue(json, attributeName);
    }

    private String sendHttpRequest(String urlString) throws IOException {
        try{
            URL url = new URL(urlString);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(con.getInputStream()))) {
                String inputLine;

                StringBuilder content = new StringBuilder();
                while ((inputLine = reader.readLine()) != null) {
                    content.append(inputLine);
                }
                return content.toString();
            } finally {
                con.disconnect();
            }
        }catch (Exception e){
            throw new IOException("Failed to fetch data from API (Http request failed): " + e.getMessage(), e);
        }
    }
    private String extractAttributeValue(String json, String attributeName)
            throws IllegalArgumentException {

        try {
            JSONParser parser = new JSONParser();
            Object parsed = parser.parse(json);

            // Case 1: Top-level JSON object
            if (parsed instanceof JSONObject obj) {
                if (!obj.containsKey(attributeName)) {
                    throw new IllegalArgumentException("Attribute '" + attributeName + "' not found.");
                }
                return String.valueOf(obj.get(attributeName));
            }

            // Case 2: Top-level JSON array → search inside objects
            if (parsed instanceof org.json.simple.JSONArray arr) {
                for (Object element : arr) {
                    if (element instanceof JSONObject obj) {
                        if (obj.containsKey(attributeName)) {
                            return String.valueOf(obj.get(attributeName));
                        }
                    }
                }
                throw new IllegalArgumentException("Attribute '" + attributeName + "' not found in array.");
            }

            // Case 3: Top-level is a primitive (string, number, boolean)
            throw new IllegalArgumentException(
                    "JSON is not an object or array. Cannot extract attribute '" + attributeName + "'."
            );

        } catch (IllegalArgumentException e) {
            throw e;
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON parsing failed: " + e.getMessage());
        }
    }

}
