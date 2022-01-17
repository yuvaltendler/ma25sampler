package Transform.DataClass.BasicData;

public enum IdType {
    BLUE_ID(0),
    PASSPORT(1),
    HMO_MEMBER_NUM(2);

    private int value;

    IdType(int value) {
        this.value = value;
    }

    public int getValue(){
        return this.value;
    }

    public static IdType getIdTypeByValue(int value){
        return IdType.values()[value];
    }
}
