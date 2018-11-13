package manage_it.com.interfaces.dataprovider;

import manage_it.com.components.YAxis.AxisDependency;
import manage_it.com.data.BarLineScatterCandleBubbleData;
import manage_it.com.utils.Transformer;

public interface BarLineScatterCandleBubbleDataProvider extends ChartInterface {

    Transformer getTransformer(AxisDependency axis);
    boolean isInverted(AxisDependency axis);
    
    float getLowestVisibleX();
    float getHighestVisibleX();

    BarLineScatterCandleBubbleData getData();
}
