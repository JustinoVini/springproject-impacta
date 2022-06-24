package br.com.impacta.treinamentos.springproject.repository;

import br.com.impacta.treinamentos.springproject.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author vinicius
 *
 * @Repository
 * A Interface abaixo, recebe a annotation repository, que cria um bean para a parte de persistência,
 * além de capturar exceções específicas de persistência.
 *
 * É utilizado a annotation para que o java entenda que a interface é uma repository
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {
	/*
	* A linha abaixo cria uma lista com o parametro de Student dentro do operador diamond
	* e que será procurado pelo metodo findByName.
	 */
    List<Student> findByName(String name);
}
