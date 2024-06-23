package view;

import model.StaticCube;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

public class Scenary {

    private BufferedImage fondo;
    private FrameView v;

    public Scenary(FrameView view) {
        this.v = view;
    }

    public BufferedImage drawNightStage() {
        URL url = getClass().getResource("/images/fondo.png");
        try {
            assert url != null;
            fondo = ImageIO.read(url);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException(e);
        }
        return fondo;
    }

    public void drawLevel() {
        StaticCube cube = new StaticCube(v);
        cube.setBorder(new Color(255, 255, 255));
        cube.drawFigure();
    }
}
