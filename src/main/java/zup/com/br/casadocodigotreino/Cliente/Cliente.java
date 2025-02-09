package zup.com.br.casadocodigotreino.Cliente;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;

import zup.com.br.casadocodigotreino.Estado.Estado;
import zup.com.br.casadocodigotreino.Pais.Pais;


@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NotEmpty
	@Email
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
	@ManyToOne
	private Pais pais;
	
	@ManyToOne
	private Estado estado;
	
	@NotEmpty
	private String telefone;
	
	@NotEmpty
	private String cep;

	public Cliente(@NotEmpty @Email String email, @NotEmpty String nome, @NotEmpty String sobrenome,
			@NotEmpty String cpfOuCnpj, @NotEmpty String endereco, @NotEmpty String complemento,
			@NotEmpty String cidade, @NotNull Pais pais, Estado estado, @NotEmpty String telefone,
			@NotEmpty String cep) {
		super();
	
	}

	public Cliente(ClienteForm form) {
		this.email = form.getEmail();
		this.nome = form.getNome();
		this.sobrenome = form.getSobrenome();
		this.cpf = form.getCpf();
		this.cnpj = form.getCnpj();
		this.endereco = form.getEndereco();
		this.complemento = form.getComplemento();
		this.cidade = form.getCidade();
		this.pais = form.getPais();
		this.estado = form.getEstado();
		this.telefone = form.getTelefone();
		this.cep = form.getCep();
	}

	
	
}
