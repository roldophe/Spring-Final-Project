package com.istad.restaurant.api.order.mapper;

import com.istad.restaurant.api.order.dto.CreateCrewDto;
import com.istad.restaurant.api.order.dto.CrewDto;
import com.istad.restaurant.api.order.dto.UpdateCrewDto;
import com.istad.restaurant.api.order.model.Crew;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CrewMapper {
    Crew fromCreateCrewDto(CreateCrewDto createCrewDto);

    void fromUpdateCrewDto(@MappingTarget Crew crew, UpdateCrewDto updateCrewDto);

    List<CrewDto> toCrewDtoList(List<Crew> crews);
    CrewDto toCrewDto(Crew crew);
}
