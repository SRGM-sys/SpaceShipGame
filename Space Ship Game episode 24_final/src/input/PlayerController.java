package input;

import gameObjects.Player;

public class PlayerController {
    
    private Player player;

    public PlayerController(Player player) {
        this.player = player;
    }

    public void update() {
        player.setShooting(KeyBoard.SHOOT);
        player.setTurningRight(KeyBoard.RIGHT);
        player.setTurningLeft(KeyBoard.LEFT);
        player.setAccelerating(KeyBoard.UP);
    }
}


