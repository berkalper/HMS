import javax.swing.JPanel;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

// this is the class that extends jfree to drawStaff/Customer ratio pie chart
class PieChart_AWT extends ApplicationFrame {

    public PieChart_AWT(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    private  PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Staff", Staff.counter);
        dataset.setValue("Customer", Customer.custCOUNTER);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Staff/Customer",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);

        return chart;
    }

    public  JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
}
// this is the class that extends jfree to draw Empty/Reserved room ratio pie chart
class PieChart_AWT2 extends ApplicationFrame {
    public PieChart_AWT2(String title) {
        super(title);
        setContentPane(createDemoPanel());
    }

    private  PieDataset createDataset() {
        DefaultPieDataset dataset = new DefaultPieDataset();
        dataset.setValue("Reserved", Main.roomCounter);
        dataset.setValue("Empty", Main.emptyRoomCounter);
        return dataset;
    }

    private static JFreeChart createChart(PieDataset dataset) {
        JFreeChart chart = ChartFactory.createPieChart(
                "Reserved/Empty",   // chart title
                dataset,          // data
                true,             // include legend
                true,
                false);

        return chart;
    }

    public  JPanel createDemoPanel() {
        JFreeChart chart = createChart(createDataset());
        return new ChartPanel(chart);
    }
}
// this is the class that extends jfree to draw room type to cost line graph

class LineChart_AWT3 extends ApplicationFrame {

    public LineChart_AWT3( String applicationTitle , String chartTitle ) {
        super(applicationTitle);
        JFreeChart lineChart = ChartFactory.createLineChart(
                chartTitle,
                "Room Types","Cost",
                createDataset(),
                PlotOrientation.VERTICAL,
                true,true,false);

        ChartPanel chartPanel = new ChartPanel( lineChart );
        chartPanel.setPreferredSize( new java.awt.Dimension( 560 , 367 ) );
        setContentPane( chartPanel );
    }

    private DefaultCategoryDataset createDataset( ) {
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        dataset.addValue( 200 , "Room Types" , "Type 1 Room" );
        dataset.addValue( 300 , "Room Types" , "Type 2 Room" );
        dataset.addValue( 500 , "Room Types" ,  "Type 3 Room" );
        return dataset;
    }
}
