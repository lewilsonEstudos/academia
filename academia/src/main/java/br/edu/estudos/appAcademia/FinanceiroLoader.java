package br.edu.estudos.appAcademia;

import java.io.BufferedReader;
import java.io.FileReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.edu.estudos.appAcademia.model.domain.Financeiro;
import br.edu.estudos.appAcademia.model.domain.Usuario;
import br.edu.estudos.appAcademia.model.service.FinanceiroService;

@Component
public class FinanceiroLoader implements ApplicationRunner {

	@Autowired
	private FinanceiroService financeiroService;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {

		FileReader file = new FileReader("arquivos/financeiro.txt");
		BufferedReader leitura = new BufferedReader(file);

		String linha = leitura.readLine();
		String[] dados = null;
		
		while(linha != null) {
			dados = linha.split(";");
			
			Usuario usuario = new Usuario();
			usuario.setId(Integer.valueOf(dados[3]));		
			
			Financeiro financeiro = new Financeiro();
			
			financeiro.setPreco(Float.valueOf(dados[1]));
			financeiro.setVencida(Boolean.valueOf(dados[2]));
			
			financeiro.setUsuario(usuario);

			financeiroService.incluir(financeiro);
			
			linha = leitura.readLine();
		}
		
		leitura.close();
	}
}
