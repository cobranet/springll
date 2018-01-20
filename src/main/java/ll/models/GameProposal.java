package ll.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;

@Entity
public class GameProposal {

    private static String[] states = {
	"PROPOSAL",
	"IN_PLAY",
	"FINSED",
	"TRAHSED"
    };
	
    
    @Id
    @GeneratedValue
    private Integer id;

    private String ownerId;

    private String state;

    public Integer getId(){
	return id;
    }

    public String getOwnerId() {
	return ownerId;
    }

    public String getState(){
	return state;
    }

    public void setState(String state){
	this.state = state;
    }

    public void setOwnerId(String ownerId){
	this.ownerId = ownerId;
    }
    
    public GameProposal(){
	
    }
    
    
}
