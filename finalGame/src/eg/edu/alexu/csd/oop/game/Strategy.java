package eg.edu.alexu.csd.oop.game;

import java.awt.Color;
import java.awt.Graphics;

public interface Strategy {
public void setColor(Color color);
public void draw(Graphics canvas);
public void setVisible(boolean visible);
public Color getColor();
}
