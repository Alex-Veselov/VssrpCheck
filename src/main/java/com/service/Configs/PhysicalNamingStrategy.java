package com.service.Config;

import org.hibernate.boot.model.naming.Identifier;
import org.hibernate.engine.jdbc.env.spi.JdbcEnvironment;

import org.hibernate.boot.model.naming.PhysicalNamingStrategyStandardImpl;

public class PhysicalNamingStrategy extends PhysicalNamingStrategyStandardImpl {
    @Override
    public Identifier toPhysicalTableName(Identifier identifier, JdbcEnvironment context) {
        return identifier;
    }
}

