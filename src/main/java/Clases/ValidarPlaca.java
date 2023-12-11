/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Clases;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;

/**
 *
 * @author Danilore
 */
public class ValidarPlaca extends DocumentFilter{
    @Override
    public void insertString(FilterBypass fb, int offset, String string,
            AttributeSet attr) throws BadLocationException {

        // Solo permitir insertar si el formato es válido
        if (isValidPlaca(fb.getDocument().getText(0, fb.getDocument().getLength()) + string)) {
            super.insertString(fb, offset, string.toUpperCase(), attr);
        }
    }

    @Override
    public void replace(FilterBypass fb, int offset, int length, String text,
            AttributeSet attrs) throws BadLocationException {

        // Solo permitir reemplazar si el formato es válido
        if (isValidPlaca(fb.getDocument().getText(0, fb.getDocument().getLength())
                .substring(0, offset)
                + text + fb.getDocument().getText(offset + length, fb.getDocument().getLength()))) {
            super.replace(fb, offset, length, text.toUpperCase(), attrs);
        }
    }

    // Método para validar el formato de la placa
    private boolean isValidPlaca(String text) {
        return text.matches("[A-Z]{3}-[A-Z]{3}");
    }
}
