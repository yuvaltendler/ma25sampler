package Transform.DataClass.Factory.DataClassContainerFactory;

import Transform.DataClass.DataClassContainer;
import Transform.DataClass.MdaReport.MdaReports;

import java.util.ArrayList;
import java.util.HashMap;

public class MdaReportsFactory implements DataClassContainerFactory {

    @Override
    public DataClassContainer create(ArrayList<HashMap<String, String>> data) {
        return MdaReports.parseMdaReports(data);
    }
}
