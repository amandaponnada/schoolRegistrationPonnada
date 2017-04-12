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
 * Servlet implementation class voteElectionServlet
 */
@WebServlet("/voteElectionServlet")
public class voteElectionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public voteElectionServlet() {
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
		int eID = Integer.valueOf(request.getParameter("eId"));
		String goTo = request.getParameter("VOTE");
		electionDAO vDAO = new electionDAO();
		electionDB vDB = new electionDB();
		
		if (goTo.equals("CAST")) {
			String selectedCandidate = request.getParameter("voteCandidate");
			System.out.println("Election Index : " + eID);
//			getServletContext().getRequestDispatcher("/indexElection.jsp").forward(request, response);
			vDB = vDAO.getAllCanddidates(eID);
			if (selectedCandidate.equals("candidate1")) {
				vDB.seteCandidate1Votes(vDB.geteCandidate1Votes()+1);
			} else if (selectedCandidate.equals("candidate2")) {
				vDB.seteCandidate2Votes(vDB.geteCandidate2Votes()+1);
			} else if (selectedCandidate.equals("candidate3")) {
				vDB.seteCandidate3Votes(vDB.geteCandidate3Votes()+1);
			}
			vDAO.updateCandidates(vDB);
			request.setAttribute("voteElection", vDB);
			getServletContext().getRequestDispatcher("/voteElection.jsp").forward(request, response);			
		}
		if (goTo.equals("BACK")) {
			electionDAO eDAO = new electionDAO();
			ArrayList<electionDB> curElections = eDAO.getAllElections();
			request.setAttribute("curElections", curElections);
			System.out.println("Launch available Election List");
 			getServletContext().getRequestDispatcher("/listElection.jsp").forward(request, response);
		}
		if (goTo.equals("RESULTS")) {
			vDB = vDAO.getAllCanddidates(eID);
			System.out.println("In Results : " + vDB.getElectionName());
			request.setAttribute("resElection", vDB);
			getServletContext().getRequestDispatcher("/resultsElection.jsp").forward(request, response);			
		}		
	}

}

