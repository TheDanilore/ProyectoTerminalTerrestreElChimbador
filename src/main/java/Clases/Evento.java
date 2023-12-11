package Clases;

import java.awt.event.KeyEvent;
import javax.swing.JTextField;

/**
 *
 * @author windows2020
 */
public class Evento {

    public void textKeyPress(KeyEvent evt) {
// declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < 'a' || car > 'z') && (car < 'A' || car > 'Z')
                && (car != (char) KeyEvent.VK_BACK_SPACE) && (car != (char) KeyEvent.VK_SPACE)) {
            evt.consume();
        }
    }

    public void numberKeyPress(KeyEvent evt) {
// declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }

    public void numberDecimalKeyPress(KeyEvent evt, JTextField textField) {
// declaramos una variable y le asignamos un evento
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9') && textField.getText().contains(".") && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        } else if ((car < '0' || car > '9') && (car != '.') && (car != (char) KeyEvent.VK_BACK_SPACE)) {
            evt.consume();
        }
    }
    
    public void placaKeyPress(KeyEvent evt, JTextField textField) {
        char car = evt.getKeyChar();
        String text = textField.getText();

        // Limitar a 7 caracteres (6 letras y un guion)
        if (text.length() >= 7 && car != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        // Permitir letras, números, guion y la tecla de borrar
        if (!isValidCharacter(car) && car != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        // Permitir un guion en la cuarta posición
        if (text.length() == 3 && car != '-' && car != KeyEvent.VK_BACK_SPACE) {
            evt.consume();
        }

        // Convertir a mayúscula si se ingresa una letra
        if (Character.isLowerCase(car)) {
            car = Character.toUpperCase(car);
            evt.setKeyChar(car);
        }
    }

    private boolean isValidCharacter(char car) {
        return Character.isLetterOrDigit(car) || car == '-';
    }



}
