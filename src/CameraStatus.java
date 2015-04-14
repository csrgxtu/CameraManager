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

import java.util.ArrayList;


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
	  
	  String res = "{recs: [";
	  // first, get all devices
	  String[][] cameras = new String[][]{
	      {"camera#1", "01:f3:45:67:89:ab", "192.168.10.97", "554"},
	      {"camera#2", "rt:23:45:67:89:ab", "192.168.10.98", "554"},
	      {"camera#3", "df:23:45:67:89:ab", "192.168.10.99", "554"},
	      {"camera#4", "0f:f3:45:67:89:ab", "192.168.10.100", "554"},
	      {"camera#5", "df:53:45:67:d9:ab", "192.168.10.101", "554"}
	  };
	  
	  // second, get the online info
	  for (int i = 0; i < cameras.length; i++) {
	    CameraState cs = new CameraState(cameras[i][2], Integer.parseInt(cameras[i][3]));
	    if (cs.isOnLine()) {
	      res += "{cameraID: '" + cameras[i][0] + "', mac: '"
	          + cameras[i][1] + "', ip: '" + cameras[i][2]
	          + "', port: '" + cameras[i][3] + "', status: 'ON'},";
	    } else {
        res += "{cameraID: '" + cameras[i][0] + "', mac: '"
            + cameras[i][1] + "', ip: '" + cameras[i][2]
            + "', port: '" + cameras[i][3] + "', status: 'OFF'},";
	    }
	  }
    res = res.substring(0, res.length() - 1);
    res += "]}";
    System.out.println(res);
    
    pw.write(res);
    pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  this.doGet(request, response);
	}

}
