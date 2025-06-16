package org.example.hints;

import java.util.List;
import java.util.Random;

public class HintSelector {
    private List<HintProvider> hintProviders;
    private Random random = new Random();

    public HintSelector(List<HintProvider> hintProviders) {
        this.hintProviders = hintProviders;
    }

    public HintProvider selectRandomHint() {
        return hintProviders.get(random.nextInt(hintProviders.size()));
    }
}
