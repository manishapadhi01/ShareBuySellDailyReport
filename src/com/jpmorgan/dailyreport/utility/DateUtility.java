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
public interface DateUtility {

	Calendar adjustDate(Calendar inputDate, Currency currency);
	

	
}
