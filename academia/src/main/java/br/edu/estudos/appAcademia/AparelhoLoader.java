package br.edu.estudos.appAcademia;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.estudos.appAcademia.model.domain.Aparelho;
import br.edu.estudos.appAcademia.model.domain.Usuario;
import br.edu.estudos.appAcademia.model.service.AparelhoService;

@Component
public class AparelhoLoader implements ApplicationRunner {
	
	@Autowired
	private AparelhoService aparelhoService;

	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/aparelho.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] dados = null;
		
		while(linha != null) {
			dados = linha.split(";");
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(dados[4]));			
			
			Aparelho aparelho = new Aparelho();
			aparelho.setCodigo(Integer.valueOf(dados[0]));
			aparelho.setMudarTreino(dados[1]);
			aparelho.setMarca(dados[2]);
			aparelho.setNomeAparelho(dados[3]);
			
			aparelho.setUsuario(usuario);
			
			aparelhoService.incluir(aparelho);
			
			linha = leitura.readLine();
		}
		
		leitura.close();
	}
}
