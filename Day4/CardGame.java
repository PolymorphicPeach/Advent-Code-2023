import java.util.List;
import java.util.Optional;

public class CardGame {
    private List<ScratchCard> cards;
    public CardGame(List<ScratchCard> cards){
        this.cards = cards;
    }
    public void play(){
        for(int i = 0; i < cards.size(); ++i){
            process(cards.get(i));
        }
    }
    private void process(ScratchCard card){
        System.out.println("Card #" + card.getCardNum() + ": " + card.getNumWinners() + " winners.");
        if(card.getNumWinners() > 0){
            for(int i = 1; i <= card.getNumWinners(); ++i){
                int finalI = i;
                Optional<ScratchCard> copiedCard = cards.stream()
                        .filter(c -> c.getCardNum() == card.getCardNum() + finalI)
                        .findFirst();
                if(copiedCard.isPresent()){
                    cards.add(copiedCard.get());
                }
            }
        }
    }
}
