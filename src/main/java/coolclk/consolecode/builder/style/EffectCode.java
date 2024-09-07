package coolclk.consolecode.builder.style;

import coolclk.consolecode.code.Effect;

/**
 * The code builder about the effects.
 * @see Effect
 * @since 1.0
 * @author CoolCLK
 */
@SuppressWarnings("unused")
public interface EffectCode<F> {
    F effect(Effect attribute);

    default F reset() {
        return this.effect(Effect.RESET);
    }

    default F normal() {
        return this.effect(Effect.NORMAL);
    }

    default F bold() {
        return this.bold(false);
    }

    default F bold(boolean off) {
        return this.effect(off ? Effect.BOLD_OFF : Effect.BOLD);
    }

    default F faint() {
        return this.effect(Effect.FAINT);
    }

    default F italic() {
        return this.effect(Effect.ITALIC);
    }

    default F underline() {
        return this.underline(false);
    }

    default F underline(boolean isDoubled) {
        return this.effect(isDoubled ? Effect.DOUBLE_UNDERLINE : Effect.UNDERLINE);
    }

    default F blink() {
        return this.blink(false);
    }

    default F blink(boolean rapid) {
        return this.effect(rapid ? Effect.SLOW_BLINK : Effect.RAPID_BLINK);
    }

    default F invert() {
        return this.effect(Effect.INVERTED);
    }

    default F conceal(boolean off) {
        return this.effect(off ? Effect.REVEAL : Effect.CONCEAL);
    }

    default F conceal() {
        return this.effect(Effect.CONCEAL);
    }

    default F crossedOut(boolean off) {
        return this.effect(off ? Effect.NOT_CROSSED_OUT : Effect.CROSSED_OUT);
    }

    default F crossedOut() {
        return this.crossedOut(false);
    }
}
