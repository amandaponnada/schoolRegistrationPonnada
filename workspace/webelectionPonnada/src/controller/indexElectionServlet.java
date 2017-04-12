package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.electionDAO;
import model.electionDB;
/**
 * Servlet implementation class indexElectionServlet
 */
@WebServlet("/indexElectionServlet")
public class indexElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public indexElectionServlet() {
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
		System.out.println("Inside Master Servlet");
		String toDo = request.getParameter("radios");
		System.out.println("Selected Radion Value : " + toDo);
		if(toDo.equals("newPoll")) {
			getServletContext().getRequestDispatcher("/addElection.jsp").forward(request, response);
		} else if (toDo.equals("curPoll")) {
			electionDAO eDAO = new electionDAO();
			ArrayList<electionDB> curElections = eDAO.getAllElections();
			request.setAttribute("curElections", curElections);
			
			System.out.println("Launch available Election List");
 			getServletContext().getRequestDispatcher("/listElection.jsp").forward(request, response);
		}
		
	}

}
