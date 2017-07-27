package main;

import java.math.BigDecimal;

public class Calculus {

	int lbs28;
	int los28;
	int vas;
	int obcrp;

	Calculus(int lbs28, int los28, int vas, int obcrp) {
		super();
		this.lbs28 = lbs28;
		this.los28 = los28;
		this.vas = vas;
		this.obcrp = obcrp;
	}

	String calculateResult() {
		BigDecimal bigResult = new BigDecimal("0.00");

		BigDecimal bigLBS = new BigDecimal(Math.sqrt(lbs28));
		BigDecimal bigLOS = new BigDecimal(Math.sqrt(los28));
		BigDecimal bigOBCRP = new BigDecimal(Math.log(obcrp));
		BigDecimal bigVAS = new BigDecimal(new Integer(vas).toString());

		bigLBS = bigLBS.multiply(new BigDecimal("0.56"));
		bigLOS = bigLOS.multiply(new BigDecimal("0.28"));
		bigOBCRP = bigOBCRP.multiply(new BigDecimal("0.70"));
		bigVAS = bigVAS.multiply(new BigDecimal("0.014"));

		bigResult = bigResult.add(bigLBS);
		bigResult = bigResult.add(bigLOS);
		bigResult = bigResult.add(bigOBCRP);
		bigResult = bigResult.add(bigVAS);

		String result = bigResult.setScale(2, BigDecimal.ROUND_HALF_UP).toString();

		return result;
	}
}
