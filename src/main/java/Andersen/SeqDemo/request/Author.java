package Andersen.SeqDemo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "автор")
public class Author {
    @Schema(description = "name")
    private String name;
    @Schema(description = "description")
    private String description;
}
