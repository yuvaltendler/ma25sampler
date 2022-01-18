package Transform.DataClass.Factory.DataClassFactory;

import Transform.DataClass.DataClass;
import Transform.DataClass.MdaReport.MdaReport;

import java.util.HashMap;

public class MdaReportFactory implements DataClassFactory {
    @Override
    public DataClass create(HashMap<String, String> data) {
        return new MdaReport(data);
    }
}
