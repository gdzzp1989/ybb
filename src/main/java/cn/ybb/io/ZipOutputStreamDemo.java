package cn.ybb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;
//压缩文件夹
public class ZipOutputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file=new File("d:"+File.separator+"zipfile");
		File zipfile=new File("d:"+File.separator+"zipfile.zip");
		InputStream input=null;
		ZipOutputStream zipout=null;
		zipout=new ZipOutputStream(new FileOutputStream(zipfile));
		zipout.setComment("这是注释");
		
		if(file.isDirectory()){
			File lists[]=file.listFiles();
			for(int i=0;i<lists.length;i++){
				input=new FileInputStream(lists[i]);
				zipout.putNextEntry(new ZipEntry(file.getName()+File.separator+lists[i].getName()));
				int temp=0;
				while((temp=input.read())!=-1){
					zipout.write(temp);
				}
				input.close();
			}
		}
		zipout.close();
	}
}
