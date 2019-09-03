package ivan.samoylov;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.*;

public class Main {

    public static void main(String[] args) {
        final String FILE = "sample.json";
        BufferedReader reader = null;
        String strTemp;
        String textJson = "";

        try{
            reader = new BufferedReader(new FileReader(FILE));
            while((strTemp = reader.readLine()) != null){
                  textJson += strTemp;
                }
            }
        catch(Exception error){
            System.out.println(error.getMessage());
        }

        JsonObject convertedObject = new Gson().fromJson(textJson, JsonObject.class);
        System.out.println(convertedObject.get("name").getAsString());
        for (JsonElement obj: convertedObject.get("persons").getAsJsonArray()) {
            System.out.print(obj.getAsJsonObject().get("name").getAsString());
            System.out.println(" - " + obj.getAsJsonObject().get("age").getAsString());
        }
    }
}
