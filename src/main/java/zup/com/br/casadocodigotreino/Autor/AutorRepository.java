package zup.com.br.casadocodigotreino.Autor;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface AutorRepository extends CrudRepository<Autor, Integer> {

	Optional<Autor> findByEmail(String email);
}
