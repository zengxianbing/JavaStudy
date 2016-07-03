package com.zxb.nio2;

import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.DosFileAttributes;

import org.junit.Test;

public class PathsTest2 {

	@Test
	public void test1() throws IOException{
		
		Path base=Paths.get("D://test");
		Path path_1=base.resolve("test1.txt");
		Path path_2=base.resolve("test2.txt");
	    System.out.println(path_1);
	    System.out.println(path_2);
	    
	    Path path=base.resolveSibling("test3.txt");
	    System.out.println(path.toString());
	    
	    Path path01=Paths.get("test1.txt");
	    Path path02=Paths.get("test2.txt");
	    
	    Path path01_to_path02=path01.relativize(path02);
	    System.out.println(path01_to_path02);
	    
	    
	    Path path02_to_path01=path02.relativize(path01);
	    System.out.println(path02_to_path01);
	     
	   /* boolean check=Files.isSameFile(path01, path02);
	    if(check){
		    System.out.println("is same");
	    }else{
		    System.out.println("is not same");
	    }
	    */
	     
	    Path pathd=Paths.get("D://test//test1.txt");
	    for(Path name:pathd){
		    System.out.println(name);
	    }
	    
	    BasicFileAttributes attr=Files.readAttributes(pathd, BasicFileAttributes.class);
	    
	    System.out.println("File size: " + attr.size());   
	    System.out.println("File creation time: " + attr.creationTime());   
	    System.out.println("File was last accessed at: " + attr.lastAccessTime());   
	    System.out.println("File was last modified at: " + attr.lastModifiedTime());   
	      
	    System.out.println("Is directory? " + attr.isDirectory());   
	    System.out.println("Is regular file? " + attr.isRegularFile());   
	    System.out.println("Is symbolic link? " + attr.isSymbolicLink());   
	    System.out.println("Is other? " + attr.isOther());  
	    
	    long size=(Long)Files.getAttribute(pathd, "basic:size",NOFOLLOW_LINKS );
	    
	    System.out.println("Size:"+size);
	    
	    

	    DosFileAttributes attr1=Files.readAttributes(pathd, DosFileAttributes.class);
	    
	    System.out.println("Is read only ? " + attr1.isReadOnly());   
	    System.out.println("Is Hidden ? " + attr1.isHidden());   
	    System.out.println("Is archive ? " + attr1.isArchive());   
	    System.out.println("Is system ? " + attr1.isSystem()); 
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	}
}
