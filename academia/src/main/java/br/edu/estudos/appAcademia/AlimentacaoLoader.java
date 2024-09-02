package br.edu.estudos.appAcademia;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.estudos.appAcademia.model.domain.Alimentacao;
import br.edu.estudos.appAcademia.model.domain.Usuario;
import br.edu.estudos.appAcademia.model.service.AlimentacaoService;

@Component
public class AlimentacaoLoader implements ApplicationRunner {

	@Autowired
	private AlimentacaoService alimentacaoService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/alimentacao.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] dados = null;
		
		while(linha != null) {
			dados = linha.split(";");
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(dados[3]));		
			
			Alimentacao alimentacao = new Alimentacao();
			
			
			alimentacao.setAlimento(dados[1]);
			alimentacao.setTipo(dados[2]);

			alimentacao.setUsuario(usuario);
			
			alimentacaoService.incluir(alimentacao);
			
			linha = leitura.readLine();
		}
		
		leitura.close();
	}
}
