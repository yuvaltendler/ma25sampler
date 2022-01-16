package Extract.Parser;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CsvParserTest {

    @Test
    void parce() {
        CsvParser csvParser = new CsvParser();
        String json = (csvParser.parce("src\\main\\resources\\Input\\TestMadaReport.csv"));
        assert json.equals("[{MDACODE=6b4f7c15-d9ac-43f5-be79-2e8674038910, IDNum=878746593, IDType=0, FirstName=Garfield," +
                " LastName=Sapseed, City=Sinacaban, Street=Mockingbird, BuildingNumber=36," +
                " Barcode=21ABBA1C-1292-5EB2-0BBA-7C4AB5DB1185, GetDate=28.04.2021, TakeDate=04.07.2021, ResultDate=23/03/2021}," +
                " {MDACODE=95cf04b0-d267-4da3-b30a-4b511b68be33, IDNum=816235596, IDType=1, FirstName=Had," +
                " LastName=Mannin, City=Drakino, Street=Swallow, BuildingNumber=51," +
                " Barcode=845E97D7-A566-C72F-84E4-24A34279C011, GetDate=24.09.2021, TakeDate=31.10.2021, ResultDate=04/12/2021}," +
                " {MDACODE=ebe92c56-9385-4aee-99df-681eccfb2475, IDNum=351141351, IDType=0, FirstName=Ruby," +
                " LastName=Daborne, City=Mont-de-Marsan, Street=La Follette, BuildingNumber=7," +
                " Barcode=2DD28A22-02A5-3D62-BDD3-17957D184033, GetDate=05.03.2021, TakeDate=18.07.2021, ResultDate=11/09/2021}," +
                " {MDACODE=7d004e47-c577-4f69-8c95-4358a1a0ece1, IDNum=689546557, IDType=2, FirstName=Mariann," +
                " LastName=Cutajar, City=Uubulan, Street=Stoughton, BuildingNumber=70," +
                " Barcode=96B941B1-B0DC-6257-E99A-273B70C2CCC6, GetDate=20.05.2021, TakeDate=21.10.2021, ResultDate=23/01/2021}]");
    }
}