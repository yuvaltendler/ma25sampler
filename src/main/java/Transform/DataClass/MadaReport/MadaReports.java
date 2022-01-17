package Transform.DataClass.MadaReport;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MadaReports {
    private ArrayList<MadaReport> madaReports = new ArrayList<>();

    public void addMadaReport(MadaReport madaReport){
        this.madaReports.add(madaReport);
    }
}
