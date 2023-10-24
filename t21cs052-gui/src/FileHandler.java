import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

public class FileHandler implements AutoCloseable {

    private File file;
    private static ArrayList<Integer> rank;

    public FileHandler(String s) {
        file = new File(s);
        rank = new ArrayList<Integer>();
        readranking();
    }

    private void readranking() {
        if (!file.exists()) {
            System.out.println("ファイルが見つかりません");
            return;
        }

        try (FileReader fileReader = new FileReader(file);
             BufferedReader bufferedReader = new BufferedReader(fileReader)) {
            String data;
            while ((data = bufferedReader.readLine()) != null) {
                rank.add(Integer.valueOf(data));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update(int score) throws IOException {
        rank.add(score);
        Collections.sort(rank, Collections.reverseOrder());

        try (FileWriter filewriter = new FileWriter(file)) {
            for (int i = 0; i < rank.size(); i++) {
                filewriter.write(String.valueOf(rank.get(i)));
                filewriter.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Integer> getRanking() {
        return new ArrayList<>(rank);
    }

    @Override
    public void close() {
       
    }
}