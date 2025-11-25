import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_2 {
    private static int r = 12;
    private static int g = 13;
    private static int b = 14;

    public static void main(String[] args){
        ArrayList<String> lines = getFileData("src/input.txt");
        int total = 0;

        for (int i = 0; i < lines.size(); i++){
            //total += partOne(lines.get(i));
        }

        //System.out.println(total);
    }

    public static int partOne(String game){
        int colonIndex = game.indexOf(":");
        int id = Integer.parseInt(game.substring(5, colonIndex));
        boolean boo = true;
        int semiIndex = game.indexOf(";");
        int k = game.indexOf(":") + 1;

        int tempR = 0;
        int tempG = 0;
        int tempB = 0;
        while (game.contains(";")){
            String tempGame = game.substring(k, semiIndex);

            k = semiIndex + 1;
            semiIndex = game.indexOf(";");
            if (semiIndex < 0){
                semiIndex =
            }
        }

        if (boo){
            return id;
        }
        return 0;
    }

    public static ArrayList<String> getFileData(String fileName) {
        ArrayList<String> fileData = new ArrayList<String>();
        try {
            File f = new File(fileName);
            Scanner s = new Scanner(f);
            while (s.hasNextLine()) {
                String line = s.nextLine();
                if (!line.equals(""))
                    fileData.add(line);
            }
            return fileData;
        }
        catch (FileNotFoundException e) {
            return fileData;
        }
    }
}
