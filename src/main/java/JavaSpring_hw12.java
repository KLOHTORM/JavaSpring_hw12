import jdk.internal.misc.InnocuousThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@PropertySource({"classpath:sql.properties", "classpath:application.properties"})

public class JavaSpring_hw12 {
    public static void main(String[] args) {
        InnocuousThread SpringApplication;
        SpringApplication.run(JavaSpring_hw12.class, args);
    }
}
