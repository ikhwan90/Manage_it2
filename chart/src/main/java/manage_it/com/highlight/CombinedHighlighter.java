package manage_it.com.highlight;

import manage_it.com.data.BarData;
import manage_it.com.data.BarLineScatterCandleBubbleData;
import manage_it.com.data.ChartData;
import manage_it.com.data.DataSet;
import manage_it.com.interfaces.dataprovider.BarDataProvider;
import manage_it.com.interfaces.dataprovider.CombinedDataProvider;
import manage_it.com.interfaces.datasets.IDataSet;

import java.util.List;

/**
 * Created by Philipp Jahoda on 12/09/15.
 */
public class CombinedHighlighter extends ChartHighlighter<CombinedDataProvider> implements manage_it.com.highlight.IHighlighter
{

    /**
     * bar highlighter for supporting stacked highlighting
     */
    protected BarHighlighter barHighlighter;

    public CombinedHighlighter(CombinedDataProvider chart, BarDataProvider barChart) {
        super(chart);

        // if there is BarData, create a BarHighlighter
        barHighlighter = barChart.getBarData() == null ? null : new BarHighlighter(barChart);
    }

    @Override
    protected List<manage_it.com.highlight.Highlight> getHighlightsAtXValue(float xVal, float x, float y) {

        mHighlightBuffer.clear();

        List<BarLineScatterCandleBubbleData> dataObjects = mChart.getCombinedData().getAllData();

        for (int i = 0; i < dataObjects.size(); i++) {

            ChartData dataObject = dataObjects.get(i);

            // in case of BarData, let the BarHighlighter take over
            if (barHighlighter != null && dataObject instanceof BarData) {
                manage_it.com.highlight.Highlight high = barHighlighter.getHighlight(x, y);

                if (high != null) {
                    high.setDataIndex(i);
                    mHighlightBuffer.add(high);
                }
            } else {

                for (int j = 0, dataSetCount = dataObject.getDataSetCount(); j < dataSetCount; j++) {

                    IDataSet dataSet = dataObjects.get(i).getDataSetByIndex(j);

                    // don't include datasets that cannot be highlighted
                    if (!dataSet.isHighlightEnabled())
                        continue;

                    List<manage_it.com.highlight.Highlight> highs = buildHighlights(dataSet, j, xVal, DataSet.Rounding.CLOSEST);
                    for (manage_it.com.highlight.Highlight high : highs)
                    {
                        high.setDataIndex(i);
                        mHighlightBuffer.add(high);
                    }
                }
            }
        }

        return mHighlightBuffer;
    }

//    protected Highlight getClosest(float x, float y, Highlight... highs) {
//
//        Highlight closest = null;
//        float minDistance = Float.MAX_VALUE;
//
//        for (Highlight high : highs) {
//
//            if (high == null)
//                continue;
//
//            float tempDistance = getDistance(x, y, high.getXPx(), high.getYPx());
//
//            if (tempDistance < minDistance) {
//                minDistance = tempDistance;
//                closest = high;
//            }
//        }
//
//        return closest;
//    }
}
