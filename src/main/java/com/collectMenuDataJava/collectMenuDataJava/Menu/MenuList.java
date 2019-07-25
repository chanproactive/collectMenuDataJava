package com.collectMenuDataJava.collectMenuDataJava.Menu;

        import com.collectMenuDataJava.collectMenuDataJava.Model.Location;
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
//    @NotNull
//    private Location location;
    @NotNull
    private String lng;
    @NotNull
    private String lat;
    @NotNull
    private String category;
    @NotNull
    private String priceRange;
    @NotNull
    private String url;
    @NotNull
    private List<String> menuImageUrl;
    @NotNull
    private List<MenuListItem> menuList;





    public void setId(String id) {

    }}