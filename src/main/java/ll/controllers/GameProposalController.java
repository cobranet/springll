package ll.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.lang.RuntimeException;

import ll.repositories.PlayerRepo;
import ll.repositories.GameProposalRepo;
import ll.models.GameProposal;
import ll.models.Player;

@CrossOrigin(origins = "http://localhost:8081")
@RestController
public class GameProposalController {
    @Autowired
    private GameProposalRepo gameProposalRepo;

    @Autowired
    private PlayerRepo playerRepo;

    

    @RequestMapping(value="/propose_game", method = RequestMethod.POST)
    public ResponseEntity proposeGame(@RequestBody Player player){
	Player owner =playerRepo.findById(player.getId());
	if (owner == null ) {
	    ExceptionResponse response = new ExceptionResponse();
	    response.setErrorCode("Not Found");
	    response.setErrorMessage("There is no player with id " + player.getId());
	    return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
	GameProposal gameProposal = new GameProposal();
	gameProposal.setState("PROPOSAL");
	gameProposal.setOwnerId(owner.getId());
	gameProposalRepo.save(gameProposal);
	return new ResponseEntity(gameProposal,HttpStatus.OK);
    }
}

