package com.suggest;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;




interface Identifier{
	String REFUSE_WORD="你无权访问";
	
	public boolean identify();
}




enum CommonIdentifier implements Identifier{
	

	Reader,Author,Admin;
	
	public boolean identify() {
		return false;
	}
	
}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Access{
	CommonIdentifier level()  default CommonIdentifier.Admin;
	
}



@Access(level=CommonIdentifier.Author)
class Foo{}








public class Annotation1 {

	public static void main(String[] args) {

		Foo b=new Foo();
		
		Access access=b.getClass().getAnnotation(Access.class);
		
		if(access==null||!access.level().identify()){
			System.out.println(access.level().REFUSE_WORD);
		}
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
