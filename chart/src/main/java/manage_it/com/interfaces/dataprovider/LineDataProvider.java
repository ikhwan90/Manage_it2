package manage_it.com.interfaces.dataprovider;

import manage_it.com.components.YAxis;
import manage_it.com.data.LineData;

public interface LineDataProvider extends manage_it.com.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider {

    LineData getLineData();

    YAxis getAxis(YAxis.AxisDependency dependency);
}
