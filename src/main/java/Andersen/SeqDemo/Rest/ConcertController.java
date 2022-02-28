package Andersen.SeqDemo.Rest;

import Andersen.SeqDemo.entities.City;
import Andersen.SeqDemo.entities.Concert;
import Andersen.SeqDemo.entities.Country;
import Andersen.SeqDemo.repo.CityRepository;
import Andersen.SeqDemo.repo.ConcertRepository;
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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

@CrossOrigin(origins = {
        "http://localhost"
}, allowCredentials = "true")
@RestController
@RequestMapping("/api/v1/concert")
@Tags(
        value = {
                @Tag(name = "Концерты",
                        description = "Работа с концертами")
        }
)
public class ConcertController {
    @Autowired
    private ConcertRepository concertRepository;
    @Autowired
    private CityRepository cityRepository;
    private final SimpleDateFormat formatter = new SimpleDateFormat("dd-M-yyyy hh:mm:ss a", Locale.ENGLISH);

    @Operation(summary = "Создание концерта")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Концерт загружен в систему",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @PostMapping()
    private void addConcert(@RequestBody Andersen.SeqDemo.request.Concert concertReq) throws ParseException {
        Concert concert = new Concert();
        concert.setPerformer(concertReq.getPerformer());
        concert.setTitle(concertReq.getTitle());
        concert.setDate(formatter.parse(concertReq.getDate()));
        Optional<City> city = cityRepository.findCityByCityName(concertReq.getCity());
        city.ifPresent(concert::setCity);
        concertRepository.save(concert);
    }

    @Operation(summary = "Получение всех авторов")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Авторы загружены",
                    content = {@Content(mediaType = MediaType.APPLICATION_JSON_VALUE,
                            schema = @Schema(implementation = String.class))}),
    })
    @GetMapping(path = "/all")
    private List<Concert> getAll() {
        return (List<Concert>) concertRepository.findAll();
    }

}
