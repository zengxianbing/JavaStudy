package com.UnitTest.easymock;

import static org.junit.Assert.*;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class ShoppingCartTest {

	
	public ShoppingCart cart=null;
	
	public Store storeMock=null;
	
	@Before
	public void initialize(){
		cart=new ShoppingCart();
		storeMock=EasyMock.createMock(Store.class);
		cart.setStore(storeMock);
	}
	
	 @Test       
	    public void testShoppingCart()  
	    {  
	      
	          
	        EasyMock.expect(storeMock.getPrice("Mead Spiral Bound Notebook, College Rule")).andStubReturn((int) 5.99);  
	        EasyMock.expect(storeMock.getPrice("Kindle Fire HD 8.9")).andReturn((int) 499.99);  
	          
	            //开始使用mock  
	        EasyMock.replay(storeMock);  
	                  
	        Item item1 = new Item("Mead Spiral Bound Notebook, College Rule", 3);  
	        Item item2 = new Item("Kindle Fire HD 8.9",1);  
	          
	        cart.addItem(item1);  
	        cart.addItem(item2);  
	          
	        double total = cart.calculateTotal();  
	          
	        System.out.println("Total price of items in shopping cart: $"+total);  
	        assertEquals("Result",505.96, total,0);  
	    }  
	      
	    @After  
	    public void cleanup()   
	    {  
	        cart=null;  
	        storeMock=null;  
	    }  
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
