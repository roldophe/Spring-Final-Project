package dev.radom.restaurant.api.user.service;

import dev.radom.restaurant.api.user.Role;
import dev.radom.restaurant.api.user.User;
import dev.radom.restaurant.api.user.UserMapper;
import dev.radom.restaurant.api.user.UserRepository;
import dev.radom.restaurant.api.user.web.*;
import dev.radom.restaurant.utils.RandomCode;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(CreateUserDto createUSerDto) {
        Boolean exists = userRepository.existsByUsernameOrEmail(createUSerDto.username(), createUSerDto.email());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username or email already exist!!");
        }
        User user = userMapper.fromCreateUserDto(createUSerDto);
        user.setUuid(UUID.randomUUID().toString());
        user.setIsVerified(false);
        user.setIsDeleted(false);
        user.setVerifiedCode(RandomCode.generateCode());
        user.setCreationAt(LocalDateTime.now());
        user.setUpdatedAt(LocalDateTime.now());

        userRepository.save(user);
    }

    @Override
    public void updateUserByUuid(String uuid, UpdateUserDto updateUserDto) {
        User isFound = userRepository.findUserByUuidAndIsDeletedFalse(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        Boolean exists = userRepository.existsByUsernameOrEmail(updateUserDto.username(), updateUserDto.email());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username or email already exist!!");
        }
        userMapper.fromUpdateUserDto(isFound, updateUserDto);
        isFound.setUpdatedAt(LocalDateTime.now());
        userRepository.save(isFound);
    }

    @Override
    public void UpdateUserRoleByUuid(String uuid, UpdateUserRoleDto updateUserRoleDto) {
        User isFound = userRepository.findUserByUuidAndIsDeletedFalse(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        Set<Role> updateUserRoles = userMapper.mapRoleIdsToRoles(updateUserRoleDto.roleIds());
        isFound.setRoles(updateUserRoles);
        isFound.setUpdatedAt(LocalDateTime.now());
        userRepository.save(isFound);
    }


    @Override
    public void UpdateUserNameByUuid(String uuid, UpdateUserNameDto updateUserNameDto) {
        User isFound = userRepository.findUserByUuidAndIsDeletedFalse(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        Boolean exists = userRepository.existsByUsername(updateUserNameDto.username());
        if (exists) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Username already exist!!");
        }
        isFound.setUsername(updateUserNameDto.username());
        userRepository.save(isFound);
    }

    @Override
    public void deleteUserByUuid(String uuid) {
        User isFound = userRepository.findUserByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        userRepository.delete(isFound);
    }

    @Override
    public UserDto findUserByUuid(String uuid) {
        User isFound = userRepository.findUserByUuidAndIsDeletedFalse(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        return userMapper.toUserDto(isFound);
    }

    @Override
    public List<UserDto> findAllUser() {
        return userMapper.toUserDtoList(userRepository.findUserByIsDeletedFalse());
    }

    @Override
    public List<UserDto> findAllUserIsDeleted() {
        return userMapper.toUserDtoList(userRepository.findUserByIsDeletedTrue());
    }

    @Override
    public void updateUserIsDeletedByUuid(String uuid, Boolean updateIsDeleted) {
        User isFound = userRepository.findUserByUuid(uuid).orElseThrow(
                () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Uuid does not exist!!"));
        isFound.setIsDeleted(updateIsDeleted);
        userRepository.save(isFound);
    }
}
