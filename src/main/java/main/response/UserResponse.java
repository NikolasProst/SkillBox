package main.response;

import lombok.Data;
import main.services.UserService;

@Data
public class UserResponse {
    private UserService userService;

    private int id;
    private String name;

    public UserResponse(int id) {
        this.id = id;
        this.name = userService.getUserNameById(id);
    }

}
