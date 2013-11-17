import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.util.EventObject;

import javax.swing.AbstractCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;



/**
 * 
 * @author Armando Benavidez
 * @version .0
 */

/**
 * @author Mando
 *
 */
public class CurrentHandComponent extends JTable{

	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);    
	
	public AspectElementAdder testAdder;
	public JTable theTable;
	
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
	public CurrentHandComponent() {

		
			GameBoardTableModel testModel = new GameBoardTableModel();

			
			testModel.addColumns(7);

			setModel(testModel);
			
			
			theTable = new JTable(testModel);
			
			//theTable.setRowMargin(5);
			setRowHeight(45);
			setTableHeader(null);
			
			PanelCellEditor testEditor = new PanelCellEditor();
			PanelCellRenderer testRenderer = new PanelCellRenderer();
			
			setDefaultEditor(Object.class, (TableCellEditor) testEditor);
			setDefaultRenderer(Object.class, (TableCellRenderer) testRenderer);

		}
		
		public JTable getTable(){
			return this.theTable;
		}
		
		class PanelCellRenderer implements TableCellRenderer{
			
			private AspectElementAdder renderer = new AspectElementAdder();
			
			@Override
			public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
			
				
				
				renderer.setCompInfo((compInfo) value);
				
			//	//if aspect is selected ? if true set selection background else (:) foreground
				renderer.setBackground(isSelected ? Color.CYAN : Color.white);
				renderer.setForeground(isSelected ? Color.black : Color.black);
			//	newAspect.setEnabled(isEnabled());
				renderer.setFont(getFont());
				renderer.setFocusable(false);
				renderer.setBorder(getBorder());
				
				table.setAutoResizeMode(AUTO_RESIZE_SUBSEQUENT_COLUMNS);
				//table.setShowGrid(true);
				//table.setFillsViewportHeight(false);
			Dimension minimumSize = new Dimension(350, 50);
			setMaximumSize(minimumSize);
			setMinimumSize(minimumSize);
		//		setVisibleRowCount(-1);
		//		setLayoutOrientation(HORIZONTAL_WRAP);
			renderer.setBorder(isSelected ? UIManager.getBorder("List.focusCellHighlightBorder") : noFocusBorder);
				
				
				return renderer;
			}
		}
		
		
		
		class PanelCellEditor extends AbstractCellEditor implements TableCellEditor{
			
			private AspectElementAdder editor = new AspectElementAdder();
			
			
			@Override
			public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
					
			  editor.setCompInfo((compInfo) value);
			  return editor;
			}
			
			@Override
			public Object getCellEditorValue() {
				return this.editor.getComp();
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
			
			
			public void addRow(){
				//0, 0, "")
				 super.addRow(new Object[]{new compInfo()});
		    }
			
			

		    public void addColumns(int NumOfColumns) {
		    	
		    	
		    	setColumnCount(NumOfColumns);
		    	Object[] setOfElements = new Object[NumOfColumns];
		    	
		    	for(int i = 0; i<=(NumOfColumns - 1); i++){
		    		//0, 0, ""
		    		setOfElements[i] = new compInfo();	
		    	}
		    	
		    	
		    	super.addRow(setOfElements);
		    }
		    
		    /**
			
			
		    public void addColumns(int NumOfColumns) {
		    	setColumnCount((NumOfColumns - 1));
		    	
		    	super.addColumn(null, new Object[]{new compInfo(0, 0, "")});
		    }
		    */
			
		}
		
		
		
		
		class compInfo{
			
			public int combAspect;
			public int combElem;
			public String textAspectEle;
			//int combAspect, int combElem, String textAspectEle
			public compInfo(){
				//this.combAspect = combAspect;
				//this.combElem = combElem;
				//this.textAspectEle = textAspectEle;
			}
			
		}
		
		
		
		
		
		
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
     
		        
		        buttonAdd.setIcon(new ImageIcon(getClass().getResource("resources/tileTexture.png")));
		        
		        

		        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
		        this.setLayout(layout);
		        layout.setHorizontalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(buttonAdd, 50, 50, 50)
	                    
		        );
		        layout.setVerticalGroup(
		            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)

		            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
		                .addComponent(buttonAdd, 50, 50 , 50)
		                )
		        );
		        
			}
		
			
	        private void enableUpper(boolean enable) {
		          //textboxAspectElementName.setEnabled(enable);
		          //listElementsAdded.setEnabled(enable);
		        }
		        
		   public void setCompInfo(compInfo comp){
			   //this.comboAspect.setSelectedIndex(comp.combAspect);
			   //this.comboElementCategory.setSelectedIndex(comp.combElem);
			   //this.textboxAspectElementName.setText(comp.textAspectEle);
			   //enableUpper(true);
			   
			    
		   }
	        public compInfo getComp() {
	        	return new compInfo();
	        }
		}
		
	}//eof

