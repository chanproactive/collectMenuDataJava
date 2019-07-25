package com.collectMenuDataJava.collectMenuDataJava.Menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MenuService {
    private MenuRepository repository;

    @Autowired
    public MenuService(MenuRepository repository) {
        this.repository = repository;
    }

    public List<MenuList> retrieveMenu() {
        return repository.findAll();
    }

    public Optional<MenuList> retrieveMenu(String id) {
        return repository.findById(id);
    }

    public List<MenuList> retrieveMenuByName(String name) {
        return repository.findByName(name);
    }

    public MenuList createMenu(MenuList menuList) {
        return repository.save(menuList);
    }

    public Optional<MenuList> updateMenu(String id, MenuList menuList) {
        Optional<MenuList> menuOpt = repository.findById(id);
        if(!menuOpt.isPresent()) {
            return menuOpt;
        }
        menuList.setId(id);
        return Optional.of(repository.save(menuList));
    }

    public boolean deleteMenu(String id) {
        try {
            repository.deleteById(id);
            return true;
        }
        catch (Exception e) {
            return false;
        }
    }

}
