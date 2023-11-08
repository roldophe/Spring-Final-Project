package com.istad.restaurant.api.order.service;

import com.istad.restaurant.api.order.dto.CreateCrewDto;
import com.istad.restaurant.api.order.dto.CrewDto;
import com.istad.restaurant.api.order.dto.UpdateCrewDto;

import java.util.List;

public interface CrewService {
    void createCrew(CreateCrewDto createCrewDto);

    void updateCrewByUuid(String uuid, UpdateCrewDto updateCrewDto);

    void deleteCrewBUuid(String uuid);

    CrewDto getCrewByUuid(String uuid);

    List<CrewDto> getAllCrews();
}
