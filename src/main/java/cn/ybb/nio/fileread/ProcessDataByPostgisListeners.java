package cn.ybb.nio.fileread;

import java.util.List;

public class ProcessDataByPostgisListeners extends ReaderFileListener{

	public ProcessDataByPostgisListeners(String string) {
	}

	@Override
	public void output(List<String> stringList) throws Exception {
		System.out.println(stringList.size());
		
	}

}
