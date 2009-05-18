package gov.nih.nci.ncicb.cadsr.bulkloader.loader;

import gov.nih.nci.ncicb.cadsr.bulkloader.beans.CaDSRObjects;
import gov.nih.nci.ncicb.cadsr.bulkloader.beans.LoadObjects;
import gov.nih.nci.ncicb.cadsr.bulkloader.beans.LoadProperties;
import gov.nih.nci.ncicb.cadsr.bulkloader.beans.LoaderInput;
import gov.nih.nci.ncicb.cadsr.bulkloader.dao.BulkLoaderDAOFacade;
import gov.nih.nci.ncicb.cadsr.bulkloader.parser.ParseResult;
import gov.nih.nci.ncicb.cadsr.bulkloader.parser.Parser;
import gov.nih.nci.ncicb.cadsr.bulkloader.persist.Persister;
import gov.nih.nci.ncicb.cadsr.bulkloader.persist.PersisterResult;
import gov.nih.nci.ncicb.cadsr.bulkloader.validate.Validation;
import gov.nih.nci.ncicb.cadsr.bulkloader.validate.ValidationResult;
import gov.nih.nci.ncicb.cadsr.bulkloader.validate.ValidationStatus;
import gov.nih.nci.ncicb.cadsr.domain.ClassificationScheme;
import gov.nih.nci.ncicb.cadsr.domain.Context;

public class CaDSRBulkLoaderImpl implements CaDSRBulkLoader{

	private Parser parser;
	private Validation validator;
	private Persister persister;
	private BulkLoaderDAOFacade daoFacade;
	
	public Parser getParser() {
		return parser;
	}
	public void setParser(Parser parser) {
		this.parser = parser;
	}
	public Validation getValidator() {
		return validator;
	}
	public void setValidator(Validation validator) {
		this.validator = validator;
	}
	
	public Persister getPersister() {
		return persister;
	}
	public void setPersister(Persister persister) {
		this.persister = persister;
	}
	public BulkLoaderDAOFacade getDaoFacade() {
		return daoFacade;
	}
	public void setDaoFacade(BulkLoaderDAOFacade daoFacade) {
		this.daoFacade = daoFacade;
	}
	public LoadResult load(LoaderInput input, LoadProperties loadProperties) {
		LoadResult result = new LoadResult(input);
		
		ParseResult parseResult = parser.parse(input.getFileToLoad());
		result.setParseResult(parseResult);
		if (!parseResult.hasErrors()) {
			CaDSRObjects caDSRObjects = parseResult.getCaDSRObjects();
			LoadObjects loadObjects = getLoadObjects(loadProperties);
			
			ValidationResult validationResult = performValidation(input, loadObjects, caDSRObjects);
			result.setValidationResult(validationResult);
			if (validationResult.isSuccessful() && !validationResult.hasErrors()) {
				PersisterResult persisterResult = persister.persist(caDSRObjects, loadObjects);
				result.setPersisterResult(persisterResult);
			}
		}
		
		return result;
	}
	
	private ValidationResult performValidation(LoaderInput input, LoadObjects loadObjects, CaDSRObjects caDSRObjects) {
		ValidationResult validationResult = null;
		if (input.isValidate()) {
			validationResult = validator.validate(caDSRObjects,loadObjects);
		}
		else {
			validationResult = new ValidationResult();
			validationResult.setValidationStatus(ValidationStatus.SUCCESS);
			validationResult.setValidationItem(caDSRObjects);
		}
		
		return validationResult;
	}
	
	private LoadObjects getLoadObjects(LoadProperties loadProperties) {
		LoadObjects loadObjects = new LoadObjects();
		
		Context loadContext = daoFacade.findContextByName(loadProperties.getContextName());
		ClassificationScheme loadClassScheme = daoFacade.getClassificationScheme(loadProperties.getClassificationSchemeName());
		
		loadObjects.setLoadContext(loadContext);
		loadObjects.setLoadClassScheme(loadClassScheme);
		
		return loadObjects;
	}
}
