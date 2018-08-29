package controller;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import entities.Regra;
import entities.TipoRegra;
import repository.RegraRepository;
import repository.TipoRegrasRepository;

public class folderCriation {

	public static void main(String[] args) {
		criarPasta(args[0],findAllTipoRegra());
		criarArquivos(args[0], findAllRegras());
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
				PrintWriter gravar = new PrintWriter(arquivo);
				gravar.print(geradorConteudoArquivo(regra));
				arquivo.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static String geradorConteudoArquivo(Regra regra) {
		final String LINE_SEPARATOR = System.getProperty("line.separator");
		
		String nome = regra.getNome();
		Integer tamNome = nome.length();
		String descricao = regra.getDescricao();
		
		StringBuilder sb = new StringBuilder();
		sb.append(repetidorString("=", tamNome)).append(LINE_SEPARATOR);
		sb.append(nome).append(LINE_SEPARATOR);
		sb.append(repetidorString("=", tamNome)).append(LINE_SEPARATOR).append(LINE_SEPARATOR);
		sb.append(repetidorString("-", 9)).append(LINE_SEPARATOR);
		sb.append("Descrição").append(LINE_SEPARATOR);
		sb.append(repetidorString("-", 10)).append(LINE_SEPARATOR);
		sb.append(descricao).append(LINE_SEPARATOR);
		
		
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
