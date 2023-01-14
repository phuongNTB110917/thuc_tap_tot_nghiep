package com.example.webbookstore.config;

import com.example.webbookstore.security.jwt.AuthEntryPointJwt;
import com.example.webbookstore.security.jwt.AuthTokenFilter;
import com.example.webbookstore.service.impl.JwtAccountService;
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
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.core.http.converter.OAuth2AccessTokenResponseHttpMessageConverter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(
        // securedEnabled = true,
        // jsr250Enabled = true,
        prePostEnabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    JwtAccountService userDetailsService;

    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Bean
    public AuthTokenFilter authenticationJwtTokenFilter() {
        return new AuthTokenFilter();
    }

    @Override
    public void configure(AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception {
        authenticationManagerBuilder.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
    }

    @Bean(BeanIds.AUTHENTICATION_MANAGER)
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable()
                .exceptionHandling().authenticationEntryPoint(unauthorizedHandler).and()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
                .authorizeRequests().antMatchers("/api/auth/**").permitAll()
                .antMatchers("/api/test/**").permitAll()
                .antMatchers("/api/product/**").permitAll()
                .antMatchers("/api/product-category/**").permitAll()
                .antMatchers("/api/cart/**").permitAll()
                .antMatchers("/api/cart-detail/**").permitAll()
                .antMatchers("/api/order/**").permitAll()
                .antMatchers("/api/order-detail/**").permitAll()
                .antMatchers("/api/rate/**").permitAll()
                .antMatchers("/api/pay/**").permitAll()
//				.anyRequest()
//				.authenticated()
//				.and()
//				.oauth2Login()
//				.authorizationEndpoint()
//				.authorizationRequestRepository(cookieAuthorizationRequestRepository())
//				.and()
//				.redirectionEndpoint()
//				.and()
//				.userInfoEndpoint()
//				.oidcUserService(customOidcUserService)
//				.userService(customOAuth2UserService)
//				.and()
//				.tokenEndpoint()
//				.accessTokenResponseClient(authorizationCodeTokenResponseClient())
//				.and()
//				.successHandler(oAuth2AuthenticationSuccessHandler)
//				.failureHandler(oAuth2AuthenticationFailureHandler);
                .anyRequest().authenticated();
//			.and()
//				.oauth2Login()
//				.loginPage("/api/auth/signin")
//				.userInfoEndpoint()
//				.userService(oAuth2UserService)
//				.and()
//				.and()
//				.logout()
//				.permitAll();

        http.addFilterBefore(authenticationJwtTokenFilter(), UsernamePasswordAuthenticationFilter.class);
    }

}