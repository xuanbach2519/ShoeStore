package bach.shoestore.controller;

import bach.shoestore.Dto.ResponseDTO;
import bach.shoestore.Entity.Role;
import bach.shoestore.Service.RoleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(value = "/role")
public class RoleController {
    private RoleService roleService;
    @Autowired
    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }
    @GetMapping
    public List<Role> getAllColor() {
        return roleService.getAllRole();
    }
    @GetMapping(value = "/id")
    public Optional<Role> findRoleById(@RequestParam Integer roleId) {
        return roleService.findRoleById(roleId);
    }
    @GetMapping(value = "/name")
    public Role findRoleByName(@RequestParam String roleName) {
        return roleService.findRoleByName(roleName);
    }
    @PostMapping(value = "/add")
    public ResponseDTO addRole(@RequestParam String roleName){
        ResponseDTO response = new ResponseDTO();
        response = roleService.AddRole(roleName);
        return response;
    }
    @DeleteMapping(value = "/delete/{id}")
    public ResponseDTO deleteRole(@PathVariable(name = "id")Integer roleId) {
        ResponseDTO response = new ResponseDTO();
        response = roleService.DeleteRole(roleId);
        return response;
    }
}
