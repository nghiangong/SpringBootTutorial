package nghiangong;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.*;

@TestPropertySource("/test.properties")
@DataJpaTest
public class SqlAnnotationTest {
    @Autowired
    private TodoRepository todoRepository;

    @Test
    @Sql("/createTodo.sql")
    public void testTodoRepositoryBySqlSchema() {
        assertThat(todoRepository.findAll()).hasSize(2);
        assertThat(todoRepository.findById(1).getTitle()).isEqualTo("Todo-1");
    }

    @AfterEach
    public void clean() {
        todoRepository.deleteAll();
    }

}