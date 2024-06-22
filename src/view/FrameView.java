package view;

import model.OperationCalculations;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Collections;

import static java.lang.Thread.sleep;

public class FrameView extends JFrame {

    // attributes
    private BufferedImage buffer;
    private Graphics graphics;
    private BufferedImage image;
    public final int WIDTH = 600;
    public final int HEIGHT = 600;
    public double[][] pP; // proyectedPoints
    public int points;

    public double cont1;
    public double cont2;
    public Animation animation;
    public Scenary scenary;
    public int[] brightness;
    public double[] sizeStarts;
    public Boolean[] brightnessFlag;
    public Boolean[] sizeStartsFlag;

    //constructor
    public FrameView() {
        setTitle("Projection 3D - View.Animation");
        setSize(WIDTH, HEIGHT);
        setLayout(null);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.cont1 = 0;
        this.cont2 = 0;
        brightness = new int[]{145, 90, 132, 110, 234, 250, 212, 180, 194, 155, 176, 85, 70, 69, 245, 190, 220, 186, 158, 140};
        sizeStarts = new double[]{2, 1, 0, 1, 3, 2, 1, 1, 3, 2, 2, 1, 0, 1, 3, 2, 1, 1, 3, 2};
        brightnessFlag = new Boolean[20];
        sizeStartsFlag = new Boolean[20];

        for (int i = 0; i < brightnessFlag.length; i++) {
            brightnessFlag[i] = true;
        }
        for (int i = 0; i < sizeStarts.length; i++) {
            sizeStartsFlag[i] = true;
        }
        animation = new Animation(this);

        buffer = new BufferedImage(1, 1, BufferedImage.TYPE_INT_RGB);
        scenary = new Scenary(this);
        //graphics = (Graphics2D) buffer.getGraphics();
    }

    //methods
    public void PutPixel(int x, int y, Color color){
        if(x >= 0 && x < WIDTH && y >= 0 && y < HEIGHT){
            image.setRGB(x, y, color.getRGB());
        }
    }

    public void paint(Graphics g){
        //image = new BufferedImage(WIDTH, HEIGHT, BufferedImage.TRANSLUCENT);
        image = scenary.drawNightStage();
        //-------------------------------------------
//        for (int x = 0; x < WIDTH; x++) {
//            for (int y = 0; y < HEIGHT; y++) {
//                //PutPixel(x, y, new Color(106, 88, 175));
//                PutPixel(x, y, new Color(7, 18, 76, 254));
//            }
//        }

        try {
            //animation.menuGame();
            //cubeScaling();
            //scenary.drawPrueba();
            drawStart();
            sleep(60/1000);
            repaint();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        //-------------------------------------------
        g.drawImage(image, 0, 0, this);
    }

    public void drawScene1() {
        Color dark_blue = new Color(7, 18, 76);
        drawFillRectangle(0, 0, WIDTH, HEIGHT, dark_blue);
    }

    public void cube() {
        Color black = new Color(0, 0, 0);
        Color red = new Color(246, 18, 18);
        Color white = new Color(254, 254, 254);

        double[][] cube1 = {{50,50,50}, {150,50,50}, {150,50,150}, {50,50,150} ,{50,150,50}, {150,150,50}, {150,150,150}, {50,150,150}};
        //Convert 3D Points to 2D
        cont1-=0.005;
        cont2+=0.01;
        OperationCalculations op = new OperationCalculations(1,1,5, cube1);
        op.getProjectedPoints();

        this.pP = op.getProjectedPoints();
        this.points = op.getProjectedPoints().length;

        int position = 150;
        drawLinesCube(position, black);

        double[][] cube2 = {{150,50,50}, {250,50,50}, {250,50,150}, {150,50,150} ,{150,150,50}, {250,150,50}, {250,150,150}, {150,150,150}};

        cont1-=0.01;
        cont2+=0.005;
        op = new OperationCalculations(cont1,cont2,5, cube2);
        op.getProjectedPoints();

        this.pP = op.getProjectedPoints();
        this.points = op.getProjectedPoints().length;

        drawLinesCube(position, red);
    }

    public void cubeScaling() {

        Color black = new Color(0, 0, 0);
        Color red = new Color(246, 18, 18);
        Color white = new Color(254, 254, 254);
        Color dark_blue = new Color(7, 18, 76);

        double[][] cubeScaling = {{50,50,50}, {150,50,50}, {150,50,150}, {50,50,150} ,{50,150,50}, {150,150,50}, {150,150,150}, {50,150,150}};

        cont1-=0.01;
        cont2+=0.005;
        OperationCalculations op = new OperationCalculations(cont1, cont2,5, cubeScaling);

        //CalculateProyection cp = new CalculateProyection(cont1, cont2,5, cubeScaling);
        //op.rotating(cont2);
        //op.setPointsXY(op.getTransformMatrix());
        //op.scaling(2, 2);
        //op.setPointsXY(op.getTransformMatrix());

        this.pP = op.getProjectedPoints();
        this.points = op.getProjectedPoints().length;

        drawLinesCube(150, white);
    }

    public void drawLinesCube(int position, Color color) {
        drawDDALine((int) pP[0][0] + position, (int) pP[0][1] + position, (int) pP[1][0] + position, (int) pP[1][1] + position, color);
        drawDDALine((int) pP[1][0] + position, (int) pP[1][1] + position, (int) pP[2][0] + position, (int) pP[2][1] + position, color);
        drawDDALine((int) pP[2][0] + position, (int) pP[2][1] + position, (int) pP[3][0] + position, (int) pP[3][1] + position, color);

        drawDDALine((int) pP[3][0] + position, (int) pP[3][1] + position, (int) pP[0][0] + position, (int) pP[0][1] + position, color);
        drawDDALine((int) pP[0][0] + position, (int) pP[0][1] + position, (int) pP[4][0] + position, (int) pP[4][1] + position, color);
        drawDDALine((int) pP[1][0] + position, (int) pP[1][1] + position, (int) pP[5][0] + position, (int) pP[5][1] + position, color);
        drawDDALine((int) pP[3][0] + position, (int) pP[3][1] + position, (int) pP[7][0] + position, (int) pP[7][1] + position, color);
        drawDDALine((int) pP[2][0] + position, (int) pP[2][1] + position, (int) pP[6][0] + position, (int) pP[6][1] + position, color);

        drawDDALine((int) pP[4][0] + position, (int) pP[4][1] + position, (int) pP[5][0] + position, (int) pP[5][1] + position, color);
        drawDDALine((int) pP[5][0] + position, (int) pP[5][1] + position, (int) pP[6][0] + position, (int) pP[6][1] + position, color);
        drawDDALine((int) pP[6][0] + position, (int) pP[6][1] + position, (int) pP[7][0] + position, (int) pP[7][1] + position, color);
        drawDDALine((int) pP[7][0] + position, (int) pP[7][1] + position, (int) pP[4][0] + position, (int) pP[4][1] + position, color);
    }

    public void drawDDALine(int x0, int y0, int xf, int yf, Color c) {
        int xDifference = xf - x0;
        int yDifference = yf - y0;

        double difference = Math.sqrt(xDifference * xDifference + yDifference * yDifference);
        int steps = (int) Math.round(difference);

        double xIncrement = (double) xDifference / steps;
        double yIncrement = (double) yDifference / steps;

        double x = x0;
        double y = y0;
        PutPixel((int) Math.round(x), HEIGHT - (int) Math.round(y), c);
        for(int i = 0 ; i <= steps ; i++){
            PutPixel((int) Math.round(x), HEIGHT - (int) Math.round(y), c);
            x += xIncrement;
            y += yIncrement;
        }

        x = x0;
        y = y0;
        for(int k = 1; k <= steps; k++){
            PutPixel((int) Math.round(x), HEIGHT - (int) Math.round(y), c);
            x += xIncrement;
            y += yIncrement;
        }
    }

    public void drawFillRectangle(int x0, int y0, int xf, int yf, Color fillColor) {
        int temp = 0;
        // Dibujar los bordes del rectángulo
        drawDDALine(x0, y0, xf, y0, fillColor);
        drawDDALine(xf, y0, xf, yf, fillColor);
        drawDDALine(xf, yf, x0, yf, fillColor);
        drawDDALine(x0, yf, x0, y0, fillColor);

        if(x0 > xf) {
            temp = x0;
            x0 = xf;
            xf = temp;
        }
        if(y0 > yf) {
            temp = y0;
            y0 = yf;
            yf = temp;
        }
        // Rellenar el área interior del rectángulo
        for (int y = y0 + 1; y < yf; y++) {
            drawDDALine(x0, y, xf, y, fillColor);
        }
    }

    // method for drawing an irregular polygon
    public void drawFillPolygon(double listPoints[][], Color c) {
        int points = listPoints.length;
        int[] x = new int[points];
        int[] y = new int[points];

        for (int i = 0; i < points; i++) {
            x[i] = (int) Math.round(listPoints[i][0]);
            y[i] = (int) Math.round(listPoints[i][1]);
        }

        for (int i = 0; i < x.length; i++) {
            if ((i + 1) != x.length) {
                drawDDALine(x[i], y[i], x[i + 1], y[i + 1], c);
            } else {
                drawDDALine(x[i], y[i], x[0], y[0], c);
            }
        }

        // Calculate the minimum and maximum for to determine the polygon area
        int minY = y[0];
        int maxY = y[0];
        for (int i = 1; i < y.length; i++) {
            minY = Math.min(minY, y[i]);
            maxY = Math.max(maxY, y[i]);
        }

        // Iterate over each horizontal line inside of polygon area
        for (int j = minY; j <= maxY; j++) {
            // Store the points of intersection with the sides of the polygon
            ArrayList<Integer> intersections = new ArrayList<>();

            // Determinate the intersections with the sides of the polygon
            for (int i = 0; i < x.length; i++) {
                int next = (i + 1) % x.length; // Index of the next point (we use modulo for the last point)
                int y1 = y[i];
                int y2 = y[next];
                if ((y1 <= j && y2 > j) || (y2 <= j && y1 > j)) {
                    // The line connecting points i and next crosses the horizontal line
                    // Calculate the point of intersection with the horizontal line
                    double xIntersect = (double) (x[next] - x[i]) * (double) (j - y[i]) / (double) (y[next] - y[i]) + x[i];
                    intersections.add((int) xIntersect);
                }
            }

            // Order the intersection points in ascendant order
            Collections.sort(intersections);

            // Draw the horizontal lines between intersection points
            for (int k = 0; k < intersections.size(); k += 2) {
                int x1 = intersections.get(k);
                int x2 = intersections.get(k + 1);
                drawDDALine(x1, j, x2, j, c); // Draw horizontal line
            }
        }
    }

    public void drawEllipse(int xc, int yc, int rx, int ry, Color c) {
        int x = 0;
        int y = ry;
        int rxSquare = rx * rx;
        int rySquare = ry * ry;
        int twoRxSquare = 2 * rxSquare;
        int twoRySquare = 2 * rySquare;
        int p;
        int px = 0;
        int py = twoRxSquare * y;

        // draw region 1
        plotEllipsePoints(xc, yc, x, y, c);

        // region 1
        p = (int) Math.round(rySquare - (rxSquare * ry) + (0.25 * rxSquare));
        while (px < py) {
            x++;
            px += twoRySquare;
            if (p < 0) {
                p += rySquare + px;
            } else {
                y--;
                py -= twoRxSquare;
                p += rySquare + px - py;
            }
            plotEllipsePoints(xc, yc, x, y, c);
        }

        // region 2
        p = (int) Math.round(rySquare * (x + 0.5) * (x + 0.5) + rxSquare * (y - 1) * (y - 1) - rxSquare * rySquare);
        while (y > 0) {
            y--;
            py -= twoRxSquare;
            if (p > 0) {
                p += rxSquare - py;
            } else {
                x++;
                px += twoRySquare;
                p += rxSquare - py + px;
            }
            plotEllipsePoints(xc, yc, x, y, c);
        }
    }

    private void plotEllipsePoints(int xc, int yc, int x, int y, Color c) {
        PutPixel(xc + x, HEIGHT - yc + y, c);
        PutPixel(xc - x, HEIGHT - yc + y, c);
        PutPixel(xc + x, HEIGHT - yc - y, c);
        PutPixel(xc - x, HEIGHT - yc - y, c);
    }

    public void drawFillEllipse(int xc, int yc, int rx, int ry, Color fillColor) {
        int x = 0;
        int y = ry;
        int rxSquare = rx * rx;
        int rySquare = ry * ry;
        int twoRxSquare = 2 * rxSquare;
        int twoRySquare = 2 * rySquare;
        int p;
        int px = 0;
        int py = twoRxSquare * y;

        // draw region 1 and 2
        drawEllipse(xc, yc, rx, ry, fillColor);

        // fill region 1 and 2
        p = (int) Math.round(rySquare - (rxSquare * ry) + (0.25 * rxSquare));
        while (px < py) {
            x++;
            px += twoRySquare;
            if (p < 0) {
                p += rySquare + px;
            } else {
                y--;
                py -= twoRxSquare;
                p += rySquare + px - py;
            }
            drawHorizontalLine(xc - x, yc + y, 2 * x, fillColor);
            drawHorizontalLine(xc - x, yc - y, 2 * x, fillColor);
        }

        // fill region 3 and 4
        p = (int) Math.round(rySquare * (x + 0.5) * (x + 0.5) + rxSquare * (y - 1) * (y - 1) - rxSquare * rySquare);
        while (y > 0) {
            y--;
            py -= twoRxSquare;
            if (p > 0) {
                p += rxSquare - py;
            } else {
                x++;
                px += twoRySquare;
                p += rxSquare - py + px;
            }
            drawHorizontalLine(xc - x, yc + y, 2 * x, fillColor);
            drawHorizontalLine(xc - x, yc - y, 2 * x, fillColor);
        }
    }

    private void drawHorizontalLine(int x, int y, int length, Color c) {
        for (int i = x; i < x + length; i++) {
            PutPixel(i, HEIGHT - y, c);
        }
    }

    public void drawStart(){
        Color light_purlple = new Color(30, 33, 155);
        Color red = new Color(255, 0, 0, 1);
        drawFillEllipse(273, 14, (int) sizeStarts[0], (int) sizeStarts[0], new Color(brightness[0],brightness[0],brightness[0], 100));
        drawFillEllipse(309, 9, (int) sizeStarts[1], (int) sizeStarts[1], new Color(brightness[1],brightness[1],brightness[1], 100));
        drawFillEllipse(395, 90, (int) sizeStarts[2], (int) sizeStarts[2], new Color(brightness[2],brightness[2],brightness[2], 100));
        drawFillEllipse(433, 94, (int) sizeStarts[3], (int) sizeStarts[3], new Color(brightness[3],brightness[3],brightness[3], 100));
        drawFillEllipse(426, 139, (int) sizeStarts[4], (int) sizeStarts[4], new Color(brightness[4],brightness[4],brightness[4], 100));
        drawFillEllipse(479, 111, (int) sizeStarts[5], (int) sizeStarts[5], new Color(brightness[5],brightness[5],brightness[5], 100));
        drawFillEllipse(480, 56, (int) sizeStarts[6], (int) sizeStarts[6], new Color(brightness[6],brightness[6],brightness[6], 100));
        drawFillEllipse(499, 92, (int) sizeStarts[7], (int) sizeStarts[7], new Color(brightness[7],brightness[7],brightness[7], 100));
        drawFillEllipse(527, 129, (int) sizeStarts[8], (int) sizeStarts[8], new Color(brightness[8],brightness[8],brightness[8], 100));
        drawFillEllipse(487, 145, (int) sizeStarts[9], (int) sizeStarts[9], new Color(brightness[9],brightness[9],brightness[9], 100));

        drawFillEllipse(97, 327, (int) sizeStarts[10], (int) sizeStarts[10], new Color(brightness[10],brightness[10],brightness[10], 100));
        drawFillEllipse(34, 158, (int) sizeStarts[11], (int) sizeStarts[11], new Color(brightness[11],brightness[11],brightness[11], 100));
        drawFillEllipse(420, 484, (int) sizeStarts[12], (int) sizeStarts[12], new Color(brightness[12],brightness[12],brightness[12], 100));
        drawFillEllipse(377, 301, (int) sizeStarts[13], (int) sizeStarts[13], new Color(brightness[13],brightness[13],brightness[13], 100));
        drawFillEllipse(556, 385, (int) sizeStarts[14], (int) sizeStarts[14], new Color(brightness[14],brightness[14],brightness[14], 100));

        for (int i = 0; i < brightness.length; i++) {
            if(brightnessFlag[i]) {
                if(brightness[i] >= 250){
                    brightnessFlag[i] = false;
                } else {
                    brightness[i]++;
                }
            } else {
                if(brightness[i] <= 140) {
                    brightnessFlag[i] = true;
                } else {
                    brightness[i]--;
                }
            }
            if (sizeStartsFlag[i]) {
                if(sizeStarts[i] >= 5){
                    sizeStartsFlag[i] = false;
                } else {
                    sizeStarts[i]+=0.005;
                }
            } else {
                if(sizeStarts[i] <= 0){
                    sizeStartsFlag[i] = true;
                } else {
                    sizeStarts[i]-=0.005;
                }
            }
        }
    }

    public static void main(String[] args) {
        FrameView view = new FrameView();
        view.setVisible(true);
    }
}
