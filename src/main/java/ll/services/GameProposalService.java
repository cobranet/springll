package ll.services;

import ll.repositories.GameProposalRepo;
import ll.models.GameProposal;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;

import java.util.List;

@Service
@Configurable
@Component
public class GameProposalService {
    @Autowired
    private GameProposalRepo proposalRepo;

    public List<GameProposal> getOpenGames(){
	List<GameProposal> openGames =  proposalRepo.findByState("PROPOSAL");
	return openGames;
    }
}

