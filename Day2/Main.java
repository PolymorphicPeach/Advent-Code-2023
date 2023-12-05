import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Main driver = new Main();
        List<String> lines = driver.getFileLines("Day2.txt");
        List<Game> games = new ArrayList<>();

        lines.stream().forEach(line -> {
            String[] gameTokens = line.split("[:]");
            int id = Integer.parseInt(gameTokens[0].split("[ ]")[1]);
            String[] individualGames = gameTokens[1].split("[;]");
            Game currentGame = new Game(id);

            for(String game : individualGames){
                int red = 0;
                int blue = 0;
                int green = 0;

                String[] pulls = game.split("[, ]");

                for(int i = 0; i < pulls.length; ++i){
                    try{
                        int value = Integer.parseInt(pulls[i]);

                        switch(pulls[i + 1].toLowerCase()){
                            case "red" -> red += value;
                            case "blue" -> blue += value;
                            case "green" -> green += value;
                        }
                    }
                    catch(NumberFormatException e){
                        // Intentionally blank...
                    }
                    currentGame.addBag(new Bag(red, green, blue));
                }
            }
            games.add(currentGame);
        });

        List<Integer> ids = new ArrayList<>();
        for(Game game : games){
            boolean validGame = true;

            for(Bag bag : game.getBags()){

                if(bag.getRed() > 12 || bag.getGreen() > 13 || bag.getBlue() > 14 ){
                    validGame = false;
                }
            }
            if(validGame){
                ids.add(game.getId());
            }
        }

        int ans = 0;
        for(Integer id : ids){
            System.out.println(id);
            ans += id;
        }
        System.out.println(ans);


        // ====== Part 2 =================================
        int sum = 0;

        for(Game game : games){
            int maxRed = game.getBags().stream().max(Comparator.comparing(Bag::getRed)).get().getRed();
            int maxGreen = game.getBags().stream().max(Comparator.comparing(Bag::getGreen)).get().getGreen();
            int maxBlue = game.getBags().stream().max(Comparator.comparing(Bag::getBlue)).get().getBlue();

            sum += (maxRed * maxGreen * maxBlue);
        }

        System.out.println(sum);
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