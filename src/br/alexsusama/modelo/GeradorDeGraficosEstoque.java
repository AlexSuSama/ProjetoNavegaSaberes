package br.alexsusama.modelo;

import java.io.IOException;
import java.io.OutputStream;
//import java.sql.SQLException;

import javax.swing.JOptionPane;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
//import org.jfree.chart.LegendItem;
//import org.jfree.chart.LegendItemCollection;
//import org.jfree.chart.block.BlockBorder;
//import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
//import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
//import org.jfree.ui.RectangleEdge;
//import org.jfree.ui.RectangleInsets;

public class GeradorDeGraficosEstoque {
	JFreeChart graficoDeBarras;

	public JFreeChart graficoOstraEmEstoque(Estoque estoque, String titulo, String labelBottom, String labelLeft) {
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();

		try {

			dataset.addValue(estoque.getOstraSemente(), "Semente", estoque.getDataEstoque());
			dataset.addValue(estoque.getOstraJuvenil(), "juvenil", estoque.getDataEstoque());
			dataset.addValue(estoque.getOstraBaby(), "baby", estoque.getDataEstoque());
			dataset.addValue(estoque.getOstraMedia(), "Média", estoque.getDataEstoque());
			dataset.addValue(estoque.getOstraMaster(), "master", estoque.getDataEstoque());

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "deu pau no grafico");
		}

		graficoDeBarras = ChartFactory.createBarChart(titulo, labelBottom, labelLeft, dataset, PlotOrientation.VERTICAL,
				true, true, false);

		return graficoDeBarras;

	}

	public JFreeChart gerarGraficoDePizzaEstoqueComercializacao(Estoque estoque, String titulo, String labelBottom,
			String labelLeft) {
		DefaultPieDataset pieData = new DefaultPieDataset();

		pieData.setValue("Baby", estoque.getOstraBaby());
		pieData.setValue("Média", estoque.getOstraMedia());
		pieData.setValue("Master", estoque.getOstraMaster());

		// pieData.setValue(comercializacao.getLocalidade(),
		// comercializacao.getQtVendidas());

		return graficoDeBarras = ChartFactory.createPieChart3D("Ostras em fase de comercialização", pieData, true, true,
				false);
	}

	public JFreeChart gerarGraficoDePizzaEstoqueApetrechos(Estoque estoque, String titulo, String labelBottom,
			String labelLeft) {
		DefaultPieDataset pieData = new DefaultPieDataset();

		pieData.setValue("Malha 6/9", estoque.getMalha69());
		pieData.setValue("Malha 12", estoque.getMalha12());
		pieData.setValue("Malha 14", estoque.getMalha14());
		pieData.setValue("Malha 21", estoque.getMalha21());
		pieData.setValue("Mesa de madeira", estoque.getMesaMadeira());
		pieData.setValue("Mesa telada", estoque.getMesaTelada());
		pieData.setValue("Mesa de PVC", estoque.getMesaPVC());
		pieData.setValue("Varal", estoque.getOstraMaster());
		pieData.setValue("Longline", estoque.getOstraMaster());
		pieData.setValue("Lanterna", estoque.getOstraMaster());

		// pieData.setValue(comercializacao.getLocalidade(),
		// comercializacao.getQtVendidas());

		return graficoDeBarras = ChartFactory.createPieChart3D("Apetrechos em estoque", pieData, true, true, false);
	}

	public void salvarGrafico(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graficoDeBarras, 700, 270);
	}

	// salvarem uma versão reduzida
	public void salvarGraficoReduzido(OutputStream out) throws IOException {
		ChartUtilities.writeChartAsPNG(out, graficoDeBarras, 400, 270);
	}
	// grafico da media de um periodo
}
