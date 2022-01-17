package Extract.Parser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class CsvParser implements Parser {

    @Override
    public ArrayList<HashMap<String, String>> parse(String path) {
        ArrayList<HashMap<String, String>> records = new ArrayList<>();
        String[] parameterNames;
        try (Scanner scanner = new Scanner(new File(path))) {
            parameterNames = scanner.nextLine().split(",");
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine(), parameterNames));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return records;
    }

    private HashMap<String, String> getRecordFromLine(String line, String[] parameterNames){
        HashMap<String, String> res = new HashMap<>();
        String[] values = line.split(",");
        for(int i = 0; i < values.length; i++){
            res.put(parameterNames[i], values[i]);
        }
        return res;
    }
}
