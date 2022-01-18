package Extract.Parser;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

class CsvParserTest {

    @Test
    void parse() {
        CsvParser csvParser = new CsvParser();
        ArrayList<HashMap<String, String>> data = (csvParser.parse("src\\main\\resources\\Input\\TestMdaReport.csv"));
//        System.out.println(data);
        assert data.toString().equals("[{TakeDate=04.07.2021, GetDate=28.04.2021, FirstName=Garfield, Barcode=21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185, " +
                "BuildingNumber=36, Street=Mockingbird, MDACODE=6b4f7c15-d9ac-43f5-be79-2e8674038910, LastName=Sapseed, " +
                "City=Sinacaban, IDType=0, IDNum=878746593, ResultDate=23/03/2021}, {TakeDate=31.10.2021, GetDate=24.09.2021, " +
                "FirstName=Had, Barcode=845E97D7-A566-C72F-84E4-24A34279C011, BuildingNumber=51, Street=Swallow, MDACODE=95cf04b0-d267-4da3-b30a-4b511b68be33, " +
                "LastName=Mannin, City=Drakino, IDType=1, IDNum=816235596, ResultDate=04/12/2021}, {TakeDate=18.07.2021, " +
                "GetDate=05.03.2021, FirstName=Ruby, Barcode=2DD28A22-02A5-3D62-BDD3-17957D184033, BuildingNumber=7, Street=La Follette, " +
                "MDACODE=ebe92c56-9385-4aee-99df-681eccfb2475, LastName=Daborne, City=Mont-de-Marsan, IDType=0, IDNum=351141351, ResultDate=11/09/2021}, " +
                "{TakeDate=21.10.2021, GetDate=20.05.2021, FirstName=Mariann, Barcode=96B941B1-B0DC-6257-E99A-273B70C2CCC6, BuildingNumber=70, " +
                "Street=Stoughton, MDACODE=7d004e47-c577-4f69-8c95-4358a1a0ece1, LastName=Cutajar, City=Uubulan, IDType=2, IDNum=689546557, " +
                "ResultDate=23/01/2021}]");
    }
}