package Transform.DataClass.MadaReport;

import Transform.DataClass.BasicData.Address;
import Transform.DataClass.BasicData.IdType;
import Transform.DataClass.BasicData.Name;
import Transform.DataClass.BasicData.Person;
import Transform.DataClass.DataClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

import java.util.Date;
import java.util.HashMap;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MdaReport implements DataClass {
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

    @Override
    public String toJson() {
        JSONObject res = new JSONObject();
        res.put("mdaCode", this.getMdaCode());
        res.put("firstName", this.getPerson().getName().getFirstName());
        res.put("lastName", this.getPerson().getName().getLastName());
        res.put("idNum", this.getPerson().getIdNum());
        res.put("city", this.getAddress().getCity());
        res.put("street", this.getAddress().getStreet());
        res.put("buildingNumber", this.getAddress().getBuildingNumber());
        res.put("idType", this.getIdType().getValue());
        res.put("barcode", this.getBarcode());
        res.put("getDate", String.format("%s/%s/%s", this.getGetDate().getDate(), this.getGetDate().getMonth(), this.getGetDate().getYear()));
        res.put("takeDate", String.format("%s/%s/%s", this.getTakeDate().getDate(), this.getTakeDate().getMonth(), this.getTakeDate().getYear()));
        res.put("resultDate", String.format("%s/%s/%s", this.getResultDate().getDate(), this.getResultDate().getMonth(), this.getResultDate().getYear()));
        return res.toString();
    }
}
