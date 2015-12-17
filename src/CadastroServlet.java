

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet central do Cadastro online. Responsável por receber as requisições do navegador,
 * realizar pré-processamento e repassá-las para o JSP apropriado
 */
@WebServlet("/CadastroServlet")
public class CadastroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	Cadastro cadastro = new Cadastro();
	
	// Esse campo é usado para armazenar a disciplina retornada pela busca, de forma a poder editá-la posteriormente
	Disciplina disciplinaAtual;
	
    public CadastroServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
PrintWriter out = response.getWriter();
		
		// Salvar cadastro
		if(request.getParameter("submit").equals("Salvar")) {
			// Tomando os parâmetros de request
			String nome = request.getParameter("nome");
			String ementa = request.getParameter("ementa");
			String codigo = request.getParameter("codigo");
			
			response.setCharacterEncoding("UTF-8");
			// Armazenando na agenda
			cadastro.adicionaDisciplina(new Disciplina(nome, ementa, codigo));
				
			// Exibe todos os cadastros	
			request.setAttribute("lista", cadastro.lista());
			request.setAttribute("action", "salvo");
			request.getRequestDispatcher("exibir.jsp").forward(request, response);
		} 
		// Remover cadastro
		else if(request.getParameter("submit").equals("Remover")) {
			
			cadastro.removeContato(disciplinaAtual.getNome());
			
			
			// Exibe todos os cadastros
			request.setAttribute("lista", cadastro.lista());
			request.setAttribute("action", "removido");
			request.getRequestDispatcher("exibir.jsp").forward(request, response);
		}
		// Buscar cadastro
		else if(request.getParameter("submit").equals("Buscar")) {
			String busca = request.getParameter("busca");
			
			try {
				
				disciplinaAtual = cadastro.buscaContato(busca);
				request.setAttribute("resultado", disciplinaAtual.toString());
				request.setAttribute("action", "Resultado");
				request.getRequestDispatcher("resultadoBusca.jsp").forward(request, response);
//				out.println("<html>");
//				out.println("<head><meta charset=\"UTF-8\"></head>");
//				out.println("<body>");
//				out.println("<h3>Contato</h3><br>");
//				out.println(disciplinaAtual.toString() + "<br>");
//				out.println("<form action=\"CadastroServlet\" method=\"get\">");
//				out.println("<input type=\"submit\" name=\"submit\" value=\"Remover\"></input>");
//				out.println("<input type=\"submit\" name=\"submit\" value=\"Editar\"></input>");
//				out.println("</form>");
//				out.println("<a href=\"index.html\">Voltar</a>");
//				out.println("</body>");
//				out.println("</html>");
				
			} catch (DisciplinaNaoExisteException e) {
				request.getRequestDispatcher("notFound.html").forward(request, response);
			}
		}
		// Edita o contato atual
		else if(request.getParameter("submit").equals("Editar")) {
			// Remove a ocorrência anterior
			// cadastro.removeContato(disciplinaAtual.getNome());
			
			// Gera a página de edição
			request.setAttribute("nomeAtual", disciplinaAtual.getNome());
			request.setAttribute("ementaAtual", disciplinaAtual.getEmenta());
			request.setAttribute("codigoAtual", disciplinaAtual.getCodigo());
			
			request.getRequestDispatcher("edit.jsp").forward(request, response);
//			out.println("<html>");
//			out.println("<head><meta charset=\"UTF-8\"></head>");
//			out.println("<body>");
//			out.println("<h3>Edite a disciplina</h3><hr>");
//			out.println("<form action=\"CadastroServlet\" method=\"get\">");
//			out.println("Nome:<br> <input type=\"text\" name=\"nome\" value=\""+ disciplinaAtual.getNome() +"\"><br>");
//			out.println("Email:<br> <input type=\"text\" name=\"ementa\" value=\""+ disciplinaAtual.getEmenta() +"\"><br>");
//			out.println("Telefone:<br> <input type=\"text\" name=\"codigo\" value=\""+ disciplinaAtual.getCodigo() +"\"><br><br>");
//			out.println("<input type=\"submit\" name=\"submit\" value=\"Salvar\"></input>");
//			out.println("</body>");
//			out.println("</html>");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
