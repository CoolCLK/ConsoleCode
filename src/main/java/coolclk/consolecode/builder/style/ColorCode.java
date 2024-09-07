package coolclk.consolecode.builder.style;

import coolclk.consolecode.code.Colors;
import coolclk.consolecode.code.Colors.Color;

/**
 * The code builder about the colors.
 * @see Color
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public interface ColorCode<F> {
    F color(Color color);

    default F color(long color) {
        return this.color(Colors.color(color));
    }

    default F color(long r, long g, long b) {
        return this.color(Colors.color(r, g, b));
    }

    default F black(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_BLACK : Colors.BLACK);
    }

    default F red(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_RED : Colors.RED);
    }

    default F green(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_GREEN : Colors.GREEN);
    }

    default F yellow(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_YELLOW : Colors.YELLOW);
    }

    default F blue(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_BLUE : Colors.BLUE);
    }

    default F purple(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_PURPLE : Colors.PURPLE);
    }

    default F cyan(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_CYAN : Colors.CYAN);
    }

    default F white(boolean bright) {
        return this.color(bright ? Colors.BRIGHT_WHITE : Colors.WHITE);
    }

    default F black() {
        return this.black(false);
    }

    default F gray() {
        return this.black(true);
    }

    default F red() {
        return this.red(false);
    }

    default F green() {
        return this.green(false);
    }

    default F yellow() {
        return this.yellow(false);
    }

    default F blue() {
        return this.blue(false);
    }

    default F purple() {
        return this.purple(false);
    }

    default F cyan() {
        return this.cyan(false);
    }

    default F white() {
        return this.white(true);
    }

    default F reset() {
        return this.color(Colors.RESET);
    }
}
