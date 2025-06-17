
package org.example.impediments.monster.factories;

import org.example.impediments.monster.HardMathMonster;
import org.example.impediments.monster.Monster;

public class HardMonsterFactory extends MonsterFactory {
    @Override
    public Monster createMonster() {
        return new HardMathMonster();
    }
}