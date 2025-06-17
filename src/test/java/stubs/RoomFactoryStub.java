package stubs;

import org.example.events.CorrectEvent;
import org.example.events.GameEvent;
import org.example.impediments.monster.factories.EasyMonsterFactory;
import org.example.impediments.monster.factories.MonsterFactory;
import org.example.rooms.IRoomFactory;
import org.example.rooms.Room;

import java.util.List;
import java.util.ArrayList;

public class RoomFactoryStub implements IRoomFactory {

    @Override
    public List<Room> createRooms() {
        List<Room> stubRooms = new ArrayList<>();
        stubRooms.add(new RoomStub("Stub Room 1", "Dit is kamer 1", new EasyMonsterFactory()));
        stubRooms.add(new RoomStub("Stub Room 2", "Dit is kamer 2", new EasyMonsterFactory()));
        return stubRooms;
    }

    static class RoomStub extends Room {
        public RoomStub(String name, String description, MonsterFactory monsterFactory) {
            super(name, description, monsterFactory);
        }

        @Override
        public GameEvent handleQuestion() {
            return new CorrectEvent();
        }
        @Override
        public void update(GameEvent event){
            // Leeg maar moet implemented ivm interface.
        }
    }
}