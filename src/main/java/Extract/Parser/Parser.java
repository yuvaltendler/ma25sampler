package Extract.Parser;

import java.util.ArrayList;
import java.util.HashMap;

public interface Parser {
    ArrayList<HashMap<String, String>> parse(String path);
}
