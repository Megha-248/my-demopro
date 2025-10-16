package com.example.demo.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configure CORS mappings for the application
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        if (registry != null) {
            registry.addMapping("/**")       // Allow all endpoints
                    .allowedOrigins("*")     // Allow all origins (or specify frontend URL)
                    .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // Allowed HTTP methods
                    .allowedHeaders("*")     // Allow all headers
                    .allowCredentials(false) // Set true if using cookies/auth
                    .maxAge(3600);           // Cache preflight response for 1 hour
        }
    }
}


