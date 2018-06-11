package com.armadillo.api.security.controller;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.armadillo.api.security.dao.PrivilegeRepository;
import com.armadillo.api.security.dao.RoleRepository;
import com.armadillo.api.security.dao.TemplateRepository;
import com.armadillo.api.security.dao.UserRepository;
import com.armadillo.api.security.model.Privilege;
import com.armadillo.api.security.model.Role;
import com.armadillo.api.security.model.Template;
import com.armadillo.api.security.model.User;


@RestController

@RequestMapping("/api")
	
public class UserController {
	


@Autowired
private UserRepository repository;

@Autowired
private PrivilegeRepository privilegeRepository;

@Autowired
private RoleRepository roleRepository;

@Autowired
private TemplateRepository templateRepository;

/*
@PostMapping(path="/users",consumes=MediaType.APPLICATION_JSON_VALUE)
public ResponseEntity<String> createUser(@RequestBody(required =false) User v ) {
	System.out.println("user");
	System.out.println(v);
	repository.save(v);
	return new ResponseEntity<>("body:"+v,HttpStatus.OK);
}
*/
@PostMapping(path="/users")
public String processJsonPostBody(@RequestBody User  body) {
	System.out.println(body);
	repository.save(body);
	return "done";
}


@GetMapping("users/all")
public List<User> getUsers() {
	List<User> users=repository.findAll();
	if (users.size()>0)
     	return users;
	else
		return null;
}

@PutMapping("/users/{id}")
public ResponseEntity<Object> updateUser(@RequestBody User user,@PathVariable String id){
	Optional<User> userOptional =repository.findById(id);
	if(!userOptional.isPresent())
		return ResponseEntity.notFound().build();
	user.setId(id);
	repository.save(user);
	return ResponseEntity.noContent().build();
}
@GetMapping("/users/{id}")
public ResponseEntity<Optional<User>> getUserById(@PathVariable String id){
	Optional<User> user =repository.findById(id);
	if(!user.isPresent())
		{return ResponseEntity.notFound().build();}
	else {return new ResponseEntity<>(user,HttpStatus.OK);}
}
@DeleteMapping("/users/{id}")
public String deleteUser(@PathVariable String id) {
	repository.deleteById(id);
	return "done";
}



/************************************************
 * ***Privilege	
 */
@PostMapping(path="/privileges")

	public Privilege createPrivilege(@RequestBody String name) {
		Privilege privilege=privilegeRepository.findByName(name);
		if(privilege ==null) {
		 privilege = new Privilege();
		 privilege.setName(name);
		 privilegeRepository.save(privilege);
		}
		return privilege;
		
	}
@PutMapping("/privileges/{id}")
public ResponseEntity<Object> updatePrivilege(@RequestBody Privilege privilege,@PathVariable String id){
	Optional<Privilege> privilegeOptional =privilegeRepository.findById(id);
	if(!privilegeOptional.isPresent())
		return ResponseEntity.notFound().build();
	privilege.setId(id);
	privilegeRepository.save(privilege);
	return ResponseEntity.noContent().build();
}


@GetMapping("privileges/all")
public List<Privilege> getPrivileges(){	
	List<Privilege> privileges=privilegeRepository.findAll();
	if (privileges.size()>0)
     	return privileges;
	else
		return null;
}


@DeleteMapping("/privileges/{id}")
public String deletePrivilege(@PathVariable String id) {
	privilegeRepository.deleteById(id);
	return "done";
}


@GetMapping("/privileges/{id}")
public ResponseEntity<Optional<Privilege>> getPrivilegeById(@PathVariable String id){
	Optional<Privilege> p =privilegeRepository.findById(id);
	if(!p.isPresent())
		{return ResponseEntity.notFound().build();}
	else {return new ResponseEntity<>(p,HttpStatus.OK);}
}


/*role
*/
@PostMapping(path="/roles")
public String createRole(@RequestBody Role role){
	roleRepository.save(role);
	return "done";
}
@PutMapping("/roles/{id}")
public ResponseEntity<Object> updateRole(@RequestBody Role role,@PathVariable String id){
	Optional<Role> roleOptional =roleRepository.findById(id);
	if(!roleOptional.isPresent())
		return ResponseEntity.notFound().build();
	role.setId(id);
	roleRepository.save(role);
	return ResponseEntity.noContent().build();
}


@GetMapping("/roles/all")
public List<Role> getRoles(){	
	List<Role> roles=roleRepository.findAll();
	if (roles.size()>0)
     	return roles;
	else
		return null;
}


@GetMapping("/roles/{id}")
public ResponseEntity<Optional<Role>> getRoleById(@PathVariable String id){
	Optional<Role> role =roleRepository.findById(id);
	if(!role.isPresent())
		{return ResponseEntity.notFound().build();}
	else {return new ResponseEntity<>(role,HttpStatus.OK);}
}

@DeleteMapping("/roles/{id}")
public String deleteRole(@PathVariable String id) {
	roleRepository.deleteById(id);
	return "done";
}
/*
 * Template
 */


@PostMapping(path="/templates")
public String createTemplate(@RequestBody Template Tp){
	templateRepository.save(Tp);
	return "done";
}
@PutMapping("/roles/{id}")
public ResponseEntity<Object> updateTemplate(@RequestBody Template Tp,@PathVariable String id){
	Optional<Template> tpOptional =templateRepository.findById(id);
	if(!tpOptional.isPresent())
		return ResponseEntity.notFound().build();
	Tp.setId(id);
	templateRepository.save(Tp);
	return ResponseEntity.noContent().build();
}


@GetMapping("/templates/all")
public List<Template> getTtemplates(){	
	List<Template> Tps=templateRepository.findAll();
	if (Tps.size()>0)
     	return Tps;
	else
		return null;
}


@GetMapping("/templates/{id}")
public ResponseEntity<Optional<Template>> getTemplateById(@PathVariable String id){
	Optional<Template> tp =templateRepository.findById(id);
	if(!tp.isPresent())
		{return ResponseEntity.notFound().build();}
	else {return new ResponseEntity<>(tp,HttpStatus.OK);}
}

@DeleteMapping("/templates/{id}")
public String deleteTemplate(@PathVariable String id) {
	templateRepository.deleteById(id);
	return "done";
}






}
