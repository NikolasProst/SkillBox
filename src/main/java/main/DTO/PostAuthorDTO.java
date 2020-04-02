package main.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import main.JsonViews;
import main.services.UserService;

@Data
@AllArgsConstructor
@JsonView(JsonViews.idPost.class)
public class PostAuthorDTO {

    private int id;
    private String name;

}
