package zup.com.br.casadocodigotreino.Categoria;



import com.sun.istack.NotNull;

import zup.com.br.casadocodigotreino.Validation.UniqueValue;

public class CategoriaForm {
	
	@NotNull
	@UniqueValue(domainClass = Categoria.class, fieldName = "nome")
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter() {
		
		return new Categoria(nome);
	}
	
	
	

}
