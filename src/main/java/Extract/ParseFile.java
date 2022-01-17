package Extract;

import Extract.Parser.Parser;

import java.util.ArrayList;
import java.util.HashMap;

public class ParseFile {
    private HashMap<String, Parser> typeToParser;

    public ParseFile(HashMap<String, Parser> typeToFile) {
        this.typeToParser = typeToFile;
    }

    public ArrayList<HashMap<String, String>> parseFile(String type, String path){
        return this.typeToParser.get(type).parse(path);
    }
}
