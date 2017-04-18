/**
 * 
 */
package com.jpmorgan.dailyreport.service;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.bean.Instruction;
import com.jpmorgan.dailyreport.utility.AmountComparator;
import com.jpmorgan.dailyreport.utility.InstructionList;
import com.jpmorgan.dailyreport.utility.InstructionListImpl;

/**
 * @author MANISHA
 *
 */
public class DailyReportImpl implements DailyReport {

	Logger logger = Logger.getLogger("DailyReportImpl");
	
	private static DailyReport dailyReport;

	public TodaysInstructions todaysInstructionList = new TodaysInstructionsImpl();

	public TodaysInstructions getTodaysInstructionList() {
		return todaysInstructionList;
	}

	public void setTodaysInstructionList(TodaysInstructions todaysInstructionList) {
		this.todaysInstructionList = todaysInstructionList;
	}

	private DailyReportImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

	public static DailyReport getDailyReportInstance() {
		if (dailyReport == null) {
			dailyReport = new DailyReportImpl();
		}
		return dailyReport;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpmorgan.dailyreport.service.DailyReport#generateReport()
	 */
	@Override
	public Map<String, Double> generateReport(InstructionList instructionList) {
		// TODO Auto-generated method stub
		double incomingAmount = 0.0;
		double outgoingAmount = 0.0;
		Map<String, Double> incomingOutgoingAmount = new HashMap<String, Double>();
		try{
		InstructionList instructionListForTodaysReport = todaysInstructionList
				.generateTodaysInstructions(instructionList);
		putTodaysInstructions(instructionListForTodaysReport);
		List<Instruction> finalList = instructionListForTodaysReport.fetchInstructionList();
		Iterator<Instruction> finalListIterator = finalList.iterator();		
		while (finalListIterator.hasNext()) {
			Instruction instruction = finalListIterator.next();
			if (instruction.indicator == Indicator.SELL) {
				incomingAmount+= instruction.getAmount();				
			} else if (instruction.indicator == Indicator.BUY) {
				outgoingAmount+= instruction.getAmount();				
			}

		}
		incomingOutgoingAmount.put("incomingAmount", incomingAmount);
		incomingOutgoingAmount.put("outgoingAmount", outgoingAmount);
		return incomingOutgoingAmount;
		}
		catch(Exception e){
			logger.log(Level.SEVERE, "Exception occured while generating report for incoming and outgoing amount", e.getMessage());
			return null;
		}
	}


	@Override
	public InstructionList rankInstructionsOnIncoming() {
		// TODO Auto-generated method stub
		InstructionList incomingAmountList = new InstructionListImpl();
		try{
		InstructionList list = getTodaysInstructionList().fetchInstructionList();
		Iterator<Instruction> listIterator = list.fetchInstructionList().iterator();
		while(listIterator.hasNext()){
			Instruction instruction = listIterator.next();
			if(instruction.getIndicator() == Indicator.SELL){
			incomingAmountList.addToList(instruction);
			}			
		}		
		
		Collections.sort(incomingAmountList.fetchInstructionList(), new AmountComparator<Instruction>());
		return incomingAmountList;
		}
		catch(Exception e){
			logger.log(Level.SEVERE, "Exception occured while ranking instructions based on incoming amount", e.getMessage());
			return null;
		}
	}

	@Override
	public InstructionList rankInstructionsOnOutgoing() {
		// TODO Auto-generated method stub
		InstructionList outgoingAmountList = new InstructionListImpl();
		try{
		InstructionList list = getTodaysInstructionList().fetchInstructionList();
		Iterator<Instruction> listIterator = list.fetchInstructionList().iterator();
		while(listIterator.hasNext()){
			Instruction instruction = listIterator.next();
			if(instruction.getIndicator() == Indicator.BUY){
				outgoingAmountList.addToList(instruction);
			}			
		}		
		Collections.sort(outgoingAmountList.fetchInstructionList(), new AmountComparator<Instruction>());
		return outgoingAmountList;
		}
		catch(Exception e){
			logger.log(Level.SEVERE, "Exception occured while ranking instructions based on outgoing amount", e.getMessage());
			return null;
		}
	}

	@Override
	public TodaysInstructions fetchTodaysInstructions() {
		// TODO Auto-generated method stub
		return getTodaysInstructionList();
	}

	@Override
	public void putTodaysInstructions(InstructionList instructionList) {
		getTodaysInstructionList().putInstructionList(instructionList);		
	}

}
