package com.collectMenuDataJava.collectMenuDataJava.Menu;

import com.collectMenuDataJava.collectMenuDataJava.respondModel.ResponseModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.ArrayList;
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

    @GetMapping(params = "name")
    public ResponseEntity<?> getMenus(@RequestParam String name) {
        List<MenuList> menuLists = menuService.retrieveMenuByName(name);
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
        ArrayList<Integer> tag = new ArrayList<Integer>();
        tag.add(1);
        tag.add(8);
        ResponseModel responseModelKotlin = new ResponseModel();
        responseModelKotlin.setPrice("123");
        responseModelKotlin.setPrice("459");
        String redp = "[\n" +
                "  {\n" +
                "    \"menuName\": \"ข้าวต้มกุ้ง\",\n" +
                "    \"MenuImageUrl\": \"https://img.wongnai.com/p/1920x0/2013/04/17/84e31e975cac4ea2be1625f7374dc9ef.jpg\",\n" +
                "    \"price\":\"50\",\n" +
                "    \"spicy\": 0,\n" +
                "    \"rating\": 5,\n" +
                "    \"tag\": [8,3]\n" +
                "  },\n" +
                "  {\n" +
                "    \"menuName\": \"ข้าวต้มหมู\",\n" +
                "    \"MenuImageUrl\": \"https://img.wongnai.com/p/1920x0/2013/04/17/ffe9226bbab04515983d84c6575890d9.jpg\",\n" +
                "    \"price\":\"40\",\n" +
                "    \"spicy\": 1,\n" +
                "    \"rating\": 4,\n" +
                "    \"tag\": [8,3]\n" +
                "  }\n" +
                "]";
        return ResponseEntity.status(HttpStatus.CREATED).body(responseModelKotlin);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMenus(@PathVariable String id, @RequestBody MenuList body) {
        Optional<?> menu = menuService.updateMenu(id, body);
        return ResponseEntity.ok(menu);
    }
}
