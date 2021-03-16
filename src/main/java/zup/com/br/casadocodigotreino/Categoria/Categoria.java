package zup.com.br.casadocodigotreino.Categoria;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sun.istack.NotNull;

@Entity
public class Categoria {

		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		private Integer id;
		
		@NotNull
		@Column(unique = true)
		private String nome;
		
		
		
		@Deprecated
		public Categoria( ) {
			
		}
		
		public Categoria(String nome) {
		
			this.nome = nome;
		}

		public Integer getId() {
			return id;
		}


		public String getNome() {
			return nome;
		}	
			
		
}
