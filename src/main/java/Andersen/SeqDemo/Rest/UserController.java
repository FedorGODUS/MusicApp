package Andersen.SeqDemo.Rest;

import Andersen.SeqDemo.Model.Developer;
import Andersen.SeqDemo.entities.City;
import Andersen.SeqDemo.entities.User;
import Andersen.SeqDemo.repo.CityRepository;
import Andersen.SeqDemo.repo.UserRepository;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.tags.Tags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@CrossOrigin(origins = {
        "http://localhost"
}, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/user")
@Tags(
        value = {
                @Tag(name = "Пользователи",
                        description = "Работа с пользователями")
        }
)
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CityRepository cityRepository;

    @Operation(summary = "Получение всех пользователей")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователи загружены",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @GetMapping(path = "/all")
    private List<User> getAll() {
        return (List<User>) userRepository.findAll();
    }

    @Operation(summary = "Создание пользователя")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Пользователь загружен в систему",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @PostMapping()
    private void addUser(@RequestBody Andersen.SeqDemo.request.User userReq){
        User user = new User();
        user.setUsername(userReq.getName());
        user.setPassword(userReq.getPassword());
        Optional<City> city = cityRepository.findCityByCityName(userReq.getCity());
        city.ifPresent(user::setCity);
        userRepository.save(user);
    }
}
