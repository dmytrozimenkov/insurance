package sample;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;


public class TableBuilder {
    public static void main(String[] args) {

    }

    public void parseTable(String filePath){
        try {
            String json = readFile(filePath, StandardCharsets.UTF_8);
            JSONObject obj = new JSONObject(json);
            JSONArray arr = obj.getJSONArray("columns");
            for(int i = 0; i < arr.length(); i++){
                System.out.println( arr.getJSONObject(i).getInt     ("ID")
                        + "\t" +    arr.getJSONObject(i).getString  ("Name")
                        + "\t" +    arr.getJSONObject(i).getString  ("Title"));
            }
        } catch(IOException ex){
            ex.printStackTrace();
        }
    }

    private static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
