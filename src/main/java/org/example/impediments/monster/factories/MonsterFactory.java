package org.example.impediments.monster.factories;

import org.example.impediments.monster.Monster;
import org.example.impediments.monster.MonsterDifficulty;

public abstract class MonsterFactory {
    public abstract Monster createMonster();

    public static MonsterFactory getFactory(MonsterDifficulty difficulty) {
        return switch (difficulty) {
            case EASY -> new EasyMonsterFactory();
            case MEDIUM -> new MediumMonsterFactory();
            case HARD -> new HardMonsterFactory();
        };
    }
}