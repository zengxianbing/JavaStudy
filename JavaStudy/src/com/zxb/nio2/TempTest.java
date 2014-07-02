package com.zxb.nio2;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;

import org.junit.Test;

public class TempTest {

	
	@Test
	public void test1() throws IOException{
		String tmp_dir_prefix="nio_";
		Path tmp_1=Files.createTempDirectory(null);
		System.out.println("Tmp:"+tmp_1.toString());
		
		
		Path tmp_2=Files.createTempDirectory(tmp_dir_prefix);
		System.out.println("Tmp:"+tmp_2.toString());
		
		String defalut_tmp=System.getProperty("java.nio:tmpdir");
		System.out.println(defalut_tmp);
	}
	
	@Test
	public void test2() throws IOException{
		Path basedir=FileSystems.getDefault().getPath("D://test2");
		String tmp_dir_prefix="rafa_";
		Path tmp=Files.createTempDirectory(basedir, tmp_dir_prefix);
		System.out.println("TMP:"+tmp.toString());
	}
	
	
	@Test
	public void test3() throws IOException, InterruptedException{
		
		final Path basedir=FileSystems.getDefault().getPath("D://test2");
		final String tmp_dir_prefix="rafa_";
		final Path tmp_dir=Files.createTempDirectory(basedir, tmp_dir_prefix);
		Runtime.getRuntime().addShutdownHook(new Thread(){
			
		public void run(){
			System.out.println("Deleteing the temporary folder...");
			DirectoryStream<Path> ds;
			try {
				ds = Files.newDirectoryStream(tmp_dir);
				for(Path file:ds){
					Files.delete(file);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Shutdown-book completed...");
		}
	
		});
		
		
		Thread.sleep(10000);
		
	}
	
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
