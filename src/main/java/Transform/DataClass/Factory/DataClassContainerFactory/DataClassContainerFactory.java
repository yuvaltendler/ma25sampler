package Transform.DataClass.Factory.DataClassContainerFactory;

import Transform.DataClass.DataClassContainer;

import java.util.ArrayList;
import java.util.HashMap;

public interface DataClassContainerFactory {
    DataClassContainer create(ArrayList<HashMap<String, String>> data);
}
