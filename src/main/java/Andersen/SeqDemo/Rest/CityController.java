package Andersen.SeqDemo.Rest;

import Andersen.SeqDemo.entities.City;
import Andersen.SeqDemo.entities.Country;
import Andersen.SeqDemo.repo.CityRepository;
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
import java.util.Optional;

@CrossOrigin(origins = {
        "http://localhost"
}, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/city")
@Tags(
        value = {
                @Tag(name = "Города",
                        description = "Работа с городами")
        }
)
public class CityController {
    @Autowired
    private CityRepository cityRepository;
    @Autowired
    private CountryRepository countryRepository;

    @Operation(summary = "Создание города")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Город загружен в систему",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @PostMapping()
    private void addCountry(@RequestBody Andersen.SeqDemo.request.City cityReq) {
        City city = new City();
        city.setCityName(cityReq.getCityName());
        Optional<Country> country = countryRepository.findCountryByCountryName(cityReq.getCountry());
        country.ifPresent(city::setCountry);
        cityRepository.save(city);
    }

    @Operation(summary = "Получение всех городов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Города загружены",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @GetMapping(path = "/all")
    private List<City> getAll() {
        return (List<City>) cityRepository.findAll();
    }
}
