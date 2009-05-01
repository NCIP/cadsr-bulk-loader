package gov.nih.nci.ncicb.cadsr.bulkloader.parser.translate;

import gov.nih.nci.ncicb.cadsr.bulkloader.beans.castor.ClassificationScheme_ISO11179;
import gov.nih.nci.ncicb.cadsr.bulkloader.beans.castor.ISO11179Elements;
import gov.nih.nci.ncicb.cadsr.domain.ClassificationScheme;
import gov.nih.nci.ncicb.cadsr.domain.DomainObjectFactory;

import java.util.List;

public class ClassificationSchemeTranslator extends AbstractTranslatorTemplate {

	@Override
	protected CaDSRObjectRegistry translateElement(ISO11179Elements iso11179Elements, CaDSRObjectRegistry objRegistry) {
		List<ClassificationScheme_ISO11179> isoClassSchemes = iso11179Elements.getClassSchemes();
		for (ClassificationScheme_ISO11179 isoClassScheme: isoClassSchemes) {
			ClassificationScheme cs = getCS(isoClassScheme);
			
			objRegistry.addClassificationScheme(isoClassScheme.getTagId(), cs);
		}
		return objRegistry;
	}
	
	private ClassificationScheme getCS(ClassificationScheme_ISO11179 isoCS) {
		ClassificationScheme cs = DomainObjectFactory.newClassificationScheme();
		String publicId = util.getIdentifier(isoCS);
		String name = isoCS.getName();
		String type = isoCS.getTypeName();
		float version = isoCS.getVersion();
		
		cs.setPublicId(publicId);
		cs.setVersion(version);
		cs.setPreferredName(name);
		cs.setPreferredDefinition(name);
		cs.setType(type);
		cs.setLongName(name);
		
		return cs;
	}

}