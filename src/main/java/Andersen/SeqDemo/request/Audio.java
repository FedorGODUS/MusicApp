package Andersen.SeqDemo.request;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Data
@Schema(description = "автор")
public class Audio {
    @Schema(description = "name")
    String name;
    @Schema(description = "authorName")
    String authorName;
}
