package Load.FileLoader;

import Transform.DataClass.DataClassContainer;

public interface FileLoader {
    void load(String path, DataClassContainer dataClassContainer);
}
