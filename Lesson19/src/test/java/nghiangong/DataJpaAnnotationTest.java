package nghiangong;

import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.*;

@TestPropertySource("/test.properties")
@DataJpaTest
public class DataJpaAnnotationTest {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Autowired
    private EntityManager entityManager;
    @Autowired
    private TodoRepository todoRepository;

    @Test
    public void allComponentAreNotNull() {
        assertThat(dataSource).isNotNull();
        assertThat(jdbcTemplate).isNotNull();
        assertThat(entityManager).isNotNull();
        assertThat(todoRepository).isNotNull();
    }

    @Test
    public void testTodoRepositoryByCode() throws InterruptedException {

        Todo newTodo1 = new Todo(null, "Todo-1", "Detail-1");
        Todo newTodo2 = new Todo(null, "Todo-2", "Detail-2");

        todoRepository.save(newTodo1);
        todoRepository.save(newTodo2);

        assertThat(todoRepository.findAll()).hasSize(2);

        Todo tempTodo = todoRepository.findById(newTodo1.getId()).get();
        assertThat(tempTodo.getTitle()).isEqualTo("Todo-1");
    }

    @AfterEach
    public void clean() {
        todoRepository.deleteAll();
    }
}
