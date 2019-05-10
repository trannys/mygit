package com.lucq.autoconfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.authentication.Http403ForbiddenEntryPoint;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;

/**
 * Created by dell on 2019/4/19.
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Override
    public void configure(HttpSecurity http) throws Exception {
//        http
//
//                //设置不需要鉴权的目录
//                .authorizeRequests()
//                .antMatchers("/oauth/security/login").permitAll()//登录页合同信息
//                //除了以上资源，其它资源都需要鉴权才能访问
//                .anyRequest().authenticated();

        http.csrf().disable()
                .exceptionHandling().authenticationEntryPoint(
                new Http403ForbiddenEntryPoint())
                .and().authorizeRequests().anyRequest().authenticated()
                .and().httpBasic();

//        http.csrf().disable()
//                .exceptionHandling().authenticationEntryPoint(
//                new Http403ForbiddenEntryPoint())
//                .and().authorizeRequests()
//                .antMatchers("/oauth/security/login").permitAll()//登录页合同信息
//                .anyRequest().authenticated()
//                .and().httpBasic();

    }

}
