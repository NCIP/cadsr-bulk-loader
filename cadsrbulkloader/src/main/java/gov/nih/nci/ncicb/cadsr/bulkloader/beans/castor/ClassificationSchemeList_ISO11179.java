/*L
 * Copyright Oracle Inc, SAIC-F.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-bulk-loader/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.bulkloader.beans.castor;

import java.util.List;

public class ClassificationSchemeList_ISO11179 {
	
	private List<ClassificationScheme_ISO11179> classSchemes;

	public List<ClassificationScheme_ISO11179> getClassSchemes() {
		return classSchemes;
	}

	public void setClassSchemes(List<ClassificationScheme_ISO11179> classSchemes) {
		this.classSchemes = classSchemes;
	}
	
}
