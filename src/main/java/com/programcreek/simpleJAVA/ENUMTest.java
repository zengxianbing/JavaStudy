package com.programcreek.simpleJAVA;

 enum Color{
	 RED( 1 ) , YELLOW( 2 ) , BLUE( 3 ) ;
//	 RED(1),
	 private int value ;
	 private Color ( ) { }
	 private Color ( int i ) {
	 this.value = i ;
	 }
	 
	 public void printValue(){
		 System.out.println(this.value);
	 }
}
public class ENUMTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		for(Color color:Color.values()){
			color.printValue();
		}
	}

}
