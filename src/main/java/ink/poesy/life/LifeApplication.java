package ink.poesy.life;

import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
@MapperScan("ink.poesy.life.dao")
public class LifeApplication {
//    private static final Logger logger = LoggerFactory.getLogger(LifeApplication.class);

    public static void main(String[] args) {
        log.info("项目启动了");
        SpringApplication.run(LifeApplication.class, args);
    }

}
