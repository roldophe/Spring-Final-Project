package dev.radom.restaurant.api.user.web;

import dev.radom.restaurant.api.user.service.UserService;
import dev.radom.restaurant.utils.UpdateStatus;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/users")
public class UserController {
    private final UserService userService;

    @PostMapping
    public void createUser(@RequestBody CreateUserDto createUserDto) {
        userService.createUser(createUserDto);
    }

    @GetMapping
    public List<UserDto> findAllUsers() {
        return userService.findAllUser();
    }

    @GetMapping("/{uuid}")
    public UserDto findUserByUuid(@PathVariable String uuid) {
        return userService.findUserByUuid(uuid);
    }

    @DeleteMapping("/{uuid}")
    public void deleteUserByUuid(@PathVariable String uuid) {
        userService.deleteUserByUuid(uuid);
    }

    @PatchMapping("/{uuid}")
    public void updateUserByUud(@PathVariable String uuid, @RequestBody UpdateUserDto updateUserDto) {
        userService.updateUserByUuid(uuid, updateUserDto);
    }

    @PutMapping("role/{uuid}")
    public void updateRoleUserByUud(@PathVariable String uuid, @RequestBody UpdateUserRoleDto updateUserRoleDto) {
        userService.UpdateUserRoleByUuid(uuid, updateUserRoleDto);
    }

    @PutMapping("/username/{uuid}")
    public void updateUsernameByUud(@PathVariable String uuid, @RequestBody UpdateUserNameDto updateUserNameDto) {
        userService.UpdateUserNameByUuid(uuid, updateUserNameDto);
    }

    @GetMapping("/isDeleted")
    public List<UserDto> findAllUserIsDeleted() {
        return userService.findAllUserIsDeleted();
    }

    @PutMapping("/status/{uuid}")
    public void updateUserIsDeletedByUuid(@PathVariable String uuid, @RequestBody UpdateStatus updateStatus) {
        userService.updateUserIsDeletedByUuid(uuid, updateStatus.status());
    }
}
