package Transform.DataClass.MadaReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashMap;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdaReports {
    private ArrayList<MdaReport> mdaReports = new ArrayList<>();

    public static MdaReports parseMdaReports(ArrayList<HashMap<String, String>> reports){
        MdaReports mdaReports = new MdaReports();
        for(HashMap<String, String> report: reports){
            mdaReports.addMdaReport(new MdaReport(report));
        }
        return mdaReports;
    }

    public void addMdaReport(MdaReport mdaReport){
        this.mdaReports.add(mdaReport);
    }
}
