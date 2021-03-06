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

package com.autentia.tnt.manager.admin;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.autentia.tnt.businessobject.Frequency;
import com.autentia.tnt.dao.SortCriteria;
import com.autentia.tnt.dao.hibernate.FrequencyDAO;
import com.autentia.tnt.dao.search.FrequencySearch;
import com.autentia.tnt.util.SpringUtils;



public class FrequencyManager 
{
/* generated by stajanov (do not edit/delete) */


  /** Logger */
  private static final Log log = LogFactory.getLog(FrequencyManager.class);

  /** Frequency DAO **/
  private FrequencyDAO frequencyDAO;

  /**
   * Get default FrequencyManager as defined in Spring's configuration file.
   * @return the default singleton FrequencyManager
   */
  public static FrequencyManager getDefault()
  {
    return (FrequencyManager)SpringUtils.getSpringBean("managerFrequency");
  }

  /** 
   * Empty constructor needed by CGLIB (Spring AOP)
   */
  protected FrequencyManager()
  {
  }
	
  /** 
   * Default constructor 
   * @deprecated do not construct managers alone: use Spring's declared beans
   */
  public FrequencyManager( FrequencyDAO frequencyDAO )
  {
    this.frequencyDAO = frequencyDAO;
  }

  /**
   * List frequencys. 
   * @param search search filter to apply
   * @param sort sorting criteria
   * @return the list of all frequencys sorted by requested criterion
   */
  public List<Frequency> getAllEntities(FrequencySearch search, SortCriteria sort){
    return frequencyDAO.search( search, sort );
  }
  
  /**
   * Get frequency by primary key.
   * @return frequency selected by id.
   */
  public Frequency getEntityById(int id){
    return frequencyDAO.getById(id);	    
  }
	
  /**
   * Insert frequency. 
   */
  public void insertEntity(Frequency frequency) {
    frequencyDAO.insert(frequency);
  }
	 
  /**
   * Update frequency. 
   */
  public void updateEntity(Frequency frequency) {
    frequencyDAO.update(frequency);
  }

  /**
   * Delete frequency. 
   */
  public void deleteEntity(Frequency frequency) {
    frequencyDAO.delete(frequency);
  }
/* generated by stajanov (do not edit/delete) */
}
