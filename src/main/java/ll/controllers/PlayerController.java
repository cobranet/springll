package ll.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import ll.repositories.PlayerRepo;
import ll.models.Player;

import java.util.List;


@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class PlayerController {

    @Autowired
    private PlayerRepo playerRepo;


   
    
    @RequestMapping(value = "/player", method = RequestMethod.GET)
    public Player getPlayer(@RequestParam("id") String id) {
        return playerRepo.findById(id);
    }
    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public List<Player> getAllPlayers(){
	return playerRepo.findAll();
    }


    

    @RequestMapping(value = "/player", method = RequestMethod.POST)
    public Player registerPlayer(@RequestBody Player player)  {
        Player p =  playerRepo.findById(player.getId());
	if ( p != null ) {
	    return p;
	}
	playerRepo.save(player);
	return player;
    }

    

}
