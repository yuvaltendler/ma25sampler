package Transform.DataClass.MadaReport;

import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.IdType;
import Transform.DataClass.BasicData.Name;
import Transform.DataClass.BasicData.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MdaReport {
    private String mdaCode;
    private Person person;
    private Address address;
    private IdType idType;
    private String barcode;
    private Date getDate;
    private Date takeDate;
    private Date resultDate;

    public MdaReport(HashMap<String, String> data){
        data = fixMapKeys(data);
        this.mdaCode = data.get("mdacode");
        Name name = new Name(data.get("firstname"), data.get("lastname"));
        Person person = new Person(Integer.parseInt(data.get("idnum")), name);
        this.person = person;
        Address address = new Address(data.get("city"), data.get("street"), Integer.parseInt(data.get("buildingnumber")));
        this.address = address;
        this.idType = IdType.getIdTypeByValue(Integer.parseInt(data.get("idtype")));
        this.barcode = data.get("barcode");
        this.getDate = parseDate(data.get("getdate"));
        this.takeDate = parseDate(data.get("takedate"));
        this.resultDate = parseDate(data.get("resultdate"));
    }

    private HashMap<String, String> fixMapKeys(HashMap<String, String> data){
        HashMap<String, String> res = new HashMap<String, String>();
        for(String key: data.keySet()){
            String newKey = key.toLowerCase().replaceAll("_", "");
            res.put(newKey, data.get(key));
        }
        return res;
    }

    private Date parseDate(String string){
        int day = Integer.parseInt(string.substring(0, 2));
        int month = Integer.parseInt(string.substring(3, 5));
        int year = Integer.parseInt(string.substring(6));
        return new Date(year, month, day);
    }
}
