package sample;

import com.sun.tools.javac.util.Name;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.json.JSONArray;
import org.json.JSONObject;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;


public class TableBuilder {

    private HashMap<Integer, TableColumn> columnList = new HashMap<>();

    public Object[] buildTable(String tableName, int columns){
        JSONArray colArray = parseTable(tableName);
        for(int i = 0; i < columns; i++){
            columnList.put  (colArray.getJSONObject(i).getInt("ID"),
                            new TableColumn(colArray.getJSONObject(i).getString("Title")));
        }
        return columnList.values().toArray();
    }

    private JSONArray parseTable(String tableName){
        try {
            String json = readFile("src/sample/tables/json/" + tableName + ".json", StandardCharsets.UTF_8);
            JSONObject obj = new JSONObject(json);
            return obj.getJSONArray("columns");
        } catch(IOException ex){
            ex.printStackTrace();
            return null;
        }
    }

    private static String readFile(String path, Charset encoding) throws IOException
    {
        byte[] encoded = Files.readAllBytes(Paths.get(path));
        return new String(encoded, encoding);
    }

}
