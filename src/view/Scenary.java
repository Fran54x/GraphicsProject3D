package view;

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

    public void drawPrueba(){
        Color white = new Color(255,255,255, 0);
        Color light_purlple = new Color(129, 132, 231, 100);
        v.drawFillEllipse(273, 14, 1, 1, white);
        v.drawFillEllipse(309, 9, 1, 1, white);
        v.drawFillEllipse(395, 90, 2, 2, white);
        v.drawFillEllipse(433, 94, 2, 2, light_purlple);
        v.drawFillEllipse(426, 139, 1, 1, light_purlple);
        v.drawFillEllipse(479, 111, 2, 2, light_purlple);
        v.drawFillEllipse(480, 56, 2, 2, light_purlple);
        v.drawFillEllipse(499, 92, 1, 1, light_purlple);
        v.drawFillEllipse(527, 129, 1, 1, light_purlple);
        v.drawFillEllipse(487, 145, 2, 2, light_purlple);
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
}
