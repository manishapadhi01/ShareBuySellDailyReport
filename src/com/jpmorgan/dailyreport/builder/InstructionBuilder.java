/**
 * 
 */
package com.jpmorgan.dailyreport.builder;

import java.util.Calendar;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public interface InstructionBuilder {

	void createInstruction(Entity entity,
			Indicator indicator,
			double agreedFx,
			Currency currency,
			Calendar instructionDate,
			Calendar settlementDate,
			int units,
			double price);
	
	InstructionList fetchInstructionList();
}
