package coolclk.consolecode.code;

/**
 * Effects and their codes.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public enum Effect {
    RESET(0),
    BOLD(1),
    FAINT(2),
    ITALIC(3),
    UNDERLINE(4),
    SLOW_BLINK(5),
    RAPID_BLINK(6),
    INVERTED(7),
    CONCEAL(8),
    CROSSED_OUT(9),
    BOLD_OFF(21),
    DOUBLE_UNDERLINE(21),
    NORMAL(22),
    ITALIC_OFF(23),
    UNDERLINE_OFF(24),
    BLINK_OFF(25),
    INVERSE_OFF(27),
    REVEAL(28),
    NOT_CROSSED_OUT(28),
    FRAMED(51),
    ENCIRCLED(52),
    OVERLINED(53),
    NOT_FRAMED(54),
    NOT_ENCIRCLED(54),
    NOT_OVERLINED(55);

    private final int code;

    Effect(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
