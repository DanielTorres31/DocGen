package controller;

import java.io.File;
import java.util.List;

import entities.Regra;
import entities.TipoRegra;
import repository.RegraRepository;
import repository.TipoRegrasRepository;

public class folderCriation {
	static List<TipoRegra> tiposRegra;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		buscaTipoRegras();
		//buscaRegras();
			
		criacaoDePasta(tiposRegra);
		
	}
	
	public static void buscaTipoRegras() {
		TipoRegrasRepository tipoRegra = new TipoRegrasRepository();
		List<TipoRegra> tiposRegra = tipoRegra.findAll();
		System.out.println(tiposRegra);

	}
	
	
	public static void criacaoDePasta(List<TipoRegra> tiposRegra) {
		//Metodo foi criado dessa forma enquanto a consulta no banco de dados nao fica pronta
		
		File pastas = new File ("U:\\Regras" );
		
		
		for (int i = 0; i < 9;) {
			if (!pastas.exists()) {			 
			((File) tiposRegra).mkdirs();
			}
			i++;
		}
		
		
		File traducao = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\1-Regra de Traducao");
		File  roteamento = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\2-Regra de Roteamento");
		File  retencao = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\3-Regra de Retencao");
		File  parametrizacao = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\4-Regra de Parametrizacao");
		File  interpretacao = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\5-Regra de Interpretacao");
		File  execucaoComandos = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\6-Regra de Execucao de Comando");
		File  enriquecimento = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\7-Regra de Enriquecimento");
		File  dependencia = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\8-Regra de Dependencia");
		File  conectores = new File("C:\\\\Users\\\\vicente.mourao\\\\Desktop\\\\Regras\\\\9-Regra de Conectores");

		try {
			if (!traducao.exists()) {
				traducao.mkdirs();
			}
			
			if (!roteamento.exists()) {
				roteamento.mkdirs();
			}
			if (!retencao.exists()) {
				retencao.mkdirs();
			}
			if (!parametrizacao.exists()) {
				parametrizacao.mkdirs();
			}
			if (!interpretacao.exists()) {
				interpretacao.mkdirs();
			}
			
			if (!execucaoComandos.exists()) {
				execucaoComandos.mkdirs();
			}
			if (!enriquecimento.exists()) {
				enriquecimento.mkdirs();
			}
			if (!dependencia.exists()) {
				dependencia.mkdirs();
			}
			if (!conectores.exists()) {
				conectores.mkdirs();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void criacaoDosArquivos() {
		/*A inserção dos arquivos será feita apos consulta no banco, a partir disso será definido em qual pasta será salva o arquivo
		 * ira criar 
		 */
		
	}
}
