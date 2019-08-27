package ybb.thread.httpserver;

public class TestMyService {
	public static void main(String[] args) {
		try {
			SimpleHttpServer.start();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
