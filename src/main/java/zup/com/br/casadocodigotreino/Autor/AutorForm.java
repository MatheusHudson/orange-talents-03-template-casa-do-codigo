package zup.com.br.casadocodigotreino.Autor;


import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;


import org.hibernate.validator.constraints.Length;

public class AutorForm {

	@NotEmpty
	private String nome;
	
	@Email
	@NotEmpty
	private String email;
	
	@NotEmpty
	@Length(min=0, max = 400)
	private String descricao;

	
	
	public String getNome() {
		return nome;
	}



	public String getEmail() {
		return email;
	}



	public String getDescricao() {
		return descricao;
	}


	public Autor converter(AutorForm autor) {
		
		return new Autor(nome,email, descricao);
	
	}
}
