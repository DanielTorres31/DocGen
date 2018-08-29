package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.Regra;
import entities.TipoRegra;
import repository.RegraRepository;
import repository.TipoRegrasRepository;

public class folderCriation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		criarPasta(args[0],findAllTipoRegra());
//		criarArquivos(args[0], findAllRegras());
		List<TipoRegra> tipoRegra = findAllTipoRegra();
		List<Regra> regras = null;
		for(TipoRegra tipo : tipoRegra) {
			if(tipo.getId() == 3) {
				regras = findRegrasByIdTipoRegra(tipo);
			}
		}
		for(Regra regra : regras) {
			String conteudo = geradorConteudoArquivo(regra);
			System.out.println(conteudo);
		}
	}

	public static List<TipoRegra> findAllTipoRegra() {
		TipoRegrasRepository tipoRegraRepository = new TipoRegrasRepository();
		List<TipoRegra> tiposRegra = tipoRegraRepository.findAll();
		return tiposRegra;
	}

	public static List<Regra> findRegrasByIdTipoRegra(TipoRegra tipoRegra) {
		RegraRepository regraRepository = new RegraRepository();
		List<Regra> regrasPorId = regraRepository.findByTipoRegra(tipoRegra);
		return regrasPorId;
	}
	
	public static List<Regra> findAllRegras() {
		RegraRepository regraRepository = new RegraRepository();
		List<Regra> regras = regraRepository.findAll();
		return regras;
	}
	
	public static void criarPasta(String path, List<TipoRegra> tiposRegra) {
		File pastas = new File(path);
		for (TipoRegra tipo : tiposRegra) {
			pastas =  new File(path + File.separator + tipo.getPath());
			for (int i = 0; i < tiposRegra.size();) {
				if (!pastas.exists()) {
					pastas.mkdirs();
				}
				i++;
			}
		}
	}

	public static void criarArquivos(String path,List<Regra> regras) {
		for (Regra regra : regras) {
			String nomeArquivo = path + File.separator + regra.getTipoRegra().getPath() + File.separator + regra.getNome() + ".rst";
			try {
				FileWriter arquivo= new FileWriter(nomeArquivo,true);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String geradorConteudoArquivo(Regra regra) {
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		
		String nome = "Regra: " + regra.getNome();
		Integer tamNome = nome.length();
		String descricao = "Descri��o: " + regra.getDescricao();
		Integer tamDesc = descricao.length();
		
		StringBuilder sb = new StringBuilder();
		sb.append(repetidorString("-", tamNome)).append(LINE_SEPARATOR);
		sb.append(nome).append(LINE_SEPARATOR);
		sb.append(repetidorString("-", tamNome)).append(LINE_SEPARATOR).append(LINE_SEPARATOR);		
		sb.append(descricao).append(LINE_SEPARATOR);
		sb.append(repetidorString("=", tamDesc));		
		
		return sb.toString();
		
	}
	
	private static String repetidorString(String str, int vezes) {
		String newStr = "";
		for(int i=0; i<vezes; i++) {
			newStr+=str;
		}		
		return newStr;
	}
}
