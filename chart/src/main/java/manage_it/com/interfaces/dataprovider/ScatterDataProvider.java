package manage_it.com.interfaces.dataprovider;

import manage_it.com.data.ScatterData;

public interface ScatterDataProvider extends manage_it.com.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider {

    ScatterData getScatterData();
}
