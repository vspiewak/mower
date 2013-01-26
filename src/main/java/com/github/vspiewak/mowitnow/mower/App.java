package com.github.vspiewak.mowitnow.mower;

import java.io.File;

import com.github.vspiewak.mowitnow.mower.exceptions.ParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.vspiewak.mowitnow.mower.setup.AppSetup;
import com.github.vspiewak.mowitnow.mower.setup.AppSetupBuilder;
import com.github.vspiewak.mowitnow.mower.setup.AppSetupFileBuilder;

public class App {

	/* UTF-8 only */
    public static final String CHARSET_UTF_8 = "UTF-8";

    /* exit status */
    public static final int EXIT_SUCCESS = 0;
    public static final int EXIT_FAILURE_BAD_ARGS = 1;
    public static final int EXIT_FAILURE_CANT_READ_FILE = 2;
    private static final int EXIT_FAILURE_PARSE_EXCEPTION = 3;

    /* Printed help */
    private static String HELP_USAGE = "Mower: usage ...";


    public static int run(String... args) {

        Logger log = LoggerFactory.getLogger(App.class);

        /* print help if bad args (double check) */
        if(args.length != 1 || args[0] == null) {

           log.info(HELP_USAGE);
           return EXIT_FAILURE_BAD_ARGS;

        }

        /* handle file */
        File file = new File(args[0]);

        /* check file */
        if(!file.canRead()) {
            log.error("Can't read the file '{}' at '{}'", file.getName(), file.getAbsolutePath());
            return EXIT_FAILURE_CANT_READ_FILE;
        }

        /* parse file */
        try {

        	AppSetupBuilder build = new AppSetupFileBuilder(file);
        	build.parse();

        	AppSetup setup = build.getSetup();
        	String result = setup.execute();

            /* log/print the result */
            log.info("{}", result);


        } catch (ParseException e) {
            log.error("Parsing error : " + e);
            return EXIT_FAILURE_PARSE_EXCEPTION;
        }

        return EXIT_SUCCESS;
    }

    public static void main(String... args) {

        int exitStatus = run(args);
        System.exit(exitStatus);

    }

}
