package Graph;

import javax.swing.*;
import java.awt.*;
import Utility.CustomLinkedList;

public class VisualRepresentation extends JFrame {
    private final int radius = 20;  // Radius of the vertex circle
    private final int vertexDiameter = 2 * radius;
    public CustomLinkedList<int[]>[] graph;

    public VisualRepresentation(CustomLinkedList<int[]>[] GraphRepresentationList) {
        this.graph = GraphRepresentationList;

        // Set up JFrame
        setTitle("Graph Visual Representation");
        setSize(800, 800);  // Increased size for better visibility
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Add GraphPanel to JFrame
        GraphPanel graphPanel = new GraphPanel();
        add(graphPanel);

        // Set the JFrame to be visible
        setVisible(true);
    }

    private class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            drawVertices(g);
            drawEdges(g);
        }

        private void drawVertices(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int panelRadius = Math.min(centerX, centerY) - vertexDiameter;

            Font labelFont = new Font("Arial", Font.BOLD, 16);  // Change "Default" to your preferred font
            g.setFont(labelFont);

            for (int i = 0; i < graph.length; i++) {
                double angle = 2 * Math.PI * i / graph.length;
                int x = centerX + (int) (panelRadius * Math.cos(angle)) - radius;
                int y = centerY + (int) (panelRadius * Math.sin(angle)) - radius;

                // Draw vertex
                g.setColor(Color.GREEN);
                g.fillOval(x, y, vertexDiameter, vertexDiameter);

                // Draw vertex label
                g.setColor(Color.BLACK);
                g.drawString(Integer.toString(i), x + radius, y + radius);
            }
        }

        private void drawEdges(Graphics g) {
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;
            int panelRadius = Math.min(centerX, centerY) - vertexDiameter;

            for (int i = 0; i < graph.length; i++) {
                double angle1 = 2 * Math.PI * i / graph.length;
                int x1 = centerX + (int) (panelRadius * Math.cos(angle1));
                int y1 = centerY + (int) (panelRadius * Math.sin(angle1));

                CustomLinkedList<int[]> neighbors = graph[i];
                for (int j = 0; j < neighbors.length(); j++) {
                    int[] edge = neighbors.get(j);

                    if (i == edge[0]) { // Self-loop
                        g.setColor(Color.BLUE);
                        int loopDiameter = 3 * radius;
                        int loopX = x1 - loopDiameter / 2;
                        int loopY = y1 - loopDiameter / 2;
                        g.drawOval(loopX, loopY, loopDiameter, loopDiameter);
                    }
                    else
                    {
                        double angle2 = 2 * Math.PI * edge[0] / graph.length;
                        int x2 = centerX + (int) (panelRadius * Math.cos(angle2));
                        int y2 = centerY + (int) (panelRadius * Math.sin(angle2));

                        // Draw edge
                        g.setColor(Color.BLUE);
                        g.drawLine(x1, y1, x2, y2);

                        // Draw weight, if applicable
                        if (edge.length > 1) {
                            g.setColor(Color.BLACK);
                            int labelX = (x1 + x2) / 2;
                            int labelY = (y1 + y2) / 2;
                            g.drawString(Integer.toString(edge[1]), labelX, labelY);
                        }
                    }
                }
            }
        }
    }
}

