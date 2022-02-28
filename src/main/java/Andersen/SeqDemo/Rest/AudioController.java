package Andersen.SeqDemo.Rest;

import Andersen.SeqDemo.entities.Author;
import Andersen.SeqDemo.music.Player;
import Andersen.SeqDemo.request.Audio;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;

@CrossOrigin(origins = {
        "http://localhost"
}, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/audio")
@Tags(
        value = {
                @Tag(name = "Аудио",
                        description = "Работа с аудио")
        }
)
public class AudioController {
    @Autowired
    private Player player;

    @Operation(summary = "Создание аудио")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Аудио загружено в систему",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @PostMapping("/add")
    private String addAudio(@RequestParam("file") MultipartFile file, @RequestParam("audio") String audioAuthor) throws UnsupportedAudioFileException, IOException {
        return player.addMusic(audioAuthor, file);
    }

    @Operation(summary = "Воспроизведение аудио")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Аудио воспроизведено",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @GetMapping("/play")
    private void play(@RequestParam("audio") String audio) throws IOException {
        player.play(audio);
    }
}
