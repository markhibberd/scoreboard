package scoreboard.pylons.score.ui.layout;

public final class DefaultSpacings implements Spacings {
    private final Double[] spacings;
    private final Double total;

    public DefaultSpacings(Double total, Double... spacings) {
        this.spacings = spacings.clone();
        this.total = total;
        validate();
    }

    private void validate() {
        double total = 0.0;
        for (Double spacing : spacings) total += spacing;
        if (total != this.total) boom();
    }

    private void boom() {
        throw new IllegalArgumentException("Spacings must add up to " + total + ".");
    }

    public Double[] abs() {
        Double[] result = new Double[spacings.length + 1];
        result[0] = 0.0;
        for (int i = 0; i < spacings.length; i++) {
            result[i + 1] = result[i] + (spacings[i] / total);
        }
        return result;
    }
}
