package control;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.http.HttpStatus;

import entity.Processo;
import persistence.ProcessoDao;



/*
 * As classes que manipulam dados junto ao protocólo HTTP, devem ser um Servlet.
 * Para uma classe atuar como Servlet é necessário a herança de HTTPServlet.
 * 
 */
public class ControleProcesso extends HttpServlet {

	/*
	 * Métodos doGet() e doPost() são usados para manipular os dados do HTTP. as
	 * escolha do método depende da forma de envio: GET ou POST.
	 */

	private static final long serialVersionUID = -8542483556976530814L;

	@Override
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		verificarAcao(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		verificarAcao(request, response);
	}

	protected void verificarAcao(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String acao = request.getParameter("acao");

		if (acao.equalsIgnoreCase("buscarProc")) {
			buscarProcesso(request, response);
		} else if (acao.equalsIgnoreCase("cadastroProc")) {
			cadastrarProcesso(request, response);
		} else if (acao.equalsIgnoreCase("consultaProc")) {
			consultarProcessos(request, response);
		} 

	}

	protected void buscarProcesso(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		String numero_pub = request.getParameter("numero_pub_pesquisa");
		String url = "https://patentscope.wipo.int/search/pt/detail.jsf?docId=" + numero_pub + "&redirectedID=true";
		
	
		
		HttpClient client = new HttpClient();
		
	    GetMethod method = new GetMethod(url);

	    //method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, 
	    //		new DefaultHttpMethodRetryHandler(3, false));

		
		try {
			
			int statusCode = client.executeMethod(method);
			
			if (statusCode != HttpStatus.SC_OK) {
		        System.err.println("Method failed: " + method.getStatusLine());
		      }
			
			
		    
			//byte[] responseBody = method.getResponseBodyAsString();

		      // Deal with the response.
		      // Use caution: ensure correct character encoding and is not binary data
			System.out.println("Saida 4 " + url);
		   //   System.out.println("Saida " + method.getResponseBodyAsString());
		      
			
		     

		}catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
			
		}
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}
	
	

		
	

	protected void cadastrarProcesso(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		try {

			Processo proc = new Processo();
			proc.setNumero_pub(request.getParameter("numero_pub"));
			proc.setNumero_ped(request.getParameter("numero_ped"));
			proc.setdatapubli(request.getParameter("datapubli"));
			proc.setRequerentes(request.getParameter("requerentes"));
			proc.setTitulo(request.getParameter("titulo"));
			
			
			Date date = new	SimpleDateFormat("dd/MM/yyyy").parse(proc.getdatapubli());
			Calendar datapubli = Calendar.getInstance();
			datapubli.setTime(date);

			
			ProcessoDao fd = new ProcessoDao();
			fd.inserirDadosProc(proc);

			request.setAttribute("msg", "Processo cadastrado com sucesso.");

		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
		}

		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void consultarProcessos(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {

		String pagina = null;

		try {
			ProcessoDao fd = new ProcessoDao();
			
		request.setAttribute("listaProc", fd.consultaProcesso());
			
			pagina = "consulta.jsp";
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("msg", "Erro: " + e.getMessage());
			pagina = "index.jsp";
		}
		request.getRequestDispatcher(pagina).forward(request, response);
		
	}
}

