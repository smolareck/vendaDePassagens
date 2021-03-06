package br.univates.views.comprar.util;

import br.univates.entity.Passagem;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.swing.table.AbstractTableModel;


public class PassagensTableModel extends AbstractTableModel{
    
    String [] colunas = {"ID","VALOR","VALIDADE"};
    List<Passagem> passagens = new ArrayList<>();
    
    @Override
    public int getRowCount() {
        return passagens.size();
    }

    @Override
    public int getColumnCount() {
       return colunas.length;
    }

    @Override
    public String getColumnName(int column) {
        switch(column){
            case 0:
                return colunas[0];
            case 1:
                return colunas[1];
            case 2:
                return colunas[2];
        }
        return null;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        switch(columnIndex){
            case 0:
                return String.class;
            case 1:
                return String.class;
            case 2:
                return String.class;
            default:
                throw new IndexOutOfBoundsException();
        }
        
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch(columnIndex){
            case 0:
                return passagens.get(rowIndex).getId()+"";
            case 1:
                return passagens.get(rowIndex).getValor()+"";
            case 2:
                return passagens.get(rowIndex).getValidade().getTime();
            default:
                throw new IndexOutOfBoundsException();
        }
    }
    
    public void addPassagens(List<Passagem> passagens){
        this.passagens.addAll(passagens);
        fireTableRowsInserted(passagens.size() - 1, passagens.size() - 1);
    }
    
    public void limpa(){
        this.passagens.clear();
        fireTableRowsDeleted(passagens.size() - 1, passagens.size() - 1);
    }
    
}
