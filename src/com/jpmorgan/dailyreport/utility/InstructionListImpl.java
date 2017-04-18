/**
 * 
 */
package com.jpmorgan.dailyreport.utility;

import java.util.ArrayList;
import java.util.List;

import com.jpmorgan.dailyreport.bean.Instruction;

/**
 * @author MANISHA
 *
 */
public class InstructionListImpl implements InstructionList {

	public List<Instruction> instructionList = new ArrayList<Instruction>();
	public List<Instruction> getInstructionList() {
		return instructionList;
	}
	public void setInstructionList(List<Instruction> instructionList) {
		this.instructionList = instructionList;
	}	
	
	public List<Instruction> fetchInstructionList(){
		return getInstructionList();
	}
	
	/* (non-Javadoc)
	 * @see com.jpmorgan.dailyreport.utility.InstructionList#addToList(com.jpmorgan.dailyreport.bean.Instruction)
	 */
	@Override
	public void addToList(Instruction instruction) {
		// TODO Auto-generated method stub
		this.instructionList.add(instruction);
	}
	public InstructionListImpl() {
		super();
		// TODO Auto-generated constructor stub
	}

}
