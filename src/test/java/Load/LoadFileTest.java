package Load;

import Load.FileLoader.FileLoader;
import Load.FileLoader.JsonFileLoader;
import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.IdType;
import Transform.DataClass.BasicData.Name;
import Transform.DataClass.BasicData.Person;
import Transform.DataClass.MdaReport.MdaReport;
import Transform.DataClass.MdaReport.MdaReports;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;

class LoadFileTest {

    @Test
    void loadFile() throws FileNotFoundException {
        ArrayList<MdaReport> reports = new ArrayList<>();
        reports.add(new MdaReport("6b4f7c15-d9ac-43f5-be79-2e8674038910", new Person(878746593, new Name("Garfield", "Sapseed")),
                new Address("Sinacaban", "Mockingbird", 36), IdType.getIdTypeByValue(0), "21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185",
                new Date(2021, 4, 28), new Date(2021, 7, 4), new Date(2021, 3, 23)));
        reports.add(new MdaReport("95cf04b0-d267-4da3-b30a-4b511b68be33", new Person(816235596, new Name("Had", "Mannin")),
                new Address("Drakino", "Swallow", 51), IdType.getIdTypeByValue(1), "845E97D7-A566-C72F-84E4-24A34279C011",
                new Date(2021, 9, 24), new Date(2021, 10, 31), new Date(2021, 12, 4)));
        MdaReports input = new MdaReports(reports);

        LoadFile loadFile = new LoadFile(new HashMap<String, FileLoader>(){{put("Json", new JsonFileLoader());}});
        loadFile.loadFile("Json", "src\\main\\resources\\output\\test.json", 1, input);

        File myObj = new File("src\\main\\resources\\output\\test0.json");
        Scanner myReader = new Scanner(myObj);
        String data = myReader.nextLine();
        assert data.equals("{\"Transform.DataClass.MdaReport.MdaReports\":[{\"firstName\":\"Garfield\",\"lastName\":\"Sapseed\",\"idType\":0,\"mdaCode\":\"6b4f7c15-d9ac-43f5-be79-2e8674038910\",\"city\":\"Sinacaban\",\"street\":\"Mockingbird\",\"buildingNumber\":36,\"resultDate\":\"23/3/2021\",\"getDate\":\"28/4/2021\",\"idNum\":878746593,\"barcode\":\"21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185\",\"takeDate\":\"4/7/2021\"}]}");
        myReader.close();
        myObj = new File("src\\main\\resources\\output\\test1.json");
        myReader = new Scanner(myObj);
        data = myReader.nextLine();
        assert data.equals("{\"Transform.DataClass.MdaReport.MdaReports\":[{\"firstName\":\"Had\",\"lastName\":\"Mannin\",\"idType\":1,\"mdaCode\":\"95cf04b0-d267-4da3-b30a-4b511b68be33\",\"city\":\"Drakino\",\"street\":\"Swallow\",\"buildingNumber\":51,\"resultDate\":\"4/0/2022\",\"getDate\":\"24/9/2021\",\"idNum\":816235596,\"barcode\":\"845E97D7-A566-C72F-84E4-24A34279C011\",\"takeDate\":\"1/11/2021\"}]}");
        myReader.close();
    }
}