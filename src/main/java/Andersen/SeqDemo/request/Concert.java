package Andersen.SeqDemo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "концерт")
public class Concert {
    @Schema(description = "title")
    private String title;
    @Schema(description = "performer")
    private String performer;
    @Schema(description = "date")
    private String date;
    @Schema(description = "city")
    private String city;
}
