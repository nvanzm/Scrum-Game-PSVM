package org.example.impediments.monster.factories;

import org.example.impediments.monster.EasyMathMonster;
import org.example.impediments.monster.Monster;

public class EasyMonsterFactory extends MonsterFactory {
    @Override
    public Monster createMonster() {
        return new EasyMathMonster();
    }
}