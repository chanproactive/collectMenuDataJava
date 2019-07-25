package com.collectMenuDataJava.collectMenuDataJava.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/menu")
public class MenuController {
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
        return ResponseEntity.status(HttpStatus.CREATED).body(menuList);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> putMenus(@PathVariable String id, @RequestBody MenuList body) {
        Optional<?> menu = menuService.updateMenu(id, body);
        return ResponseEntity.ok(menu);
    }
}
