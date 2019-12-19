package playground.ee.jpa;

import liquibase.integration.cdi.CDILiquibaseConfig;
import liquibase.integration.cdi.annotations.LiquibaseType;
import liquibase.resource.ClassLoaderResourceAccessor;
import liquibase.resource.ResourceAccessor;

import javax.annotation.Resource;
import javax.enterprise.inject.Produces;
import javax.inject.Named;
import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author jhirschbeck
 */
@Named
public class LiquibaseProducer {

    @Resource(lookup = "java:jboss/datasources/H2FileDS")
    DataSource datasource;

    @Produces
    @LiquibaseType
    public CDILiquibaseConfig createConfig() {
        CDILiquibaseConfig config = new CDILiquibaseConfig();
        config.setChangeLog("lb/changelog.xml");
        return config;
    }

    @Produces
    @LiquibaseType
    public DataSource createDataSource() throws SQLException {
        return datasource;
    }

    @Produces
    @LiquibaseType
    public ResourceAccessor create() {
        return new ClassLoaderResourceAccessor(getClass().getClassLoader());
    }
}
