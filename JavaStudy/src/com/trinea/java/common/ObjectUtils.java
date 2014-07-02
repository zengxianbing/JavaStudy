package com.trinea.java.common;

public class ObjectUtils {

	/**
	 * 比较两个对象是否相等
	 * @param actual
	 * @param expected
	 * @return
	 */
	public static boolean isEquals(Object actual,Object expected){
		return actual==null?expected==null:actual.equals(expected);
	}
	
	 /**
     * long数组转换成Long数组
     * 
     * @param source
     * @return
     */
	public static Long[] transformLongArray(long[] source){
		Long[] destin=new Long[source.length];
		for(int i=0;i<source.length;i++){
			destin[i]=source[i];
		}
		return destin;
	}
	
	  /**
     * Long数组转换成long数组
     * 
     * @param source
     * @return
     */
	public static long[] transformLongArray(Long[] source){
		long[] destin=new long[source.length];
		for(int i=0;i<source.length;i++){
			destin[i]=source[i];
		}
		return destin;
	}
	
	/**
     * int数组转换成Integer数组
     * 
     * @param source
     * @return
     */
	public static Integer[] transformIntArray(int[] source){
		Integer[] destin=new Integer[source.length];
		for(int i=0;i<source.length;i++){
			destin[i]=source[i];
		}
		return destin;
	}
	
	  /**
     * Integer数组转换成int数组
     * 
     * @param source
     * @return
     */
	public static int[] transformIntArray(Integer[] source){
		int[] destin=new int[source.length];
		for(int i=0;i<source.length;i++){
			destin[i]=source[i];
		}
		return destin;
	}
	
	
	   /**
     * 比较两个值的大小<br/>
     * <ul>
     * </ul>
     * <strong>关于比较的结果</strong>
     * <ul>
     * <li>v1大于v2返回1</li>
     * <li>v1等于v2返回0</li>
     * <li>v1小于v2返回-1</li>
     * </ul>
     * <strong>关于比较的规则</strong>
     * <ul>
     * <li>若v1为null，v2为null，则相等</li>
     * <li>若v1为null，v2不为null，则v1小于v2</li>
     * <li>若v1不为null，v2为null，则v1大于v2</li>
     * <li>若v1、v2均不为null，则利用v1的{@link Comparable#compareTo(Object)}判断，参数为v2</li>
     * </ul>
     * 
     * @param v1
     * @param v2
     * @return
     */
    @SuppressWarnings({"unchecked", "rawtypes"})
    public static <V> int compare(V v1, V v2) {
        return v1 == null ? (v2 == null ? 0 : -1) : (v2 == null ? 1 : ((Comparable)v1).compareTo(v2));
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
