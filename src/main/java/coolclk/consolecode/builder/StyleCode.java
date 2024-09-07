package coolclk.consolecode.builder;

import coolclk.consolecode.ConsoleCode;
import coolclk.consolecode.builder.style.EffectCode;
import coolclk.consolecode.builder.style.ColorCode;
import coolclk.consolecode.builder.style.FontCode;
import coolclk.consolecode.code.Colors.Color;
import coolclk.consolecode.code.Colors.EightBitsColor;
import coolclk.consolecode.code.Colors.RGBColor;
import coolclk.consolecode.code.Effect;
import coolclk.consolecode.code.Font;

/**
 * The style code builder.
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public final class StyleCode extends ConsoleCode {
    private Effect effect = Effect.RESET;
    private Font font = null;
    private Color front = null, background = null;

    public EffectCode<StyleCode> effect() {
        return effect -> {
            if (effect == Effect.RESET) {
                this.front = null;
                this.background = null;
            }
            this.effect = effect;
            return this;
        };
    }

    public FontCode<StyleCode> font() {
        return font -> {
            this.font = font;
            return this;
        };
    }

    public ColorCode<StyleCode> front() {
        return color -> {
            this.front = color;
            return this;
        };
    }

    public ColorCode<StyleCode> background() {
        return color -> {
            this.background = color;
            return this;
        };
    }

    @Override
    public String build() {
        StringBuilder builder = new StringBuilder(ESCAPE_CODE);
        builder.append("[");
        if (this.effect != null) {
            builder.append(this.effect.getCode()).append(this.background == null || this.front == null ? "" : ";");
        }
        if (this.background != null) {
            builder.append(this.background.getBackgroundCode());
            if (this.background instanceof EightBitsColor) {
                builder.append(";5;").append(((EightBitsColor) this.background).getColor());
            } else if (this.background instanceof RGBColor) {
                builder.append(";5;").append(((RGBColor) this.background).getColorR()).append(";").append(((RGBColor) this.background).getColorG()).append(";").append(((RGBColor) this.background).getColorB());
            }
            builder.append(this.front == null ? "" : ";");
        }
        if (this.front != null) {
            builder.append(this.front.getFrontCode());
            if (this.front instanceof EightBitsColor) {
                builder.append(";5;").append(((EightBitsColor) this.front).getColor());
            } else if (this.front instanceof RGBColor) {
                builder.append(";5;").append(((RGBColor) this.front).getColorR()).append(";").append(((RGBColor) this.front).getColorG()).append(";").append(((RGBColor) this.front).getColorB());
            }
            builder.append(this.front == null ? "" : ";");
        }
        return builder.append("m").toString();
    }
}
