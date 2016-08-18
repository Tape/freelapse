package org.tageno.freelapse;

import org.tageno.freelapse.db.Database;
import org.tageno.freelapse.util.CLI;

public class Main {
    /**
     * Let's get this rodeo rolling!
     *
     * @param $args Command line arguments
     */
    public static void main(final String[] $args) {
        if (!CLI.parse($args) || !Database.connect()) {
            CLI.printUsage(System.out);
            System.exit(1);
        }

        Database.disconnect();
    }
}
