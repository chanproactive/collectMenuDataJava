package com.collectMenuDataJava.collectMenuDataJava.Menu;

import com.collectMenuDataJava.collectMenuDataJava.tools.CloudVision;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import java.util.List;
import java.util.Optional;

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
    @Autowired
    private MenuService menuService;

    @GetMapping()
    public ResponseEntity<?> getMenus() {
        List<MenuList> menuLists = menuService.retrieveMenu();
        return ResponseEntity.ok(menuLists);
    }


    @GetMapping("/{id}")
    public ResponseEntity<?> getMenu(@PathVariable String id) {
        Optional<?> menu = menuService.retrieveMenu(id);
        if (!menu.isPresent()) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(menu);
    }

    @PostMapping()
    public ResponseEntity<?> postMenus(@RequestBody MenuList body) {
        MenuList menuList = menuService.createMenu(body);
        CloudVision cloud = new CloudVision();
        cloud.request(menuList.getImageBase64());

        return ResponseEntity.status(HttpStatus.CREATED).body(menuList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMenus(@PathVariable String id, @RequestBody MenuList body) {
        Optional<?> menu = menuService.updateMenu(id, body);
        return ResponseEntity.ok(menu);
    }
}
