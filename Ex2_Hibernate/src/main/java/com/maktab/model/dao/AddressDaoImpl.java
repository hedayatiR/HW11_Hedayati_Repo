package com.maktab.model.dao;

import com.maktab.core.dao.BaseDaoImpl;
import com.maktab.model.Address;
import org.hibernate.SessionFactory;

public class AddressDaoImpl  extends BaseDaoImpl<Address> {

    public AddressDaoImpl(SessionFactory factory) {
        super(factory);
    }

    @Override
    protected String getEntity() {
        return "Address";
    }
}
