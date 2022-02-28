package Andersen.SeqDemo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "пользователь")
public class User {
    @Schema(description = "name")
    private String name;
    @Schema(description = "password")
    private String password;
    @Schema(description = "city")
    private String city;
}
