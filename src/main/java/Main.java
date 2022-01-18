import Extract.ParseFile;
import Extract.Parser.CsvParser;
import Extract.Parser.Parser;
import Load.FileLoader.FileLoader;
import Load.FileLoader.JsonFileLoader;
import Load.LoadFile;
import Transform.Creator.DataClassContainerCreator;
import Transform.DataClass.DataClassContainer;
import Transform.DataClass.Factory.DataClassContainerFactory.DataClassContainerFactory;
import Transform.DataClass.Factory.DataClassContainerFactory.MdaReportsFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class Main {
    private static final int NUM_OF_RECORDS = 50000;
    public static void main(String[] args) {
        ParseFile parseFile = new ParseFile(new HashMap<String, Parser>() {{ put("CSV", new CsvParser()); }});
        ArrayList<HashMap<String, String>> data = parseFile.parseFile("CSV", "C:\\Users\\user\\Documents\\Magshimim\\army codes\\ma25sampler\\src\\main\\resources\\Input\\MadaReports.csv");

        DataClassContainerCreator dataClassContainerCreator = new DataClassContainerCreator(new HashMap<String, DataClassContainerFactory>(){{put("MdaReports", new MdaReportsFactory());}});
        DataClassContainer dataClassContainer = dataClassContainerCreator.createDataClassContainer("MdaReports", data);

        LoadFile loadFile = new LoadFile(new HashMap<String, FileLoader>(){{put("Json", new JsonFileLoader());}});
        loadFile.loadFile("Json", "src\\main\\resources\\output\\mdaReport.json", NUM_OF_RECORDS, dataClassContainer);
    }
}
