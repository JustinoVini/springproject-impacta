package br.com.impacta.treinamentos.springproject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

/**
 * 
 * @author vinicius
 * @Entity ou Domain
 *
 * A camada de domínio é uma coleção de objetos de entidade e lógicas de
 * negócios relacionadas projetadas para representar o modelo de negócios da
 * empresa
 */

@Entity
public class Student {
	
	/*A linha abaixo, gera um Id, para o banco através da annotation Id do javax.xml.bind,
	 *  sem essa dependencia, a annotation não funciona.
	 *  
	 *  e Por fim a generatedValue, que gera o valor automaticamente no banco atraves do JPA.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@NotBlank(message = "Nome é obrigatorio")
	@Column(name = "name")
	private String name;

	/*
	*@NotBlank faz a mesma verificação que NotNull e NotEmpty
	*/
	@NotBlank(message = "Email é obrigatorio")
	@Column(name = "email")
	private String email;

	/*
	*@Column é utilizada para especificar os detalhes da coluna que
	*um campo ou propriedade será mapeado
	*/
	@Column(name = "phone_no")
	private long phoneNo;
	
	/*
	 * Geração do constructor padrão
	 */
	
	public Student() {

	}

	public Student(String name, String email) {
		this.name = "name";
		this.email = "email";
	}
	
	/*
	 * Geração dos métodos acessores.
	 */

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

}
