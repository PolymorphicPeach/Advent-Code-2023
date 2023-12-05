import java.util.List;

public class ScratchCard {
    List<Integer> winningNums;
    List<Integer> myNums;
    private int cardNum;
    ScratchCard(int card, List<Integer> winningNums, List<Integer> myNums){
        this.cardNum = card;
        this.winningNums = winningNums;
        this.myNums = myNums;
    }
    public int getCardNum(){
        return cardNum;
    }
    public int getPoints(){
        int points = 0;

        for(Integer num : myNums){
            if (winningNums.contains(num)){
                if(points == 0){
                    points = 1;
                }
                else{
                    points *= 2;
                }
            }
        }
        return points;
    }
    public int getNumWinners(){
        int numWinners = 0;
        for(Integer num : myNums){
            if (winningNums.contains(num)){
                numWinners += 1;
            }
        }
        return numWinners;
    }
    public void displayCard(){
        System.out.println("======================");
        System.out.println("Card: " + cardNum);
        System.out.println("Winners: " + winningNums);
        System.out.println("My Nums: " + myNums);
    }
}
