package pl.kurs.schooldiary.securitybasic;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;


//@Configuration
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {


        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        auth.inMemoryAuthentication()
                .withUser("zibi").password(encoder.encode("1234")).roles("USER")
                .and()
                .withUser("admin").password(encoder.encode("admin")).roles("ADMIN");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers(HttpMethod.GET,"/grades", "/grades/*").hasRole("USER")
                .antMatchers(HttpMethod.POST,"/grades", "/students", "/teachers").hasRole("ADMIN")
                .anyRequest().authenticated()
                .and().csrf().disable().httpBasic(); //wyłączenie ochrony przed atakami csrf (z włączoną chroną postman nie ogarnie tych rzadań, nie zautoryzuje wogóle nam użytkowników)
    }

    //jwt token

}
