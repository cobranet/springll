package ll.models;

import ll.models.Player;
import ll.models.Card;
import ll.models.Game;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationConfig;

public class GameForPlayer {

    private List<Player> otherPlayers;
    private List<Card> myCards;
    private List<List<Card>> playersDiscard;
    private Player me;
    private int onMove;
    private int myGameId;
    
    public int getOnMove(){
	return onMove;
    }

    public int getMyGameId(){
	return myGameId;
    }
    
    public List<Player> getOtherPlayers(){
	return otherPlayers;
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
    
    public Player getMe(){
	return me;
    }
    
    public GameForPlayer(int player, Game g){
	otherPlayers = new ArrayList<Player>();
	for (int i=0; i< g.getPlayers().size(); i++){
	    if( i != player ){
		otherPlayers.add(g.getPlayers().get(i));
	    } else {
		me = g.getPlayers().get(i);
	    }
	}
	myGameId = player;
	playersDiscard = g.getPlayersDiscard();
	onMove = g.getOnMove();
    }
}
