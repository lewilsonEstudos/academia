package br.edu.estudos.appAcademia;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import br.edu.estudos.appAcademia.model.domain.Aparelho;
import br.edu.estudos.appAcademia.model.domain.Endereco;
import br.edu.estudos.appAcademia.model.domain.Usuario;
import br.edu.estudos.appAcademia.model.service.EnderecoService;
import br.edu.estudos.appAcademia.model.service.UsuarioService;

@Component
@Order(1)
public class UsuarioLoader implements ApplicationRunner {

	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private EnderecoService enderecoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/usuario.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] dados = null;
		
		Usuario usuario = null;
		
		while(linha != null) {
			
			dados = linha.split(";");

			switch (dados[0].toUpperCase()) {
			case "U":

				Endereco endereco = enderecoService.obterPorCep(dados[5]);
				
				usuario = new Usuario();
				usuario.setSobrenome(dados[1]);
				usuario.setEmail(dados[2]);
				usuario.setNome(dados[3]);
				usuario.setIdade(Integer.valueOf(dados[4]));
				usuario.setEndereco(endereco);
				
				usuarioService.incluir(usuario);
				
				break;

				
			case "A":
				Aparelho aparelho = new Aparelho();
				aparelho.setCodigo(Integer.valueOf(dados[1]));
				aparelho.setMudarTreino(dados[2]);
				aparelho.setMarca(dados[3]);
				aparelho.setNomeAparelho(dados[4]);
				
				
				usuario.getTreino().add(aparelho);

				break;

			default:
				break;
			}
			
			linha = leitura.readLine();
		}
				
		leitura.close();
	}
}