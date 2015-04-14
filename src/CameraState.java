/**
 * Author: Archer Reilly
 * Date: 13/Apr/2015
 * File: CameraState.java
 * Desc: check the state of the Camera
 * 
 * Produced By Ebang
 */
import java.net.Socket;
import java.io.IOException;

public class CameraState {
  private String IP;
  private int Port;
  
  public CameraState(String ip, int port) {
    this.IP = ip;
    this.Port = port;
  }
  
  public boolean isOnLine() {
    try {
      Socket socket = new Socket(IP, Port);
      socket.close(); 
    } catch (IOException e) {
      return false;
    }
    return true;
  }
  
  public String getIP() {
    return IP;
  }
  
  public int getPort() {
    return Port;
  }
  
  public void setIP(String ip) {
    this.IP = ip;
  }
  
  public void setPort(int port) {
    this.Port = port;
  }
}
