package ll.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
@Entity
public class GameRecord  {

    @Id @GeneratedValue
    private String id;

    @Column(length = 32000)
    private String json;

    public String getId() {
	return id;
    }

    
    public void setId(String id){
	this.id = id;
    }

    public String getJson(){
	return json;
    }

    public GameRecord (){
    }

    
    
}
