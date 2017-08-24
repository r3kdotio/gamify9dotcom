package io.r3k.gamify9dotcom;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

//@EnableWebSecurity
public class WebSecurityConfig {}
//extends WebSecurityConfigurerAdapter {
//  @Override
//  public void configure(WebSecurity web) throws Exception {
//    web
//      .ignoring()
//         .antMatchers("/api/**"); // #3
//  }
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .headers()
//                .frameOptions().sameOrigin()
//                //enable https://docs.spring.io/spring-security/site/docs/current/reference/html/headers.html#headers-hsts
//                .httpStrictTransportSecurity();
//    }
//    
//    
//    
//}
