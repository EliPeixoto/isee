package br.com.fiap.isee.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import br.com.fiap.isee.entities.StandardError;
import jakarta.servlet.http.HttpServletRequest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {ControllerExceptionHandler.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
class ControllerExceptionHandlerDiffblueTest {
    @Autowired
    private ControllerExceptionHandler controllerExceptionHandler;

    /**
     * Method under test:
     * {@link ControllerExceptionHandler#entityNotFound(ControllerNotFoundException, HttpServletRequest)}
     */
    @Test
    void testEntityNotFound() {
        // Arrange
        ControllerNotFoundException e = new ControllerNotFoundException("An error occurred");

        // Act
        ResponseEntity<StandardError> actualEntityNotFoundResult = controllerExceptionHandler.entityNotFound(e,
                new MockHttpServletRequest());

        // Assert
        StandardError body = actualEntityNotFoundResult.getBody();
        assertEquals("", body.getPath());
        assertEquals("An error occurred", body.getMessage());
        assertEquals("Entity not Found", body.getError());
        assertEquals(404, body.getStatus().intValue());
        assertEquals(404, actualEntityNotFoundResult.getStatusCodeValue());
        assertTrue(actualEntityNotFoundResult.hasBody());
        assertTrue(actualEntityNotFoundResult.getHeaders().isEmpty());
    }

    /**
     * Method under test:
     * {@link ControllerExceptionHandler#entityNotFound(ControllerNotFoundException, HttpServletRequest)}
     */
    @Test
    void testEntityNotFound2() {
        // Arrange
        ControllerNotFoundException e = mock(ControllerNotFoundException.class);
        when(e.getMessage()).thenReturn("Not all who wander are lost");

        // Act
        ResponseEntity<StandardError> actualEntityNotFoundResult = controllerExceptionHandler.entityNotFound(e,
                new MockHttpServletRequest());

        // Assert
        verify(e).getMessage();
        StandardError body = actualEntityNotFoundResult.getBody();
        assertEquals("", body.getPath());
        assertEquals("Entity not Found", body.getError());
        assertEquals("Not all who wander are lost", body.getMessage());
        assertEquals(404, body.getStatus().intValue());
        assertEquals(404, actualEntityNotFoundResult.getStatusCodeValue());
        assertTrue(actualEntityNotFoundResult.hasBody());
        assertTrue(actualEntityNotFoundResult.getHeaders().isEmpty());
    }
}
