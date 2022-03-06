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
 * Servlet implementation class EditShowingListServlet
 */
@WebServlet("/editShowingListServlet")
public class EditShowingListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditShowingListServlet() {
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
		HouseHelper hh = new HouseHelper();
		RealtorHelper rh = new RealtorHelper();
		
		int tmpId = Integer.parseInt(request.getParameter("id"));
		ShowingList sl = slh.findShowingListById(tmpId);

		String newShowingName = request.getParameter("showingName");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		String year = request.getParameter("year");
		String realtorName = request.getParameter("realtorName");
		
		Realtor newRealtor = rh.findRealtor(realtorName);

		LocalDate ld;
		try {
			ld = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
		} catch (NumberFormatException e) {
			ld = LocalDate.now();
		}
		try {
			String[] selectedHouses = request.getParameterValues("allHousesToAdd");
			List<House> selectedHousesList = new ArrayList<House>();

			for (int i = 0; i < selectedHouses.length; i++) {
				System.out.println(selectedHouses[i]);
				House h = hh.findHouseById(Integer.parseInt(selectedHouses[i]));
				selectedHousesList.add(h);
			}
			sl.setListOfShowings(selectedHousesList);
		} catch (NullPointerException e) {
			List<House> selectedHousesList = new ArrayList<House>();
			sl.setListOfShowings(selectedHousesList);
		}

		sl.setShowingName(newShowingName);
		sl.setRealtor(newRealtor);
		sl.setShowingDate(ld);
		
		slh.editShowingList(sl);

		getServletContext().getRequestDispatcher("/viewAllShowingListsServlet").forward(request, response);
	}

}
