package Transform.DataClass.Factory;

import Transform.DataClass.DataClass;

public interface DataClassFactory {
    DataClass create(String json);
}
