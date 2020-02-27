package main.controllers;

import main.GeneralInfo;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiGeneralController {
    @GetMapping("/init")
    public ResponseEntity header() {
        return new ResponseEntity(new GeneralInfo("DevPub",
                "Рассказы разработчиков",
                "+7 910 231-57-06",
                "ramanik32@mail.com",
                "Ромашов Николай",
                "2020"),
                HttpStatus.OK);
    }
}
