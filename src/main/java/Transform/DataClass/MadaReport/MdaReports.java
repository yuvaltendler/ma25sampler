package Transform.DataClass.MadaReport;

import Transform.DataClass.DataClass;
import Transform.DataClass.DataClassList;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdaReports implements DataClass, DataClassList {
    private ArrayList<MdaReport> mdaReports = new ArrayList<>();

    public static MdaReports parseMdaReports(ArrayList<HashMap<String, String>> reports){
        MdaReports mdaReports = new MdaReports();
        for(HashMap<String, String> report: reports){
            mdaReports.addToList(new MdaReport(report));
        }
        return mdaReports;
    }

    @Override
    public void addToList(DataClass dataClass) {
        this.mdaReports.add((MdaReport) dataClass);
    }

    @Override
    public String toJson() {
        return "";
    }
}
