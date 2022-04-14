package bach.shoestore.controller;

import bach.shoestore.Dto.ResponseDTO;
import bach.shoestore.Dto.UserDTO;
import bach.shoestore.Entity.User;
import bach.shoestore.Service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/user")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
    @GetMapping(value = "/active")
    public List<User> getAllUsersActive() {
        return userService.getAllUsersActive();
    }
    @GetMapping(value = "/costumer")
    public List<User> getAllCostumer() {
        return userService.getAllCostumer();
    }
    @GetMapping(value = "/admin")
    public List<User> getAllAdmin() {
        return userService.getAllAdmin();
    }
    @GetMapping(value = "/id")
    public Optional<User> findUserById(@RequestParam Integer id) {
        return userService.findUserById(id);
    }
    @GetMapping(value = "/name")
    public List<User> findUserByName(@RequestParam String fullName) {
        return userService.findUserByFullName(fullName);
    }
    @GetMapping(value = "/gender")
    public List<User> findUserByGender(@RequestParam String gender) {
        return userService.findUserByGender(gender);
    }
    @GetMapping(value = "/address")
    public List<User> findUserByAddress(@RequestParam String address) {
        return userService.findUserByAddress(address);
    }
    @GetMapping(value = "/phonenumber")
    public User findUserByPhoneNumber(@RequestParam String phoneNumber) {
        return userService.findUserByPhoneNumber(phoneNumber);
    }
    @GetMapping(value = "/email")
    public User findUserByEmail(@RequestParam String email) {
        return userService.findUserByEmail(email);
    }
    @GetMapping(value = "/role")
    public List<User> findUserByRole(@RequestParam String role) {
        return userService.findUserByRole(role);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addUser(@RequestBody UserDTO userDTO) {
        ResponseDTO response = new ResponseDTO();
        response = userService.AddUser(userDTO);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteUser(@PathVariable(name = "id") Integer id) {
        ResponseDTO response = new ResponseDTO();
        response = userService.DeleteUser(id);
        return response;
    }

    @PutMapping(value = "/update/{email}")
    public ResponseDTO updateUser(@RequestBody UserDTO userDTO, @PathVariable(name = "email") String email){
        ResponseDTO response = new ResponseDTO();
        response = userService.updateUser(userDTO, email );
        return response;
    }
}

