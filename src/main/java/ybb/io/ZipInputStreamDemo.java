package ybb.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

//解压文件夹
public class ZipInputStreamDemo {
	public static void main(String[] args) throws Exception {
		File file=new File("d:"+File.separator+"zipfile.zip");
		File outfile=null;
		ZipFile zipfile=new ZipFile(file);
		ZipInputStream zipinput=new ZipInputStream(new FileInputStream(file));
		ZipEntry entry=null;
		
		InputStream input=null;
		OutputStream output=null;
		while((entry=zipinput.getNextEntry())!=null){
			System.out.println("解压文件："+entry.getName());
			outfile=new File("d:"+File.separator+entry.getName());
			if(!outfile.getParentFile().exists()){
				outfile.getParentFile().mkdir();
			}
			if(!outfile.exists()){
				outfile.createNewFile();
			}
			input=zipfile.getInputStream(entry);
			output=new FileOutputStream(outfile);
			int temp=0;
			while((temp=input.read())!=-1){
				output.write(temp);
			}
			input.close();
			output.close();
		}
	}
}
