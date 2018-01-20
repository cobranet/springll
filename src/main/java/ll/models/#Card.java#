package ll.models;
import java.util.List;
import java.util.ArrayList;

public class Card {
    private static int[] cards = {
	0,0,0,0,1,
	1,2,2,2,3,3,
	3,4,5,6,7
    }; 
    private static String[] cardNames = {
	"Guard",
	"Priest",
	"Baron",
	"Handmaid",
	"Prince",
	"King",
	"Coutess",
	"Princess"
    };
    public static List<Card>  getAllCards(){
	List<Card> l = new ArrayList();
	for ( int i= 0 ; i < 16; i++){
	    l.add(new Card(i));
	}
	return l;
    }
    private int id;
    public int getId(){
	return id;
    }
    public String getName(){
	return Card.cardNames[cards[id]];
    }
    public String getImage(){
	return Card.cardNames[cards[id]].toLowerCase() + ".jpg";
    }
    public Card(int id){
	this.id= id;
    }

}
