package coolclk.consolecode;

import coolclk.consolecode.builder.ContextCode;
import coolclk.consolecode.builder.CursorCode;
import coolclk.consolecode.builder.StyleCode;

/**
 * An abstract builder about the code.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public abstract class ConsoleCode {
    protected static String ESCAPE_CODE = "\033";

    /**
     * Build a code about styles.
     * @since 1.0
     * @author CoolCLK
     */
    public static StyleCode style() {
        return new StyleCode();
    }

    /**
     * Build a code about context.
     * @since 1.0
     * @author CoolCLK
     */
    public static ContextCode context() {
        return new ContextCode();
    }

    /**
     * Build a code about context.
     * @since 1.0
     * @author CoolCLK
     */
    public static CursorCode cursor() {
        return new CursorCode();
    }

    /**
     * Build the code.
     * @since 1.0
     * @author CoolCLK
     */
    public abstract String build();

    @Override
    public String toString() {
        return this.build();
    }
}
