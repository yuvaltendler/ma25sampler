package Transform.DataClass.MadaReport;

import Transform.DataClass.DataClass;
import Transform.DataClass.DataClassContainer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdaReports implements DataClass, DataClassContainer {
    private ArrayList<MdaReport> mdaReports = new ArrayList<>();

    public static MdaReports parseMdaReports(ArrayList<HashMap<String, String>> reports){
        MdaReports mdaReports = new MdaReports();
        for(HashMap<String, String> report: reports){
            mdaReports.addToList(new MdaReport(report));
        }
        return mdaReports;
    }

    @Override
    public ArrayList getDataClassList() {
        return this.mdaReports;
    }

    @Override
    public void addToList(DataClass dataClass) {
        this.mdaReports.add((MdaReport) dataClass);
    }

    @Override
    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        JSONArray jsonArray = new JSONArray();
        for(MdaReport dataClass: this.mdaReports){
            JSONObject dataClassObject = new JSONObject(dataClass.toJson());
            jsonArray.put(dataClassObject);
        }
        jsonObject.put("mdaReports", jsonArray);
        return jsonObject.toString();
    }
}
