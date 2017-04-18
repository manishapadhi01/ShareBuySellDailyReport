/**
 * 
 */
package com.jpmorgan.dailyreport.main;

import java.util.GregorianCalendar;
import java.util.HashMap;

import java.util.ListIterator;
import java.util.Map;

import com.jpmorgan.dailyreport.bean.Currency;
import com.jpmorgan.dailyreport.bean.Entity;
import com.jpmorgan.dailyreport.bean.Indicator;
import com.jpmorgan.dailyreport.bean.Instruction;

import com.jpmorgan.dailyreport.facade.DailyReportFacade;
import com.jpmorgan.dailyreport.facade.DailyReportFacadeImpl;
import com.jpmorgan.dailyreport.utility.InstructionList;

/**
 * @author MANISHA
 *
 */
public class ReportGenerationDemo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, Double> finalAmountForTheDay = new HashMap<String, Double>();
		DailyReportFacade dailyReportFacade = new DailyReportFacadeImpl();

		dailyReportFacade.createInstruction(new Entity("test1", "7873484343"), Indicator.BUY, 0.25, Currency.SGP,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 200, 67.89);
		dailyReportFacade.createInstruction(new Entity("test2", "7873484343"), Indicator.BUY, 0.25, Currency.AED,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 100, 76.98);
		dailyReportFacade.createInstruction(new Entity("test3", "7873484343"), Indicator.BUY, 0.25, Currency.GBP,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 250, 50.00);
		dailyReportFacade.createInstruction(new Entity("test4", "7873484343"), Indicator.BUY, 0.25, Currency.INR,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 180, 100.00);
		dailyReportFacade.createInstruction(new Entity("test5", "7873484343"), Indicator.BUY, 0.25, Currency.SGP,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 50, 43.98);
		dailyReportFacade.createInstruction(new Entity("test6", "7873484343"), Indicator.SELL, 0.25, Currency.SGP,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 80, 43.45);
		dailyReportFacade.createInstruction(new Entity("test7", "7873484343"), Indicator.SELL, 0.25, Currency.AED,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 300, 43.87);
		dailyReportFacade.createInstruction(new Entity("test8", "7873484343"), Indicator.SELL, 0.25, Currency.GBP,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 180, 56.98);
		dailyReportFacade.createInstruction(new Entity("test9", "7873484343"), Indicator.SELL, 0.25, Currency.INR,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 200, 76.56);
		dailyReportFacade.createInstruction(new Entity("test10", "7873484343"), Indicator.SELL, 0.25, Currency.SGP,
				new GregorianCalendar(2017, 3, 12), new GregorianCalendar(2017, 3, 18), 210, 87.54);

		finalAmountForTheDay = dailyReportFacade.dailyReportService();

		System.out.println("Total Incoming Amount for today: " + finalAmountForTheDay.get("incomingAmount")+" USD\n");
		System.out.println("Total Outgoing Amount for today: " + finalAmountForTheDay.get("outgoingAmount")+" USD\n");

		InstructionList rankIncomingInstruction = dailyReportFacade.sortedIncomingInstructionList();
		InstructionList rankOutgoingInstruction = dailyReportFacade.sortedOutgoingInstructionList();

		ListIterator<Instruction> incomingInstructionListIterator = rankIncomingInstruction.fetchInstructionList()
				.listIterator();
		System.out.println("Instructions Ranking based on Incoming Amount\n");
		System.out.println("Entity Name\tIncoming Amount\n");
		while (incomingInstructionListIterator.hasNext()) {
			Instruction instruction = incomingInstructionListIterator.next();
			System.out.println(instruction.getEntity().getName()+"\t\t "+instruction.getAmount()+" USD");
		}

		ListIterator<Instruction> outgoingInstructionListIterator = rankOutgoingInstruction.fetchInstructionList()
				.listIterator();
		System.out.println("\nInstructions Ranking based on Outgoing Amount\n");
		System.out.println("Entity Name\tOutgoing Amount\n");
		while (outgoingInstructionListIterator.hasNext()) {
			Instruction instruction = outgoingInstructionListIterator.next();
			System.out.println(instruction.getEntity().getName()+"\t\t"+instruction.getAmount()+" USD");
		}
	}

}
