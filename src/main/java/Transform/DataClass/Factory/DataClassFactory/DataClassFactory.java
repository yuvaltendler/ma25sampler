package Transform.DataClass.Factory.DataClassFactory;

import Transform.DataClass.DataClass;

import java.util.HashMap;

public interface DataClassFactory {
    DataClass create(HashMap<String, String> data);
}
