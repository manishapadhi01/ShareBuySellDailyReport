/**
 * 
 */
package com.jpmorgan.dailyreport.builder;

import java.util.Calendar;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.bean.Instruction;
import com.jpmorgan.dailyreport.utility.DateUtility;
import com.jpmorgan.dailyreport.utility.DateUtilityImpl;
import com.jpmorgan.dailyreport.utility.InstructionList;
import com.jpmorgan.dailyreport.utility.InstructionListImpl;
import com.jpmorgan.dailyreport.utility.SetAmount;
import com.jpmorgan.dailyreport.utility.SetAmountImpl;

/**
 * @author MANISHA
 *
 */
public class InstructionBuilderImpl implements InstructionBuilder {

	/* (non-Javadoc)
	 * @see com.jpmorgan.dailyreport.builder.InstructionBuilder#createInstruction(com.jpmorgan.dailyreport.bean.Entity, com.jpmorgan.dailyreport.bean.Indicator, double, com.jpmorgan.dailyreport.bean.Currency, java.util.Calendar, java.util.Calendar, int, double)
	 */
	public InstructionList instructionList= new InstructionListImpl();
	
	public InstructionList getInstructionList() {
		return instructionList;
	}
	public void setInstructionList(InstructionList instructionList) {
		this.instructionList = instructionList;
	}
	public DateUtility dateUtil = new DateUtilityImpl();
	public SetAmount setAmount = new SetAmountImpl();	
	private static InstructionBuilder instructionBuilder;
	
	public InstructionList fetchInstructionList(){
		return getInstructionList();
	}
	
	private InstructionBuilderImpl() {
		super();
		// TODO Auto-generated constructor stub
	}
	public static InstructionBuilder getInstructionBuilderInstance(){
		if(instructionBuilder == null){
			instructionBuilder = new InstructionBuilderImpl();			
		}
		return instructionBuilder;
	}
	@Override
	public void createInstruction(Entity entity, Indicator indicator, double agreedFx, Currency currency,
			Calendar instructionDate, Calendar settlementDate, int units, double price) {
		// TODO Auto-generated method stub
		Instruction instruction = new Instruction(entity,indicator,agreedFx,currency,instructionDate,settlementDate,units,price);
		instruction.setSettlementDate(dateUtil.adjustDate(settlementDate, currency));
		instruction.setAmount(setAmount.calculateAmount(price, units, agreedFx));
		instructionList.addToList(instruction);
	}

}
