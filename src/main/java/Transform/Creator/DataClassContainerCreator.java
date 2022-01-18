package Transform.Creator;

import Transform.DataClass.DataClassContainer;
import Transform.DataClass.Factory.DataClassContainerFactory.DataClassContainerFactory;

import java.util.ArrayList;
import java.util.HashMap;

public class DataClassContainerCreator {
    private HashMap<String, DataClassContainerFactory> typeToDataClassContainerFactory;

    public DataClassContainerCreator(HashMap<String, DataClassContainerFactory> typeToDataClassContainerFactory) {
        this.typeToDataClassContainerFactory = typeToDataClassContainerFactory;
    }

    public DataClassContainer createDataClassContainer(String type, ArrayList<HashMap<String, String>> data){
        return this.typeToDataClassContainerFactory.get(type).create(data);
    }
}
