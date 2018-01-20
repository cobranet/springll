package ll.models;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;


@Entity
public class Player  {
    @Id
    private String id;
    private String name;
    private String url;


    public String getId() {
	return id;
    }
    
    public void setId(String id){
	this.id = id;
    }

    public String getName(){
	return name;
    }
    @Column(length = 32000)
    public  String getUrl(){
	return url;
    }
    public Player (){
    }
    public Player (String id, String name , String url){
	this.id = id;
	this.name = name;
	this.url = url;
    }
    
    
}
