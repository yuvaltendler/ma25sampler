package Extract.Parser;

import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.dataformat.csv.*;

import java.io.File;
import java.util.List;
import java.util.Map;

public class CsvParser implements Parser{

    @Override
    public String parce(String path) {
        File input = new File(path);
        try {
            CsvSchema csv = CsvSchema.emptySchema().withHeader();
            CsvMapper csvMapper = new CsvMapper();
            MappingIterator<Map<?, ?>> mappingIterator =  csvMapper.reader().forType(Map.class).with(csv).readValues(input);
            List<Map<?, ?>> list = mappingIterator.readAll();
            return list.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "";
    }
}
