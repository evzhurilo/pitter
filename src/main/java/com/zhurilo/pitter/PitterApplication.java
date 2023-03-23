package com.zhurilo.pitter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@Configuration
/*When using @ComponentScan, Spring searches for components that can be automatically created and managed by Spring.
These components can be classes annotated with @Component (or its descendants), such as @Service, @Repository,
@Controller, etc., as well as other components that can be created using @Configuration.
 */
@ComponentScan({
        "com.zhurilo.pitter.convertor",
        "com.zhurilo.pitter.controller",
        "com.zhurilo.pitter.service"
})
@EnableJpaRepositories(basePackages = "com.zhurilo.pitter.repository")
//allow spring to find repositories from repository package
@EntityScan(basePackages = "com.zhurilo.pitter.entities")
//allow spring to find entities from entity package
public class PitterApplication {

    public static void main(String[] args) {
        SpringApplication.run(PitterApplication.class, args);
    }

}
