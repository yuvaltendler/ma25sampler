package Extract;

import Extract.Parser.CsvParser;
import Extract.Parser.Parser;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class ParseFileTest {

    @Test
    void parseFile() {
        HashMap<String, Parser> typeToParser = new HashMap<String, Parser>() {{
            put("CSV", new CsvParser());
        }};
        ParseFile parseFile = new ParseFile(typeToParser);
        String res = parseFile.parseFile("CSV", "src\\main\\resources\\Input\\TestMadaReport.csv");
        assert !res.isEmpty();
    }
}