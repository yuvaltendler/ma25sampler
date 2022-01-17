package Transform.DataClass.MadaReport;

import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.IdType;
import Transform.DataClass.BasicData.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MadaReport {
    private String madaCode;
    private Person person;
    private Address address;
    private IdType idType;
    private String Barcode;
    private Date getDate;
    private Date takeDate;
    private Date resultDate;
}
