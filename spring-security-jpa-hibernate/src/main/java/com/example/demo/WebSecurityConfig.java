package com.example.demo;

import com.example.demo.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    @Bean
    public PasswordEncoder passwordEncoder(){
        //Password encoder, để Spring Security sử dụng mã hoá mật khẩu người dùng
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService) //cung cap userService cho spring security
                .passwordEncoder(passwordEncoder()); //cung cap password encoder
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.authorizeRequests()
                .antMatchers("/","/home").permitAll() //cho phép tất cả truy cập vào home
                .anyRequest().authenticated() //tất cả các request khác đều cần xác thực
                .and()
                .formLogin() //cho phép người dùng xác thực bằng form login
                .defaultSuccessUrl("/hello")
                .permitAll() //tất cả đều được  truy cập địa chỉ này
                .and()
                .logout()
                .permitAll();
    }
}
