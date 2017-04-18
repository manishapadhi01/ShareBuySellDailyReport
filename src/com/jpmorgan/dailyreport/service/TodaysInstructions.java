/**
 * 
 */
package com.jpmorgan.dailyreport.service;

import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public interface TodaysInstructions {

	InstructionList generateTodaysInstructions(InstructionList instructionList);
	
	InstructionList fetchInstructionList();
	
	public void putInstructionList(InstructionList instructionList);
}
