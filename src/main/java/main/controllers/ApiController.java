package main.controllers;

import com.fasterxml.jackson.annotation.JsonView;
import main.GeneralInfo;
import main.enums.PostViewMode;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {
    @GetMapping("/init")
    public ResponseEntity footer() {
        return new ResponseEntity(new GeneralInfo("DevPub",
                "Рассказы разработчиков",
                "+7 910 231-57-06",
                "ramanik32@mail.com",
                "Ромашов Николай",
                "2020"),
                HttpStatus.OK);
    }
}
