package com.example.project_h_shop.security;


import com.example.project_h_shop.security.jwt.CustomAccessDeniedHandler;
import com.example.project_h_shop.security.jwt.JwtAuthenticationFilter;
import com.example.project_h_shop.security.jwt.RestAuthenticationEntryPoint;
import com.example.project_h_shop.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig extends WebSecurityconfigurerA{


    @Autowired
    private UserService userService;

    @Bean
    public JwtAuthenticationFilter jwtAuthenticationFilter() {
        return new JwtAuthenticationFilter();
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Bean
    public RestAuthenticationEntryPoint restServicesEntryPoint() {
        return new RestAuthenticationEntryPoint();
    }

    @Bean
    public CustomAccessDeniedHandler customAccessDeniedHandler() {
        return new CustomAccessDeniedHandler();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }


    @Autowired
    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(new BCryptPasswordEncoder(10));
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().ignoringAntMatchers("/**");
        http.httpBasic().authenticationEntryPoint(restServicesEntryPoint());
        http.authorizeRequests()
                .antMatchers("/login", "/register", "/**").permitAll()
//                .antMatchers("/users/**").permitAll()
//                .antMatchers("/bills/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/bills/**").access("hasRole('ROLE_OWNER')")
//                .antMatchers("/historybills/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/historybills/**").access("hasRole('ROLE_OWNER')")
//                .antMatchers("/homes/delete/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/homes/restore/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/homes/findValid/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers("/homes/*").access("hasRole('ROLE_ADMIN')")
//                .antMatcher7s("/images/**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_OWNER')")


//                .antMatchers("/users/**").access("hasRole('ROLE_USER')")
//                .antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.GET
//                        ).access("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.DELETE, "/categories",
//                        "/typeOfQuestions",
//                        "/questions",
//                        "/answers",
//                        "/quizzes",
//                        "/hello").access("hasRole('ROLE_ADMIN')")
//                .antMatchers(HttpMethod.PUT, "/users")
//                .access("hasRole('ROLE_USER')")
                .anyRequest().authenticated()
                .and().csrf().disable()
                .logout().logoutRequestMatcher(new AntPathRequestMatcher("/logout"));
        http.addFilterBefore(jwtAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class)
                .exceptionHandling().accessDeniedHandler(customAccessDeniedHandler());
        http.sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.cors();
    }
}
