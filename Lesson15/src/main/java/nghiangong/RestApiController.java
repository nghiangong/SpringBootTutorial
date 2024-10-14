package nghiangong;

import jakarta.annotation.PostConstruct;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/api/v1")
public class RestApiController {

    private List<Todo> todoList;

    // bạn còn nhớ @PostConstruct dùng để làm gì chứ?
    // nếu không nhớ, hãy coi lại bài viết Spring Boot #3 nhé
    @PostConstruct
    public void init() {
        todoList = IntStream.range(0, 10)
                .mapToObj(i -> new Todo("title-" + i, "detail-" + i))
                .collect(Collectors.toList());
    }

    /*
    phần path URL bạn muốn lấy thông tin sẽ để trong ngoặc kép {}
     */
    @GetMapping("/todo/{todoId}")
    public Todo getTodo(@PathVariable(name = "todoId") Integer todoId) {
        // @PathVariable lấy ra thông tin trong URL
        // dựa vào tên của thuộc tính đã định nghĩa trong ngoặc kép /todo/{todoId}
        return todoList.get(todoId);
    }
}