package gov.nih.nci.ncicb.cadsr.bulkloader.dao;

import gov.nih.nci.ncicb.cadsr.MainTestCase;
import gov.nih.nci.ncicb.cadsr.bulkloader.beans.CaDSRObjects;
import gov.nih.nci.ncicb.cadsr.bulkloader.dao.util.BulkLoaderDAOUtil;
import gov.nih.nci.ncicb.cadsr.bulkloader.util.SpringBeansUtil;

/**
 * 
 * @author Ashwin Mathur
 * @version 1.0, Jan 16, 2009
 * @since 
 */

public class ConceptsDAOTestCase extends MainTestCase {

	public void testSaveConcept() {
		BulkLoaderDAOUtil conceptsDAO = SpringBeansUtil.getConceptsDAO();
		conceptsDAO.saveElements(getCaDSRObjects());
	}
	
	private CaDSRObjects getCaDSRObjects() {
		CaDSRObjects objects = new CaDSRObjects();
		
		objects.setConcepts(getObjectClassConcepts());
		
		return objects;
	}
}