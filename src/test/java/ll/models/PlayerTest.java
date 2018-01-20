package ll.test.models;

import static org.hamcrest.Matchers.equalTo;

import org.junit.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.*;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.beans.factory.annotation.Autowired;
import static org.assertj.core.api.Assertions.*;
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureTestDatabase.Replace;
import ll.repositories.PlayerRepo;
import ll.models.Player;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class PlayerTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private PlayerRepo playerRepo;

    
    @Test
    public void saveAndGetPlayer() throws Exception {
        this.entityManager.persist(new Player("1234", "Bratislav Petrovic", "https://scontent.xx.fbcdn.net/v/t1.0-1/c12.12.155.155/s50x50/215243_1887081010100_2998764_n.jpg?oh=cb76dd26bd7de7704a89d9f815115479&oe=5AE93312"));
	Player player = this.playerRepo.findById("1234");
	assertThat(player.getName()).isEqualTo("Bratislav Petrovic");
	assertThat(player.getUrl()).isEqualTo("https://scontent.xx.fbcdn.net/v/t1.0-1/c12.12.155.155/s50x50/215243_1887081010100_2998764_n.jpg?oh=cb76dd26bd7de7704a89d9f815115479&oe=5AE93312");
	
    }
}
