/**
 * 
 */
package com.jpmorgan.dailyreport.utility;

import java.util.List;

import com.jpmorgan.dailyreport.bean.Instruction;

/**
 * @author MANISHA
 *
 */
public interface InstructionList {

	void addToList(Instruction instruction);
	
	List<Instruction> fetchInstructionList();
}
