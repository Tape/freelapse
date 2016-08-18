package org.tageno.freelapse.util;

import org.junit.Test;

import static org.junit.Assert.*;

public class CLITest {
    @Test
    public void parse() throws Exception {
        assertTrue(CLI.parse(new String[]{}));
        assertTrue(CLI.parse(new String[]{"-u", "test", "-p", "test"}));
        assertFalse(CLI.parse(new String[]{"-u", "test", "-p"}));
        assertFalse(CLI.parse(new String[]{"-u", "-p", "test"}));
    }

    @Test
    public void get() throws Exception {
        assertTrue(CLI.parse(new String[]{"-u", "test1", "-p", "test2"}));
        assertEquals("test1", CLI.get("u"));
        assertEquals("test2", CLI.get("p"));
    }

    @Test
    public void getWithDefault() throws Exception {
        assertTrue(CLI.parse(new String[]{"-u", "test1"}));
        assertEquals("test1", CLI.get("u", "test3"));
        assertEquals("test2", CLI.get("p", "test2"));
    }
}
