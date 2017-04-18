/**
 * 
 */
package com.jpmorgan.dailyreport.service;

import java.util.Map;

import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public interface DailyReport {

	Map<String, Double> generateReport(InstructionList instructionList);	
	
	InstructionList rankInstructionsOnIncoming();
	
	InstructionList rankInstructionsOnOutgoing();
	
	TodaysInstructions fetchTodaysInstructions();
	
	void putTodaysInstructions(InstructionList instructionList);
	}
