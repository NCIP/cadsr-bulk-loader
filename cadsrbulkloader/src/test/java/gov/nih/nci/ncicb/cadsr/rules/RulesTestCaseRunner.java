/*L
 * Copyright Oracle Inc, SAIC-F.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-bulk-loader/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.rules;

import junit.framework.Test;
import junit.framework.TestSuite;


public class RulesTestCaseRunner  {

	public static Test suite() {
		TestSuite suite = new TestSuite();
		suite.addTestSuite(ValueDomainNoErrorTestCase.class);
		suite.addTestSuite(ValueDomainErrorTestCase.class);
		suite.addTestSuite(DECNoErrorTestCase.class);
		
		return suite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}
}
