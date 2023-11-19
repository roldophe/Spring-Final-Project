package dev.radom.restaurant.api.user;

import dev.radom.restaurant.api.user.web.CreateUserDto;
import dev.radom.restaurant.api.user.web.UpdateUserDto;
import dev.radom.restaurant.api.user.web.UserDto;
import org.mapstruct.*;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "Spring")
public interface UserMapper {

    @Mapping(source = "roleIds", target = "roles", qualifiedByName = "mapRoleIdsToRoles")
    User fromCreateUserDto(CreateUserDto createUserDto);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void fromUpdateUserDto(@MappingTarget User user, UpdateUserDto updateUserDto);

    List<UserDto> toUserDtoList(List<User> users);

    @Mapping(source = "roles", target = "roles")
    UserDto toUserDto(User user);

    default List<String> mapRoles(Set<Role> roles) {
        return roles.stream()
                .map(Role::getName)
                .collect(Collectors.toList());
    }

    @Named("mapRoleIdsToRoles")
    default Set<Role> mapRoleIdsToRoles(Set<Integer> roleIds) {
        return roleIds.stream()
                .map(roleId -> {
                    Role role = new Role();
                    role.setId(roleId);
                    return role;
                })
                .collect(Collectors.toSet());
    }
}
