package manage_it.com.interfaces.dataprovider;

import manage_it.com.data.CandleData;

public interface CandleDataProvider extends manage_it.com.interfaces.dataprovider.BarLineScatterCandleBubbleDataProvider {

    CandleData getCandleData();
}
