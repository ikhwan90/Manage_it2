package manage_it.com.interfaces.dataprovider;

import manage_it.com.data.CombinedData;

/**
 * Created by philipp on 11/06/16.
 */
public interface CombinedDataProvider extends LineDataProvider, manage_it.com.interfaces.dataprovider.BarDataProvider, manage_it.com.interfaces.dataprovider.BubbleDataProvider, manage_it.com.interfaces.dataprovider.CandleDataProvider, ScatterDataProvider {

    CombinedData getCombinedData();
}
