package be.decocks.xygrafiek;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;


public class XYChart extends ApplicationFrame {

    public static void main(final String[] args) {

        final XYChart demo = new XYChart("XY grafiek");
        demo.pack();
        RefineryUtilities.centerFrameOnScreen(demo);
        demo.setVisible(true);

    }

    //Maak een scherm met assen
    public XYChart(final String title) {

        super(title);
        JFreeChart chart = createChart(createDataset());    //data invullen
             // add the chart to a panel...
        final ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500, 500)); //grootte van scherm
        setContentPane(chartPanel);

    }

    //Grafiekbenoeming
    private JFreeChart createChart(XYSeriesCollection dataset) {

        JFreeChart chart = ChartFactory.createXYLineChart("Titel", "xAsLabel", "yAsLabel", dataset, PlotOrientation.VERTICAL, true, true, true);

        chart.getXYPlot().addAnnotation(new XYPointerAnnotation("label", 2, 2, 90));

        chart.getXYPlot().setRenderer(new XYLineAndShapeRenderer());

        return chart;
    }


    //dataset
    private XYSeriesCollection createDataset() {
        XYSeriesCollection collection = new XYSeriesCollection();

        XYSeries s1 = new XYSeries("grafiek 1");
        s1.add(-1, 5);
        s1.add(2, 9);
        s1.add(3, 3);
        s1.add(4, 8);
        collection.addSeries(s1);

        XYSeries s2 = new XYSeries("grafiek 2");
        s2.add(1, 9);
        s2.add(2, 3);
        s2.add(3, 8);
        s2.add(4, 5);
        collection.addSeries(s2);

        XYSeries s3 = new XYSeries("grafiek 3");
        for (double i =0; i<4; i += 0.1) {
            s3.add(i, Math.sin(i));
        }
        collection.addSeries(s3);

        return collection;
  }
}
