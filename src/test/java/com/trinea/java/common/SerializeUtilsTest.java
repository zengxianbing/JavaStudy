package com.trinea.java.common;

import java.io.Serializable;

import junit.framework.TestCase;

public class SerializeUtilsTest extends TestCase {
	 private static final String BASE_DIR = "C:\\Users\\Trinea\\Desktop\\temp\\JavaCommonTest\\SerializeUtilsTest\\";
	  protected void setUp() throws Exception {
	        assertTrue(FileUtils.makeFolder(BASE_DIR));
	    }

	    protected void tearDown() throws Exception {
	        super.tearDown();
	    }

	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    public void testSerializationAndDeserialization(){
	    
	    }
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
	    
public class ClassNotImplSerialize {

	        @SuppressWarnings("unused")
	        private long   userId;
	        @SuppressWarnings("unused")
	        private String userName;

	        public ClassNotImplSerialize(long userId, String userName){
	            this.userId = userId;
	            this.userName = userName;
	        }
	    }

	    public static class ClassImplSerialize implements Serializable {

	        private static final long serialVersionUID = 88940079192401092L;
	        private long              userId;
	        private String            userName;

	        public ClassImplSerialize(){
	            this.userId = 1;
	            this.userName = "defaultUser";
	        }

	        public ClassImplSerialize(long userId, String userName){
	            this.userId = userId;
	            this.userName = userName;
	        }

	        public long getUserId() {
	            return userId;
	        }

	        public void setUserId(long userId) {
	            this.userId = userId;
	        }

	        public String getUserName() {
	            return userName;
	        }

	        public void setUserName(String userName) {
	            this.userName = userName;
	        }
	    }
}
