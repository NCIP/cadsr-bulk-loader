/*L
 * Copyright Oracle Inc, SAIC-F.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-bulk-loader/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.bulkloader.loader;

import gov.nih.nci.ncicb.cadsr.bulkloader.beans.LoadProperties;
import gov.nih.nci.ncicb.cadsr.bulkloader.beans.LoaderInput;
import gov.nih.nci.ncicb.cadsr.bulkloader.event.EventRecorder;

public interface CaDSRBulkLoader {

	public EventRecorder getRecorder();
	public void setRecorder(EventRecorder recorder);
	public void load(LoaderInput input, LoadProperties loadProperties);
}
