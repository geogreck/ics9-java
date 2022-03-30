import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class PictureForm {
    private JPanel mainPanel;
    private JSpinner floorSpinner;
    private CanvasPanel canvasPanel;
    private JSpinner windowSpinner;
    private JCheckBox heatingBox;

    public PictureForm() {
        floorSpinner.setValue(2);
        windowSpinner.setValue(3);
        heatingBox.setSelected(true);


        floorSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int floors = (int) floorSpinner.getValue();
                canvasPanel.setFloors(floors);
            }
        });

        windowSpinner.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int windows = (int) windowSpinner.getValue();
                canvasPanel.setWindows(windows);
            }
        });
        heatingBox.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                boolean heating = (boolean) heatingBox.isSelected();
                canvasPanel.setHeating(heating);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Домик ¯\\_(ツ)_/¯");
        frame.setContentPane(new PictureForm().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
        floorSpinner = new JSpinner(new SpinnerNumberModel(2, -2, 10, 1));
        windowSpinner = new JSpinner(new SpinnerNumberModel(3, 0, 100, 1));
    }
}
