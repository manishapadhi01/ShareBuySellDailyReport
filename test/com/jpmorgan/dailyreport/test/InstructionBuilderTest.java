/**
 * 
 */
package com.jpmorgan.dailyreport.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Iterator;

import org.junit.Test;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.bean.Instruction;
import com.jpmorgan.dailyreport.builder.InstructionBuilder;
import com.jpmorgan.dailyreport.builder.InstructionBuilderImpl;
import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public class InstructionBuilderTest {

	@Test
	public void testCreateInstruction() {
		InstructionBuilder instructionBuilder = InstructionBuilderImpl.getInstructionBuilderInstance();
		Instruction instruction = null;
		Entity entity = new Entity("foo", "7873484343");
		Entity entity1 = new Entity("bar", "7873484343");
		Calendar incomingDate = new GregorianCalendar(2017, 3, 16);
		Calendar settlementDate = new GregorianCalendar(2017, 3, 18);
		Calendar incomingDate1 = new GregorianCalendar(2017, 4, 23);
		Calendar settlementDate1 = new GregorianCalendar(2017, 4, 24);
		instructionBuilder.createInstruction(entity, Indicator.BUY, 0.25, Currency.SGP, incomingDate, settlementDate,
				200, 67.89);
		InstructionList instructionList = instructionBuilder.fetchInstructionList();
		Iterator<Instruction> instructionListIterator = instructionList.fetchInstructionList().iterator();
		while (instructionListIterator.hasNext()) {
			instruction = instructionListIterator.next();			
		}
		assertEquals(entity, instruction.getEntity());
		assertEquals(Indicator.BUY, instruction.getIndicator());
		assertEquals(Currency.SGP, instruction.getCurrency());
		assertEquals(incomingDate, instruction.getInstructionDate());
		assertEquals(settlementDate, instruction.getSettlementDate());
		assertEquals(0.25, instruction.getAgreedFx(), 0);
		assertEquals(200, instruction.getUnits());
		assertEquals(67.89, instruction.getPrice(), 0);
		assertEquals(3394.50, instruction.getAmount(), 0.0);
		
		assertNotEquals(entity1, instruction.getEntity());
		assertNotEquals(Indicator.SELL, instruction.getIndicator());
		assertNotEquals(Currency.AED, instruction.getCurrency());
		assertNotEquals(incomingDate1, instruction.getInstructionDate());
		assertNotEquals(settlementDate1, instruction.getSettlementDate());
		assertNotEquals(0.87, instruction.getAgreedFx(), 0);
		assertNotEquals(56, instruction.getUnits());
		assertNotEquals(34.90, instruction.getPrice(), 0);
		assertNotEquals(4535.89, instruction.getAmount(), 0.0);
	}
	
	@Test
	public void testInstructionList(){
		InstructionBuilder instructionBuilder = InstructionBuilderImpl.getInstructionBuilderInstance();		
		Entity entity = new Entity("car", "7873484343");		
		Calendar incomingDate = new GregorianCalendar(2017, 3, 12);
		Calendar settlementDate = new GregorianCalendar(2017, 3, 14);		
		instructionBuilder.createInstruction(entity, Indicator.BUY, 0.25, Currency.SGP, incomingDate, settlementDate,
				200, 67.89);
		InstructionList instructionList = instructionBuilder.fetchInstructionList();
		assertEquals(3,instructionList.fetchInstructionList().size());
		assertNotEquals(5,instructionList.fetchInstructionList().size());
	}

	@Test
	public void testDateUtilityForNonAED(){
		InstructionBuilder instructionBuilder = InstructionBuilderImpl.getInstructionBuilderInstance();		
		Instruction instruction = null;
		Entity entity = new Entity("testSGP", "7873484343");		
		Calendar incomingDate = new GregorianCalendar(2017, 3, 13);
		Calendar settlementDate = new GregorianCalendar(2017, 3, 15);	
		Calendar settlementDate1 = GregorianCalendar.getInstance();
		settlementDate1.set(2017, 3, 15);
		instructionBuilder.createInstruction(entity, Indicator.BUY, 0.25, Currency.SGP, incomingDate, settlementDate,
				200, 67.89);
		InstructionList instructionList = instructionBuilder.fetchInstructionList();
		Iterator<Instruction> instructionListIterator = instructionList.fetchInstructionList().iterator();
		while (instructionListIterator.hasNext()) {
			instruction = instructionListIterator.next();	
			if(instruction.getEntity().equals(entity)){
				break;
			}
		}
		settlementDate1.add(Calendar.DATE, 2);
		assertEquals(settlementDate1.get(Calendar.YEAR), instruction.getSettlementDate().get(Calendar.YEAR));	
		assertEquals(settlementDate1.get(Calendar.MONTH), instruction.getSettlementDate().get(Calendar.MONTH));	
		assertEquals(settlementDate1.get(Calendar.DAY_OF_MONTH), instruction.getSettlementDate().get(Calendar.DAY_OF_MONTH));		
		assertNotEquals(incomingDate,instruction.getSettlementDate());
	}
	
	@Test
	public void testDateUtilityForAED(){
		InstructionBuilder instructionBuilder = InstructionBuilderImpl.getInstructionBuilderInstance();		
		Instruction instruction = null;
		Entity entity = new Entity("testAED", "7873484343");		
		Calendar incomingDate = new GregorianCalendar(2017, 3, 13);
		Calendar settlementDate = new GregorianCalendar(2017, 3, 15);	
		Calendar settlementDate1 = GregorianCalendar.getInstance();
		settlementDate1.set(2017, 3, 15);
		instructionBuilder.createInstruction(entity, Indicator.BUY, 0.25, Currency.AED, incomingDate, settlementDate,
				200, 67.89);
		InstructionList instructionList = instructionBuilder.fetchInstructionList();
		Iterator<Instruction> instructionListIterator = instructionList.fetchInstructionList().iterator();
		while (instructionListIterator.hasNext()) {
			instruction = instructionListIterator.next();	
			if(instruction.getEntity().equals(entity)){
				break;
			}
		}
		settlementDate1.add(Calendar.DATE, 1);
		assertEquals(settlementDate1.get(Calendar.YEAR), instruction.getSettlementDate().get(Calendar.YEAR));	
		assertEquals(settlementDate1.get(Calendar.MONTH), instruction.getSettlementDate().get(Calendar.MONTH));	
		assertEquals(settlementDate1.get(Calendar.DAY_OF_MONTH), instruction.getSettlementDate().get(Calendar.DAY_OF_MONTH));		
		assertNotEquals(incomingDate,instruction.getSettlementDate());
	}
}
