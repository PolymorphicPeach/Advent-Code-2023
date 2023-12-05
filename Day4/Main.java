import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main driver = new Main();
        List<String> lines = driver.getFileLines("Day4.txt");
        List<ScratchCard> cards = new ArrayList<>();

        for(String line : lines){
            String[] test = line.split("[: ]+");

            System.out.println(line);
            for(String t : test){
                System.out.println(t);
            }
            int cardNum = Integer.parseInt(test[1]);
            String[] split1 = line.split("[:]");
            String[] split2 = split1[1].split("[|]+");
            List<Integer> winners = new ArrayList<>();
            List<Integer> myNums = new ArrayList<>();
            String[] win = split2[0].split("[\\s+]");
            String[] nums = split2[1].split("[\\s+]");
            for(String w : win){
                if(!w.isEmpty()){
                    winners.add(Integer.parseInt(w));
                }
            }
            for(String n : nums){
                if(!n.isEmpty()){
                    myNums.add(Integer.parseInt(n));
                }
            }
            cards.add(new ScratchCard(cardNum, winners, myNums));
        }
        int sum = 0;
        for(ScratchCard card : cards){
            sum += card.getPoints();
        }
        System.out.println(sum);
        // =====================================
        //               Part 2
        // ====================================
        CardGame game = new CardGame(cards);
        game.play();
    }

    public List<String> getFileLines(String filePath){
        List<String> lines = new ArrayList<>();
        String line;

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))){
            while((line = bufferedReader.readLine()) != null){
                lines.add(line);
            }
        }
        catch (IOException e) {
            System.out.println("Error reading file");
        }

        return lines;
    }
}