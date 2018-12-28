package org.wulfnoth.gadus.ui.custom;

/**
 * Created on 2018/12/28.
 */
public class RatioPane extends ConstrainedGridPane {

	public RatioPane(int... ratios) {
		int sum = 0;
		for (int ratio: ratios) {
			sum += ratio;
		}
		if (sum != 100) {
			throw new RuntimeException("比例错误");
		}
		super.fixRowSizes(5, 100);
		super.fixColumnSizes(5, ratios);
	}
}
