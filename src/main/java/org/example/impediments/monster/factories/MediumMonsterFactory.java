package org.example.impediments.monster.factories;

import org.example.impediments.monster.MediumMathMonster;
import org.example.impediments.monster.Monster;

public class MediumMonsterFactory extends MonsterFactory {
    @Override
    public Monster createMonster() {
        return new MediumMathMonster();
    }
}