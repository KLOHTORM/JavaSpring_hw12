package properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "sql")
@Dat

public class SQLCommands {
    private String findAll;
    private String insertUser;
    private String deleteById;
    private String findById;
    private String updateUser;
}
