package coolclk.consolecode;

import java.util.ArrayList;
import java.util.List;

/**
 * The multi-support code.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public class MultiCodes extends ConsoleCode {
    private final List<Code> codes = new ArrayList<>();

    protected ActionBuilder<MultiCodes> codes() {
        final MultiCodes instance = this;
        return new ActionBuilder<MultiCodes>() {
            @Override
            public MultiCodes add(Code code) {
                instance.codes.add(code);
                return instance;
            }

            @Override
            public List<Code> getAll() {
                return new ArrayList<>(instance.codes);
            }

            @Override
            public MultiCodes clear() {
                instance.codes.clear();
                return instance;
            }
        };
    }

    @Override
    public String build() {
        StringBuilder builder = new StringBuilder();
        this.codes().getAll().forEach(code -> builder.append(code.build()));
        return builder.toString();
    }

    protected interface ActionBuilder<T> {
        T add(Code code);

        List<Code> getAll();

        T clear();
    }

    protected abstract static class Code {
        protected Code() {

        }

        public abstract String build();
    }
}
