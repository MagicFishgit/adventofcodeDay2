package rudivisagie;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        //Day 2 Part 1 answer.
        System.out.println("Day 2 Part 1 answer: " + calcCheckSum());

        //Day 2 Part 2 answer.
        System.out.println("Day 2 Part 2 answer: " + getCommLetters());
    }

    /**
     * @return Returns string ArrayList with data in file loaded.
     */
    private static ArrayList<String> getDataFromFile() {

        ArrayList<String> invID = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("day2Data"));

            String line;

            while ((line = br.readLine()) != null) {

                invID.add(line);
            }
        } catch (Exception e) {
            System.err.format("Opps an eroor has occured" + e.toString());
        }

        return invID;
    }

    private static int calcCheckSum(){

        //var declaration
        int threeCount = 0;
        int twoCount = 0;
        int checkSum;

        ArrayList data = getDataFromFile();

        for (Object item : data) {

            String itemCode = item.toString();

            HashMap<String, Integer> charMap = new HashMap<>();

            //Fills the Hash Map with each character in the string as a key reference without duplicates
            // and sets their counting value to 0;
            for (int i = 0; i < itemCode.length(); i++) {

                String index = Character.toString(itemCode.charAt(i));

                if (!charMap.containsKey(index)) {
                    charMap.put(index, 0);
                }
            }

            //Increments values in the Hash Map according to the number of them in the string.
            for (int i = 0; i < itemCode.length(); i++) {

                String index = Character.toString(itemCode.charAt(i));

                //Increases the count of characters found.
                if (charMap.containsKey(index)) {
                    charMap.put(index, charMap.get(index) + 1);
                }
            }

            //Searches the hash map for the first result that = 3  or = 2 and inc the relevant var.
            if (charMap.containsValue(3)) {
                threeCount++;
            }
            if (charMap.containsValue(2)) {
                twoCount++;
            }
        }

        checkSum = threeCount*twoCount;

        return checkSum;
    }

    private static String getCommLetters(){

        String line1;
        String line2;
        String answer = ""; // Result of method.
        int equal = 0;
        int diff = 0;

        ArrayList<String> data = getDataFromFile();

        for (int j = 0; j < 250; j++){

            line1 = data.get(j);

           for (int k = 0; k < 250; k++){

               line2 = data.get(k);

               for (int i = 0 ; i < 26; i++){

                   if (line1.charAt(i) == line2.charAt(i)){
                       equal++;
                   }else{
                       diff++;
                   }
               }

               if (equal == 25 && diff == 1){

                   //find and remove the characters that are different in the two strings;
                   for (int i = 0; i < line1.length(); i++){

                       if (line1.charAt(i) == line2.charAt(i)){

                           answer+= line1.charAt(i); // Ignoring warning here because string concatenation is desired in this use case.

                       }
                   }

                   return answer;


               }

               equal = 0;
               diff = 0;

           }
        }

        return answer;
    }
}
