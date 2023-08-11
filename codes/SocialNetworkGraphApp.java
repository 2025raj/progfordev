import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class SocialNetworkGraphApp extends JFrame {

    private GraphPanel graphPanel;
    private List<Node> nodes;
    private List<Edge> edges;

    public SocialNetworkGraphApp() {
        setTitle("Social Network Graph");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        nodes = new ArrayList<>();
        edges = new ArrayList<>();

        graphPanel = new GraphPanel();
        add(graphPanel, BorderLayout.CENTER);

        JButton addNodeButton = new JButton("Add Node");
        addNodeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                nodes.add(new Node("New User", 50, 50)); // Adding a new node
                graphPanel.repaint(); // Repaint the canvas to update the rendering
            }
        });

        JPanel toolbarPanel = new JPanel();
        toolbarPanel.add(addNodeButton);

        add(toolbarPanel, BorderLayout.NORTH);

        // Sample nodes and edges
        nodes.add(new Node("raj", 100, 100));
        nodes.add(new Node("avishek ", 300, 100));
        nodes.add(new Node("anuj ", 250, 300));
        nodes.add(new Node("abhay ", 400, 200));
        nodes.add(new Node("krishna ", 500, 400));
        


        edges.add(new Edge(0, 1));
        edges.add(new Edge(0, 2));
        edges.add(new Edge(0, 3));
        edges.add(new Edge(0, 4));
        edges.add(new Edge(0, 4));

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SocialNetworkGraphApp::new);
    }

    class GraphPanel extends JPanel {
        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);

            for (Edge edge : edges) {
                Node sourceNode = nodes.get(edge.source);
                Node targetNode = nodes.get(edge.target);

                g.setColor(Color.BLACK);
                g.drawLine(sourceNode.x, sourceNode.y, targetNode.x, targetNode.y);
            }

            for (Node node : nodes) {
                g.setColor(Color.BLUE);
                g.fillOval(node.x - 20, node.y - 20, 40, 40);

                g.setColor(Color.BLACK);
                g.drawString(node.name, node.x - 15, node.y - 25);
            }
        }
    }

    class Node {
        String name;
        int x, y;

        Node(String name, int x, int y) {
            this.name = name;
            this.x = x;
            this.y = y;
        }
    }

    class Edge {
        int source, target;

        Edge(int source, int target) {
            this.source = source;
            this.target = target;
        }
    }
}
