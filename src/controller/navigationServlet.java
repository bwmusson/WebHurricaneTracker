package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hurricane;

/**
 * Servlet implementation class navigationServlet
 */
@WebServlet("/navigationServlet")
public class navigationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public navigationServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HurricaneHelper hHelper = new HurricaneHelper();
		String act = request.getParameter("doThisToItem");
		
		if (act == null) {
			getServletContext().getRequestDispatcher("/viewAllItemsServlet").forward(request, response);
		} 
		
		else if (act.equals("Delete")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Hurricane stormToDelete = hHelper.searchForHurricaneById(tempId);
				hHelper.deleteHurricane(stormToDelete);
			} 
			catch (NumberFormatException e) {
				System.out.println("Id: " + request.getParameter("id"));
				System.out.println("No Hurricane Selected");
			} 
			finally {
				getServletContext().getRequestDispatcher("/viewAllHurricanesServlet").forward(request, response);
			}
		} 
		else if (act.equals("Edit")) {
			try {
				Integer tempId = Integer.parseInt(request.getParameter("id"));
				Hurricane itemToEdit = hHelper.searchForHurricaneById(tempId);
				request.setAttribute("itemToEdit", itemToEdit);
				getServletContext().getRequestDispatcher("/editHurricane.jsp").forward(request, response);
			}
			catch (NumberFormatException e) {
				System.out.println("Id: " + request.getParameter("id"));
				System.out.println("No Hurricane Selected");
			}
			finally {
					getServletContext().getRequestDispatcher("/viewAllHurricanesServlet").forward(request, response);
			}
		}
	}

}
