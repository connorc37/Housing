package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ShowingList;

/**
 * Servlet implementation class ShowingListNavServlet
 */
@WebServlet("/showingListNavServlet")
public class ShowingListNavServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShowingListNavServlet() {
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
		ShowingListHelper slh = new ShowingListHelper();
		String action = request.getParameter("doThisToShowingList");

		if (action == null) {
			getServletContext().getRequestDispatcher("/viewAllShowingListsServlet").forward(request, response);
			
		} else if (action.equals("remove")) {
			try {
				int tmpId = Integer.parseInt(request.getParameter("id"));
				ShowingList toDelete = slh.findShowingListById(tmpId);
				slh.removeShowingList(toDelete);
			} catch (NumberFormatException e) {
				System.out.println("Nothing selected");
			} finally {
				getServletContext().getRequestDispatcher("/viewAllShowingListsServlet").forward(request, response);
			}
			
		} else if (action.equals("edit")) {
			try {
				int tmpId = Integer.parseInt(request.getParameter("id"));
				ShowingList toEdit = slh.findShowingListById(tmpId);
				request.setAttribute("showingListToEdit", toEdit);
				request.setAttribute("month", toEdit.getShowingDate().getMonthValue());
				request.setAttribute("date", toEdit.getShowingDate().getDayOfMonth());
				request.setAttribute("year", toEdit.getShowingDate().getYear());
						
				HouseHelper hh = new HouseHelper();
				request.setAttribute("allShowingLists", hh.showAllHouses());
				if (hh.showAllHouses().isEmpty()) {
					request.setAttribute("allItems", " ");
				}
				getServletContext().getRequestDispatcher("/edit-showing-list.jsp").forward(request, response);
			} catch (NumberFormatException e) {
				getServletContext().getRequestDispatcher("/viewAllShowingListsServlet").forward(request, response);
			}
		
		} else if (action.equals("add")) {
			getServletContext().getRequestDispatcher("/addHousesForShowingListServlet").forward(request, response);
		}
		
	}
	
}
