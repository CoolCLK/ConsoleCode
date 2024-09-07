package coolclk.consolecode.builder.cursor;

/**
 * The code builder about the movement of cursor.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public interface MoveCode<F> {
    F move(int line, int column);

    default F up(int line) {
        return this.down(-line);
    }

    default F down(int line) {
        return this.move(line, 0);
    }

    default F forward(int column) {
        return this.move(0, column);
    }

    default F backward(int column) {
        return this.forward(-column);
    }
}
