package com.springapp.mvc.syncmodel;

import java.util.List;

/**
 *  Copyright 2012 Society for Health Information Systems Programmes, India (HISP India)
 *
 *  This file is part of DHIS2 Reporting module.
 *
 *  DHIS2 Reporting module is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.

 *  DHIS2 Reporting module is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with DHIS2 Reporting module.  If not, see <http://www.gnu.org/licenses/>.
 *
 **/

public class SyncDataElement

{
    protected String id;

    protected String code;

    protected String concept_id;

    protected String name;

    protected String href;

    protected List<SyncDisaggregation> dag;

    protected List<SyncDataSet> ds;
    public String uid;

    public String getCode()
    {
        return code;
    }

    public void setCode( String code )
    {
        this.code = code;
    }

    public List<SyncDisaggregation> getDisaggregation()
    {
        return dag;
    }

    public void setDisaggregation( List<SyncDisaggregation> disag )
    {
        this.dag = disag;
    }

    public List<SyncDataSet> getDataSet()
    {
        return ds;
    }

    public void setDataSet( List<SyncDataSet> ds )
    {
        this.ds = ds;
    }

    public String getHref()
    {
        return href;
    }

    public void setHref( String href )
    {
        this.href = href;
    }

    public String getId()
    {
        return id;
    }

    public void setId( String id )
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName( String name )
    {
        this.name = name;
    }

    @Override
    public boolean equals( Object obj )
    {
        if ( obj == null )
        {
            return false;
        }
        if ( getClass() != obj.getClass() )
        {
            return false;
        }
        final SyncDataElement other = (SyncDataElement) obj;
        if ( (this.code == null) ? (other.code != null) : !this.code.equals( other.code ) )
        {
            return false;
        }
        if ( (this.concept_id == null) ? (other.concept_id  != null) : !this.concept_id .equals( other.concept_id ) )
        {
            return false;
        }
        if ( (this.name == null) ? (other.name != null) : !this.name.equals( other.name ) )
        {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode()
    {
        int hash = 3;
        hash = 89 * hash + (this.code != null ? this.code.hashCode() : 0);
        hash = 89 * hash + (this.concept_id  != null ? this.concept_id .hashCode() : 0);
        hash = 89 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString()
    {
        return "DE: " + this.getId() + " : " + this.getCode() + " : " + this.getName() + ":" + this.getHref();
    }

}
