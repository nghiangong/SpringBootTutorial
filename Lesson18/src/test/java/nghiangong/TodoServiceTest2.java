package nghiangong;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
public class TodoServiceTest2 {
    /**
     * Cách này sử dụng @TestConfiguration
     * Nó chỉ tạo ra Bean trong Context test này mà thôi
     * Tiết kiệm thời gian hơn khi sử dụng @SpringBootTest (vì phải load hết Bean lên mà không dùng đến)
     */

    @TestConfiguration
    public static class TodoServiceTest2Configuration {
        @Bean
        TodoService todoService() {
            return new TodoService();
        }
    }

    @MockBean
    TodoRepository todoRepository;

    @Autowired
    private TodoService todoService;

    @BeforeEach
    public void setUp() {
        when(todoRepository.findAll())
                .thenReturn(LongStream.range(0, 10)
                        .mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                        .collect(Collectors.toList()));
    }
    
    @Test
    public void testCount() {
        assertEquals(10, todoService.countTodo());
    }
}

