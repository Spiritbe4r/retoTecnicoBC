package com.banco.comercio.apiblog.adapters.postgres.repository;

import com.banco.comercio.apiblog.adapters.postgres.models.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<PostEntity,Long> {
    @Query(value = "SELECT pe FROM PostEntity pe JOIN pe.user u WHERE  u.username = :username")
    List<PostEntity> getPostEntitiesByUser(@Param("username") String username);

   /* @Query(value = "SELECT pe FROM PostEntity pe JOIN pe.user u WHERE pe.id=:postId  and u.username = :username")
    PostEntity getPostEntitiesByUser(@Param("postId") String postId,@Param("username") String username);*/
}
