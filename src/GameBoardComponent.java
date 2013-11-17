

/**
 * 
 * @author Armando Benavidez
 * @version .0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.TextArea;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractCellEditor;
import javax.swing.DropMode;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListCellRenderer;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
import javax.swing.text.Caret;


/**
 * @author Mando
 *
 */
public class GameBoardComponent extends JTable {

	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);    
	
	public AspectElementAdder testAdder;
	//public JTable theTable;
	
	
	/**
	 * generic comment
	 *
	 * <p>
	 * <code></code>
	 * </p>
	 *
	 * @param  <code></code>
	 * @return <code></code>
	 * 
	 */
	public GameBoardComponent() {
		GameBoardTableModel testModel = new GameBoardTableModel();

		testModel.setColumnCount(15);
		//testModel.addColumns(3);
		testModel.addRow(15);

		setModel(testModel);
		
		
		//theTable = new JTable(testModel);
		//theTable.setRowMargin(5);
		
		
		setRowHeight(45);
		setTableHeader(null);
		setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(51, 51, 51), 3));
		
		setDropMode(DropMode.USE_SELECTION);
		setDragEnabled(true);
		setTransferHandler(new MyTransferHandler());
		
		setDefaultEditor(Object.class, new PanelCellEditor());
		setDefaultRenderer(Object.class, new PanelCellRenderer());
		

	}
	
	public JTable getTable(){
		return this;
	}
	
	@SuppressWarnings("serial")
	class MyTransferHandler extends TransferHandler{
		
		public MyTransferHandler(){
		}
		
		@Override
		public int getSourceActions(JComponent comp){
			return MOVE;
		}
		
		@Override
		protected Transferable createTransferable(JComponent source) {  
			  
	        return new StringSelection((String) ((JTable) source).getModel().getValueAt(((JTable) source).getSelectedRow(), ((JTable) source).getSelectedColumn()));  
	    }  
		
	    @Override  
	    protected void exportDone(JComponent source, Transferable data, int action) {  
	    	
	        ((JTable) source).getModel().setValueAt("", ((JTable) source).getSelectedRow(), ((JTable) source).getSelectedColumn());  
	  
	    }  
	  
	    @Override  
	    public boolean canImport(TransferSupport support) {  
	        return true;  
	    }  
	  
	    @Override  
	    public boolean importData(TransferSupport support) {  
	        JTable jt = (JTable) support.getComponent();  
	        try {  
	            jt.setValueAt(support.getTransferable().getTransferData(DataFlavor.stringFlavor), jt.getSelectedRow(), jt.getSelectedColumn());  
	        } catch (UnsupportedFlavorException ex) {  
	            Logger.getLogger(MyTransferHandler.class.getName()).log(Level.SEVERE, null, ex);  
	        } catch (IOException ex) {  
	            Logger.getLogger(MyTransferHandler.class.getName()).log(Level.SEVERE, null, ex);  
	        }  
	        return super.importData(support);  
	    } 
		
		
		
	}
	
	class PanelCellRenderer implements TableCellRenderer{
		
		private AspectElementAdder renderer = new AspectElementAdder();
		
		@Override
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
		
			
			
			//renderer.setCompInfo((compInfo) value);
			
		//	//if aspect is selected ? if true set selection background else (:) foreground
			renderer.setBackground(isSelected ? Color.CYAN : Color.white);
			renderer.setForeground(isSelected ? Color.black : Color.black);
		//	newAspect.setEnabled(isEnabled());
			renderer.aspect.setFont(getFont());
			renderer.aspect.setFocusable(false);
			renderer.setBorder(getBorder());
			
			table.setAutoResizeMode(AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			table.setShowGrid(true);
			//table.setFillsViewportHeight(false);
			Dimension minimumSize = new Dimension(750, 675);
			setMaximumSize(minimumSize);
			setMinimumSize(minimumSize);
	//		setVisibleRowCount(-1);
	//		setLayoutOrientation(HORIZONTAL_WRAP);
		//renderer.aspect.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
			
			
			return renderer.aspect;
		}
	}
		
	class PanelCellEditor extends AbstractCellEditor implements TableCellEditor{
		
		private AspectElementAdder editor = new AspectElementAdder();
		
		
		@Override
		public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
				
		  //System.out.println("yo" + value.toString());
		  editor.setTileVal((String) value);
		  return editor.aspect;
		}
		
		@Override
		public Object getCellEditorValue() {
			return this.editor.getTileVal();
		}

		
	    @Override
	    public boolean isCellEditable(EventObject anEvent) {
	        return true;
	    }

	    @Override
	    public boolean shouldSelectCell(EventObject anEvent) {
	        return false;
	    }
	}
	
	class GameBoardTableModel extends DefaultTableModel{
	
	   // @Override
	   // public int getColumnCount() {
	   //     return 1;
	   // }
		
		/**
		public void addRow(){
			
			 super.addRow(new Object[]{new compInfo("")});
	    }
		
		
		public String getValueAt(int row, int column){
			
			//Component test = getComponentAt(row, column);
			
			
			
			//System.out.println(row + "   " + column);
			
			return "c";
			
		}
		
		**/
		
		public void addRow(int NumOfRows){	
			
			
			//setRowCount(NumOfRows);
			
			String[] setOfElements = new String[getColumnCount()];
			
			//System.out.println(getColumnCount());
			
	    	for(int i = 0; i<=(getColumnCount() - 1); i++){
	    		setOfElements[i] = ("");	
	    	}
			
			for(int i = 0; i<=(NumOfRows - 1); i++){
				super.addRow(setOfElements);
			}
	    }
		

	    public void addColumns(int NumOfColumns) {
	    	
	    	//System.out.println(NumOfColumns);
	    	
	    	//setColumnCount(NumOfColumns);
	    	
	    	//Object[] setOfElements = new Object[NumOfColumns];
	    	
	    	
	    	for(int i = 0; i<=(NumOfColumns - 1); i++){
	    		super.addColumn(null);	
	    	}
	    	
	    	
	    	//super.addRow(setOfElements);
	    }
	    

	    /**	
		
	    public void addColumns(int NumOfColumns) {
	    	setColumnCount((NumOfColumns - 1));
	    	
	    	super.addColumn(null, new Object[]{new compInfo(0, 0, "")});
	    }
	    */
		
	}
	
	
	/**
	
	class compInfo{
		
		public String tileLetter;
		
		public compInfo(String tileLetter){
			this.tileLetter = tileLetter;
		}
		
	}
	*/
	
	
	
	
	
	 /**
	 * *******Generic Description*******************
	 *
	 * @param Generic comment
	 * @param Generic Comment
	 * @return  Generic Comment
	 */  
	private class AspectElementAdder extends JPanel{
		// Variables declaration - do not modify                     
	  JButton buttonAdd;
	  

	    private JPanel aspect;
	    // End of variables declaration   
	    
		 /**
		 * *******Generic Description*******************
		 *
		 * @param Generic comment
		 * @param Generic Comment
		 * @return  Generic Comment
		 */  
		public AspectElementAdder() {
	        buttonAdd = new JButton();
	        
	        aspect = new JPanel();        
	        
	        setDragEnabled(true);
	        
	        buttonAdd.setText("");
	        buttonAdd.setIcon(new ImageIcon(getClass().getResource("resources/tileTexture.png")));

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(aspect);
	        aspect.setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(buttonAdd, 50, 50, 50)
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

	            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
	                .addComponent(buttonAdd, 45, 45, 45 ))
	        );
	        
		}
	
		
        /**
		 * description sentence <code></code>
		 *
		 * <p>description paragraph</p>
		 *
		 * @param
		 * @param
		 * @return
		 */
		public String getTileVal() {			
			return buttonAdd.getText();
		}


		private void enableUpper(boolean enable) {
        		buttonAdd.setEnabled(enable);
        		buttonAdd.setVisible(true);
	        }
	        
	   public void setTileVal(String tileLetter){
		   this.buttonAdd.setText(tileLetter);
		   enableUpper(true);    
	   }
	   
	   
	   
	   
        public String getComp() {
        	return this.buttonAdd.getText();
        }
	}
	
}//eof
