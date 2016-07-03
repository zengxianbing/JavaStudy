package com.zxb.nio2;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.junit.Test;

public class PathsTest {

	@Test
	public void pathTest(){
		Path path=Paths.get("D:","test.txt");
		System.out.println("The file/directory path"+path.getFileName());
		System.out.println(path.getRoot());
		System.out.println(path.getParent());
		for(int i=0;i<path.getNameCount();i++){
			System.out.println("Name element"+i+" is:"+path.getName(i));
			
		}
		System.out.println("Subpath(0,3):"+path.subpath(0, 3));
		
		
		String path_to_String=path.toString();
		
		System.out.println("Path to String:"+path_to_String);
		
		URI path_to_uri=path.toUri();
		System.out.println("Path to URI:"+path_to_uri);
		
		
		Path path_to_absolute_path=path.toAbsolutePath();
		System.out.println("Path to absolute:"+path_to_absolute_path);
		
		
		try {
			Path real_path=path.toRealPath(LinkOption.NOFOLLOW_LINKS);
			System.out.println("Path to real path:"+real_path);
		} catch (IOException e) {
			// TODO A.uto-generated catch block
			e.printStackTrace();
		}
		
		 
		
		File path_to_file=path.toFile();
		Path file_to_path=path_to_file.toPath();
		System.out.println("Path to file name:"+path_to_file.getName());
		System.out.println("Path to path:"+file_to_path.toString());
		
		
		
		
		
		
		
		
		
		
		
	}
}
