/**
 * 
 */
package com.jpmorgan.dailyreport.bean;

import java.util.Calendar;


/**
 * @author MANISHA
 *
 */
public class Instruction  {

	public Entity entity;
	public Indicator indicator;
	public double agreedFx;
	public Currency currency;
	public Calendar instructionDate;
	public Calendar settlementDate;
	public int units;
	public double price;
	public double amount;
	
	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Instruction(Entity entity, Indicator indicator, double agreedFx, Currency currency, Calendar instructionDate,
			Calendar settlementDate, int units, double price) {
		super();
		this.entity = entity;
		this.indicator = indicator;
		this.agreedFx = agreedFx;
		this.currency = currency;
		this.instructionDate = instructionDate;
		this.settlementDate = settlementDate;
		this.units = units;
		this.price = price;
	}

	public Entity getEntity() {
		return entity;
	}

	public void setEntity(Entity entity) {
		this.entity = entity;
	}

	public Indicator getIndicator() {
		return indicator;
	}

	public void setIndicator(Indicator indicator) {
		this.indicator = indicator;
	}

	public double getAgreedFx() {
		return agreedFx;
	}

	public void setAgreedFx(double agreedFx) {
		this.agreedFx = agreedFx;
	}

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public Calendar getInstructionDate() {
		return instructionDate;
	}

	public void setInstructionDate(Calendar instructionDate) {
		this.instructionDate = instructionDate;
	}

	public Calendar getSettlementDate() {
		return settlementDate;
	}

	public void setSettlementDate(Calendar settlementDate) {
		this.settlementDate = settlementDate;
	}

	public int getUnits() {
		return units;
	}

	public void setUnits(int units) {
		this.units = units;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}



}
