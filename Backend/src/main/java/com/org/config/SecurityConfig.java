package com.org.config;


import com.org.filter.JwtAuthFilter;
import com.org.service.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import static org.springframework.security.config.Customizer.withDefaults;


@EnableMethodSecurity
@EnableWebSecurity
@Configuration
@RequiredArgsConstructor
public class SecurityConfig {

    @Autowired
    private JwtAuthFilter authFilter;

    @Autowired
    CustomUserDetailsService customUserDetailService;

    @Bean
    public UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//		httpSecurity.csrf().disable().authorizeHttpRequests().requestMatchers("/api/**").permitAll().and()
//				.anyRequest().authenticated().and()
//				.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and()
//				.authenticationProvider(authenticationProvider())
//				.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
//
//		return httpSecurity.build();
//
//	}
//
//	private static final String[] AUTH_WHITELIST = { "/api/v1/auth/**", "/v3/api-docs/**", "/v3/api-docs.yaml",
//			"/swagger-ui/**", "/swagger-ui.html", "/login", "/register", "/authenticate", "/guest/**" };
//
//	@Bean
//	public AuthenticationProvider authenticationProvider() {
//		DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
//		authenticationProvider.setUserDetailsService(userDetailsService());
//		authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
//		return authenticationProvider;
//	}

        http = http.csrf(csrf -> csrf.disable());

        http = http.sessionManagement(management -> management
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        http = http.exceptionHandling(handling -> handling
                .authenticationEntryPoint((request, response, exception) -> {
                    response.sendError(HttpServletResponse.SC_UNAUTHORIZED, exception.getMessage());
                }));

        //http.authenticationProvider(configure());

        http
                .authorizeHttpRequests((auth) -> auth
                        .requestMatchers(AUTH_WHITELIST)
                        .permitAll()
                        .requestMatchers("/api/user/roles").hasRole("admin")
                        .requestMatchers("/api/location/add").hasRole("admin")
                        .requestMatchers("/api/hotel/review/add").hasRole("customer")
                        .requestMatchers("/api/hotel/add").hasRole("admin")
                        .requestMatchers("/api/facility/add").hasRole("admin")
                        .requestMatchers("/api/facility/hotel/add").hasRole("admin")
                        .requestMatchers("/api/book/hotel/update/status").hasRole("admin")



                        .anyRequest().authenticated())
                .formLogin(withDefaults());

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        // .httpBasic(withDefaults());
        return http.build();
    }
    private static final String[] AUTH_WHITELIST = { "/api/v1/auth/**", "/v3/api-docs/**", "/v3/api-docs.yaml",
            "/swagger-ui/**", "/swagger-ui.html", "/api/user/login","/api/user/register"};

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailService).passwordEncoder(bCryptPasswordEncoder());
    }
    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(bCryptPasswordEncoder());
        return authenticationProvider;
    }

}

/*
@Order(1)
@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    private JwtFilter authFilter;

    @Bean
    //authentication
    public UserDetailsService userDetailsService() {
//        UserDetails admin = User.withUsername("Basant")
//                .password(encoder.encode("Pwd1"))
//                .roles("ADMIN")
//                .build();
//        UserDetails user = User.withUsername("John")
//                .password(encoder.encode("Pwd2"))
//                .roles("USER","ADMIN","HR")
//                .build();
//        return new InMemoryUserDetailsManager(admin, user);
        return new UserInfoUserDetailsService();
    }

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//         http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers("/login","/register/user").permitAll()
//                .and()
//                .authorizeHttpRequests().requestMatchers("get/seller/**").hasRole("ADMIN")
//                .and()
//                .httpBasic();

//    	http.csrf().disable()
//        .authorizeHttpRequests().requestMatchers("/register/user","/add/seller","/add/product/{id}").permitAll().and()
//        .authorizeHttpRequests().
//        requestMatchers("api-seller/get","/placeorder/{ids}",
//        		"/add/order","/register/customer","api-admin/getCustomer","api-admin/getAllOrderProduct")
//        .hasRole("ADMIN").and()
//        .httpBasic();
        http.csrf().disable()
                .authorizeHttpRequests().requestMatchers("api-all/**","/authenticate").permitAll().and()
                .authorizeHttpRequests().requestMatchers("api-customer/**").hasRole("CUSTOMER").and()
                .authorizeHttpRequests().requestMatchers("api-admin/**").hasRole("ADMIN").and()
                .authorizeHttpRequests().requestMatchers("api-order/**").hasAnyRole("ADMIN","CUSTOMER").and()
                .authorizeHttpRequests().requestMatchers("/api-seller/**").hasRole("SELLER").and()
                .httpBasic().and()
                .sessionManagement()
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authenticationProvider(authenticationProvider())
                .addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);

        return http.build();

//        return http.build();
    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider(){
        DaoAuthenticationProvider authenticationProvider=new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService());
        authenticationProvider.setPasswordEncoder(passwordEncoder());
        return authenticationProvider;
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception {
        return config.getAuthenticationManager();
    }

}
*/
