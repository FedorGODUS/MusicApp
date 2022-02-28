package Andersen.SeqDemo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "город")
public class City {
    @Schema(description = "city name")
    private String cityName;
    @Schema(description = "country")
    private String country;
}
