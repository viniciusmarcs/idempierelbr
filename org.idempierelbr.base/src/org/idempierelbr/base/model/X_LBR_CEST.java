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
/** Generated Model - DO NOT CHANGE */
package org.idempierelbr.base.model;

import java.sql.ResultSet;
import java.util.Properties;
import org.compiere.model.*;
import org.compiere.util.KeyNamePair;

/** Generated Model for LBR_CEST
 *  @author iDempiere (generated) 
 *  @version Release 2.1 - $Id$ */
public class X_LBR_CEST extends PO implements I_LBR_CEST, I_Persistent 
{

	/**
	 *
	 */
	private static final long serialVersionUID = 20160324L;

    /** Standard Constructor */
    public X_LBR_CEST (Properties ctx, int LBR_CEST_ID, String trxName)
    {
      super (ctx, LBR_CEST_ID, trxName);
      /** if (LBR_CEST_ID == 0)
        {
			setLBR_CEST_ID (0);
			setValue (null);
        } */
    }

    /** Load Constructor */
    public X_LBR_CEST (Properties ctx, ResultSet rs, String trxName)
    {
      super (ctx, rs, trxName);
    }

    /** AccessLevel
      * @return 3 - Client - Org 
      */
    protected int get_AccessLevel()
    {
      return accessLevel.intValue();
    }

    /** Load Meta Data */
    protected POInfo initPO (Properties ctx)
    {
      POInfo poi = POInfo.getPOInfo (ctx, Table_ID, get_TrxName());
      return poi;
    }

    public String toString()
    {
      StringBuffer sb = new StringBuffer ("X_LBR_CEST[")
        .append(get_ID()).append("]");
      return sb.toString();
    }

	/** Set Description.
		@param Description 
		Optional short description of the record
	  */
	public void setDescription (String Description)
	{
		set_Value (COLUMNNAME_Description, Description);
	}

	/** Get Description.
		@return Optional short description of the record
	  */
	public String getDescription () 
	{
		return (String)get_Value(COLUMNNAME_Description);
	}

    /** Get Record ID/ColumnName
        @return ID/ColumnName pair
      */
    public KeyNamePair getKeyNamePair() 
    {
        return new KeyNamePair(get_ID(), String.valueOf(getDescription()));
    }

	/** Set CEST.
		@param LBR_CEST_ID CEST	  */
	public void setLBR_CEST_ID (int LBR_CEST_ID)
	{
		if (LBR_CEST_ID < 1) 
			set_ValueNoCheck (COLUMNNAME_LBR_CEST_ID, null);
		else 
			set_ValueNoCheck (COLUMNNAME_LBR_CEST_ID, Integer.valueOf(LBR_CEST_ID));
	}

	/** Get CEST.
		@return CEST	  */
	public int getLBR_CEST_ID () 
	{
		Integer ii = (Integer)get_Value(COLUMNNAME_LBR_CEST_ID);
		if (ii == null)
			 return 0;
		return ii.intValue();
	}

	/** Set LBR_CEST_UU.
		@param LBR_CEST_UU LBR_CEST_UU	  */
	public void setLBR_CEST_UU (String LBR_CEST_UU)
	{
		set_ValueNoCheck (COLUMNNAME_LBR_CEST_UU, LBR_CEST_UU);
	}

	/** Get LBR_CEST_UU.
		@return LBR_CEST_UU	  */
	public String getLBR_CEST_UU () 
	{
		return (String)get_Value(COLUMNNAME_LBR_CEST_UU);
	}

	/** Set Search Key.
		@param Value 
		Search key for the record in the format required - must be unique
	  */
	public void setValue (String Value)
	{
		set_Value (COLUMNNAME_Value, Value);
	}

	/** Get Search Key.
		@return Search key for the record in the format required - must be unique
	  */
	public String getValue () 
	{
		return (String)get_Value(COLUMNNAME_Value);
	}
}