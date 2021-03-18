package zup.com.br.casadocodigotreino.Cliente;

import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import zup.com.br.casadocodigotreino.Pais.Pais;

public interface ClienteRepository  extends CrudRepository<Cliente, Integer>{
	
	@Query("Select p From Pais p Where p.id = :pId")
	Optional<Pais> findPaisById(Integer pId);
	
	@Query("Select p From Pais p JOIN Estado e ON p.id = e.pais.id Where e.id = :idEstado AND p.id = :idPais")
	Optional<?> findStateCountryById(Integer idEstado, Integer idPais);
	
}
