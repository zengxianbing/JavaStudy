package com.mkyong.IO;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.LineNumberReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.StringTokenizer;

import junit.framework.TestCase;

public class IODemo extends TestCase {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		try {
			File file = new File("d:\\test3.txt");
			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {

				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void FilePathExample() {
		try {
			String filename = "testing.txt";
			String finalfile = "";
			String workingDir = System.getProperty("user.dir");

			String your_os = System.getProperty("os.name").toLowerCase();
			if (your_os.indexOf("win") >= 0) {
				finalfile = workingDir + "\\" + filename;
			} else if (your_os.indexOf("nix") >= 0
					|| your_os.indexOf("nux") >= 0) {
				finalfile = workingDir + "/" + filename;

			} else {
				finalfile = workingDir + "{others}" + filename;
			}

			System.out.println("Final filepath:" + finalfile);
			File file = new File(finalfile);

			if (file.createNewFile()) {
				System.out.println("Done");
			} else {
				System.out.println("File already exists!");
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void FilePermissionExample() {
		try {

			File file = new File("/mkyong/shellscript.sh");

			if (file.exists()) {
				System.out.println("Is Execute allow : " + file.canExecute());
				System.out.println("Is Write allow : " + file.canWrite());
				System.out.println("Is Read allow : " + file.canRead());
			}

			file.setExecutable(false);
			file.setReadable(false);
			file.setWritable(false);

			System.out.println("Is Execute allow : " + file.canExecute());
			System.out.println("Is Write allow : " + file.canWrite());
			System.out.println("Is Read allow : " + file.canRead());

			if (file.createNewFile()) {
				System.out.println("File is created!");
			} else {
				System.out.println("File already exists.");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void BufferedInputStreamExample() {
		File file = new File("D:\\testing.txt");
		FileInputStream fis = null;
		BufferedInputStream bis = null;
		DataInputStream dis = null;

		try {
			fis = new FileInputStream(file);

			bis = new BufferedInputStream(fis);
			dis = new DataInputStream(bis);

			while (dis.available() != 0) {
				System.out.println(dis.readLine());
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fis.close();
				bis.close();
				dis.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void BufferedReaderExample() {
		BufferedReader br = null;

		try {

			String sCurrentLine;

			br = new BufferedReader(new FileReader("C:\\testing.txt"));

			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (br != null)
					br.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void WriteFileExample() {
		FileOutputStream fop = null;
		File file;
		String content = "This is the text content";

		try {

			file = new File("c:/newfile.txt");
			fop = new FileOutputStream(file);

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (fop != null) {
					fop.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	public void WriteFileExample1() {
		/*File file = new File("c:/newfile.txt");
		String content = "This is the text content";

		try (FileOutputStream fop = new FileOutputStream(file)) {

			// if file doesn't exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// get the content in bytes
			byte[] contentInBytes = content.getBytes();

			fop.write(contentInBytes);
			fop.flush();
			fop.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}*/
	}

	public void WriteToFileExample() {
		try {

			String content = "This is the content to write into file";

			File file = new File("/users/mkyong/filename.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			FileWriter fw = new FileWriter(file.getAbsoluteFile());
			BufferedWriter bw = new BufferedWriter(fw);
			bw.write(content);
			bw.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void AppendToFileExample() {
		try {
			String data = " This content will append to the end of the file";

			File file = new File("javaio-appendfile.txt");

			// if file doesnt exists, then create it
			if (!file.exists()) {
				file.createNewFile();
			}

			// true = append file
			FileWriter fileWritter = new FileWriter(file.getName(), true);
			BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
			bufferWritter.write(data);
			bufferWritter.close();

			System.out.println("Done");

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void DeleteFileExample() {
		try {

			File file = new File("c:\\logfile20100131.log");

			if (file.delete()) {
				System.out.println(file.getName() + " is deleted!");
			} else {
				System.out.println("Delete operation is failed.");
			}

		} catch (Exception e) {

			e.printStackTrace();

		}
	}

	public void RenameFileExample() {
		File oldfile = new File("oldfile.txt");
		File newfile = new File("newfile.txt");

		if (oldfile.renameTo(newfile)) {
			System.out.println("Rename succesful");
		} else {
			System.out.println("Rename failed");
		}
	}

	private static final String FILE_DIR = "c:\\folder";
	private static final String FILE_TEXT_EXT = ".txt";

	public void deleteFile(String folder, String ext) {

		GenericExtFilter filter = new GenericExtFilter(ext);
		File dir = new File(folder);

		// list out all the file name with .txt extension
		String[] list = dir.list(filter);

		if (list.length == 0)
			return;

		File fileDelete;

		for (String file : list) {
			String temp = new StringBuffer(FILE_DIR).append(File.separator)
					.append(file).toString();
			fileDelete = new File(temp);
			boolean isdeleted = fileDelete.delete();
			System.out.println("file : " + temp + " is deleted : " + isdeleted);
		}
	}

	// inner class, generic extension filter
	public class GenericExtFilter implements FilenameFilter {

		private String ext;

		public GenericExtFilter(String ext) {
			this.ext = ext;
		}

		public boolean accept(File dir, String name) {
			return (name.endsWith(ext));
		}
	}
	
	
	
	
	public void listFile(String folder, String ext) {
		 
		GenericExtFilter filter = new GenericExtFilter(ext);
 
		File dir = new File(folder);
 
		if(dir.isDirectory()==false){
			System.out.println("Directory does not exists : " + FILE_DIR);
			return;
		}
 
		// list out all the file name and filter by the extension
		String[] list = dir.list(filter);
 
		if (list.length == 0) {
			System.out.println("no files end with : " + ext);
			return;
		}
 
		for (String file : list) {
			String temp = new StringBuffer(FILE_DIR).append(File.separator)
					.append(file).toString();
			System.out.println("file : " + temp);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public  void CopyFileExample(){
		InputStream inStream = null;
		OutputStream outStream = null;
	 
	    	try{
	 
	    	    File afile =new File("Afile.txt");
	    	    File bfile =new File("Bfile.txt");
	 
	    	    inStream = new FileInputStream(afile);
	    	    outStream = new FileOutputStream(bfile);
	 
	    	    byte[] buffer = new byte[1024];
	 
	    	    int length;
	    	    //copy the file content in bytes 
	    	    while ((length = inStream.read(buffer)) > 0){
	 
	    	    	outStream.write(buffer, 0, length);
	 
	    	    }
	 
	    	    inStream.close();
	    	    outStream.close();
	 
	    	    System.out.println("File is copied successful!");
	 
	    	}catch(IOException e){
	    		e.printStackTrace();
	    	}
	}
	
	
	
	public void  MoveFileExample(){
		InputStream inStream = null;
		OutputStream outStream = null;
	 
	    	try{
	 
	    	    File afile =new File("C:\\folderA\\Afile.txt");
	    	    File bfile =new File("C:\\folderB\\Afile.txt");
	 
	    	    inStream = new FileInputStream(afile);
	    	    outStream = new FileOutputStream(bfile);
	 
	    	    byte[] buffer = new byte[1024];
	 
	    	    int length;
	    	    //copy the file content in bytes 
	    	    while ((length = inStream.read(buffer)) > 0){
	 
	    	    	outStream.write(buffer, 0, length);
	 
	    	    }
	 
	    	    inStream.close();
	    	    outStream.close();
	 
	    	    //delete the original file
	    	    afile.delete();
	 
	    	    System.out.println("File is copied successful!");
	 
	    	}catch(IOException e){
	    	    e.printStackTrace();
	    	}
	}
	
	
	public void GetFileCreationDateExample(){
		try{
			 
    		Process proc = 
    		   Runtime.getRuntime().exec("cmd /c dir c:\\logfile.log /tc");
 
    		BufferedReader br = 
    		   new BufferedReader(
    		      new InputStreamReader(proc.getInputStream()));
 
    		String data ="";
 
    		//it's quite stupid but work
    		for(int i=0; i<6; i++){
    			data = br.readLine();
    		}
 
    		System.out.println("Extracted value : " + data);
 
    		//split by space
    		StringTokenizer st = new StringTokenizer(data);
    		String date = st.nextToken();//Get date
    		String time = st.nextToken();//Get time
 
    		System.out.println("Creation Date  : " + date);
    		System.out.println("Creation Time  : " + time);
 
    	}catch(IOException e){
 
    		e.printStackTrace();
 
    	}
	}
	
	
	
	
	public void GetFileLastModifiedExample(){
	
		File file = new File("c:\\logfile.log");
		 
		System.out.println("Before Format : " + file.lastModified());
	 
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
	 
		System.out.println("After Format : " + sdf.format(file.lastModified()));
	
	}
	
	
	public void ChangeFileLastModifiedExample(){
		try{
			 
    		File file = new File("C:\\logfile.log");
 
    		//print the original last modified date
    		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
    		System.out.println("Original Last Modified Date : " 
    				+ sdf.format(file.lastModified()));
 
    		//set this date 
    		String newLastModified = "01/31/1998";
 
    		//need convert the above date to milliseconds in long value 
    		Date newDate = sdf.parse(newLastModified);
    		file.setLastModified(newDate.getTime());
 
    		//print the latest last modified date
    		System.out.println("Lastest Last Modified Date : " 
    				+ sdf.format(file.lastModified()));
 
    	}catch(ParseException e){
 
    		e.printStackTrace();
 
    	}
	}
	
	
	
	public void FileReadAttribute(){
		File file = new File("c:/file.txt");
		 
    	//mark this file as read only, since jdk 1.2
    	file.setReadOnly();
 
    	if(file.canWrite()){
    	     System.out.println("This file is writable");
    	}else{
    	     System.out.println("This file is read only");
    	}
 
    	//revert the operation, mark this file as writable, since jdk 1.6
    	file.setWritable(true);
 
    	if(file.canWrite()){
    	     System.out.println("This file is writable");
    	}else{
    	     System.out.println("This file is read only");
    	}   	
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public void  FileSizeExample(){
		File file =new File("c:\\java_xml_logo.jpg");
		 
		if(file.exists()){
 
			double bytes = file.length();
			double kilobytes = (bytes / 1024);
			double megabytes = (kilobytes / 1024);
			double gigabytes = (megabytes / 1024);
			double terabytes = (gigabytes / 1024);
			double petabytes = (terabytes / 1024);
			double exabytes = (petabytes / 1024);
			double zettabytes = (exabytes / 1024);
			double yottabytes = (zettabytes / 1024);
 
			System.out.println("bytes : " + bytes);
			System.out.println("kilobytes : " + kilobytes);
			System.out.println("megabytes : " + megabytes);
			System.out.println("gigabytes : " + gigabytes);
			System.out.println("terabytes : " + terabytes);
			System.out.println("petabytes : " + petabytes);
			System.out.println("exabytes : " + exabytes);
			System.out.println("zettabytes : " + zettabytes);
			System.out.println("yottabytes : " + yottabytes);
		}else{
			 System.out.println("File does not exists!");
		}
	}
	
	
	public void AbsoluteFilePathExample(){
		try{
			 
    	    File temp = File.createTempFile("i-am-a-temp-file", ".tmp" );
 
    	    String absolutePath = temp.getAbsolutePath();
    	    System.out.println("File path : " + absolutePath);
 
    	    String filePath = absolutePath.
    	    	     substring(0,absolutePath.lastIndexOf(File.separator));
 
    	    System.out.println("File path : " + filePath);
 
    	}catch(IOException e){
 
    	    e.printStackTrace();
 
    	}
	}
	
	public void LineNumberReaderExample(){
		try{
			 
    		File file =new File("c:\\ihave10lines.txt");
 
    		if(file.exists()){
 
    		    FileReader fr = new FileReader(file);
    		    LineNumberReader lnr = new LineNumberReader(fr);
 
    		    int linenumber = 0;
 
    	            while (lnr.readLine() != null){
    	        	linenumber++;
    	            }
 
    	            System.out.println("Total number of lines : " + linenumber);
 
    	            lnr.close();
 
 
    		}else{
    			 System.out.println("File does not exists!");
    		}
 
    	}catch(IOException e){
    		e.printStackTrace();
    	}
 
	}
	
	
	public void FileChecker(){
		  File f = new File("c:\\mkyong.txt");
		  
		  if(f.exists()){
			  System.out.println("File existed");
		  }else{
			  System.out.println("File not found!");
		  }
	}
	
	
	public void FileHidden(){
	
		File file = new File("c:/hidden-file.txt");
		 
    	if(file.isHidden()){
    		System.out.println("This file is hidden");
    	}else{
    		System.out.println("This file is not hidden");
    	}
	}
	
	
	
	public void test1UTF(){
		try {
			File fileDir = new File("c:\\temp\\test.txt");
	 
			BufferedReader in = new BufferedReader(
			   new InputStreamReader(
	                      new FileInputStream(fileDir), "UTF8"));
	 
			String str;
	 
			while ((str = in.readLine()) != null) {
			    System.out.println(str);
			}
	 
	                in.close();
		    } 
		    catch (UnsupportedEncodingException e) 
		    {
				System.out.println(e.getMessage());
		    } 
		    catch (IOException e) 
		    {
				System.out.println(e.getMessage());
		    }
		    catch (Exception e)
		    {
				System.out.println(e.getMessage());
		    }
	}
	
	
	
	public void test2UTF(){
		  try {
				File fileDir = new File("c:\\temp\\test.txt");
		 
				Writer out = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(fileDir), "UTF8"));
		 
				out.append("Website UTF-8").append("\r\n");
				out.append("?? UTF-8").append("\r\n");
				out.append("??????? UTF-8").append("\r\n");
		 
				out.flush();
				out.close();
		 
			    } 
			   catch (UnsupportedEncodingException e) 
			   {
				System.out.println(e.getMessage());
			   } 
			   catch (IOException e) 
			   {
				System.out.println(e.getMessage());
			    }
			   catch (Exception e)
			   {
				System.out.println(e.getMessage());
			   } 
	}
	
	public void Assign_File_Content(){
		try{
			 
	         DataInputStream dis = 
		    new DataInputStream (
		    	 new FileInputStream ("c:\\logging.log"));

		 byte[] datainBytes = new byte[dis.available()];
		 dis.readFully(datainBytes);
		 dis.close();

		 String content = new String(datainBytes, 0, datainBytes.length);

		 System.out.println(content);

	}catch(Exception ex){
		ex.printStackTrace();
	}
	}
	
	
	
	
	
	
	

}
