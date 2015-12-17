
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class Cadastro {

	Map<String, Disciplina> cadastros = new HashMap<String, Disciplina>();
	
	public Cadastro() {
		//Busca contatos prévios
		LeitorCSV csv;
		try {
			csv = new LeitorCSV( "armazenamento_cadastro.csv" );
			while( csv.proximo() ) 
	            adicionaDisciplina(new Disciplina(csv));

	        csv.close();
		} catch (FileNotFoundException e) {
			// Se um arquivo prévio não for encontrado, nada precisa ser feito
			System.out.println("Armazenamento não encontrado");
		}
        
	}
	public void adicionaDisciplina(Disciplina disciplina) {
		// Adiciona o novo cadastro ao mapa
		cadastros.put(disciplina.getNome(), disciplina);
		
		// Atualiza o arquivo de armazenamento
		atualizaArmazenamento();
	}
	public Disciplina buscaContato(String nome) throws DisciplinaNaoExisteException {
		if (cadastros.containsKey(nome)) {
			System.out.println("Cadastro " + nome + " encontrado");
			return cadastros.get(nome);
			
		} else {
			System.out.println("Contato " + nome + " não encontrado");
			throw new DisciplinaNaoExisteException("Cadastro não encontrado");
		}
	}

	public void removeContato(String nome) {
		this.cadastros.remove(nome);
		atualizaArmazenamento();
		System.out.println("Cadastro " + nome + " removido");
	}
	// Exibe todos os cadastros em um tabela html
		public String lista() {
			StringBuilder sb = new StringBuilder();
			sb.append("<table border=\"1\">");
			sb.append("<tr><td>Nome</td><td>Ementa</td><td>Código</td>");
			//Itera por cada um dos contatos
			for(Map.Entry<String, Disciplina> entry : cadastros.entrySet()) {
				Disciplina c = entry.getValue();
				sb.append("<tr><td>");
				sb.append(c.getNome() + "</td><td>");
				//Teste
				System.out.println(c.getNome());
				//Fim do teste
				sb.append(c.getEmenta() + "</td><td>");
				sb.append(c.getCodigo() + "</td></tr>");
			}
			sb.append("</table>");
			return sb.toString();
		}
	private void atualizaArmazenamento() {
		try {
			PrintWriter writer = new PrintWriter("armazenamento_cadastro.csv", "UTF-8");

			// Itera por todos os elementos de contatos
			for(Map.Entry<String, Disciplina> entry : cadastros.entrySet()) {
				writer.println(entry.getValue().armazenamento());
			}
			writer.close();
			System.out.println("Armazenamento atualizado");
		} catch (FileNotFoundException | UnsupportedEncodingException e) {
			System.out.println("Incapaz de criar armazenamento");
		}
		
	}
}
