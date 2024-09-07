package coolclk.consolecode.code;

/**
 * Color and their codes.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public class Colors {
    public static final Color BLACK = new Color(30, 40);
    public static final Color RED = new Color(31, 41);
    public static final Color GREEN = new Color(32, 42);
    public static final Color YELLOW = new Color(33, 43);
    public static final Color BLUE = new Color(34, 44);
    public static final Color PURPLE = new Color(35, 45);
    public static final Color CYAN = new Color(36, 46);
    public static final Color WHITE = new Color(37, 47);
    public static final Color RESET = new Color(39, 49);
    public static final Color BRIGHT_BLACK = new Color(90, 100);
    public static final Color BRIGHT_RED = new Color(91, 101);
    public static final Color BRIGHT_GREEN = new Color(92, 102);
    public static final Color BRIGHT_YELLOW = new Color(93, 103);
    public static final Color BRIGHT_BLUE = new Color(94, 104);
    public static final Color BRIGHT_PURPLE = new Color(95, 105);
    public static final Color BRIGHT_CYAN = new Color(96, 106);
    public static final Color BRIGHT_WHITE = new Color(97, 107);

    /**
     * Get or create an instance for getting color.
     *
     * @param color The ascii color code
     * @author CoolCLK
     * @since 1.0
     */
    public static Color color(long color) {
        return new EightBitsColor(color);
    }

    /**
     * Get or create an instance for getting color.
     * @param r The red part of the color
     * @param g The green part of the color
     * @param b The blue part of the color
     * @since 1.0
     * @author CoolCLK
     */
    public static Color color(long r, long g, long b) {
        return new RGBColor(r, g, b);
    }

    public static class Color {
        private final int front, background;

        private Color(int front, int background) {
            this.front = front;
            this.background = background;
        }

        public int getFrontCode() {
            return this.front;
        }

        public int getBackgroundCode() {
            return this.background;
        }
    }

    public final static class RGBColor extends Color {
        private final long r, g, b;

        private RGBColor(long r, long g, long b) {
            super(38, 48);
            this.r = r;
            this.g = g;
            this.b = b;
        }

        public long getColorR() {
            return this.r;
        }

        public long getColorG() {
            return this.g;
        }

        public long getColorB() {
            return this.b;
        }
    }

    public final static class EightBitsColor extends Color {
        private final long color;

        private EightBitsColor(long color) {
            super(38, 48);
            this.color = color;
        }

        public long getColor() {
            return this.color;
        }
    }
}
