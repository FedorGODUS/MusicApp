package Andersen.SeqDemo.Rest;

import Andersen.SeqDemo.entities.Author;
import Andersen.SeqDemo.entities.Country;
import Andersen.SeqDemo.repo.AuthorRepository;
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

import java.util.List;

@CrossOrigin(origins = {
        "http://localhost"
}, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/author")
@Tags(
        value = {
                @Tag(name = "Авторы",
                        description = "Работа со авторами")
        }
)
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @Operation(summary = "Создание автора")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Автор загружен в систему",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @PostMapping()
    private void addAuthor(@RequestBody Andersen.SeqDemo.request.Author authorReq) {
        Author author = new Author();
        author.setDescription(authorReq.getDescription());
        author.setName(authorReq.getName());
        authorRepository.save(author);
    }

    @Operation(summary = "Получение всех авторов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Авторы загружены",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @GetMapping(path = "/all")
    private List<Author> getAll() {
        return (List<Author>) authorRepository.findAll();
    }
}
