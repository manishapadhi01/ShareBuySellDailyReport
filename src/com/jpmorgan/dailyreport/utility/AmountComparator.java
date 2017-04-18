/**
 * 
 */
package com.jpmorgan.dailyreport.utility;

import java.util.Comparator;

import com.jpmorgan.dailyreport.bean.Instruction;

/**
 * @author MANISHA
 *
 */
public class AmountComparator<Object> implements Comparator<Object> {

	@Override
	public int compare(Object obj1, Object obj2) {
		// TODO Auto-generated method stub
		Instruction instruction1 = (Instruction) obj1;
		Instruction instruction2 = (Instruction) obj2;
			if(instruction2.getAmount()==instruction1.getAmount())
			return 0;  
			else if(instruction2.getAmount()>instruction1.getAmount())  
			return 1;  
			else  
			return -1;
	}

}
