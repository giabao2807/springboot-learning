package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    @Override
    public UserDetailsService userDetailsService(){

        //Tạo ra user trong bộ nhớ
        //lưu trữ, chỉ sử dụng cách này để minh hoạ
        //Thực tế sẽ kiểm tra trong csdl

        InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
        manager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("giabao")
                        .password("2807")
                        .roles("USER") //phân quyền người dùng
                        .build()
        );
        return manager;
    }

    @Override
    protected void configure(HttpSecurity http) throws  Exception{
        http.authorizeRequests()
                .antMatchers("/","home").permitAll() //cho phép tất cả mọi người truy cập vào 2 địa chỉ này
                .anyRequest().authenticated() //tất cả các request khác đều phải xác thực mới được truy cập
                .and()
                .formLogin() //cho phép người dùng xác thực bằng form login
                .defaultSuccessUrl("/hello")
                .permitAll() //tất cả đều được truy cập địa chỉ này
                .and()
                .logout() //cho phép logout
                .permitAll();
    }
}
