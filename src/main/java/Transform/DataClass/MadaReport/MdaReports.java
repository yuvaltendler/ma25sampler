package Transform.DataClass.MadaReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MdaReports {
    private ArrayList<MdaReport> mdaReports = new ArrayList<>();

    public void addMdaReport(MdaReport mdaReport){
        this.mdaReports.add(mdaReport);
    }
}
