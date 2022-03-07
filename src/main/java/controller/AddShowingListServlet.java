package controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;
import model.Realtor;
import model.ShowingList;

/**
 * Servlet implementation class AddShowingListServlet
 */
@WebServlet("/addShowingListServlet")
public class AddShowingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddShowingListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Gather info.
		String showingListName = request.getParameter("showingListName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String realtorName = request.getParameter("realtorName");
		String realtorCompany = request.getParameter("realtorCompany");

		// Address the date.
		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException exception){
			ld = LocalDate.now();
		}
		
		// Address the realtor.
		Realtor r = new Realtor(realtorName, realtorCompany);
		
		// Address the selection
		String[] selectedHouses = request.getParameterValues("housesToAdd");
		List<House> selectedHousesList = new ArrayList<House>();
		
		HouseHelper hh = new HouseHelper();
		if(selectedHouses != null && selectedHouses.length > 0) {
			for(int i = 0; i < selectedHouses.length; i++) {
				House h = hh.findHouseById(Integer.parseInt(selectedHouses[i]));
				selectedHousesList.add(h);
			}
		}
		
		// Create new showing list using all the above and add it.
		ShowingList sl = new ShowingList(showingListName, ld, r, selectedHousesList);
		ShowingListHelper slh = new ShowingListHelper();
		slh.addShowingList(sl);
		
		getServletContext().getRequestDispatcher("/viewAllShowingListsServlet").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
