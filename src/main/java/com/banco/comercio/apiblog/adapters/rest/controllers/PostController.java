package com.banco.comercio.apiblog.adapters.rest.controllers;

import com.banco.comercio.apiblog.adapters.rest.dto.CreatePostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.CreateUserWebDTO;
import com.banco.comercio.apiblog.adapters.rest.dto.PostWebDTO;
import com.banco.comercio.apiblog.adapters.rest.facade.PostFacade;
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


import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/posts")
public class PostController {

    private final PostFacade postFacade;

    public PostController(PostFacade postFacade) {
        this.postFacade = postFacade;
    }


    @GetMapping
    @Operation(method = "getPosts", summary = "list of posts", description = "Get list of posts", tags = {"post",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Get posts", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PostWebDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<List<PostWebDTO>> getUserPosts(Principal principal) {
        var username= principal.getName();
        return ResponseEntity.ok(postFacade.findPostsByUser(username));
    }

   @PostMapping
    @Operation(method = "createUser", summary = "create users", description = "create users", tags = {"user",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "User created", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PostWebDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<PostWebDTO> createPostUser(@Valid @RequestBody CreatePostWebDTO createPostWebDTO, Principal principal) {
        var result = postFacade.createPost(principal.getName(),createPostWebDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @GetMapping(value = "/{id}")
    @Operation(method = "getPostById", summary = "get post", description = "Get user by Id", tags = {"post",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "find Post", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PostWebDTO.class))}),
            @ApiResponse(responseCode = "404", description = "Item not Found.", content = @Content)})
    public ResponseEntity<PostWebDTO> getPostById(@Parameter(name = "id", description = "Post Identifier", required = true) @PathVariable Long id) {
        var result = postFacade.findPostById(id);
        return result.map(createUserWebDTO -> ResponseEntity.ok().body(createUserWebDTO))
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }


    @PutMapping(value = "/{id}")
    @Operation(method = "updatePost", summary = "update post", description = "update user by Id", tags = {"post",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "Post Updated Sucessfully", content = {
                    @Content(mediaType = "application/json", schema = @Schema(implementation = PostWebDTO.class))}),
            @ApiResponse(responseCode = "500", description = "An error occured.", content = @Content)})
    public ResponseEntity<PostWebDTO> updatetPost(@Parameter(name = "id", description = "Post Identifier", required = true)
                                                   @PathVariable Long id, @RequestBody CreatePostWebDTO createUserWebDTO) {
        var result = postFacade.updatePost(id, createUserWebDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(result);
    }

    @DeleteMapping(value = "/{id}")
    @Operation(method = "deletePostById", summary = "delete post", description = "delete post By Id", tags = {"post",})
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Post deleted"),
            @ApiResponse(responseCode = "404", description = "Post not Found.")})
    public ResponseEntity<Void> deletetPostById(@Parameter(name = "id", description = "Post Identifier", required = true) @PathVariable Long id) {
        postFacade.deletePost(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
