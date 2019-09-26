package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class viewAllHurricanesServlet
 */
@WebServlet("/viewAllHurricanesServlet")
public class viewAllHurricanesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public viewAllHurricanesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HurricaneHelper hHelper = new HurricaneHelper();
		
		request.setAttribute("allHurricanes", hHelper.showAllHurricanes());
		
		if(hHelper.showAllHurricanes().isEmpty()){
			request.setAttribute("allHurricanes", " ");
		}
		
		getServletContext().getRequestDispatcher("/allHurricanes.jsp").forward(request, response);
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
