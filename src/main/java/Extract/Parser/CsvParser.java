package Extract.Parser;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

import java.io.*;
import java.util.List;
import java.util.Map;

public class CsvParser implements Parser{

    @Override
    public String parce(String path) throws FileNotFoundException {
        //        new ObjectMapper()
//                .configure(SerializationFeature.INDENT_OUTPUT, true)
//                .writeValue(new File(path), orderLines.readAll());

        File input = new File(path);
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<String, String>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
            List<Map<String, String>> list = mappingIterator.readAll();
            return list.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
