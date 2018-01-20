package ll.repositories;

import ll.models.Player;
import java.util.List;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PlayerRepo extends PagingAndSortingRepository<Player,Long> {
    public Player findById(String id);
    public List<Player> findAll();
    public int deleteById(String id);
}
    
    
