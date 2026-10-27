package gameObjects;

import java.awt.Color;
import java.awt.image.BufferedImage;

import graphics.Assets;
import math.Vector2D;
import states.GameState;
import ui.Action;

public enum PowerUpTypes {
    SHIELD("SHIELD", Assets.shield) {
        @Override
        public Action getAction(GameState state, Vector2D position) {
            return new Action() {
                @Override
                public void doAction() {
                    state.getPlayer().setShield();
                    state.getMessages().add(new Message(position, false, text, Color.DARK_GRAY, false, Assets.fontMed));
                }
            };
        }
    },
    LIFE("+1 LIFE", Assets.life) {
        @Override
        public Action getAction(GameState state, Vector2D position) {
            return new Action() {
                @Override
                public void doAction() {
                    state.addLife();
                    state.getMessages().add(new Message(position, false, text, Color.GREEN, false, Assets.fontMed));
                }
            };
        }
    },
    SCORE_X2("SCORE x2", Assets.doubleScore) {
        @Override
        public Action getAction(GameState state, Vector2D position) {
            return new Action() {
                @Override
                public void doAction() {
                    state.getPlayer().setDoubleScore();
                    state.getMessages().add(new Message(position, false, text, Color.YELLOW, false, Assets.fontMed));
                }
            };
        }
    },
    FASTER_FIRE("FAST FIRE", Assets.fastFire) {
        @Override
        public Action getAction(GameState state, Vector2D position) {
            return new Action() {
                @Override
                public void doAction() {
                    state.getPlayer().setFastFire();
                    state.getMessages().add(new Message(position, false, text, Color.BLUE, false, Assets.fontMed));
                }
            };
        }
    },
    SCORE_STACK("+1000 SCORE", Assets.star) {
        @Override
        public Action getAction(GameState state, Vector2D position) {
            return new Action() {
                @Override
                public void doAction() {
                    state.addRawScore(1000);
                    state.getMessages().add(new Message(position, false, text, Color.MAGENTA, false, Assets.fontMed));
                }
            };
        }
    },
    DOUBLE_GUN("DOUBLE GUN", Assets.doubleGun) {
        @Override
        public Action getAction(GameState state, Vector2D position) {
            return new Action() {
                @Override
                public void doAction() {
                    state.getPlayer().setDoubleGun();
                    state.getMessages().add(new Message(position, false, text, Color.ORANGE, false, Assets.fontMed));
                }
            };
        }
    };

    public String text;
    public BufferedImage texture;

    private PowerUpTypes(String text, BufferedImage texture){
        this.text = text;
        this.texture = texture;
    }

    // Método que obliga a cada tipo de PowerUp a definir su propia lógica
    public abstract Action getAction(GameState state, Vector2D position);
}