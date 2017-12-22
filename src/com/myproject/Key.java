package com.myproject;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.scene.input.KeyCode;

public  final class Key {

	private final KeyCode keyCode;
    private final BooleanProperty pressedProperty;

    public Key(final KeyCode keyCode) {
        this.keyCode = keyCode;
        this.pressedProperty = new SimpleBooleanProperty(this, "pressed");
    }

    public KeyCode getKeyCode() {
        return keyCode;
    }

    public boolean isPressed() {
        return pressedProperty.get();
    }

    public void setPressed(final boolean value) {
        pressedProperty.set(value);
    }
	
}
