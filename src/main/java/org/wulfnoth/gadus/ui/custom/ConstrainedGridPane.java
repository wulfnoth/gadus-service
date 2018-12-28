package org.wulfnoth.gadus.ui.custom;

import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;

/**
 * Created on 2018/12/28.
 */
public class ConstrainedGridPane extends GridPane {


	/**
	 * fix the columnSizes to the given column Width
	 * @param colWidths
	 */
	public void fixColumnSizes(int hGap,int... colWidths) {
		this.setHgap(hGap);
		// Setting columns size in percent
		for (int colWidth : colWidths) {
			ColumnConstraints column = new ColumnConstraints();
			column.setPercentWidth(colWidth);
			getColumnConstraints().add(column);
		}
	}

	/**
	 * fix the rowSizes to the given rowHeights
	 * @param rowHeight
	 */
	public void fixRowSizes(int vGap,int... rowHeight) {
		this.setVgap(vGap);
		for (int rowWidth : rowHeight) {
			RowConstraints rowc = new RowConstraints();
			rowc.setPercentHeight(rowWidth);
			getRowConstraints().add(rowc);
		}

		// grid.setPrefSize(WINDOW_WIDTH, WINDOW_HEIGHT); // Default width and
		// height
		this.setMaxSize(Region.USE_COMPUTED_SIZE, Region.USE_COMPUTED_SIZE);
	}
}
