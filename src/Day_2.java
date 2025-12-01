import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day_2 {
    private static int r = 12;
    private static int g = 13;
    private static int b = 14;

    public static void main(String[] args){
        ArrayList<String> lines = getFileData("src/input_2.txt");
        int total = 0;

        for (int i = 0; i < lines.size(); i++){
            total += partOne(lines.get(i));
        }

        System.out.println(total);
    }

    public static int partOne(String game){
        boolean boo = true;
        int colonIndex = game.indexOf(":");
        int id = Integer.parseInt(game.substring(5, colonIndex));
        game = game.replace(";", ",");
        game = game.substring(colonIndex + 2);
        int idx = game.indexOf(",");

        int tempR = 0;
        int tempG = 0;
        int tempB = 0;

        while(idx > -1 && boo){
            String let = game.substring(game.indexOf(" ") + 1, game.indexOf(" ") + 2);
            int num = Integer.parseInt(game.substring(0, game.indexOf(" ")));
            if (let.equals("r")){
                tempR = num;
            }else if (let.equals("g")){
                tempG = num;
            }else if (let.equals("b")){
                tempB = num;
            }

            if (tempR > r || tempG > g || tempB > b){
                boo = false;
            }

            tempR = 0;
            tempG = 0;
            tempB = 0;
            game = game.substring(idx + 2);
            idx = game.indexOf(",");
        }
        // one last iteration
        String let = game.substring(game.indexOf(" ") + 1, game.indexOf(" ") + 2);
        int num = Integer.parseInt(game.substring(0, game.indexOf(" ")));
        if (let.equals("r")){
            tempR = num;
        }else if (let.equals("g")){
            tempG = num;
        }else if (let.equals("b")){
            tempB = num;
        }

        if (tempR > r || tempG > g || tempB > b){
            boo = false;
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
