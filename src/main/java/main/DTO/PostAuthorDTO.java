package main.DTO;

import lombok.Data;
import main.services.UserService;

@Data
public class PostAuthorDTO {
    private UserService userService;

    private int id;
    private String name;

    public PostAuthorDTO(int id) {
        this.id = id;
        this.name = userService.getUserNameById(id);
    }

}
