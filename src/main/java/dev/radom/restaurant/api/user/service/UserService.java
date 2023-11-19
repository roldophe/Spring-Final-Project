package dev.radom.restaurant.api.user.service;
import dev.radom.restaurant.api.user.web.*;

import java.util.List;

public interface UserService {

    void createUser(CreateUserDto createUSerDto);
    void updateUserByUuid(String uuid, UpdateUserDto updateUserDto);
    void updateUserIsDeletedByUuid(String uuid, Boolean updateIsDeleted);
    void UpdateUserRoleByUuid(String uuid, UpdateUserRoleDto updateUserRoleDto);
    void UpdateUserNameByUuid(String uuid, UpdateUserNameDto updateUserNameDto);
    void deleteUserByUuid(String uuid);
    UserDto findUserByUuid(String uuid);
    List<UserDto> findAllUser();
    List<UserDto> findAllUserIsDeleted();
}
