package nghiangong;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.stream.Collectors;
import java.util.stream.LongStream;

@ExtendWith(SpringExtension.class)
@WebMvcTest(TodoRestController.class)
public class TodoRestControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private TodoService todoService;

    @Test
    public void testFindAll() throws Exception {
        // Tạo ra một List<Todo> 10 phần tử
        Mockito.when(todoService.getAll())
                .thenReturn(LongStream.range(0, 10)
                        .mapToObj(i -> new Todo(i, "title-" + i, "detail-" + i))
                        .collect(Collectors.toList()));

        mvc.perform(MockMvcRequestBuilders.get("/api/v1/todo")
                        .contentType(MediaType.APPLICATION_JSON)) // Thực hiện GET REQUEST
                .andExpect(status().isOk()) // Mong muốn Server trả về status 200
                .andExpect(jsonPath("$.length()").value(10)) // Hi vọng server trả về List độ dài 10
                .andExpect(jsonPath("$[0].id").value(0)) // Hi vọng phần tử trả về đầu tiên có id = 0
                .andExpect(jsonPath("$[0].title").value("title-0")) // Hi vọng phần tử trả về đầu tiên có title = "title-0"
                .andExpect(jsonPath("$[0].detail").value("detail-0"));
    }
}
