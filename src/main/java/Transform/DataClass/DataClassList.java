package Transform.DataClass;

import Transform.JsonConvertAble;

public interface DataClassList extends JsonConvertAble {
//    ArrayList<T extends DataClass> getList();
    void addToList(DataClass dataClass);
}
