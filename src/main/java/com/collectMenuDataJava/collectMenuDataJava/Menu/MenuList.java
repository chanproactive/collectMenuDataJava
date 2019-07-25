package com.collectMenuDataJava.collectMenuDataJava.Menu;

import lombok.Data;
import org.springframework.data.annotation.Id;
import javax.validation.constraints.NotNull;
import java.util.List;

@Data
public class MenuList {
    @Id
    private String id;
    @NotNull
    private String name;
    @NotNull
    private String imageUrl;
    @NotNull
    private String imageBase64;


    public void setId(String id) {

    }
}