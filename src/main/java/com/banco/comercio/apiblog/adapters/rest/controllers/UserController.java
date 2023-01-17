package com.banco.comercio.apiblog.adapters.rest.controllers;

import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.PostFacade;
import com.banco.comercio.apiblog.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/users")
public class UserController {

    private final PostFacade postFacade;
    private final UserService userService;

    public UserController(PostFacade postFacade, UserService userService) {
        this.postFacade = postFacade;
        this.userService = userService;
    }

    @GetMapping("/list")
    @Operation(method = "getUsers", summary = "list of clients", description = "Get list of users", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get users", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserWebDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<List<UserWebDTO>> getUsers() {
        var result = userService.findAll();
        return ResponseEntity.ok(result);
    }

   /* @PostMapping
    @Operation(method = "createUser", summary = "create users", description = "create users", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserWebDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<UserWebDTO> createUser(@Valid @RequestBody CreateUserWebDTO createUserWebDTO) {
        var result = userService.createUser(createUserWebDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }*/

    @GetMapping(value = "/{id}")
    @Operation(method = "getUserById", summary = "get user", description = "Get user by Id", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "find Client", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserWebDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Item not Found.", content = @Content)})
    public ResponseEntity<UserWebDTO> getUserById(@Parameter(name = "id", description = "User Identifier", required = true) @PathVariable Long id) {
        var result = userService.findUserById(id);
        return result.map(createUserWebDTO -> ResponseEntity.ok().body(createUserWebDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PutMapping(value = "/{id}")
    @Operation(method = "updateUser", summary = "update users", description = "update user by Id", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User Updated Sucessfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = UserWebDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<UserWebDTO> updateClient(@Parameter(name = "id", description = "User Identifier", required = true)
                                                   @PathVariable Long id, @RequestBody CreateUserWebDTO createUserWebDTO) {
        var result = userService.updateUser(id, createUserWebDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(method = "deleteUserById", summary = "delete user", description = "delete user By Id", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "User deleted"),
            @ApiResponse(responseCode = "404", description = "User not Found.")})
    public ResponseEntity<Void> deleteUserById(@Parameter(name = "id", description = "User Identifier", required = true) @PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
