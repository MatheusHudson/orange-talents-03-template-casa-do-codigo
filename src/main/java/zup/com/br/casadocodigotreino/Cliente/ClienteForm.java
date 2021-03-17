package zup.com.br.casadocodigotreino.Cliente;


import javax.persistence.EntityManager;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


import zup.com.br.casadocodigotreino.Estado.Estado;
import zup.com.br.casadocodigotreino.Pais.Pais;
import zup.com.br.casadocodigotreino.Validation.UniqueValue;

public class ClienteForm {

	@NotEmpty
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String sobrenome;

	@NotEmpty
	@UniqueValue(domainClass = Cliente.class, fieldName = "cpfOuCnpj")
	private String cpfOuCnpj;

	@NotEmpty
	private String endereco;

	@NotEmpty
	private String complemento;

	@NotEmpty
	private String cidade;

	@NotNull
	private Pais pais;

	private Estado estado;

	@NotEmpty
	private String telefone;

	@NotEmpty
	private String cep;

	public String getEmail() {
		return email;
	}

	public String getNome() {
		return nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public String getCpfOuCnpj() {
		return cpfOuCnpj;
	}

	public String getEndereco() {
		return endereco;
	}

	public String getComplemento() {
		return complemento;
	}

	public String getCidade() {
		return cidade;
	}

	public Pais getPais() {
		return pais;
	}

	public Estado getEstado() {
		return estado;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getCep() {
		return cep;
	}

	public Cliente converter(EntityManager manager) {
		
	
		Cliente cliente = new Cliente(email, nome, sobrenome, cpfOuCnpj, endereco, complemento, cidade, pais, estado,
				telefone, cep);
		return cliente;

	}

}
