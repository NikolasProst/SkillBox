package main.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class GeneralInfo {
    private String title;
    private String subTitle;
    private String email;
    private String phone;
    private String copyright;
    private String copyrightFrom;
}
