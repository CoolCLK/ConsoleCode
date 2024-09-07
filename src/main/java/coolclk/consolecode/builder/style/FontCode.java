package coolclk.consolecode.builder.style;

import coolclk.consolecode.code.Font;

/**
 * The code builder about the fonts.
 * @see Font
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public interface FontCode<F> {
    F font(Font font);

    default F normal() {
        return this.font(Font.DEFAULT);
    }

    default F backup(int code) {
        return this.font(Font.backup(code));
    }

    default F fraktur(boolean off) {
        return this.font(off ? Font.FRAKTUR_OFF : Font.FRAKTUR);
    }

    default F fraktur() {
        return this.fraktur(false);
    }
}
