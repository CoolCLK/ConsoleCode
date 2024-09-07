package coolclk.consolecode.builder;

import coolclk.consolecode.MultiCodes;
import coolclk.consolecode.builder.context.EraseCode;

/**
 * The context code builder.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public class ContextCode extends MultiCodes {
    /**
     * Erase context.
     * @since 1.0
     * @author CoolCLK
     */
    public coolclk.consolecode.builder.context.EraseCode<ContextCode> erase() {
        final ContextCode instance = this;
        return new EraseCode<ContextCode>() {
            @Override
            public LineCode<ContextCode> line() {
                return code -> (ContextCode) instance.codes().add(new Code() {
                    @Override
                    public String build() {
                        return ESCAPE_CODE + "[" + code + "K";
                    }
                });
            }

            @Override
            public ScreenCode<ContextCode> screen() {
                return code -> (ContextCode) instance.codes().add(new Code() {
                    @Override
                    public String build() {
                        return ESCAPE_CODE + "[" + code + "J";
                    }
                });
            }
        };
    }
}
