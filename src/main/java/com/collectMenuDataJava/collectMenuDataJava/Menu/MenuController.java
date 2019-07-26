package com.collectMenuDataJava.collectMenuDataJava.Menu;

import com.collectMenuDataJava.collectMenuDataJava.respondModel.ResponseModel;
import com.collectMenuDataJava.collectMenuDataJava.tools.CloudVision;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.ArrayList;

@RestController
@RequestMapping("/menu")
public class MenuController {
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**").allowedOrigins("*");
            }
        };
    }

    @PostMapping()
    public ResponseEntity<?> postMenus(@RequestBody MenuList body) {
        CloudVision cloud = new CloudVision();
        ArrayList<ResponseModel> respond =cloud.request(body.getImageBase64());

        return ResponseEntity.status(HttpStatus.CREATED).body(respond);
    }

}
