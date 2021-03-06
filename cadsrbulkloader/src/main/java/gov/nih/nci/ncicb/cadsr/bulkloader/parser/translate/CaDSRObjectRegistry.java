/*L
 * Copyright Oracle Inc, SAIC-F.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-bulk-loader/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.bulkloader.parser.translate;

import gov.nih.nci.ncicb.cadsr.domain.ClassificationScheme;
import gov.nih.nci.ncicb.cadsr.domain.ClassificationSchemeItem;
import gov.nih.nci.ncicb.cadsr.domain.Concept;
import gov.nih.nci.ncicb.cadsr.domain.ConceptualDomain;
import gov.nih.nci.ncicb.cadsr.domain.DataElement;
import gov.nih.nci.ncicb.cadsr.domain.DataElementConcept;
import gov.nih.nci.ncicb.cadsr.domain.ObjectClass;
import gov.nih.nci.ncicb.cadsr.domain.Property;
import gov.nih.nci.ncicb.cadsr.domain.ValueDomain;
import gov.nih.nci.ncicb.cadsr.domain.ValueMeaning;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class CaDSRObjectRegistry {
	
	private final Map<String, Concept> conceptsMap;
	private final Map<String, Property> propertiesMap;
	private final Map<String, ObjectClass> objectClassMap;
	private final Map<String, ValueDomain> valueDomainMap;
	private final Map<String, DataElementConcept> dataElementConceptMap;
	private final Map<String, DataElement> dataElementMap;
	private final Map<String, ConceptualDomain> conceptualDomainMap;
	private final Map<String, ValueMeaning> valueMeaningMap;
	private final Map<String, ClassificationSchemeItem> csiMap;
	private final Map<String, ClassificationScheme> csMap;
	
	public CaDSRObjectRegistry() {
		conceptsMap = new HashMap<String, Concept>();
		propertiesMap = new HashMap<String, Property>();
		objectClassMap = new HashMap<String, ObjectClass>();
		valueDomainMap = new HashMap<String, ValueDomain>();
		dataElementConceptMap = new HashMap<String, DataElementConcept>();
		dataElementMap = new HashMap<String, DataElement>();
		conceptualDomainMap = new HashMap<String, ConceptualDomain>();
		valueMeaningMap = new HashMap<String, ValueMeaning>();
		csiMap = new HashMap<String, ClassificationSchemeItem>();
		csMap = new HashMap<String, ClassificationScheme>();
	}
	
	public void addConcept(String tagId, Concept con) {
		conceptsMap.put(tagId, con);
	}
	
	public void addProperty(String tagId, Property prop) {
		propertiesMap.put(tagId, prop);
	}
	
	public void addObjectClass(String tagId, ObjectClass oc) {
		objectClassMap.put(tagId, oc);
	}
	
	public void addValueDomain(String tagId, ValueDomain vd) {
		valueDomainMap.put(tagId, vd);
	}
	
	public void addDataElementConcept(String tagId, DataElementConcept dec) {
		dataElementConceptMap.put(tagId, dec);
	}
	
	public void addDataElement(String tagId, DataElement de) {
		dataElementMap.put(tagId, de);
	}
	
	public void addConceptualDomain(String tagId, ConceptualDomain cd) {
		conceptualDomainMap.put(tagId, cd);
	}
	
	public void addValueMeaning(String tagId, ValueMeaning vm) {
		valueMeaningMap.put(tagId, vm);
	}
	
	public void addClassificationSchemeItem(String tagId, ClassificationSchemeItem csi) {
		csiMap.put(tagId, csi);
	}
	
	public void addClassificationScheme(String tagId, ClassificationScheme cs) {
		csMap.put(tagId, cs);
	}
	
	
	
	
	
	
	public Concept getConcept(String tagId) {
		return conceptsMap.get(tagId);
	}
	
	public Property getProperty(String tagId) {
		if (tagId == null) return null;
		else {
			return propertiesMap.get(tagId);
		}
	}
	
	public ObjectClass getObjectClass(String tagId) {
		if (tagId == null) return null;
		else {
			return objectClassMap.get(tagId);
		}
	}
	
	public ValueDomain getValueDomain(String tagId) {
		return valueDomainMap.get(tagId);
	}
	
	public DataElementConcept getDataElementConcept(String tagId) {
		return dataElementConceptMap.get(tagId);
	}
	
	public DataElement getDataElement(String tagId) {
		return dataElementMap.get(tagId);
	}
	
	public ConceptualDomain getConceptualDomain(String tagId) {
		return conceptualDomainMap.get(tagId);
	}
	
	public ValueMeaning getValueMeaning(String tagId) {
		return valueMeaningMap.get(tagId);
	}
	
	public ClassificationSchemeItem getClassificationSchemeItem(String tagId) {
		return csiMap.get(tagId);
	}
	
	public ClassificationScheme getClassificationScheme(String tagId) {
		return csMap.get(tagId);
	}
	
	
	
	
	public List<Concept> getConcepts() {
		return getValuesAsList(conceptsMap);
	}
	
	public List<Property> getProperties() {
		return getValuesAsList(propertiesMap);
	}
	
	public List<ObjectClass> getObjectClasses() {
		return getValuesAsList(objectClassMap);
	}
	
	public List<ValueDomain> getValueDomains() {
		return getValuesAsList(valueDomainMap);
	}
	
	public List<DataElementConcept> getDataElementConcepts() {
		return getValuesAsList(dataElementConceptMap);
	}
	
	public List<DataElement> getDataElements() {
		return getValuesAsList(dataElementMap);
	}
	
	public List<ConceptualDomain> getConceptualDomains() {
		return getValuesAsList(conceptualDomainMap);
	}
	
	public List<ValueMeaning> getValueMeanings() {
		return getValuesAsList(valueMeaningMap);
	}
	
	public List<ClassificationSchemeItem> getClassificationSchemeItems() {
		return getValuesAsList(csiMap);
	}
	
	public List<ClassificationScheme> getClassificationSchemes() {
		return getValuesAsList(csMap);
	}
	
	
	
	private <T> List<T> getValuesAsList(Map<String, T> map) {
		Collection<T> collection = map.values();
		List<T> retList = new ArrayList<T>();
		
		Iterator<T> collectionIter = collection.iterator();
		while(collectionIter.hasNext()) {
			retList.add(collectionIter.next());
		}
		
		return retList;
	}

}
