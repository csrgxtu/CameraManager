/**
 * Author: Archer Reilly
 * Date: 13/Apr/2015
 * File: Rtsp2RtmpTask.java
 * Desc: the task that pull from rtsp and push to rtmp, and will be
 * invoked by thread, should implement runnable.
 * 
 * Produced By Ebang.
 */
import com.hnebang.android.ebrtsp2livelib.RtspH264Processor;

public class Rtsp2RtmpTask implements Runnable {
  private String rtspUrl;
  private String rtmpUrl;
  private String rtmpUrlParams = "";
  
  public Rtsp2RtmpTask(String rtspUrl, String rtmpUrl) {
    this.rtspUrl = rtspUrl;
    this.rtmpUrl = rtmpUrl;
  }
  
  public void run() {
    ProcessorCallback callback = new ProcessorCallback();
    RtspH264Processor h264Processor = new RtspH264Processor(callback, rtspUrl);
    h264Processor.asyncStartPublish(rtmpUrl, rtmpUrlParams);
  }
}
