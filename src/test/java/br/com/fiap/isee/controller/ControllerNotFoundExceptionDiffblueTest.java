package br.com.fiap.isee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class ControllerNotFoundExceptionDiffblueTest {
    /**
     * Method under test:
     * {@link ControllerNotFoundException#ControllerNotFoundException(String)}
     */
    @Test
    void testNewControllerNotFoundException() {
        // Arrange and Act
        ControllerNotFoundException actualControllerNotFoundException = new ControllerNotFoundException(
                "An error occurred");

        // Assert
        assertEquals("An error occurred", actualControllerNotFoundException.getLocalizedMessage());
        assertEquals("An error occurred", actualControllerNotFoundException.getMessage());
        assertNull(actualControllerNotFoundException.getCause());
        assertEquals(0, actualControllerNotFoundException.getSuppressed().length);
    }
}
