package Load.FileLoader;

import Transform.DataClass.DataClass;
import Transform.DataClass.DataClassContainer;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class JsonFileLoader implements FileLoader {
    @Override
    public void load(String path, int numOfRecords, DataClassContainer dataClassContainer) {
        ArrayList<JSONObject> jsonObjects = new ArrayList<>();
        for(Object object: dataClassContainer.getDataClassList()){
            DataClass dataClass = (DataClass) object;
            jsonObjects.add(new JSONObject(dataClass.toJson()));
        }
        List<List<JSONObject>> lists = FileLoader.chopped(jsonObjects, numOfRecords);
        System.out.println(lists);
        JSONObject res = new JSONObject();
        for(int i = 0; i < lists.size(); i++)
        {
            List<JSONObject> list = lists.get(i);
            JSONArray value = new JSONArray();
            for(JSONObject jsonObject: list){
                value.put(jsonObject);
            }
            res.put(dataClassContainer.getClass().getName(), value);
            String startPath = path.substring(0, path.length() - 5);
            String newPath = startPath + i + ".json";
            System.out.println(newPath);
            FileLoader.writeToFile(newPath, res.toString());
        }
    }
}
