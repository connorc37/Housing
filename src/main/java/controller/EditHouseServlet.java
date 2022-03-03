package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.House;

/**
 * Servlet implementation class EditHouseServlet
 */
@WebServlet("/editHouseServlet")
public class EditHouseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditHouseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HouseHelper hh = new HouseHelper();
		
		String number = request.getParameter("number");
		String street = request.getParameter("street");
		String city = request.getParameter("city");
		String zip = request.getParameter("zip");
		int tmpId = Integer.parseInt(request.getParameter("id"));
		
		House houseToEdit = hh.findHouseById(tmpId);
		houseToEdit.setNumber(number);
		houseToEdit.setStreet(street);
		houseToEdit.setCity(city);
		houseToEdit.setZip(zip);
		
		hh.editHouse(houseToEdit);
		
		getServletContext().getRequestDispatcher("/viewAllHousesServlet").forward(request, response);
	}

}
