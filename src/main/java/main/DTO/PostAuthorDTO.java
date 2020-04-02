package main.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import main.services.UserService;

@Data
@AllArgsConstructor
public class PostAuthorDTO {

    private int id;
    private String name;

}
