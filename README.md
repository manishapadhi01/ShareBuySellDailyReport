# ShareBuySellDailyReport

This is a daily report to show the total incoming and outgoing amount for the instructions received and whose settlement date falls on the date on which the report runs, and also to rank the instructions based on incoming and outgoing for that day.

An Instruction consists of the following:

Entity: A financial entity whose shares are to be bought or sold
Currency: Currency in which the trades are bought or sold
Instruction Date: Date on which the instruction was sent to JP Morgan by various clients
Settlement Date: The date on which the client wished for the instruction to be settled with respect to Instruction Date
Buy/Sell flag:
o B – Buy – outgoing
o S – Sell – incoming
Agreed Fx is the foreign exchange rate with respect to USD that was agreed
Units: Number of shares to be bought or sold
Price: Price per Unit
Amount: USD amount of a trade calculated as Price per unit * Units * Agreed Fx

Problem Statement:

 A work week starts Monday and ends Friday, unless the currency of the trade is AED or SAR, where the work week starts Sunday and ends Thursday. No other holidays are taken into account.
 A trade can only be settled on a working day.
 If an instructed settlement date falls on a weekend, then the settlement date is changed to the next working day.
Create a report that shows
 Amount in USD settled incoming everyday
 Amount in USD settled outgoing everyday
 Ranking of entities based on incoming and outgoing amount. Eg: If entity foo instructs the highest amount for a buy instruction, then foo is rank 1 for outgoing

Functional Assumptions:

 Report is generated daily. So, the instructions for which the settlement date falls on the day the report is generated is considered for   incoming and outgoing amount and ranking for the day.
 Holidays are not taken into account while adjusting the settlement day if it falls on a weekend.
 Report is only meant to be generated on weekdays.
