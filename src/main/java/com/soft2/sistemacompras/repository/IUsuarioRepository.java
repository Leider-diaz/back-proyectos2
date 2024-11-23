package com.soft2.sistemacompras.repository;

import com.soft2.sistemacompras.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface IUsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query("SELECT CASE WHEN COUNT (u) > 0 THEN TRUE ELSE FALSE END " +
            "FROM Usuario u " +
            "WHERE u.username = :username " +
            "AND u.password = :password ")
    Boolean validateUser(String username, String password);

    @Query("SELECT u " +
            "FROM Usuario u " +
            "WHERE u.username = :username " +
            "AND u.password = :password ")
    Usuario findUserByUsernameAndPassword(String username, String password);
}
