/**
 * Created by mandarin on 27.05.17.
 */

import javax.swing.*;
import java.io.IOException;
import java.io.OutputStream;

/**
 * This class extends from OutputStream to redirect output to a JTextArrea
 *
 */
class CustomOutputStream extends OutputStream {
    private JTextArea textArea;

    public CustomOutputStream(JTextArea textArea) {
        this.textArea = textArea;
    }

    // @Override
    // как не надо делать
    // public void write(int b) throws IOException {
    // // redirects data to the text area
    // textArea.append(String.valueOf((char) b));
    // // scrolls the text area to the end of data
    // textArea.setCaretPosition(textArea.getDocument().getLength());
    // }

    // правильная русская кодировка
    @Override
    public void write(byte[] buffer, int offset, int length) throws IOException {
        final String text = new String(buffer, offset, length);
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                textArea.append (text);
            }
        });
    }

    @Override
    public void write(int b) throws IOException {
        write(new byte[] { (byte) b }, 0, 1);
    }
}