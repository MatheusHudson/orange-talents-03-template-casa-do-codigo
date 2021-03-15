package zup.com.br.casadocodigotreino.Categoria;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer> {

	Optional<Categoria> findByNome(String nome);
}
