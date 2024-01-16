package pl.management.app.management_app.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import pl.management.app.management_app.auth.resource.LoginSuccessHandler;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Autowired
    private UserDetailsService userDetailsService;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(encodePWD());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors();
        http.csrf().disable();

//        http.authorizeRequests()
//                .antMatchers("/auth/**").authenticated()
//                .antMatchers("/rest/**").authenticated()
//                .antMatchers("/auth/addUser").authenticated()
//                .antMatchers("/auth/showAllUsers").authenticated()
//                .antMatchers("*").fullyAuthenticated()
//                .antMatchers("/secure/**").hasAnyRole("ADMIN")
//                .anyRequest().permitAll()
//                .and()
//                .formLogin().successHandler(new LoginSuccessHandler()).permitAll()
//                .and().httpBasic();
//
    http.authorizeRequests()
            .antMatchers("/secure/auth/deleteUser/*").permitAll()
            .antMatchers("/secure/auth/showAllUsers").permitAll()
            .antMatchers("/secure/auth/addUser").permitAll()
            .antMatchers("/secure/**").hasAnyRole("ADMIN")
                .antMatchers("/auth/**", "/rest/**").authenticated()
                .anyRequest().permitAll()
                .and()
                .formLogin().successHandler(new LoginSuccessHandler()).permitAll()
                .and()
                .httpBasic();

    }



/*
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("dominik").password("{noop}123").roles("USER");
    }
*/
    @Bean
    public BCryptPasswordEncoder encodePWD() {

        return new BCryptPasswordEncoder();
    }
}
