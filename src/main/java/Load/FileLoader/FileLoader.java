package Load.FileLoader;

import Transform.DataClass.DataClassContainer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public interface FileLoader {
    void load(String path, int numOfRecords, DataClassContainer dataClassContainer);

    static void writeToFile(String path, String text){
        try {
            FileWriter file = new FileWriter(path);
            file.write(text);
            file.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static <T> List<List<T>> chopped(List<T> list, final int L) {
        List<List<T>> parts = new ArrayList<List<T>>();
        final int N = list.size();
        for (int i = 0; i < N; i += L) {
            parts.add(new ArrayList<T>(
                    list.subList(i, Math.min(N, i + L)))
            );
        }
        return parts;
    }
}
