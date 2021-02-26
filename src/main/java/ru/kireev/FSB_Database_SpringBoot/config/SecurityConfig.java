package ru.kireev.FSB_Database_SpringBoot.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import ru.kireev.FSB_Database_SpringBoot.service.UserService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserService userService;

//    @Override
//    public void configure(WebSecurity web) throws Exception {
//        web.ignoring().antMatchers("/static/**");
//    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        /*  Вход по умолчанию:
            Логин: Rita  Пароль: rita
            Логин: Vasya Пароль: vasya  */

        http
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/", "/authorization/newUser", "/h2-console/**", "/static/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .formLogin().loginPage("/authorization/login").permitAll()
                .defaultSuccessUrl("/people")
                .and().headers().frameOptions().disable()
                .and()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/authorization/logout", "POST"))
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID")
                .logoutSuccessUrl("/");
    }

    @Bean
    protected DaoAuthenticationProvider daoAuthenticationProvider() {
        DaoAuthenticationProvider daoAuthenticationProvider = new DaoAuthenticationProvider();
        daoAuthenticationProvider.setPasswordEncoder(new BCryptPasswordEncoder(12));
        daoAuthenticationProvider.setUserDetailsService(userService);
        return daoAuthenticationProvider;
    }

}
