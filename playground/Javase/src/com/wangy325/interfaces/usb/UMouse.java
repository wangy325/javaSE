/**
 * 
 */
package com.wangy325.interfaces.usb;

/**
 * @author wangy325
 *
 * @date Dec 16, 2017  6:45:18 PM
 *
 * @decription  
 * 
 * @target TODO
 */
public class UMouse implements USBInerface{

	/* (non-Javadoc)
	 * @see com.wangy325.USB.USBInerface#services()
	 */
	@Override
	public void services() {
		// TODO Auto-generated method stub
		System.out.println("a UMouse  connect to a pc with USB port");
	}

}
