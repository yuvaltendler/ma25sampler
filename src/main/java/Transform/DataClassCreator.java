package Transform;

import Transform.DataClass.DataClass;
import Transform.DataClass.Factory.DataClassFactory.DataClassFactory;

import java.util.HashMap;

public class DataClassCreator{
    private HashMap<String, DataClassFactory> typeToDataClassFactory;

    public DataClassCreator(HashMap<String, DataClassFactory> typeToDataClassFactory) {
        this.typeToDataClassFactory = typeToDataClassFactory;
    }

    public DataClass createDataClass(String type, HashMap<String, String> data){
        return this.typeToDataClassFactory.get(type).create(data);
    }
}
