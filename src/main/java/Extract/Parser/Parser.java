package Extract.Parser;

import java.io.FileNotFoundException;

public interface Parser {
    String parce(String path) throws FileNotFoundException;
}
