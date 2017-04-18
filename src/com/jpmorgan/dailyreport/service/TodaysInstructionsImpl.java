/**
 * 
 */
package com.jpmorgan.dailyreport.service;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Calendar;
import java.util.Iterator;

import com.jpmorgan.dailyreport.bean.Instruction;
import com.jpmorgan.dailyreport.utility.InstructionList;
import com.jpmorgan.dailyreport.utility.InstructionListImpl;

/**
 * @author MANISHA
 *
 */
public class TodaysInstructionsImpl implements TodaysInstructions {
	
	Logger logger = Logger.getLogger("TodaysInstructionsImpl");

	InstructionList todaysInstructionList = new InstructionListImpl();
	/*
	 * (non-Javadoc)
	 * 
	 * @see com.jpmorgan.dailyreport.service.TodaysInstructions#
	 * generateTodaysInstructions()
	 */
	@Override
	public InstructionList generateTodaysInstructions(InstructionList instructionList) {
		// TODO Auto-generated method stub
		try{
		List<Instruction> instructionFinalList = instructionList.fetchInstructionList();
		Iterator<Instruction> instructionIterator = instructionFinalList.iterator();
		while (instructionIterator.hasNext()) {
			Instruction instruction = instructionIterator.next();
			if(isSameDay(instruction.getSettlementDate())){
				getTodaysInstructionList().addToList(instruction);
			}
		}		
		return getTodaysInstructionList();
		}
		catch(Exception e){
			logger.log(Level.SEVERE, "Exception occured while generating todays Instruction", e.getMessage());
			return null;
		}
	}
		

	public InstructionList getTodaysInstructionList() {
		return todaysInstructionList;
	}

	public void setTodaysInstructionList(InstructionList todaysInstructionList) {
		this.todaysInstructionList = todaysInstructionList;
	}
	
	public void putInstructionList(InstructionList instructionList){
		setTodaysInstructionList(instructionList);
	}

	public boolean isSameDay(Calendar settlementDate) {

		Calendar todaysDate = Calendar.getInstance();
		if (todaysDate.get(Calendar.YEAR) == settlementDate.get(Calendar.YEAR)
				&& todaysDate.get(Calendar.MONTH) == settlementDate.get(Calendar.MONTH)
				&& todaysDate.get(Calendar.DAY_OF_MONTH) == settlementDate.get(Calendar.DAY_OF_MONTH)) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public InstructionList fetchInstructionList() {
		// TODO Auto-generated method stub
		return getTodaysInstructionList();
	}

}
