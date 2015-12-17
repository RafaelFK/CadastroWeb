
public class Disciplina {
	private String nome, ementa, codigo;

	// Contrutor usado por Agenda para gerar objetos Contato provenientes de
	// arquivo
	public Disciplina(ILeitor leitor) {
		nome = leitor.leCampo("nome");
		ementa = leitor.leCampo("ementa");
		codigo = leitor.leCampo("codigo");
	}

	public Disciplina(String nome, String ementa, String codigo) {
		this.nome = nome;
		this.ementa = ementa;
		this.codigo = codigo;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public void setEmenta(String ementa) {
		this.ementa = ementa;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
		// Else exception?
	}

	public String getNome() {
		return this.nome;
	}

	public String getEmenta() {
		return this.ementa;
	}

	public String getCodigo() {
		return this.codigo;
	}

	// Gera um string para que o cadastro seja exibido como uma tabela html
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("<table border=\"1\"><tr><td>Nome</td><td>Ementa</td><td>Código</td></tr>");
		sb.append("<tr><td>" + getNome() + "</td><td>" + getEmenta()
				+ "</td><td>" + getCodigo() + "</td></tr></table>");
		
		return sb.toString();
	}

	// Usado para gerar a String de armaznamento do cadastro
	public String armazenamento() {
		return getNome() + "," + getEmenta() + "," + getCodigo();
	}

}
