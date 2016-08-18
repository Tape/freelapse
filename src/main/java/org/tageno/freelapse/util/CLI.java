package org.tageno.freelapse.util;

import org.apache.commons.cli.*;

public final class CLI {
    /**
     * Instance of the parsed command line instance.
     */
    private static CommandLine _cli;

    /**
     * Parse the provided command line arguments.
     *
     * @param $args The arguments from the command line.
     * @return True if the parse was successful, false if not.
     */
    public static boolean parse(final String[] $args) {
        final Options options = new Options();
        options.addOption("u", true, "Username to the PostgreSQL database");
        options.addOption("p", true, "Password to the PostgreSQL database");

        try {
            final CommandLineParser parser = new DefaultParser();
            _cli = parser.parse(options, $args);
            return true;
        } catch (ParseException $e) {
            new HelpFormatter().printHelp("freelapse", options);
            return false;
        }
    }

    /**
     * Get the value of a command line argument.
     *
     * @param $prop The property to fetch.
     * @return The value of the property, can be null.
     */
    public static String get(final String $prop) {
        return _cli.getOptionValue($prop);
    }

    /**
     * Get the value of a command line argument with a default value.
     *
     * @param $prop    The property to fetch.
     * @param $default The default value of the property if not provided.
     * @return The value of the property, or the default value if not provided.
     */
    public static String get(final String $prop, final String $default) {
        return _cli.getOptionValue($prop, $default);
    }
}
