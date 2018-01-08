/**
 * 
 */
package com.wangy325.interfaces.interfaces;

/**
 * @author wangy325
 *
 * @date Dec 13, 2017  7:57:25 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class Material {
	
	 String material;
	
	public Material() {}
	
	public Material(String material) {
		super();
		this.material = setMat(material);
	}
	
	protected String setMat(String mat) {
		return mat;
		
	}
	

}
