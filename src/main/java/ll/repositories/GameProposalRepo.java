package ll.repositories;

import ll.models.GameProposal;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.jpa.repository.Query;


public interface GameProposalRepo extends PagingAndSortingRepository<GameProposal,Long> {
    public GameProposal findById(String id);
    public List<GameProposal> findAll();
    public int deleteById(String id);
    List<GameProposal> findByState(String status);

}
	
	
