package coolclk.consolecode.builder;

import coolclk.consolecode.MultiCodes;
import coolclk.consolecode.builder.cursor.MoveCode;

/**
 * The cursor code builder.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public final class CursorCode extends MultiCodes {
    private static boolean savedPosition = false;

    /**
     * Put the cursor to a position.
     * @param line The line that the cursor at (start from 1).
     * @param column The column that the cursor at (start from 1).
     * @since 1.0
     * @author CoolCLK
     */
    public CursorCode put(int line, int column) {
        return (CursorCode) this.codes().add(new MoveCursor(line, column));
    }

    /**
     * Move the cursor to a position.
     * @since 1.0
     * @author CoolCLK
     */
    public MoveCode<CursorCode> move() {
        return (line, column) -> (CursorCode) this.codes().add(new PutCursor(line, column));
    }

    /**
     * Move the cursor to ordinal point.
     * @since 1.0
     * @author CoolCLK
     */
    public MoveCode<CursorCode> ordinal() {
        return (line, column) -> (CursorCode) this.codes().add(new PutCursor());
    }

    /**
     * Save the position of the cursor.
     * @since 1.0
     * @author CoolCLK
     */
    public CursorCode save() {
        savedPosition = true;
        return (CursorCode) this.codes().add(new SaveCursor());
    }

    /**
     * Restore the position of the cursor.
     * @since 1.0
     * @author CoolCLK
     */
    @SuppressWarnings("StatementWithEmptyBody")
    public CursorCode restore() {
        if (!savedPosition);
        return (CursorCode) this.codes().add(new RestoreCursor());
    }

    private static class MoveCursor extends Code {
        private final int line, column;

        private MoveCursor(int line, int column) {
            super();
            this.line = line;
            this.column = column;
        }

        @Override
        public String build() {
            StringBuilder builder = new StringBuilder(ESCAPE_CODE);
            builder.append("[");
            if (this.line != 0) {
                builder.append(this.line).append(this.line > 0 ? "B" : "A");
                if (this.column != 0) {
                    builder.append(ESCAPE_CODE).append("[");
                }
            }
            if (this.column != 0) {
                builder.append(this.column).append(this.column > 0 ? "C" : "D");
            }
            return builder.toString();
        }
    }

    private static class PutCursor extends Code {
        private final Integer line, column;

        private PutCursor() {
            this.line = null;
            this.column = null;
        }

        private PutCursor(int line, int column) {
            this.line = line;
            this.column = column;
        }

        /**
         * Get the code to put cursor.
         * @since 1.0
         * @author CoolCLk
         * @return The code that used to put cursor, it can be {@code "H"} or {@code "f"}
         */
        private static String getPutCode() {
            return "H";
        }

        @Override
        public String build() {
            StringBuilder builder = new StringBuilder(ESCAPE_CODE + "[");
            if (this.line != null && this.column != null) {
                builder.append(this.line).append(";").append(this.column);
            }
            builder.append(getPutCode());
            return builder.toString();
        }
    }

    private static class SaveCursor extends Code {
        @Override
        public String build() {
            return ESCAPE_CODE + "[s";
        }
    }

    private static class RestoreCursor extends Code {
        @Override
        public String build() {
            return ESCAPE_CODE + "[u";
        }
    }
}
