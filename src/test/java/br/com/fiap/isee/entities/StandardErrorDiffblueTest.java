package br.com.fiap.isee.entities;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneOffset;

import org.junit.jupiter.api.Test;

class StandardErrorDiffblueTest {
    /**
     * Methods under test:
     * <ul>
     *   <li>{@link StandardError#StandardError()}
     *   <li>{@link StandardError#setError(String)}
     *   <li>{@link StandardError#setMessage(String)}
     *   <li>{@link StandardError#setPath(String)}
     *   <li>{@link StandardError#setStatus(Integer)}
     *   <li>{@link StandardError#setTimestamp(Instant)}
     *   <li>{@link StandardError#getError()}
     *   <li>{@link StandardError#getMessage()}
     *   <li>{@link StandardError#getPath()}
     *   <li>{@link StandardError#getStatus()}
     *   <li>{@link StandardError#getTimestamp()}
     * </ul>
     */
    @Test
    void testGettersAndSetters() {
        // Arrange and Act
        StandardError actualStandardError = new StandardError();
        actualStandardError.setError("An error occurred");
        actualStandardError.setMessage("Not all who wander are lost");
        actualStandardError.setPath("Path");
        actualStandardError.setStatus(1);
        actualStandardError.setTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        String actualError = actualStandardError.getError();
        String actualMessage = actualStandardError.getMessage();
        String actualPath = actualStandardError.getPath();
        Integer actualStatus = actualStandardError.getStatus();
        Instant actualTimestamp = actualStandardError.getTimestamp();

        // Assert that nothing has changed
        assertEquals("An error occurred", actualError);
        assertEquals("Not all who wander are lost", actualMessage);
        assertEquals("Path", actualPath);
        assertEquals(1, actualStatus.intValue());
        assertSame(actualTimestamp.EPOCH, actualTimestamp);
    }

    /**
     * Methods under test:
     * <ul>
     *   <li>
     * {@link StandardError#StandardError(Instant, Integer, String, String, String)}
     *   <li>{@link StandardError#setError(String)}
     *   <li>{@link StandardError#setMessage(String)}
     *   <li>{@link StandardError#setPath(String)}
     *   <li>{@link StandardError#setStatus(Integer)}
     *   <li>{@link StandardError#setTimestamp(Instant)}
     *   <li>{@link StandardError#getError()}
     *   <li>{@link StandardError#getMessage()}
     *   <li>{@link StandardError#getPath()}
     *   <li>{@link StandardError#getStatus()}
     *   <li>{@link StandardError#getTimestamp()}
     * </ul>
     */
    @Test
    void testGettersAndSetters2() {
        // Arrange and Act
        StandardError actualStandardError = new StandardError(
                LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant(), 1, "An error occurred",
                "Not all who wander are lost", "Path");
        actualStandardError.setError("An error occurred");
        actualStandardError.setMessage("Not all who wander are lost");
        actualStandardError.setPath("Path");
        actualStandardError.setStatus(1);
        actualStandardError.setTimestamp(LocalDate.of(1970, 1, 1).atStartOfDay().atZone(ZoneOffset.UTC).toInstant());
        String actualError = actualStandardError.getError();
        String actualMessage = actualStandardError.getMessage();
        String actualPath = actualStandardError.getPath();
        Integer actualStatus = actualStandardError.getStatus();
        Instant actualTimestamp = actualStandardError.getTimestamp();

        // Assert that nothing has changed
        assertEquals("An error occurred", actualError);
        assertEquals("Not all who wander are lost", actualMessage);
        assertEquals("Path", actualPath);
        assertEquals(1, actualStatus.intValue());
        assertSame(actualTimestamp.EPOCH, actualTimestamp);
    }
}
