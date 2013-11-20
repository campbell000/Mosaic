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
public class GameBoardComponent extends JTable {

	protected static Border noFocusBorder = new EmptyBorder(1, 1, 1, 1);

	private final Board gameBoard = new Board();

	public TableCellComponent testAdder;

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
	public GameBoardComponent() {

		super();

		setRowHeight(45);
		setTableHeader(null);
		setBorder(javax.swing.BorderFactory.createLineBorder(
				new java.awt.Color(51, 51, 51), 3));

		setDropMode(DropMode.USE_SELECTION);
		setDragEnabled(true);
		setTransferHandler(new MyTransferHandler());

		setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		setDefaultEditor(Object.class, new PanelCellEditor());
		setDefaultRenderer(Object.class, new PanelCellRenderer());

		setInitialBoardModel();

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
	public void setInitialBoardModel() {
		GameBoardTableModel testModel = new GameBoardTableModel();

		// testModel.setColumnCount(15);
		// testModel.addRows(15);

		String[][] dataVector = new String[15][15];

		dataVector[0][0] = "3W";
		dataVector[0][7] = "3W";
		dataVector[0][14] = "3W";

		dataVector[7][0] = "3W";
		dataVector[7][14] = "3W";

		dataVector[14][0] = "3W";
		dataVector[14][7] = "3W";
		dataVector[14][14] = "3W";

		// Place Double Word Spaces
		dataVector[1][1] = "2W";
		dataVector[2][2] = "2W";
		dataVector[3][3] = "2W";
		dataVector[4][4] = "2W";

		dataVector[4][10] = "2W";
		dataVector[3][11] = "2W";
		dataVector[2][12] = "2W";
		dataVector[1][13] = "2W";

		dataVector[13][1] = "2W";
		dataVector[12][2] = "2W";
		dataVector[11][3] = "2W";
		dataVector[10][4] = "2W";

		dataVector[13][13] = "2W";
		dataVector[12][12] = "2W";
		dataVector[11][11] = "2W";
		dataVector[10][10] = "2W";

		// Triple Letter
		dataVector[1][5] = "3L";
		dataVector[1][9] = "3L";

		dataVector[5][1] = "3L";
		dataVector[5][5] = "3L";
		dataVector[5][9] = "3L";
		dataVector[5][14] = "3L";

		dataVector[9][1] = "3L";
		dataVector[9][5] = "3L";
		dataVector[9][9] = "3L";
		dataVector[9][14] = "3L";

		dataVector[14][5] = "3L";
		dataVector[14][9] = "3L";

		// Double Letter
		dataVector[0][3] = "2L";
		dataVector[0][11] = "2L";

		dataVector[2][6] = "2L";
		dataVector[2][8] = "2L";

		dataVector[3][0] = "2L";
		dataVector[3][7] = "2L";
		dataVector[3][14] = "2L";

		dataVector[6][2] = "2L";
		dataVector[6][6] = "2L";
		dataVector[6][8] = "2L";
		dataVector[6][12] = "2L";

		dataVector[7][3] = "2L";
		dataVector[7][11] = "2L";

		dataVector[8][2] = "2L";
		dataVector[8][6] = "2L";
		dataVector[8][8] = "2L";
		dataVector[8][12] = "2L";

		dataVector[11][0] = "2L";
		dataVector[11][7] = "2L";
		dataVector[11][14] = "2L";

		dataVector[12][6] = "2L";
		dataVector[12][8] = "2L";

		dataVector[14][3] = "2L";
		dataVector[14][11] = "2L";

		String[] columnIdentifiers = new String[15];

		testModel.setDataVector(dataVector, columnIdentifiers);
		setModel(testModel);

	}

	public JTable getTable() {
		return this;
	}

	@SuppressWarnings("serial")
	class MyTransferHandler extends TransferHandler {

		public MyTransferHandler() {
		}

		@Override
		public int getSourceActions(JComponent comp) {
			return MOVE;
		}

		@Override
		protected Transferable createTransferable(JComponent source) {

			return new StringSelection((String) ((JTable) source).getModel()
					.getValueAt(((JTable) source).getSelectedRow(),
							((JTable) source).getSelectedColumn()));
		}

		@Override
		protected void exportDone(JComponent source, Transferable data,
				int action) {

			((JTable) source)
					.getModel()
					.setValueAt(
							gameBoard.gameBoard[((JTable) source)
									.getSelectedRow()][((JTable) source)
									.getSelectedColumn()].toString(),
							((JTable) source).getSelectedRow(),
							((JTable) source).getSelectedColumn());

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

		private final TableCellComponent renderer = new TableCellComponent();

		@Override
		public Component getTableCellRendererComponent(JTable table,
				Object value, boolean isSelected, boolean hasFocus, int row,
				int column) {

			renderer.setTileVal(gameBoard.gameBoard[row][column].toString());

			// renderer.setCompInfo((compInfo) value);

			// //if aspect is selected ? if true set selection background else
			// (:) foreground

			if (value != null) {
				switch ((String) value) {
					case "3W" :
						renderer.fieldTile.setBackground(hasFocus ? Color
								.getHSBColor(205, 81, 85) : Color.CYAN);
						break;
					case "2W" :
						renderer.fieldTile.setBackground(isSelected
								? Color.MAGENTA
								: Color.MAGENTA);
						break;
					case "3L" :
						renderer.fieldTile.setBackground(isSelected
								? Color.ORANGE
								: Color.ORANGE);
						break;
					case "2L" :
						renderer.fieldTile.setBackground(isSelected
								? Color.YELLOW
								: Color.YELLOW);
						break;
					default :
						renderer.fieldTile.setBackground(isSelected
								? Color.white
								: Color.white);
						break;
				}
			} else {
				renderer.fieldTile.setBackground(isSelected
						? Color.white
						: Color.white);
			}

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

		private final TableCellComponent editor = new TableCellComponent();

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
	 * class compInfo{
	 * 
	 * public String tileLetter;
	 * 
	 * public compInfo(String tileLetter){ this.tileLetter = tileLetter; }
	 * 
	 * }
	 */

	/**
	 * *******Generic Description*******************
	 * 
	 * @param Generic
	 *            comment
	 * @param Generic
	 *            Comment
	 * @return Generic Comment
	 */
	private class TableCellComponent extends JPanel {
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
		public TableCellComponent() {

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

}// eof
