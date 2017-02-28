package test.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.model.entity.Usuario;
import test.model.to.SignUpTO;
import test.repository.UsuarioRepository;
import test.service.SignUpService;

@Service
public class SignUpServiceImpl implements SignUpService{
	
	@Autowired
	private UsuarioRepository usuarioRepo;
	
	@Override
	public void signUser(SignUpTO signUpTO) {
		Usuario usuario = new Usuario();
		usuario.setEmail(signUpTO.getEmail());
		usuario.setLogin(signUpTO.getUsername());
		usuario.setPassword(signUpTO.getPassword());
		usuarioRepo.save(usuario);
	}
	
}
