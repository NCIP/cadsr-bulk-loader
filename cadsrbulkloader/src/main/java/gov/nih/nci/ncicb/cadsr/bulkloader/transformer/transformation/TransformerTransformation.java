/*L
 * Copyright Oracle Inc, SAIC-F.
 *
 * Distributed under the OSI-approved BSD 3-Clause License.
 * See http://ncip.github.com/cadsr-bulk-loader/LICENSE.txt for details.
 */

package gov.nih.nci.ncicb.cadsr.bulkloader.transformer.transformation;

import gov.nih.nci.ncicb.cadsr.bulkloader.transformer.beans.Item;

public interface TransformerTransformation {

	public TransformerTransformationResult transform(Item marshalledObject);
}
