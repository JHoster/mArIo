
package org.gradle;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayerTest {
    @Test public void canConstructAPlayerWithAName() {
        Player player = new Player("Mario");
        assertEquals("Mario", player.getName());
    }
}
