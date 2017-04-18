/**
 * 
 */
package com.jpmorgan.dailyreport.test;

import static org.junit.Assert.*;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.ListIterator;
import java.util.Map;

import org.junit.Test;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.bean.Instruction;
import com.jpmorgan.dailyreport.builder.InstructionBuilder;
import com.jpmorgan.dailyreport.builder.InstructionBuilderImpl;
import com.jpmorgan.dailyreport.service.DailyReport;
import com.jpmorgan.dailyreport.service.DailyReportImpl;
import com.jpmorgan.dailyreport.service.TodaysInstructions;
import com.jpmorgan.dailyreport.service.TodaysInstructionsImpl;
import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public class RankInstructionsOnIncomingTest {

	@Test
	public void testRankInstructionsOnIncoming() {
		InstructionBuilder instructionBuilder = InstructionBuilderImpl.getInstructionBuilderInstance();

		Entity entity = new Entity("foo", "7873484343");
		Entity entity1 = new Entity("testSGP", "7873484343");
		Entity entity2 = new Entity("testAED", "7873484343");
		Calendar incomingDate = new GregorianCalendar(2017, 3, 16);
		Calendar settlementDate = new GregorianCalendar(2017, 3, 18);
		Calendar incomingDate1 = new GregorianCalendar(2017, 3, 23);
		Calendar settlementDate1 = new GregorianCalendar(2017, 3, 18);
		Calendar incomingDate2 = new GregorianCalendar(2017, 3, 23);
		Calendar settlementDate2 = new GregorianCalendar(2017, 3, 16);
		instructionBuilder.createInstruction(entity, Indicator.SELL, 0.25, Currency.SGP, incomingDate, settlementDate,
				200, 67.89);
		instructionBuilder.createInstruction(entity1, Indicator.SELL, 0.25, Currency.SGP, incomingDate1, settlementDate1,
				200, 37.89);
		instructionBuilder.createInstruction(entity2, Indicator.BUY, 0.25, Currency.AED, incomingDate2, settlementDate2,
				200, 67.89);
		//TodaysInstructions i = new TodaysInstructionsImpl();
		
		DailyReport report = DailyReportImpl.getDailyReportInstance();		
		InstructionList list = report.fetchTodaysInstructions().generateTodaysInstructions(instructionBuilder.fetchInstructionList());
		report.putTodaysInstructions(list);
		InstructionList sortedList = report.rankInstructionsOnIncoming();
		ListIterator<Instruction> itr = sortedList.fetchInstructionList().listIterator();		
		Map<Integer, String> rank = new HashMap<Integer, String>();
		Map<Integer, String> rankTest = new HashMap<Integer, String>();
		rankTest.put(1, "foo");
		rankTest.put(2, "testSGP");
		while(itr.hasNext()){
			rank.put(1, itr.next().getEntity().getName());
			rank.put(2, itr.next().getEntity().getName());
		}
		assertEquals(rankTest, rank);
	}

}
