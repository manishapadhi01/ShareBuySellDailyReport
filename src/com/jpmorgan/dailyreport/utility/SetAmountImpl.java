/**
 * 
 */
package com.jpmorgan.dailyreport.utility;

/**
 * @author MANISHA
 *
 */
public class SetAmountImpl implements SetAmount {

	/* (non-Javadoc)
	 * @see com.jpmorgan.dailyreport.utility.SetAmount#calculateAmount(double, int, double)
	 */
	@Override
	public double calculateAmount(double price, int units, double agreedFx) {
		// TODO Auto-generated method stub
		return price*units*agreedFx ;
	}

}
