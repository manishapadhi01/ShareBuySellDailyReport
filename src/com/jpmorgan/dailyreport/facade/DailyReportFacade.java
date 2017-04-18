/**
 * 
 */
package com.jpmorgan.dailyreport.facade;

import java.util.Calendar;
import java.util.Map;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public interface DailyReportFacade {

	void createInstruction(Entity entity, Indicator indicator, double agreedFx, Currency currency,
			Calendar instructionDate, Calendar settlementDate, int units, double price);
	
	Map<String,Double> dailyReportService();
	
	InstructionList sortedIncomingInstructionList();
	
	InstructionList sortedOutgoingInstructionList();
}
