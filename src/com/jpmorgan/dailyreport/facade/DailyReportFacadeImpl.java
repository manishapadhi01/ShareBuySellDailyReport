/**
 * 
 */
package com.jpmorgan.dailyreport.facade;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.builder.InstructionBuilder;
import com.jpmorgan.dailyreport.builder.InstructionBuilderImpl;
import com.jpmorgan.dailyreport.service.DailyReport;
import com.jpmorgan.dailyreport.service.DailyReportImpl;
import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public class DailyReportFacadeImpl implements DailyReportFacade {

	
	/* (non-Javadoc)
	 * @see com.jpmorgan.dailyreport.facade.DailyReportFacade#dailyReportService()
	 */
	@Override
	public Map<String,Double> dailyReportService() {
		// TODO Auto-generated method stub
		Map<String,Double> dailyAmount = new HashMap<String,Double>();
		DailyReport report = DailyReportImpl.getDailyReportInstance();
		dailyAmount = report.generateReport(InstructionBuilderImpl.getInstructionBuilderInstance().fetchInstructionList());
		return dailyAmount;
	}
	
	public void createInstruction(Entity entity, Indicator indicator, double agreedFx, Currency currency,
			Calendar instructionDate, Calendar settlementDate, int units, double price){
		InstructionBuilder instructionBuilder = InstructionBuilderImpl.getInstructionBuilderInstance();
		instructionBuilder.createInstruction(entity, indicator, agreedFx, currency, instructionDate, settlementDate, units, price);
	}

	@Override
	public InstructionList sortedIncomingInstructionList() {
		// TODO Auto-generated method stub
		DailyReport report = DailyReportImpl.getDailyReportInstance();
		InstructionList sortedIncomingInstructionList = report.rankInstructionsOnIncoming();
		return sortedIncomingInstructionList;
	}

	@Override
	public InstructionList sortedOutgoingInstructionList() {
		// TODO Auto-generated method stub
		DailyReport report = DailyReportImpl.getDailyReportInstance();
		InstructionList sortedOutgoingInstructionList = report.rankInstructionsOnOutgoing();
		return sortedOutgoingInstructionList;
	}

}
