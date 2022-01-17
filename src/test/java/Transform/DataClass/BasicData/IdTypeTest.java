package Transform.DataClass.BasicData;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IdTypeTest {

    @Test
    void getValue() {
        assertEquals(IdType.BLUE_ID.getValue(), 0);
        assertEquals(IdType.PASSPORT.getValue(), 1);
        assertEquals(IdType.HMO_MEMBER_NUM.getValue(), 2);
    }

    @Test
    void getIdTypeByValue() {
        assertEquals(IdType.getIdTypeByValue(0), IdType.BLUE_ID);
        assertEquals(IdType.getIdTypeByValue(1), IdType.PASSPORT);
        assertEquals(IdType.getIdTypeByValue(2), IdType.HMO_MEMBER_NUM);
    }
}