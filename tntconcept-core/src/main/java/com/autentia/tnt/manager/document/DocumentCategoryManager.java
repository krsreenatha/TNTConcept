/**
 * TNTConcept Easy Enterprise Management by Autentia Real Bussiness Solution S.L.
 * Copyright (C) 2007 Autentia Real Bussiness Solution S.L.
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package com.autentia.tnt.manager.document;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.businessobject.DocumentCategory;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.DocumentCategoryDAO;
import com.autentia.tnt.dao.search.DocumentCategorySearch;
import com.autentia.tnt.util.ConfigurationUtil;
import com.autentia.tnt.util.SpringUtils;



public class DocumentCategoryManager {


/* DocumentCategory - generated by stajanov (do not edit/delete) */


  /** Logger */
  private static final Log log = LogFactory.getLog(DocumentCategoryManager.class);

  /** DocumentCategory DAO **/
  private DocumentCategoryDAO documentCategoryDAO;

  /**
   * Get default DocumentCategoryManager as defined in Spring's configuration file.
   * @return the default singleton DocumentCategoryManager
   */
  public static DocumentCategoryManager getDefault()
  {
    return (DocumentCategoryManager)SpringUtils.getSpringBean("managerDocumentCategory");
  }

  /** 
   * Empty constructor needed by CGLIB (Spring AOP)
   */
  protected DocumentCategoryManager()
  {
  }
	
  /** 
   * Default constructor 
   * @deprecated do not construct managers alone: use Spring's declared beans
   */
  public DocumentCategoryManager( DocumentCategoryDAO documentCategoryDAO )
  {
    this.documentCategoryDAO = documentCategoryDAO;
  }

  /**
   * List documentCategorys. 
   * @param search search filter to apply
   * @param sort sorting criteria
   * @return the list of all documentCategorys sorted by requested criterion
   */
  public List<DocumentCategory> getAllEntities(DocumentCategorySearch search, SortCriteria sort){
    return documentCategoryDAO.search( search, sort );
  }
  
  /**
   * Get documentCategory by primary key.
   * @return documentCategory selected by id.
   */
  public DocumentCategory getEntityById(int id){
    return documentCategoryDAO.getById(id);	    
  }
	
  /**
   * Insert documentCategory. 
   */
  public void insertEntity(DocumentCategory documentCategory) {
    documentCategoryDAO.insert(documentCategory);
  }
	 
  /**
   * Update documentCategory. 
   */
  public void updateEntity(DocumentCategory documentCategory) {
    documentCategoryDAO.update(documentCategory);
  }

  /**
   * Delete documentCategory. 
   */
  public void deleteEntity(DocumentCategory documentCategory) {
    documentCategoryDAO.delete(documentCategory);
  }
/* DocumentCategory - generated by stajanov (do not edit/delete) */
	
	
  public DocumentCategory getDocumentCategoryParent()
  {
    return (DocumentCategory) documentCategoryDAO.getById( ConfigurationUtil.getDefault().getUserDocumentCategoryId() );
  }
	
}
