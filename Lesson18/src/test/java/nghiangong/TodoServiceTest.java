package nghiangong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
public class TodoServiceTest {
    @MockBean
    TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @BeforeEach
    public void setUp() {
        Mockito.when(todoRepository.findAll())
                .thenReturn(LongStream.range(0, 10)
                        .mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                        .collect(Collectors.toList()));
    }

    @Test
    public void testCount() {
        assertEquals(10, todoService.countTodo());
    }
}
