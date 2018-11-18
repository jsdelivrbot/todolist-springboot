package todolist.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class WebsiteConfig implements WebMvcConfigurer {

    private static final String[] CLASSPATH_RESOURCE_LOCATIONS = {
            "classpath:/META-INF/resources/", "classpath:/resources/",
            "classpath:/static/", "classpath:/public/" };

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
      
            registry.addResourceHandler(
                    "/webjars/**",
                    "/images/**",
                    "/css/**",
                    "/js/**")
                    .addResourceLocations(
                            "classpath:/META-INF/resources/webjars/",
                            "classpath:/static/images/",
                            "classpath:/static/css/",
                            "classpath:/static/js/");
        //  registry.addResourceHandler("/**")
       //         .addResourceLocations(CLASSPATH_RESOURCE_LOCATIONS)
                
    }
}