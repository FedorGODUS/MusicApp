package Andersen.SeqDemo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Schema(description = "страна")
public class Country {
    @Schema(description = "country name")
    private String countryName;
}
