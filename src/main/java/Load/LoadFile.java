package Load;

import Load.FileLoader.FileLoader;
import Transform.DataClass.DataClassContainer;

import java.util.HashMap;

public class LoadFile {
    private HashMap<String, FileLoader> typeToFileLoader;

    public LoadFile(HashMap<String, FileLoader> typeToFileLoader) {
        this.typeToFileLoader = typeToFileLoader;
    }

    public void loadFile(String type, String path, int numOfRecords, DataClassContainer dataClassContainer){
        this.typeToFileLoader.get(type).load(path, numOfRecords, dataClassContainer);
    }
}
