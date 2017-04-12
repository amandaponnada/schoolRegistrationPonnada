package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.electionDAO;
import model.electionDB;

/**
 * Servlet implementation class listElectionServlet
 */
@WebServlet("/listElectionServlet")
public class listElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public listElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
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
		// TODO Auto-generated method stub
		System.out.println("Inside listElection Servlet");

		String listName = request.getParameter("LIST");
		System.out.println("listName : " + listName);
		
		if (listName.equals("BACK TO MAIN")) {
			getServletContext().getRequestDispatcher("/indexElection.jsp").forward(request, response);
		}
		
		if (listName.equals("VOTE NOW")) {
			int electionIndex = Integer.valueOf(request.getParameter("eIndex"));
			System.out.println("Election Index : " + electionIndex);
			electionDAO vDAO = new electionDAO();
			electionDB vDB = new electionDB();
			vDB = vDAO.getAllCanddidates(electionIndex);
			request.setAttribute("voteElection", vDB);
			getServletContext().getRequestDispatcher("/voteElection.jsp").forward(request, response);			
		}
		
	}

}
