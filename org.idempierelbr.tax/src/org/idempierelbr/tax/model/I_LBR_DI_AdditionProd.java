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

/** Generated Interface for LBR_DI_AdditionProd
 *  @author iDempiere (generated) 
 *  @version Release 2.0
 */
@SuppressWarnings("all")
public interface I_LBR_DI_AdditionProd 
{

    /** TableName=LBR_DI_AdditionProd */
    public static final String Table_Name = "LBR_DI_AdditionProd";

    /** AD_Table_ID=800002 */
    public static final int Table_ID = 800002;

    KeyNamePair Model = new KeyNamePair(Table_ID, Table_Name);

    /** AccessLevel = 1 - Org 
     */
    BigDecimal accessLevel = BigDecimal.valueOf(1);

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

    /** Column name C_Currency_ID */
    public static final String COLUMNNAME_C_Currency_ID = "C_Currency_ID";

	/** Set Currency.
	  * The Currency for this record
	  */
	public void setC_Currency_ID (int C_Currency_ID);

	/** Get Currency.
	  * The Currency for this record
	  */
	public int getC_Currency_ID();

	public org.compiere.model.I_C_Currency getC_Currency() throws RuntimeException;

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

    /** Column name C_UOM_ID */
    public static final String COLUMNNAME_C_UOM_ID = "C_UOM_ID";

	/** Set UOM.
	  * Unit of Measure
	  */
	public void setC_UOM_ID (int C_UOM_ID);

	/** Get UOM.
	  * Unit of Measure
	  */
	public int getC_UOM_ID();

	public org.compiere.model.I_C_UOM getC_UOM() throws RuntimeException;

    /** Column name Description */
    public static final String COLUMNNAME_Description = "Description";

	/** Set Description.
	  * Optional short description of the record
	  */
	public void setDescription (String Description);

	/** Get Description.
	  * Optional short description of the record
	  */
	public String getDescription();

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

    /** Column name LBR_DI_Addition_ID */
    public static final String COLUMNNAME_LBR_DI_Addition_ID = "LBR_DI_Addition_ID";

	/** Set Import Declaration (DI) Addition.
	  * Identifies an Import Declaration (DI) Addiction
	  */
	public void setLBR_DI_Addition_ID (int LBR_DI_Addition_ID);

	/** Get Import Declaration (DI) Addition.
	  * Identifies an Import Declaration (DI) Addiction
	  */
	public int getLBR_DI_Addition_ID();

	public I_LBR_DI_Addition getLBR_DI_Addition() throws RuntimeException;

    /** Column name LBR_DI_AdditionProd_ID */
    public static final String COLUMNNAME_LBR_DI_AdditionProd_ID = "LBR_DI_AdditionProd_ID";

	/** Set DI Addition Product.
	  * Identifies an Import Declaration (DI) Addiction Product
	  */
	public void setLBR_DI_AdditionProd_ID (int LBR_DI_AdditionProd_ID);

	/** Get DI Addition Product.
	  * Identifies an Import Declaration (DI) Addiction Product
	  */
	public int getLBR_DI_AdditionProd_ID();

    /** Column name LBR_DI_AdditionProd_UU */
    public static final String COLUMNNAME_LBR_DI_AdditionProd_UU = "LBR_DI_AdditionProd_UU";

	/** Set DI Addition Product.
	  * Identifies an Import Declaration (DI) Addiction Product
	  */
	public void setLBR_DI_AdditionProd_UU (String LBR_DI_AdditionProd_UU);

	/** Get DI Addition Product.
	  * Identifies an Import Declaration (DI) Addiction Product
	  */
	public String getLBR_DI_AdditionProd_UU();

    /** Column name LBR_Specification */
    public static final String COLUMNNAME_LBR_Specification = "LBR_Specification";

	/** Set Specification.
	  * Optional short description of the record
	  */
	public void setLBR_Specification (String LBR_Specification);

	/** Get Specification.
	  * Optional short description of the record
	  */
	public String getLBR_Specification();

    /** Column name M_Product_ID */
    public static final String COLUMNNAME_M_Product_ID = "M_Product_ID";

	/** Set Product.
	  * Product, Service, Item
	  */
	public void setM_Product_ID (int M_Product_ID);

	/** Get Product.
	  * Product, Service, Item
	  */
	public int getM_Product_ID();

	public org.compiere.model.I_M_Product getM_Product() throws RuntimeException;

    /** Column name PriceActual */
    public static final String COLUMNNAME_PriceActual = "PriceActual";

	/** Set Unit Price.
	  * Actual Price 
	  */
	public void setPriceActual (BigDecimal PriceActual);

	/** Get Unit Price.
	  * Actual Price 
	  */
	public BigDecimal getPriceActual();

    /** Column name Qty */
    public static final String COLUMNNAME_Qty = "Qty";

	/** Set Quantity.
	  * Quantity
	  */
	public void setQty (BigDecimal Qty);

	/** Get Quantity.
	  * Quantity
	  */
	public BigDecimal getQty();

    /** Column name SeqNo */
    public static final String COLUMNNAME_SeqNo = "SeqNo";

	/** Set Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public void setSeqNo (int SeqNo);

	/** Get Sequence.
	  * Method of ordering records;
 lowest number comes first
	  */
	public int getSeqNo();

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
}
