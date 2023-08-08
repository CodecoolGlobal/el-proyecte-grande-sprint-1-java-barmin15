//package com.codecool.eventPlanner.controller.old;
//
//import com.codecool.eventPlanner.model.dto.LoginUserDTO;
//import com.codecool.eventPlanner.model.dto.NewUserDTO;
//import com.codecool.eventPlanner.model.dto.UserDTO;
//import com.codecool.eventPlanner.service.old.OldUserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//@CrossOrigin
//@RestController
//@RequestMapping("/user")
//public class OldUserController {
//
//    private final OldUserService userService;
//
//    @Autowired
//    public OldUserController(OldUserService userService) {
//        this.userService = userService;
//    }
//
//    @GetMapping("/{id}")
//    public UserDTO getUserById(@PathVariable int id){
//        return userService.getUserById(id);
//    }
//
//    @GetMapping("/current")
//    public UserDTO getCurrentUser(){
//        return userService.getCurrentUser();
//    }
//
//    @GetMapping("/all")
//    public List<UserDTO> getAllUsers(){
//        return userService.getAll();
//    }
//
//    @DeleteMapping("/delete")
//    public boolean deleteUser(@RequestBody int id) {
//        return userService.delete(id);
//    }
//
//    @PostMapping()
//    public boolean createUser(@RequestBody NewUserDTO userDTO){
//        return userService.createUser(userDTO);
//    }
//
////    @PostMapping("/login")
////    public boolean loginUser(@RequestBody String username, String password) {
////        return userService.isAllowed(username, password);
////    }
//
//    @PostMapping("/login")
//    public boolean loginUser(@RequestBody LoginUserDTO loginUserDTO) {
//        return userService.logInUser(loginUserDTO.username(), loginUserDTO.password());
//    }
//
//    @PutMapping("/update")
//    public boolean updateUser(@RequestBody UserDTO userDTO){
//        return userService.updateUser(userDTO);
//    }
//}
//
//
//
//
//
//
//
//
