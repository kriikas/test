package test.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import test.model.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
