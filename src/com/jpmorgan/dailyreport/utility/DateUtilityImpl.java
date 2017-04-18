/**
 * 
 */
package com.jpmorgan.dailyreport.utility;

import java.util.Calendar;

import com.jpmorgan.dailyreport.bean.Currency;

/**
 * @author MANISHA
 *
 */
public class DateUtilityImpl implements DateUtility {

	
	/* (non-Javadoc)
	 * @see com.jpmorgan.dailyreport.utility.DateUtility#adjustDate(java.util.Calendar, com.jpmorgan.dailyreport.bean.Currency)
	 */
	@Override
	public Calendar adjustDate(Calendar inputDate, Currency currency) {
		// TODO Auto-generated method stub
		 
	if(currency.equals(Currency.AED)){
		if(inputDate.get(Calendar.DAY_OF_WEEK) == Calendar.FRIDAY)
		        {
		            inputDate.add(Calendar.DATE, 2);
		        }
		else if(inputDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
			inputDate.add(Calendar.DATE, 1);
		}
	}
	else if(!(currency.equals(Currency.AED))){
		if(inputDate.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
        {
            inputDate.add(Calendar.DATE, 2);
        }
		else if(inputDate.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
			inputDate.add(Calendar.DATE, 1);
}
	}
		
		return inputDate;
	}
	

}
