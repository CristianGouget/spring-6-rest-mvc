package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ActiveProfiles("localmysql")
public class MySqlIT {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:9");

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testListBeers() {
        List<Beer> beers = beerRepository.findAll();

        assertThat(beers.size()).isGreaterThan(0);
    }
}

/*package guru.springframework.spring6restmvc.repositories;

import guru.springframework.spring6restmvc.entities.Beer;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.test.context.ActiveProfiles;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.containers.wait.strategy.LogMessageWaitStrategy;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.time.Duration;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Testcontainers
@SpringBootTest
@ActiveProfiles("localmysql")
public class MySqlIT {

    @Container
    @ServiceConnection
    static MySQLContainer<?> mySQLContainer = new MySQLContainer<>("mysql:8.0")
            .withDatabaseName("restdb")  // Database name
            .withUsername("restadmin")   // Username
            .withPassword("password")   // Password
            .withExposedPorts(3307)     // Exposing the 3307 port externally
            .withStartupTimeout(Duration.ofSeconds(60)) // Increase timeout to 60 seconds
            .waitingFor(new LogMessageWaitStrategy()
                    .withRegEx(".*ready for connections.*\\s")  // Ensure MySQL is fully ready
                    .withStartupTimeout(Duration.ofSeconds(60))) // Additional wait if needed
            .withReuse(true); // Reuse container for faster testing

    @Autowired
    BeerRepository beerRepository;

    @Test
    void testListBeers() {
        // Print container logs and JDBC URL to troubleshoot if necessary
        System.out.println("MySQL Container Logs: " + mySQLContainer.getLogs());
        System.out.println("JDBC URL: " + mySQLContainer.getJdbcUrl());

        // Execute test logic: Verify that there is at least one beer in the repository
        List<Beer> beers = beerRepository.findAll();
        assertThat(beers.size()).isGreaterThan(0);
    }
}*/



