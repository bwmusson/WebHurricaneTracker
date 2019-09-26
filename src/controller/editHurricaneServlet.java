package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hurricane;

/**
 * Servlet implementation class editHurricaneServlet
 */
@WebServlet("/editHurricaneServlet")
public class editHurricaneServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editHurricaneServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HurricaneHelper hHelper = new HurricaneHelper();
		
		String name = request.getParameter("name");
		int year = Integer.parseInt(request.getParameter("year"));
		int cat = Integer.parseInt(request.getParameter("cat"));
		Integer tempId = Integer.parseInt(request.getParameter("id"));
		
		Hurricane hurricaneToUpdate = hHelper.searchForHurricaneById(tempId);
		hurricaneToUpdate.setName(name);
		hurricaneToUpdate.setYear(year);
		hurricaneToUpdate.setCategory(cat);
		
		hHelper.updateHurricane(hurricaneToUpdate);
		
		getServletContext().getRequestDispatcher("/viewAllHurricanesServlet").forward(request, response);
	}

}
