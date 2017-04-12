package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.electionDB;
import model.electionDAO;
/**
 * Servlet implementation class addElectionServlet
 */
@WebServlet("/addElectionServlet")
public class addElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addElectionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}    

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {	

		System.out.println("----------Add Election Servlet --------------");
		try {
			String electionName 	= request.getParameter("eName");
			String eCandidate1Name = request.getParameter("candidate1Name");
			String eCandidate2Name = request.getParameter("candidate2Name");
			String eCandidate3Name = request.getParameter("candidate3Name");

			Random rand = new Random();
			int rand_eid = rand.nextInt(1000) + 1;
			
			electionDB newElection = new electionDB(rand_eid, electionName, eCandidate1Name, eCandidate2Name, eCandidate3Name);
 			electionDAO eDAO = new electionDAO();
 			eDAO.insertNewElection(newElection);
			
			RequestDispatcher dispatcher=request.getRequestDispatcher("/viewElection.jsp");
			request.setAttribute("election", newElection);
			dispatcher.forward(request, response);
			
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
