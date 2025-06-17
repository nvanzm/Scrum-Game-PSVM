package org.example.core.renderer.output;

import org.example.events.GameEvent;
import org.example.menus.handlers.InputHandler;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RenderableWrapperTest {

    @Test
    void testRenderWithValidItemAndRenderer() {
        // Arrange
        Object mockItem = new Object();
        TestRenderer mockRenderer = new TestRenderer();
        InputHandler mockInputHandler = new TestInputHandler();

        RenderableWrapper wrapper = new RenderableWrapper(mockItem, mockRenderer, mockInputHandler);

        // Act
        wrapper.render();

        // Assert
        assertTrue(mockRenderer.isRenderCalled(), "Render method of renderer should be called.");
        assertEquals(mockItem, mockRenderer.getRenderedItem(), "Rendered item should match the provided item.");
    }

    @Test
    void testRenderWithNoRendererShouldDoNothing() {
        // Arrange
        Object mockItem = new Object();
        InputHandler mockInputHandler = new TestInputHandler();

        RenderableWrapper wrapper = new RenderableWrapper(mockItem, null, mockInputHandler);

        // Act & Assert
        assertDoesNotThrow(wrapper::render, "Render method should not throw an exception when renderer is null.");
    }

    @Test
    void testRenderWithNoItemShouldDoNothing() {
        // Arrange
        TestRenderer mockRenderer = new TestRenderer();
        InputHandler mockInputHandler = new TestInputHandler();

        RenderableWrapper wrapper = new RenderableWrapper(null, mockRenderer, mockInputHandler);

        // Act
        wrapper.render();

        // Assert
        assertFalse(mockRenderer.isRenderCalled(), "Render method should not be called when item is null.");
    }

    @Test
    void testHandleInputWithValidInputHandler() {
        // Arrange
        String testInput = "test_input";
        GameEvent expectedEvent = new GameEvent() {
        }; // Stubbed GameEvent

        TestInputHandler mockInputHandler = new TestInputHandler() {
            @Override
            public GameEvent handleInput(String input) {
                return expectedEvent; // Return predefined test value
            }
        };
        RenderableWrapper wrapper = new RenderableWrapper(null, null, mockInputHandler);

        // Act
        GameEvent result = wrapper.handleInput(testInput);

        // Assert
        assertEquals(expectedEvent, result, "The returned GameEvent should match the expected value.");
    }

    @Test
    void testHandleInputWithNoInputHandlerShouldReturnNull() {
        // Arrange
        RenderableWrapper wrapper = new RenderableWrapper(null, null, null);

        // Act
        GameEvent result = wrapper.handleInput("any_input");

        // Assert
        assertNull(result, "HandleInput should return null when no input handler is set.");
    }

    // Mock and Stub Classes for Testing
    static class TestRenderer implements Renderer<Object> {
        private boolean renderCalled = false;
        private Object renderedItem = null;

        @Override
        public void render(Object item) {
            this.renderCalled = true;
            this.renderedItem = item;
        }

        boolean isRenderCalled() {
            return renderCalled;
        }

        Object getRenderedItem() {
            return renderedItem;
        }
    }

    static class TestInputHandler implements InputHandler {
        @Override
        public GameEvent handleInput(String input) {
            return null; // Stub
        }
    }
}