package coolclk.consolecode.builder.context;

/**
 * The code builder about erasing.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public interface EraseCode<P> {
    LineCode<P> line();

    ScreenCode<P> screen();

    /**
     * The code builder about erasing of the line.
     * @since 1.0
     * @author CoolCLK
     */
    interface LineCode<SP> {
        SP code(int code);

        default SP toEnd() {
            return this.code(0);
        }

        default SP fromStart() {
            return this.code(1);
        }

        default SP startToEnd() {
            return this.code(2);
        }
    }

    /**
     * The code builder about erasing of the screen.
     * @since 1.0
     * @author CoolCLK
     */
    interface ScreenCode<SP> {
        SP code(int code);

        default SP toEnd() {
            return this.code(0);
        }

        default SP fromStart() {
            return this.code(1);
        }

        default SP startToEnd() {
            return this.code(2);
        }
    }
}
