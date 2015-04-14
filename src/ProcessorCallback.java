import com.hnebang.android.ebrtsp2livelib.RtspH264ProcessorCallback;
import com.hnebang.android.ebrtsp2livelib.VideoPublishState;

public 	class ProcessorCallback implements RtspH264ProcessorCallback{
	@Override
	public void postProcessorMessage(long receivedKB, long publishedKB, String msg, String cameraIp) {
		if(msg != null && msg != ""){
			System.out.println(String.format("Video source message -- IP: %s, Message: %s ", cameraIp, msg));
		}else{
			System.out.println(String.format("Published data update -- IP: %s, sent: %d KB ", cameraIp, publishedKB));
		}		
	}

	@Override
	public void updateProcessorStatus(VideoPublishState publishState, String cameraIp) {
		System.out.println(String.format("video source changed -- IP: %s, Video Publishing State:%s ", cameraIp, publishState.toString()));		
	}
}