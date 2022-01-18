package Extract;

import Extract.Parser.CsvParser;
import Extract.Parser.Parser;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class ParseFileTest {

    @Test
    void parseFile() {
        HashMap<String, Parser> typeToParser = new HashMap<String, Parser>() {{
            put("CSV", new CsvParser());
        }};
        ParseFile parseFile = new ParseFile(typeToParser);
        ArrayList<HashMap<String, String>> res = parseFile.parseFile("CSV", "src\\main\\resources\\Input\\TestMdaReport.csv");
        assert !res.isEmpty();
    }
}