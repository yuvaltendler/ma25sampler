package Transform.DataClass.MadaReport;

import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.Name;
import Transform.DataClass.BasicData.Person;
import org.junit.jupiter.api.Test;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;

class MdaReportTest {

    @Test
    void createMadaReportFromHashMap(){
        HashMap<String, String> data = new HashMap<String, String>(){{
            put("TakeDate", "04.07.2021");
            put("GetDate", "28.04.2021");
            put("FirstName", "Garfield");
            put("Barcode", "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185");
            put("BuildingNumber", "36");
            put("Street", "Mockingbird");
            put("MDACODE", "6b4f7c15-d9ac-43f5-be79-2e8674038910");
            put("LastName", "Sapseed");
            put("City", "Sinacaban");
            put("IDType", "0");
            put("IDNum", "878746593");
            put("ResultDate", "23/03/2021");
        }};
        MdaReport mdaReport = new MdaReport(data);
        assert mdaReport.getMdaCode().equals("6b4f7c15-d9ac-43f5-be79-2e8674038910");
        assert mdaReport.getBarcode().equals("21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185");
        assert mdaReport.getGetDate().equals(new Date(2021, Calendar.MAY, 28));
        assert mdaReport.getTakeDate().equals(new Date(2021, Calendar.AUGUST, 4));
        assert mdaReport.getResultDate().equals(new Date(2021, Calendar.APRIL, 23));
        assert mdaReport.getPerson().equals(new Person(878746593, new Name("Garfield", "Sapseed")));
        assert mdaReport.getAddress().equals(new Address("Sinacaban", "Mockingbird", 36));

    }
}