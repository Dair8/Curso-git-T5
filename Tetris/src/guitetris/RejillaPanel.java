/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package guitetris;
import data.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
/**
 *
 * @author dair
 */
public class RejillaPanel extends javax.swing.JPanel {
    /**
     * Referencia al TetrisFrame donde se incluye este Jpanel.
     */
    private TetrisFrame frame;
    /**
     *Número de pixeles del ancho y alto de cada celda de este tablero de juego.
     */
    private int anchoCelda=-1;
    /**
     * Creates new form RejillaPanel
     */
    public RejillaPanel() {
        initComponents();
    }

    public RejillaPanel(TetrisFrame fr) {
        this();
        frame = fr;
    }
    
    /**
     * Dibuja cada una de las celdas de la matriz bidimensional de la Rejilla.
     * Cada celda puede estar ocupada por BLOQUE (muro exterior) o PIEZA
     * (elemento de una Figura)
     a
     * @param el Graphics donde se dibujar ́
     */
    public void dibujaRejilla(java.awt.Graphics g){
        int i,j;
        Rejilla rejilla=frame.getRejilla();
        int xoffset=(getWidth()-rejilla.getAnchura()*anchoCelda)/2;
        
        for(i=0;i<rejilla.getAnchura();i++){
            for(j=0;j<rejilla.getAltura();j++){
                if(rejilla.getTipoCelda(i,j) == Rejilla.BLOQUE){
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                } else if(rejilla.getTipoCelda(i,j) == Rejilla.PIEZA){
                    g.setColor(Color.GRAY);
                    g.fillRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+i*anchoCelda,j*anchoCelda,anchoCelda,
                    anchoCelda);
                }
             }
        }
    }

    @Override
    protected void paintComponent(java.awt.Graphics g) {
        super.paintComponent(g);
        if(anchoCelda==-1){
            anchoCelda=Math.min(getWidth()/frame.getRejilla().getAnchura(),
                               (getHeight()-10)/frame.getRejilla().getAltura());
        }
        g.setColor(Color.WHITE);
        g.fillRect(0,0,getWidth(),getHeight());
        dibujaRejilla(g);
        dibujaFigura(frame.getFigura(),g);
    }
    
    /**
    * Dibuja la Figura fig en el Graphics g pasado como paŕrametro
    * (normalmente el asociado a este Canvas).
    * @param fig la Figura a dibujar
    * @param el Graphics donde se dibujará
    */
    void dibujaFigura(Figura fig,java.awt.Graphics g){
        if (fig!=null){
            Elemento elemento;
            Rejilla rejilla=frame.getRejilla();
            int xoffset=(getWidth()-rejilla.getAnchura()*anchoCelda)/
            2+fig.getXOrigen()*anchoCelda;
            int yoffset=fig.getYOrigen()*anchoCelda;
            
            for(int i=0;i<fig.getNElements();i++){
                elemento=fig.getElementAt(i);
                if (fig.getTipo()==0){
                    g.setColor(Color.CYAN);
                    g.fillRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,
                    anchoCelda,anchoCelda);
                }else if (fig.getTipo()==1 || (fig.getTipo()==2)){
                    g.setColor(Color.GREEN);
                    g.fillRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,
                    anchoCelda,anchoCelda);
                }else if (fig.getTipo()==3){
                    g.setColor(Color.RED);
                    g.fillRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,
                    anchoCelda,anchoCelda);
                }else if (fig.getTipo()==5 || (fig.getTipo()==6)){
                    g.setColor(Color.MAGENTA);
                    g.fillRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,
                    anchoCelda,anchoCelda);
                }else if (fig.getTipo()==4){
                    g.setColor(Color.YELLOW);
                    g.fillRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,anchoCelda,anchoCelda);
                    g.setColor(Color.BLACK);
                    g.drawRect(xoffset+elemento.getColumna()*anchoCelda,
                    yoffset+elemento.getFila()*anchoCelda,
                    anchoCelda,anchoCelda);
                }
            }
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setPreferredSize(new java.awt.Dimension(200, 400));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                RejillaPanel.this.mouseEntered(evt);
            }
        });
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                RejillaPanel.this.keyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void keyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_keyPressed
        if (evt.getKeyCode() == KeyEvent.VK_SPACE){
            if(frame.getMueve().getParado()==false){
                frame.getMueve().suspender();
            }else{
                frame.getMueve().reanudar();
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_LEFT){
            if(!frame.getRejilla().seChoca(frame.getFigura(),Figura.IZQUIERDA)){
                frame.getFigura().mueve(Figura.IZQUIERDA);
                if(frame.getPanel()!=null)
                    frame.getPanel().repaint();
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_RIGHT){
            if(!frame.getRejilla().seChoca(frame.getFigura(),Figura.DERECHA)){
                frame.getFigura().mueve(Figura.DERECHA);
                if(frame.getPanel()!=null)
                    frame.getPanel().repaint();
            }
        }else if (evt.getKeyCode() == KeyEvent.VK_UP){
            frame.getFigura().rotar(frame.getRejilla());
            if(frame.getPanel()!=null)
                frame.getPanel().repaint();
        }else if (evt.getKeyCode() == KeyEvent.VK_DOWN){
            if(!frame.getRejilla().seChoca(frame.getFigura(),Figura.ABAJO)){
                frame.getFigura().mueve(Figura.ABAJO);
                if(frame.getPanel()!=null)
                    frame.getPanel().repaint();
            }
        }
    }//GEN-LAST:event_keyPressed

    private void mouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseEntered
        requestFocus();
    }//GEN-LAST:event_mouseEntered


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
