package zup.com.br.casadocodigotreino.Categoria;

import javax.persistence.Column;

import com.sun.istack.NotNull;

public class CategoriaForm {
	
	@NotNull
	@Column(unique = true)
	private String nome;

	public String getNome() {
		return nome;
	}

	public Categoria converter() {
		
		return new Categoria(nome);
	}
	
	
	

}
