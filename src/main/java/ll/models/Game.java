package ll.models;

import ll.models.Player;
import ll.models.Card;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;


public class Game {
    
    private List<Player> players;
    private List<List<Card>> playersCard;
    private List<List<Card>> playersDiscard;
    private List<Card> deck;

    private int onMove;
    
    public static Game testGame(int[] cards ){
	Game game = new Game();
	game.setDeck(new ArrayList<Card>());
	for ( int i = 0; i < cards.length ; i++){
	    game.getDeck().add(new Card(cards[i]));
	}
	return game;
    }

    public List<List<Card>> getPlayersDiscard(){
	return playersDiscard;
    }

    public int getOnMove(){
	return onMove;
    }
    
    public Game(){
	players = new ArrayList<Player>();
	deck = new ArrayList<Card>(Card.getAllCards());
	Collections.shuffle(deck);
	playersCard = new ArrayList<List<Card>>();
	playersDiscard = new ArrayList<List<Card>>();
	onMove = 0;
    }


    public List<Player> getPlayers(){
	return players;
    }
    
    public void setDeck(List<Card> cards){
	deck = cards;
    }
    
    public List<Card>getDeck(){
	return deck;
    }
    public List<Card>getPlayerCards(int player){
	return playersCard.get(player);
    }

    public String json(){
	ObjectMapper mapper = new ObjectMapper();
	try { 
	    return mapper.writeValueAsString(this);
	} catch (Exception ex) {
	    ex.printStackTrace();
	    return "";
	}
    }
    public void dealToAll(){
	for(int i =0; i < players.size(); i++){
	    dealToPlayer(i);
	}
    }
    public void dealToPlayer(int player){
	Card c = deck.remove(0);
	playersCard.get(player).add(c);
    }

    public void discard(int player, int card){
	Card c = playersCard.get(player).remove(card);
	playersDiscard.get(player).add(c);
    }
    
    public void addPlayer(Player player){
        players.add(player);
	playersCard.add(new ArrayList<Card>());
	playersDiscard.add(new ArrayList<Card>());
    }
}
