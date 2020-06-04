package bookstore;

import java.io.*;
import java.security.Timestamp;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Output {

    private static Output instance = null;
    private static BufferedWriter writer;
    private static String OutputFile = "C:\\Users\\toni\\Documents\\GitHub\\Java\\Proiect-part2\\defaultOutputFile.txt";

    private Output() {
    }

    public static Output getInstance() {
        if (instance == null) {
            instance = new Output();
        }
        return instance;
    }

    public static void write(String action){

        try {
            long yourmilliseconds = System.currentTimeMillis();
            SimpleDateFormat sdf = new SimpleDateFormat("MMM dd,yyyy HH:mm:ss");
            Date resultdate = new Date(yourmilliseconds);

            writer = new BufferedWriter(new FileWriter(OutputFile, true));
            writer.write(action.toString() + "," + sdf.format(resultdate) + "\n");
            writer.flush();
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void setOutputFile(String outputFile) {
        OutputFile = outputFile;
    }
}
