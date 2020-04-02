package main.DTO;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Data;
import main.JsonViews;

@Data
@AllArgsConstructor
@JsonView(JsonViews.post.class)
public class PostAuthorDTO {

    private int id;
    private String name;

}
