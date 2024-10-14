package nghiangong;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Data
@Component
@PropertySource("application.yaml")
@ConfigurationProperties(prefix = "properties")
public class AppProperties {
    private String email;
    private String googleAnalyticsId;

    private List<String> authors;

    private Map<String, String> exampleMap;
}
