package Andersen.SeqDemo.Rest;

import Andersen.SeqDemo.entities.Country;
import Andersen.SeqDemo.entities.User;
import Andersen.SeqDemo.repo.CountryRepository;
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
@RequestMapping("/api/v1/country")
@Tags(
        value = {
                @Tag(name = "Страны",
                        description = "Работа со странами")
        }
)
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @Operation(summary = "Создание страны")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Страна загружена в систему",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @PostMapping()
    private void addCity(@RequestBody Andersen.SeqDemo.request.Country countryReq) {
        Country country = new Country();
        country.setCountryName(countryReq.getCountryName());
        countryRepository.save(country);
    }

    @Operation(summary = "Получение всех стран")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Страны загружены",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @GetMapping(path = "/all")
    private List<Country> getAll() {
        return (List<Country>) countryRepository.findAll();
    }
}
