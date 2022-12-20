package springbook;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.sql.Connection;

@Configuration
public class DaoFactory {
    @Bean
    public UserDao userDao(){
        return new UserDao(connectionMaker());
    }
    @Bean
    public ConnectionMaker connectionMaker(){
        return new DConnectionMaker();
    }
}
