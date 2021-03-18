package zup.com.br.casadocodigotreino.Pais;


import javax.validation.constraints.NotEmpty;

import zup.com.br.casadocodigotreino.Validation.UniqueValue;

public class PaisForm {
	
	@NotEmpty
	@UniqueValue(domainClass = Pais.class, fieldName = "nome")
	private String nome;
	
	

	public String getNome() {
		return nome;
	}



	public Pais toModel(PaisForm form) {
		
		return new Pais(nome);
	}
	
	


}
