package zup.com.br.casadocodigotreino.Cliente;



import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import zup.com.br.casadocodigotreino.Estado.Estado;
import zup.com.br.casadocodigotreino.Pais.Pais;
import zup.com.br.casadocodigotreino.Validation.Cpf;
import zup.com.br.casadocodigotreino.Validation.StateCountry;
import zup.com.br.casadocodigotreino.Validation.UniqueValue;

@Cpf
@StateCountry
public class ClienteForm {

	@NotEmpty
	@Email
	@UniqueValue(domainClass = Cliente.class, fieldName = "email")
	private String email;

	@NotEmpty
	private String nome;

	@NotEmpty
	private String sobrenome;
	
	@CPF
	private String cpf;

	@CNPJ
	private String cnpj;
	

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

	

	public String getCpf() {
		return cpf;
	}

	public String getCnpj() {
		return cnpj;
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

	public Cliente toModel() {
		
	
		return new Cliente(this);
	}


}
