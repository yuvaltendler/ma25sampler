package Transform.DataClass.MadaReport;

import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.IdType;
import Transform.DataClass.BasicData.Name;
import Transform.DataClass.BasicData.Person;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

class MdaReportsTest {

    @Test
    void createMdaReportFromArrayListOfHashMap() {
        ArrayList<MdaReport> reports = new ArrayList<>();
        reports.add(new MdaReport("6b4f7c15-d9ac-43f5-be79-2e8674038910", new Person(878746593, new Name("Garfield", "Sapseed")),
                new Address("Sinacaban", "Mockingbird", 36), IdType.getIdTypeByValue(0), "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185",
                new Date(2021, 4, 28), new Date(2021, 7, 4), new Date(2021, 3, 23)));
        reports.add(new MdaReport("95cf04b0-d267-4da3-b30a-4b511b68be33", new Person(816235596, new Name("Had", "Mannin")),
                new Address("Drakino", "Swallow", 51), IdType.getIdTypeByValue(1), "845E97D7-A566-C72F-84E4-24A34279C011",
                new Date(2021, 9, 24), new Date(2021, 10, 31), new Date(2021, 12, 4)));
        MdaReports expected = new MdaReports(reports);

        ArrayList<HashMap<String, String>> input = new ArrayList<>();
        input.add(new HashMap<String, String>() {{
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
        }});

        input.add(new HashMap<String, String>() {{
            put("TakeDate", "31.10.2021");
            put("GetDate", "24.09.2021");
            put("FirstName", "Had");
            put("Barcode", "845E97D7-A566-C72F-84E4-24A34279C011");
            put("BuildingNumber", "51");
            put("Street", "Swallow");
            put("MDACODE", "95cf04b0-d267-4da3-b30a-4b511b68be33");
            put("LastName", "Mannin");
            put("City", "Drakino");
            put("IDType", "1");
            put("IDNum", "816235596");
            put("ResultDate", "04/12/2021");
        }});

        MdaReports mdaReports = MdaReports.parseMdaReports(input);
        assert mdaReports.equals(expected);
    }

    @Test
    void addMdaReport() {
        ArrayList<MdaReport> reports = new ArrayList<>();
        reports.add(new MdaReport("6b4f7c15-d9ac-43f5-be79-2e8674038910", new Person(878746593, new Name("Garfield", "Sapseed")),
                new Address("Sinacaban", "Mockingbird", 36), IdType.getIdTypeByValue(0), "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185",
                new Date(2021, 4, 28), new Date(2021, 7, 4), new Date(2021, 3, 23)));
        reports.add(new MdaReport("95cf04b0-d267-4da3-b30a-4b511b68be33", new Person(816235596, new Name("Had", "Mannin")),
                new Address("Drakino", "Swallow", 51), IdType.getIdTypeByValue(1), "845E97D7-A566-C72F-84E4-24A34279C011",
                new Date(2021, 9, 24), new Date(2021, 10, 31), new Date(2021, 12, 4)));
        MdaReports expected = new MdaReports();
        expected.setMdaReports(reports);

        MdaReports mdaReports = new MdaReports();
        mdaReports.addToList(new MdaReport("6b4f7c15-d9ac-43f5-be79-2e8674038910", new Person(878746593, new Name("Garfield", "Sapseed")),
                new Address("Sinacaban", "Mockingbird", 36), IdType.getIdTypeByValue(0), "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185",
                new Date(2021, 4, 28), new Date(2021, 7, 4), new Date(2021, 3, 23)));
        mdaReports.addToList(new MdaReport("95cf04b0-d267-4da3-b30a-4b511b68be33", new Person(816235596, new Name("Had", "Mannin")),
                new Address("Drakino", "Swallow", 51), IdType.getIdTypeByValue(1), "845E97D7-A566-C72F-84E4-24A34279C011",
                new Date(2021, 9, 24), new Date(2021, 10, 31), new Date(2021, 12, 4)));
    }

    @Test
    void toJson(){
        ArrayList<MdaReport> reports = new ArrayList<>();
        reports.add(new MdaReport("6b4f7c15-d9ac-43f5-be79-2e8674038910", new Person(878746593, new Name("Garfield", "Sapseed")),
                new Address("Sinacaban", "Mockingbird", 36), IdType.getIdTypeByValue(0), "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185",
                new Date(2021, 4, 28), new Date(2021, 7, 4), new Date(2021, 3, 23)));
        reports.add(new MdaReport("95cf04b0-d267-4da3-b30a-4b511b68be33", new Person(816235596, new Name("Had", "Mannin")),
                new Address("Drakino", "Swallow", 51), IdType.getIdTypeByValue(1), "845E97D7-A566-C72F-84E4-24A34279C011",
                new Date(2021, 9, 24), new Date(2021, 10, 31), new Date(2021, 12, 4)));
        MdaReports mdaReports = new MdaReports(reports);
        String json = mdaReports.toJson();
        assert json.equals("{\"mdaReports\":[{\"firstName\":\"Garfield\",\"lastName\":\"Sapseed\",\"idType\":0," +
                "\"mdaCode\":\"6b4f7c15-d9ac-43f5-be79-2e8674038910\",\"city\":\"Sinacaban\",\"street\":\"Mockingbird\"," +
                "\"buildingNumber\":36,\"resultDate\":\"23/3/2021\",\"getDate\":\"28/4/2021\",\"idNum\":878746593," +
                "\"barcode\":\"21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185\",\"takeDate\":\"4/7/2021\"},{\"firstName\":\"Had\"," +
                "\"lastName\":\"Mannin\",\"idType\":1,\"mdaCode\":\"95cf04b0-d267-4da3-b30a-4b511b68be33\",\"city\":\"Drakino\"," +
                "\"street\":\"Swallow\",\"buildingNumber\":51,\"resultDate\":\"4/0/2022\",\"getDate\":\"24/9/2021\"," +
                "\"idNum\":816235596,\"barcode\":\"845E97D7-A566-C72F-84E4-24A34279C011\",\"takeDate\":\"1/11/2021\"}]}");
    }
}