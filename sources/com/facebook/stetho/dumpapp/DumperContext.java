package com.facebook.stetho.dumpapp;

import com.facebook.stetho.common.Util;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.List;
import javax.annotation.concurrent.Immutable;
import org.apache.commons.cli.CommandLineParser;

@Immutable
public class DumperContext {
    private final List<String> mArgs;
    private final CommandLineParser mParser;
    private final PrintStream mStderr;
    private final InputStream mStdin;
    private final PrintStream mStdout;

    protected DumperContext(DumperContext existingContext, List<String> newRemainingArguments) {
        this(existingContext.getStdin(), existingContext.getStdout(), existingContext.getStderr(), existingContext.getParser(), newRemainingArguments);
    }

    public DumperContext(InputStream stdin, PrintStream stdout, PrintStream stderr, CommandLineParser parser, List<String> args) {
        this.mStdin = (InputStream) Util.throwIfNull(stdin);
        this.mStdout = (PrintStream) Util.throwIfNull(stdout);
        this.mStderr = (PrintStream) Util.throwIfNull(stderr);
        this.mParser = (CommandLineParser) Util.throwIfNull(parser);
        this.mArgs = (List) Util.throwIfNull(args);
    }

    public InputStream getStdin() {
        return this.mStdin;
    }

    public PrintStream getStdout() {
        return this.mStdout;
    }

    public PrintStream getStderr() {
        return this.mStderr;
    }

    public CommandLineParser getParser() {
        return this.mParser;
    }

    public List<String> getArgsAsList() {
        return this.mArgs;
    }
}
