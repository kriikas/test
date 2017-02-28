package test.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "USUARIO")
public class Usuario {
	
	private static final String SEQ_NAME = "ID_USUARIO_SEQ";
    private static final String SEQ_GEN = "USUARIO_SEQ";

    @Id
    @SequenceGenerator(name = SEQ_GEN, sequenceName = SEQ_NAME, allocationSize = 1)
    @GeneratedValue(generator = SEQ_GEN, strategy = GenerationType.SEQUENCE)
    @Column(name = "ID_USUARIO", unique = true, nullable = false, precision = 19)
	private Long id;
	
    @Column(name = "LOGIN")
	private String login;

    @Column(name = "PASSWORD")
	private String password;

    @Column(name = "EMAIL")
	private String email;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
}
