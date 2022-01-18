package Transform.DataClass;

import Transform.JsonConvertAble;

import java.util.ArrayList;

public interface DataClassContainer<T extends DataClass> extends JsonConvertAble {
    ArrayList<T> getDataClassList();
    void addToList(T dataClass);
}
