package com.zxb.nio2;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;

import org.junit.Test;

public class FileVisitorTest {

	class ListTree extends SimpleFileVisitor<Path>{

		@Override
		public FileVisitResult postVisitDirectory(Path dir, IOException arg1)
				throws IOException {
            System.out.println("Vistied directory:"+dir.toString());
			return FileVisitResult.CONTINUE;
		}

		@Override
		public FileVisitResult visitFileFailed(Path arg0, IOException exc)
				throws IOException {
            System.out.println(exc);
			return FileVisitResult.CONTINUE;
		}
		
	}
	
	@Test
	public void test1() throws IOException{
		Path listDir=Paths.get("D://test2");
		ListTree walk=new ListTree();
		Files.walkFileTree(listDir, walk);
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
