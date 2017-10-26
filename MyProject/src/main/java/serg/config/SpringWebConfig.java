package serg.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.UrlBasedViewResolver;
import org.springframework.web.servlet.view.tiles3.TilesConfigurer;
import org.springframework.web.servlet.view.tiles3.TilesView;

@EnableWebMvc
@Configuration
@ComponentScan({"serg"})
public class SpringWebConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("/static/");
    }
    
    @Bean
    public TilesConfigurer tilesConfigurer(){
	TilesConfigurer tilesConfigurer = new TilesConfigurer();
	tilesConfigurer.setDefinitions(new String[] {"/WEB-INF/views/**/tiles.xml"});
	tilesConfigurer.setCheckRefresh(true);
	return tilesConfigurer;
    }

    @Bean  
    public UrlBasedViewResolver urlBasedViewResolver() {  
        UrlBasedViewResolver resolver = new UrlBasedViewResolver(); 
        resolver.setViewClass(TilesView.class); 
        return resolver;  
    }
}
