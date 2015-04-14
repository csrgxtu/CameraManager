

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Rtsp2Rtmp
 */
@WebServlet("/Rtsp2Rtmp")
public class Rtsp2Rtmp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Rtsp2Rtmp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		String IP = request.getParameter("ip");
		String cameraID = request.getParameter("cameraID");
		String rtspUrl = "rtsp://" + IP + ":554/AmbaStreamTest";
		String rtmpUrl = "rtmp://127.0.0.1:1935/live/" + cameraID;
		
		// create tasks
		Runnable task = new Rtsp2RtmpTask(rtspUrl, rtmpUrl);
		
		// create threads
		Thread thread = new Thread(task);
		
		// start threads
		thread.start();
		
		pw.write("OK");
		pw.flush();
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  this.doGet(request, response);
	}

}
