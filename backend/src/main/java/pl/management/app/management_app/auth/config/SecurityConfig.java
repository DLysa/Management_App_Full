package pl.management.app.management_app.auth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
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
        http
                .cors().and()
                .csrf().disable()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)
                .and()
                .authorizeRequests()
                .antMatchers("/rest/auth/logout").permitAll()
                .antMatchers("/rest/auth/userinfo").authenticated()
                .antMatchers("/rest/auth/userinfo").permitAll()
                .antMatchers("/secure/auth/deleteUser/*", "/secure/auth/showAllUsers", "/secure/auth/addUser")
                .permitAll()
                .antMatchers("/auth/**", "/rest/**").authenticated()
                .anyRequest().permitAll()

                .and()
                .formLogin().successHandler(new LoginSuccessHandler()).permitAll()
                .and()
                .httpBasic();
    }

        /*
    http.authorizeRequests()
            .antMatchers("/rest/auth/currentUser/*").permitAll()
            .antMatchers("/rest/auth/currentUser/").permitAll()
            .antMatchers("/rest/auth/currentUser").permitAll()
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
*/

    @Bean
    public BCryptPasswordEncoder encodePWD() {

        return new BCryptPasswordEncoder();
    }
}
