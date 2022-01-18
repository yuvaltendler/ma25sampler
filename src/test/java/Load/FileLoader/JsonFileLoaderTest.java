package Load.FileLoader;

import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.IdType;
import Transform.DataClass.BasicData.Name;
import Transform.DataClass.BasicData.Person;
import Transform.DataClass.MdaReport.MdaReport;
import Transform.DataClass.MdaReport.MdaReports;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class JsonFileLoaderTest {

    @Test
    void load() {
        ArrayList<MdaReport> reports = new ArrayList<>();
        reports.add(new MdaReport("6b4f7c15-d9ac-43f5-be79-2e8674038910", new Person(878746593, new Name("Garfield", "Sapseed")),
                new Address("Sinacaban", "Mockingbird", 36), IdType.getIdTypeByValue(0), "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185",
                new Date(2021, 4, 28), new Date(2021, 7, 4), new Date(2021, 3, 23)));
        reports.add(new MdaReport("95cf04b0-d267-4da3-b30a-4b511b68be33", new Person(816235596, new Name("Had", "Mannin")),
                new Address("Drakino", "Swallow", 51), IdType.getIdTypeByValue(1), "845E97D7-A566-C72F-84E4-24A34279C011",
                new Date(2021, 9, 24), new Date(2021, 10, 31), new Date(2021, 12, 4)));
        MdaReports input = new MdaReports(reports);

        JsonFileLoader jsonFileLoader = new JsonFileLoader();
        jsonFileLoader.load("src\\main\\resources\\output\\test.json", 1, input);
    }
}