package org.tageno.freelapse.util;

import org.apache.commons.cli.*;

import java.io.PrintStream;
import java.io.PrintWriter;

public final class CLI {
    /**
     * Instance of the parsed command line instance.
     */
    private static CommandLine _cli;

    /**
     * The command line options for the web application.
     */
    private static Options _options = new Options();

    static {
        _options.addOption("u", true, "Username to the PostgreSQL database");
        _options.addOption("p", true, "Password to the PostgreSQL database");
    }

    /**
     * Parse the provided command line arguments.
     *
     * @param $args The arguments from the command line.
     * @return True if the parse was successful, false if not.
     */
    public static boolean parse(final String[] $args) {
        try {
            final CommandLineParser parser = new DefaultParser();
            _cli = parser.parse(_options, $args);
            return true;
        } catch (ParseException $e) {
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

    /**
     * Print the usage of the command line interface to the given writer.
     *
     * @param $ps The stream to output to.
     */
    public static void printUsage(final PrintStream $ps) {
        final HelpFormatter formatter = new HelpFormatter();
        final PrintWriter pw = new PrintWriter($ps);

        formatter.printUsage(pw, 80, "freelapse", _options);
        formatter.printOptions(pw, 80, _options, 4, 3);

        pw.flush();
    }
}
