/******************************************************************************
 * Product: iDempiere ERP & CRM Smart Business Solution                       *
 * Copyright (C) 1999-2012 ComPiere, Inc. All Rights Reserved.                *
 * This program is free software, you can redistribute it and/or modify it    *
 * under the terms version 2 of the GNU General Public License as published   *
 * by the Free Software Foundation. This program is distributed in the hope   *
 * that it will be useful, but WITHOUT ANY WARRANTY, without even the implied *
 * warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.           *
 * See the GNU General Public License for more details.                       *
 * You should have received a copy of the GNU General Public License along    *
 * with this program, if not, write to the Free Software Foundation, Inc.,    *
 * 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA.                     *
 * For the text or an alternative of this public license, you may reach us    *
 * ComPiere, Inc., 2620 Augustine Dr. #245, Santa Clara, CA 95054, USA        *
 * or via info@compiere.org or http://www.compiere.org/license.html           *
 *****************************************************************************/
package org.idempierelbr.tax.model;

import java.math.BigDecimal;
import java.sql.Timestamp;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Interface for LBR_TaxConfig_BPGroup
 *  @author iDempiere (generated) 
 *  @version Release 2.0
 */
@SuppressWarnings("all")
public interface I_LBR_TaxConfig_BPGroup 
{

    /** TableName=LBR_TaxConfig_BPGroup */
    public static final String Table_Name = "LBR_TaxConfig_BPGroup";

    /** AD_Table_ID=1000020 */
    public static final int Table_ID = MTable.getTable_ID(Table_Name);

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 3 - Client - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(3);

    /** Load Meta Data */

    /** Column name AD_Client_ID */
    public static final String COLUMNNAME_AD_Client_ID = "AD_Client_ID";

	/** Get Client.
	  * Client/Tenant for this installation.
	  */
	public int getAD_Client_ID();

    /** Column name AD_Org_ID */
    public static final String COLUMNNAME_AD_Org_ID = "AD_Org_ID";

	/** Set Organization.
	  * Organizational entity within client
	  */
	public void setAD_Org_ID (int AD_Org_ID);

	/** Get Organization.
	  * Organizational entity within client
	  */
	public int getAD_Org_ID();

    /** Column name Created */
    public static final String COLUMNNAME_Created = "Created";

	/** Get Created.
	  * Date this record was created
	  */
	public Timestamp getCreated();

    /** Column name CreatedBy */
    public static final String COLUMNNAME_CreatedBy = "CreatedBy";

	/** Get Created By.
	  * User who created this records
	  */
	public int getCreatedBy();

    /** Column name IsActive */
    public static final String COLUMNNAME_IsActive = "IsActive";

	/** Set Active.
	  * The record is active in the system
	  */
	public void setIsActive (boolean IsActive);

	/** Get Active.
	  * The record is active in the system
	  */
	public boolean isActive();

    /** Column name LBR_FiscalGroup_BPartner_ID */
    public static final String COLUMNNAME_LBR_FiscalGroup_BPartner_ID = "LBR_FiscalGroup_BPartner_ID";

	/** Set BP Fiscal Group.
	  * Identifies a Business Partner Fiscal Group
	  */
	public void setLBR_FiscalGroup_BPartner_ID (int LBR_FiscalGroup_BPartner_ID);

	/** Get BP Fiscal Group.
	  * Identifies a Business Partner Fiscal Group
	  */
	public int getLBR_FiscalGroup_BPartner_ID();

	public I_LBR_FiscalGroup_BPartner getLBR_FiscalGroup_BPartner() throws RuntimeException;

    /** Column name LBR_LegalMessage_ID */
    public static final String COLUMNNAME_LBR_LegalMessage_ID = "LBR_LegalMessage_ID";

	/** Set Legal Message.
	  * Identifies a Legal Message
	  */
	public void setLBR_LegalMessage_ID (int LBR_LegalMessage_ID);

	/** Get Legal Message.
	  * Identifies a Legal Message
	  */
	public int getLBR_LegalMessage_ID();

	public I_LBR_LegalMessage getLBR_LegalMessage() throws RuntimeException;

    /** Column name LBR_TaxConfig_BPGroup_ID */
    public static final String COLUMNNAME_LBR_TaxConfig_BPGroup_ID = "LBR_TaxConfig_BPGroup_ID";

	/** Set Business Partner Group Exception.
	  * Identifies a Business Partner Group Exception
	  */
	public void setLBR_TaxConfig_BPGroup_ID (int LBR_TaxConfig_BPGroup_ID);

	/** Get Business Partner Group Exception.
	  * Identifies a Business Partner Group Exception
	  */
	public int getLBR_TaxConfig_BPGroup_ID();

    /** Column name LBR_TaxConfig_BPGroup_UU */
    public static final String COLUMNNAME_LBR_TaxConfig_BPGroup_UU = "LBR_TaxConfig_BPGroup_UU";

	/** Set LBR_TaxConfig_BPGroup_UU	  */
	public void setLBR_TaxConfig_BPGroup_UU (String LBR_TaxConfig_BPGroup_UU);

	/** Get LBR_TaxConfig_BPGroup_UU	  */
	public String getLBR_TaxConfig_BPGroup_UU();

    /** Column name LBR_TaxConfiguration_ID */
    public static final String COLUMNNAME_LBR_TaxConfiguration_ID = "LBR_TaxConfiguration_ID";

	/** Set Tax Configuration.
	  * Tax Configuration Used
	  */
	public void setLBR_TaxConfiguration_ID (int LBR_TaxConfiguration_ID);

	/** Get Tax Configuration.
	  * Tax Configuration Used
	  */
	public int getLBR_TaxConfiguration_ID();

	public I_LBR_TaxConfiguration getLBR_TaxConfiguration() throws RuntimeException;

    /** Column name LBR_Tax_ID */
    public static final String COLUMNNAME_LBR_Tax_ID = "LBR_Tax_ID";

	/** Set Transaction Tax.
	  * Identifies a transaction tax (document/line)
	  */
	public void setLBR_Tax_ID (int LBR_Tax_ID);

	/** Get Transaction Tax.
	  * Identifies a transaction tax (document/line)
	  */
	public int getLBR_Tax_ID();

    /** Column name LBR_TaxStatus */
    public static final String COLUMNNAME_LBR_TaxStatus = "LBR_TaxStatus";

	/** Set Tax Status.
	  * Defines the Tax Status
	  */
	public void setLBR_TaxStatus (String LBR_TaxStatus);

	/** Get Tax Status.
	  * Defines the Tax Status
	  */
	public String getLBR_TaxStatus();

    /** Column name Updated */
    public static final String COLUMNNAME_Updated = "Updated";

	/** Get Updated.
	  * Date this record was updated
	  */
	public Timestamp getUpdated();

    /** Column name UpdatedBy */
    public static final String COLUMNNAME_UpdatedBy = "UpdatedBy";

	/** Get Updated By.
	  * User who updated this records
	  */
	public int getUpdatedBy();
	
	/** Column name ValidFrom */
    public static final String COLUMNNAME_ValidFrom = "ValidFrom";

	/** Set Valid from.
	  * Valid from including this date (first day)
	  */
	public void setValidFrom (Timestamp ValidFrom);

	/** Get Valid from.
	  * Valid from including this date (first day)
	  */
	public Timestamp getValidFrom();
}
