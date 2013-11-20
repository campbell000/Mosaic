/**
 * 
 * @author Armando Benavidez
 * @version .0
 */

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.AbstractCellEditor;
import javax.swing.DropMode;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.TransferHandler;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

/**
 * @author Mando
 * 
 */
public class CurrentHandComponent extends JTable {

	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

	private String[] currentHand;

	private String setWord = "";

	public HandCellComponent testAdder;

	/**
	 * <code>GameBoardComponent</code> constructor set general attributes to the
	 * class. It sets a customer <code>TransferHandler</code>,
	 * <code>DefaultEditor</code> and <code>DefaultRenderer</code>.
	 * 
	 * <p>
	 * <code></code>
	 * </p>
	 * 
	 */
	public CurrentHandComponent() {

		super();

		setRowHeight(45);
		setTableHeader(null);
		setBorder(javax.swing.BorderFactory.createLineBorder(
				new java.awt.Color(51, 51, 51), 3));

		// setRowSelectionAllowed(false);

		// setSelectionModel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// setSelectionModel(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		setColumnSelectionAllowed(true);
		setDropMode(DropMode.USE_SELECTION);
		setDragEnabled(true);
		setTransferHandler(new MyTransferHandler());
		setCellSelectionEnabled(true);
		setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		setDefaultEditor(Object.class, new PanelCellEditor());
		setDefaultRenderer(Object.class, new PanelCellRenderer());

	}
	/**
	 * Sets the initial GameBoard table model; this is a one time only user when
	 * a game stars
	 * 
	 * <p>
	 * description paragraph
	 * </p>
	 * 
	 * @param
	 * 
	 * @return void
	 */
	public void setInitialBoardModel(ArrayList<Tile> drawTiles) {
		GameBoardTableModel testModel = new GameBoardTableModel();

		this.currentHand = new String[7];

		for (int i = 0; i < drawTiles.size(); i++) {

			currentHand[i] = drawTiles.get(i).toString();
		}

		// String[] columnIdentifiers = new String[15];
		testModel.addColumns(7);
		testModel.addRow(currentHand);

		// testModel.setDataVector(dataVector, columnIdentifiers);
		setModel(testModel);
		addColumnSelectionInterval(0, 6);

	}

	/**
	 * description sentence <code></code>
	 * 
	 * <p>
	 * description paragraph
	 * </p>
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public int getEnabledHandTiles() {
		// TODO Auto-generated method stub
		return 0;
	}

	public JTable getTable() {
		return this;
	}

	public String getPlacedWord() {
		return setWord;
	}

	@SuppressWarnings("serial")
	class MyTransferHandler extends TransferHandler {

		HandCellComponent temp;

		public MyTransferHandler() {
		}

		@Override
		public int getSourceActions(JComponent comp) {
			// temp = (HandCellComponent) comp;
			return MOVE;
		}

		@Override
		protected Transferable createTransferable(JComponent source) {

			setWord += (String) ((JTable) source).getModel().getValueAt(
					((JTable) source).getSelectedRow(),
					((JTable) source).getSelectedColumn());

			System.out.println(setWord);

			return new StringSelection((String) ((JTable) source).getModel()
					.getValueAt(((JTable) source).getSelectedRow(),
							((JTable) source).getSelectedColumn()));
		}

		@Override
		protected void exportDone(JComponent source, Transferable data,
				int action) {

			((JTable) source).getModel().setValueAt(" ",
					((JTable) source).getSelectedRow(),
					((JTable) source).getSelectedColumn());

			// temp.setTileVal(" ");

		}

		@Override
		public boolean canImport(TransferSupport support) {
			return true;
		}

		@Override
		public boolean importData(TransferSupport support) {
			JTable jt = (JTable) support.getComponent();
			try {
				jt.setValueAt(
						support.getTransferable().getTransferData(
								DataFlavor.stringFlavor), jt.getSelectedRow(),
						jt.getSelectedColumn());
			} catch (UnsupportedFlavorException ex) {
				Logger.getLogger(MyTransferHandler.class.getName()).log(
						Level.SEVERE, null, ex);
			} catch (IOException ex) {
				Logger.getLogger(MyTransferHandler.class.getName()).log(
						Level.SEVERE, null, ex);
			}
			return super.importData(support);
		}

	}

	class PanelCellRenderer implements TableCellRenderer {

		private final HandCellComponent renderer = new HandCellComponent();

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			renderer.setTileVal(currentHand[column].toString());

			// renderer.setCompInfo((compInfo) value);

			// //if aspect is selected ? if true set selection background else
			// (:) foreground

			renderer.fieldTile.setBackground(isSelected ? Color.getHSBColor(10,
					10, 10) : Color.getHSBColor(10, 10, 10));

			// renderer.setBackground(isSelected ? Color.black : Color.black);
			// renderer.setForeground(isSelected ? Color.black : Color.black);
			// newAspect.setEnabled(isEnabled());

			// renderer.setEnabled(false);
			renderer.fieldTile.setEnabled(false);
			renderer.fieldTile.setFocusable(false);
			renderer.setFocusable(false);
			renderer.setBorder(getBorder());

			table.setAutoResizeMode(AUTO_RESIZE_SUBSEQUENT_COLUMNS);
			table.setShowGrid(true);
			// table.setFillsViewportHeight(false);
			Dimension minimumSize = new Dimension(750, 675);
			setMaximumSize(minimumSize);
			setMinimumSize(minimumSize);
			// setVisibleRowCount(-1);
			// setLayoutOrientation(HORIZONTAL_WRAP);
			// renderer.aspect.setBorder(isSelected ?
			// UIManager.getBorder("List.focusCellHighlightBorder") :
			// noFocusBorder);

			return renderer;
		}
	}

	class PanelCellEditor extends AbstractCellEditor implements TableCellEditor {

		private final HandCellComponent editor = new HandCellComponent();

		@Override
		public Component getTableCellEditorComponent(JTable table,
				Object value, boolean isSelected, int row, int column) {

			// System.out.println("yo" + value.toString());
			editor.setTileVal((String) value);
			return editor;
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
			return true;
		}
	}

	class GameBoardTableModel extends DefaultTableModel {

		// @Override
		// public int getColumnCount() {
		// return 1;
		// }

		/**
		 * public void addRow(){
		 * 
		 * super.addRow(new Object[]{new compInfo("")}); }
		 * 
		 * 
		 * public String getValueAt(int row, int column){
		 * 
		 * //Component test = getComponentAt(row, column);
		 * 
		 * 
		 * 
		 * //System.out.println(row + "   " + column);
		 * 
		 * return "c";
		 * 
		 * }
		 **/
		/**
		 * public void setDataVector(String[][] dataVector, String[]
		 * columnIdentifier){
		 * 
		 * 
		 * }
		 */
		public void addRows(int NumOfRows) {

			// setRowCount(NumOfRows);

			String[] setOfElements = new String[getColumnCount()];

			// System.out.println(getColumnCount());

			for (int i = 0; i <= (getColumnCount() - 1); i++) {
				setOfElements[i] = ("k");
			}

			for (int i = 0; i <= (NumOfRows - 1); i++) {
				addRow(setOfElements);
			}
		}

		public void addColumns(int NumOfColumns) {

			// System.out.println(NumOfColumns);

			// setColumnCount(NumOfColumns);

			// Object[] setOfElements = new Object[NumOfColumns];

			for (int i = 0; i <= (NumOfColumns - 1); i++) {
				addColumn(null);
			}

			// super.addRow(setOfElements);
		}

		/**
		 * public void addColumns(int NumOfColumns) {
		 * setColumnCount((NumOfColumns - 1));
		 * 
		 * super.addColumn(null, new Object[]{new compInfo(0, 0, "")}); }
		 */

	}

	/**
	 * *******Generic Description*******************
	 * 
	 * @param Generic
	 *            comment
	 * @param Generic
	 *            Comment
	 * @return Generic Comment
	 */
	private class HandCellComponent extends JPanel {
		// Variables declaration - do not modify
		JTextField fieldTile;

		// End of variables declaration

		/**
		 * *******Generic Description*******************
		 * 
		 * @param Generic
		 *            comment
		 * @param Generic
		 *            Comment
		 * @return Generic Comment
		 */
		public HandCellComponent() {

			/**
			 * URL url = getClass().getResource("resources/tileTexture.png");
			 * String text = "<html>
			 * <table border='0' width='50' height='50' cellpadding='0' cellspacing='1' background='" + url.toExternalForm() + "'>
			 * <tr>
			 * <td width='50' height='50' align='left' >&nbsp&nbsp&nbsp&nbsp g
			 * &nbsp&nbsp&nbsp&nbsp</td>
			 * </tr>
			 * </table>
			 * </html>";
			 **/

			fieldTile = new JTextField();
			fieldTile.setEditable(false);
			fieldTile.setDisabledTextColor(Color.BLACK);
			fieldTile.setFont(new Font("Aharoni", 0, 22));
			// setFocusable(true);
			fieldTile.setHorizontalAlignment(JTextField.CENTER);

			setDragEnabled(true);
			// setBackground(new Color(200, 200, 200));

			// buttonAdd.setText();
			// buttonAdd.setIcon(new
			// ImageIcon(getClass().getResource("resources/tileTexture.png")));

			javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
			this.setLayout(layout);
			layout.setHorizontalGroup(layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING).addComponent(
					fieldTile, 50, 50, 50));
			layout.setVerticalGroup(layout.createParallelGroup(
					javax.swing.GroupLayout.Alignment.LEADING)

			.addGroup(
					javax.swing.GroupLayout.Alignment.TRAILING,
					layout.createSequentialGroup().addComponent(fieldTile, 45,
							45, 45)));

		}

		/**
		 * description sentence <code></code>
		 * 
		 * <p>
		 * description paragraph
		 * </p>
		 * 
		 * @param
		 * @param
		 * @return
		 */
		public String getTileVal() {
			return fieldTile.getText();
		}

		private void enableUpper(boolean enable) {
			fieldTile.setEnabled(enable);
			fieldTile.setVisible(true);
		}

		public void setTileVal(String tileLetter) {
			this.fieldTile.setText(tileLetter);
			enableUpper(true);
		}

		public String getComp() {
			return this.fieldTile.getText();
		}
	}

	/**
	 * description sentence <code></code>
	 * 
	 * <p>
	 * description paragraph
	 * </p>
	 * 
	 * @param
	 * @param
	 * @return
	 */
	public String getSetWord() {
		// TODO Auto-generated method stub
		return null;
	}

}// eof
