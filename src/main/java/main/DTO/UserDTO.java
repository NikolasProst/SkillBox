package main.DTO;

import lombok.Data;
import main.services.UserService;

@Data
public class UserDTO {
    private UserService userService;

    private int id;
    private String name;

    public UserDTO(int id) {
        this.id = id;
        this.name = userService.getUserNameById(id);
    }

}
