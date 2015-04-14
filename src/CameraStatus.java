/**
 * Author: Archer Reilly
 * Date: 13/Apr/2015
 * File: CameraStatus.java
 * Desc: provide RESTful API for the client.
 * 
 * Produced By Ebang
 */

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class CameraStatus
 */
@WebServlet("/CameraStatus")
public class CameraStatus extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  /**
   * @see HttpServlet#HttpServlet()
   */
  public CameraStatus() {
      super();
      // TODO Auto-generated constructor stub
  }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  PrintWriter pw = response.getWriter();
	  String jsonString = "{recs: [";
	  for (int i = 0; i < 4; i++) {
	    CameraState cs = new CameraState("127.0.0.1", 8080);
	    if (cs.isOnLine()) {
	      jsonString += "{cameraID: 'camera#" + i + "', Status: 'ON', Push: 0},";
	    } else {
	      jsonString += "{cameraID: 'camera#" + i + "', Status: 'OFF', Push: 0},";
	    }
	  }
	  jsonString = jsonString.substring(0, jsonString.length() - 1);
	  jsonString += "]}";
	  pw.write(jsonString);
	  pw.flush();
	  
	  // first, get all devices status
	  
	  // second, get the online info
	  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  this.doGet(request, response);
	}

}
