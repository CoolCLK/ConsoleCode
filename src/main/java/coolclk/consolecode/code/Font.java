package coolclk.consolecode.code;

import java.util.HashMap;
import java.util.Map;

/**
 * Font and their codes.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public final class Font {
    public static final Font DEFAULT = new Font(10);
    public static final Font FRAKTUR = new Font(20);
    public static final Font FRAKTUR_OFF = new Font(233);
    private static final Map<Integer, Font> BACKUP = new HashMap<>();

    private final int code;

    private Font(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }

    /**
     * Get or create an instance for getting backup font codes.
     * @param code The code of backup fonts, in range 11~19.
     * @since 1.0
     * @author CoolCLK
     */
    public static Font backup(int code) {
        if (code < 11 || code > 19) {
            throw new IllegalArgumentException("Out of bound 11~19");
        }
        return BACKUP.getOrDefault(code, BACKUP.put(code, new Font(code)));
    }
}
