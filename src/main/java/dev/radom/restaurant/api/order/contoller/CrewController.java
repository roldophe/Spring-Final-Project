package dev.radom.restaurant.api.order.contoller;

import dev.radom.restaurant.api.order.dto.CreateCrewDto;
import dev.radom.restaurant.api.order.dto.CrewDto;
import dev.radom.restaurant.api.order.dto.UpdateCrewDto;
import dev.radom.restaurant.api.order.service.CrewService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/v1/crews")
@RequiredArgsConstructor
@RestController
public class CrewController {
    private final CrewService crewService;

    @GetMapping
    public List<CrewDto> getCrewDtos() {
        return crewService.getAllCrews();
    }

    @GetMapping("/{uuid}")
    public CrewDto getCrewByUuid(@PathVariable String uuid) {
        return crewService.getCrewByUuid(uuid);
    }

    @PutMapping("/{uuid}")
    @ResponseStatus(HttpStatus.OK)
    public void updateCrewByUuid(@PathVariable String uuid
            , @RequestBody UpdateCrewDto updateCrewDto) {
        crewService.updateCrewByUuid(uuid, updateCrewDto);
    }

    @DeleteMapping("/{uuid}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCrewByUuid(@PathVariable String uuid) {
        crewService.deleteCrewBUuid(uuid);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    void createCrew(@RequestBody @Valid CreateCrewDto createCrewDto) {
        crewService.createCrew(createCrewDto);
    }
}
