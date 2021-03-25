package campaignconfigurator.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;import org.springframework.security.config.annotation.method.configuration.EnableReactiveMethodSecurity;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.zalando.problem.spring.webflux.advice.security.SecurityProblemSupport;

@EnableWebFluxSecurity
@EnableReactiveMethodSecurity
@Import(SecurityProblemSupport.class)
public class SecurityConfiguration {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        return http
            .csrf()
            .disable()
            .authorizeExchange()
            .pathMatchers("/**").permitAll()
            .and().build();
    }

}

