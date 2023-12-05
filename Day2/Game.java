import java.util.ArrayList;
import java.util.List;

public class Game {
    List<Bag> bags;
    int id;

    public Game(int id){
        this.id = id;
        bags = new ArrayList<>();
    }

    public void addBag(Bag bag){
        this.bags.add(bag);
    }

    public List<Bag> getBags(){
        return bags;
    }

    public int getId(){
        return id;
    }
}
