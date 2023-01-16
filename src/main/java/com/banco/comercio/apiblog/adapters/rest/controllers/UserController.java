package com.banco.comercio.apiblog.adapters.rest.controllers;

import com.banco.comercio.apiblog.adapters.rest.dto.UserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.ClientFacade;
import com.banco.comercio.apiblog.adapters.rest.dto.ClientWebDTO;
import com.banco.comercio.apiblog.domain.dto.ClientDTO;
import com.banco.comercio.apiblog.domain.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final ClientFacade clientFacade;
    private final UserService userService;

    public UserController(ClientFacade clientFacade, UserService userService) {
        this.clientFacade = clientFacade;
        this.userService = userService;
    }

    @GetMapping
/*    @Operation(method = "getClients", summary = "list of clients", description = "Get list of clients", tags = {"client",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Clone created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})*/
    public ResponseEntity<List<UserWebDTO>> getClients() {
        var result = userService.findAll();
        return ResponseEntity.ok(result);
    }

    @PostMapping
    /*@Operation(method = "createClient", summary = "create clients", description = "create client", tags = {"client",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})*/
    public ResponseEntity<ClientDTO> createClient(@Valid @RequestBody ClientWebDTO clientWebDTO) {
        //var result = userService.c(clientWebDTO);
        return null;
    }

   /* @GetMapping(value = "/{id}")
    @Operation(method = "getClientById", summary = "get client", description = "Get client by Id", tags = {"client",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "find Client", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Item not Found.", content = @Content)})
    public ResponseEntity<ClientDTO> getClientById(@Parameter(name = "id", description = "Client Identifier", required = true) @PathVariable Long id) {
        var result = clientFacade.findClientById(id);
        return result.map(clientDTO -> ResponseEntity.ok().body(clientDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }



    @PutMapping(value = "/{id}")
    @Operation(method = "updateClient", summary = "update clients", description = "update client by Id", tags = {"client",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Client Updated Sucessfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = ClientDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<ClientDTO> updateClient(@Parameter(name = "id", description = "Client Identifier", required = true)
                                                  @PathVariable Long id, @RequestBody ClientWebDTO clientWebDTO) {
        var result = clientFacade.updateClient(id, clientWebDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(method = "deleteClientById", summary = "delete client", description = "delete client By Id", tags = {"client",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Client deleted"),
            @ApiResponse(responseCode = "404", description = "Client not Found.")})
    public ResponseEntity<Void> deleteClientById(@Parameter(name = "id", description = "Client Identifier", required = true) @PathVariable Long id) {
        clientFacade.deleteClient(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }*/

}
