import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) {
        Main driver = new Main();

        List<String> lines = driver.getFileLines("day1.txt");
        List<Integer> nums = new ArrayList<>();

        lines.stream().forEach(line -> {
            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(line);
            StringBuilder allNums = new StringBuilder();

            while(matcher.find()) {
                allNums.append(matcher.group());
            }

            String results = allNums.toString();

            if(results.length() >= 2) {
                String twodigit = String.valueOf(results.charAt(0)) + String.valueOf(results.charAt(results.length() - 1));
                nums.add(Integer.parseInt(twodigit));
            }
            if(results.length() == 1){
                String twodigit = String.valueOf(results.charAt(0)) + String.valueOf(results.charAt(0));
                nums.add(Integer.parseInt(twodigit));

            }
        });

        System.out.println(nums);
        int ans = nums.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Ans = " + ans);

        // =======================================================
        List<Integer> nums2 = new ArrayList<>();

        lines.stream().forEach(line -> {
            Map<Integer, Integer> indexAt = new HashMap<>();

            StringBuilder currentWord = new StringBuilder();

            for(int i = 0; i < line.length(); ++i){
                char currentChar = line.charAt(i);

                if(Character.isDigit(currentChar)){
                    indexAt.put(i, Integer.parseInt(String.valueOf(currentChar)));
                    currentWord.setLength(0);
                }
                if(Character.isLetter(currentChar)){
                    currentWord.append(currentChar);
                }

                if(currentWord.toString().contains("one") ||
                        currentWord.toString().contains("two") ||
                        currentWord.toString().contains("three") ||
                        currentWord.toString().contains("four") ||
                        currentWord.toString().contains("five") ||
                        currentWord.toString().contains("six") ||
                        currentWord.toString().contains("seven") ||
                        currentWord.toString().contains("eight") ||
                        currentWord.toString().contains("nine")) {

                    if(currentWord.toString().contains("one")){
                        int indexOfLast = currentWord.toString().indexOf("on");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 2);
                        }

                        indexAt.put(i, 1);
                    }
                    if(currentWord.toString().contains("two")){
                        int indexOfLast = currentWord.toString().indexOf("tw");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 2);
                        }
                        indexAt.put(i, 2);
                    }
                    if(currentWord.toString().contains("three")){
                        int indexOfLast = currentWord.toString().indexOf("thre");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 4);
                        }

                        indexAt.put(i, 3);
                    }
                    if(currentWord.toString().contains("four")){
                        int indexOfLast = currentWord.toString().indexOf("fou");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 3);
                        }
                        indexAt.put(i, 4);
                    }
                    if(currentWord.toString().contains("five")){
                        int indexOfLast = currentWord.toString().indexOf("fiv");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 3);
                        }

                        indexAt.put(i, 5);
                    }
                    if(currentWord.toString().contains("six")){
                        int indexOfLast = currentWord.toString().indexOf("si");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 2);
                        }

                        indexAt.put(i, 6);
                    }
                    if(currentWord.toString().contains("seven")){
                        int indexOfLast = currentWord.toString().indexOf("seve");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 4);
                        }

                        indexAt.put(i, 7);
                    }
                    if(currentWord.toString().contains("eight")){
                        int indexOfLast = currentWord.toString().indexOf("eigh");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 4);
                        }

                        indexAt.put(i, 8);
                    }
                    if(currentWord.toString().contains("nine")){
                        int indexOfLast = currentWord.toString().indexOf("nin");
                        if (indexOfLast != -1) {
                            currentWord.delete(0, indexOfLast + 3);
                        }

                        indexAt.put(i, 9);
                    }
                }
            }

            String num1 = String.valueOf(indexAt.get(Collections.min(indexAt.keySet())));
            String num2 = String.valueOf(indexAt.get(Collections.max(indexAt.keySet())));
            nums2.add(Integer.parseInt(num1 + num2));
        });

        System.out.println(nums2);
        int ans2 = nums2.stream().mapToInt(Integer::intValue).sum();
        System.out.println("Ans = " + ans2);
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