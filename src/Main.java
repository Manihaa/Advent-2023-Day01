import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        ArrayList<String> lines = getFileData("src/input.txt");
        int partOneAnswer = 0;
        //int partTwoAnswer = 0;
        int max = lines.size();
        for (int i = 0; i < max; i++) {
            partOneAnswer += getPartOneNumber(lines.get(i));
            //partTwoAnswer += getPartTwoNumber(lines.get(i));
        }

        System.out.println("Part one answer: " + partOneAnswer);
        //System.out.println("Part two answer: " + partTwoAnswer);
    }

    public static int getPartOneNumber(String line) {
        int len = line.length();
        String nums = "";
        String[] digits = {"0","1","2","3","4","5","6","7","8","9"};
        for (int i = 0; i < len; i++){
            for (int k = 0; k < digits.length; k++) {
                if (line.substring(i, i + 1).equals(digits[k])){
                    nums = nums + line.substring(i, i+1);
                }
            }
        }

        int newNum = Integer.parseInt(nums.substring(0, 1) + nums.substring(nums.length() - 1, nums.length()));
        return newNum;
    }

    public static int getPartTwoNumber(String line) {
        // do part 2
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