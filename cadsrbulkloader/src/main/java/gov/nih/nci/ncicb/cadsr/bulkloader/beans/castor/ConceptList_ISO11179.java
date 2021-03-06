/*L
 * Copyright Oracle Inc, SAIC-F.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-bulk-loader/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.bulkloader.beans.castor;

import java.util.List;

/**
 * 
 * @author Ashwin Mathur
 * @version 1.0, Jan 15, 2009
 * @since 
 */

public class ConceptList_ISO11179 {

	private List<Concept_caDSR11179> concepts;

	public List<Concept_caDSR11179> getConcepts() {
		return concepts;
	}

	public void setConcepts(List<Concept_caDSR11179> concepts) {
		this.concepts = concepts;
	}
	
	
}
