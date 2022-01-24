package learn.note.springlearn.depend;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author WangWenLei
 * @DATE: 2020/11/4
 **/
@Configuration
public class ServiceConfig {

    @Bean
    public TransferService transferService(AccountRepository accountRepository){
        return new TransFerServiceImpl(accountRepository);
    }
}
