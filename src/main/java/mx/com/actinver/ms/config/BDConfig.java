package mx.com.actinver.ms.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
public class BDConfig {

	@Bean(value = "dataSource",name = "dataSource", destroyMethod = "close")
	public DataSource getDataSource(Environment env) {

		final HikariConfig dataSourceConfig = new HikariConfig();
		dataSourceConfig.setJdbcUrl(env.getProperty("spring.datasource.url"));
		dataSourceConfig.setUsername(env.getProperty("spring.datasource.username"));
		dataSourceConfig.setPassword(env.getProperty("spring.datasource.password"));
		dataSourceConfig.setDriverClassName(env.getProperty("spring.datasource.driver"));
		dataSourceConfig.setPoolName(env.getProperty("spring.datasource.poolName"));
		dataSourceConfig.setMaximumPoolSize(env.getProperty("spring.datasource.maximumPoolSize", Integer.class));
		dataSourceConfig.setMinimumIdle(env.getProperty("spring.datasource.minimumIdle", Integer.class));
		dataSourceConfig.setConnectionTimeout(env.getProperty("spring.datasource.connectionTimeoutMs", Long.class));
		dataSourceConfig.setIdleTimeout(env.getProperty("spring.datasource.idleTimeoutMs", Long.class));
		dataSourceConfig.addDataSourceProperty("cachePrepStmts", env.getProperty("spring.datasource.properties.cachePrepStmts", Boolean.class));
		dataSourceConfig.addDataSourceProperty("prepStmtCacheSize", env.getProperty("spring.datasource.properties.prepStmtCacheSize", Integer.class));
		dataSourceConfig.addDataSourceProperty("prepStmtCacheSqlLimit", env.getProperty("spring.datasource.properties.prepStmtCacheSqlLimit", Integer.class));
		dataSourceConfig.addDataSourceProperty("useServerPrepStmts", env.getProperty("spring.datasource.properties.useServerPrepStmts", Boolean.class));
		dataSourceConfig.setAutoCommit(env.getProperty("spring.datasource.autoCommit", Boolean.class));
		dataSourceConfig.setMaxLifetime(env.getProperty("spring.datasource.maxLifetimeMs",Integer.class));
		return new HikariDataSource(dataSourceConfig);
	}

	@Bean(name = "transactionManager")
	public DataSourceTransactionManager txManager(DataSource dataSource) {
		return new DataSourceTransactionManager(dataSource);
	}

}
