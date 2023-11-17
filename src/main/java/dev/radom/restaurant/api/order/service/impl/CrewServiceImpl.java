package dev.radom.restaurant.api.order.service.impl;

import dev.radom.restaurant.api.order.dto.CreateCrewDto;
import dev.radom.restaurant.api.order.dto.CrewDto;
import dev.radom.restaurant.api.order.dto.UpdateCrewDto;
import dev.radom.restaurant.api.order.mapper.CrewMapper;
import dev.radom.restaurant.api.order.model.Crew;
import dev.radom.restaurant.api.order.repository.CrewRepository;
import dev.radom.restaurant.api.order.service.CrewService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.UUID;

@Slf4j
@Service
@RequiredArgsConstructor
public class CrewServiceImpl implements CrewService {
    private final CrewMapper crewMapper;
    private final CrewRepository crewRepository;

    @Transactional
    @Override
    public void createCrew(CreateCrewDto createCrewDto) {
        boolean exist = crewRepository.
                existsCrewByFirstNameAndLastNameAndDob(createCrewDto.firstName(), createCrewDto.lastName(), createCrewDto.dob());
        if (exist) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Crew already exists.");
        }
        Crew crew = crewMapper.fromCreateCrewDto(createCrewDto);
        crew.setUuid(UUID.randomUUID().toString());
        crew.setAge(Period.between(crew.getDob(), LocalDate.now()).getYears());
        crew.setIsWorking(true);
        crewRepository.save(crew);
    }

    @Transactional
    @Override
    public void updateCrewByUuid(String uuid, UpdateCrewDto updateCrewDto) {
        Crew isFound = crewRepository.findCrewByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Crew uuid %s dost not exist in db!", uuid)));
        crewMapper.fromUpdateCrewDto(isFound, updateCrewDto);
        crewRepository.save(isFound);
    }

    @Override
    public void deleteCrewBUuid(String uuid) {
        Crew isFound = crewRepository.findCrewByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Crew uuid %s dost not exist in db!", uuid)));
        crewRepository.delete(isFound);
    }

    @Override
    public CrewDto getCrewByUuid(String uuid) {
        Crew isFound = crewRepository.findCrewByUuid(uuid)
                .orElseThrow(() ->
                        new ResponseStatusException(HttpStatus.NOT_FOUND,
                                String.format("Crew uuid %s dost not exist in db!", uuid)));
        return crewMapper.toCrewDto(isFound);
    }

    @Override
    public List<CrewDto> getAllCrews() {
        return crewMapper.toCrewDtoList(crewRepository.findAll());
    }
}
