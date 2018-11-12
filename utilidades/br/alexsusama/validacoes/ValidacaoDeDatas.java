package br.alexsusama.validacoes;

import java.util.Calendar;

import javax.swing.JOptionPane;

public class ValidacaoDeDatas {

	public static Calendar ordenarData(String data) {
		String dia;
		String mes;
		String ano;

		Calendar dataPadronizada = Calendar.getInstance();
		if (data != null) {

			dia = data.substring(0, 2);
			mes = data.substring(3, 5);
			ano = data.substring(6, 10);

			int year = Integer.parseInt(ano);
			int month = Integer.parseInt(mes);
			int day = Integer.parseInt(dia);

			if (month >= 1 && month <= 12) {
				dataPadronizada.set(Calendar.MONTH, month - 1);
				if (year >= 2000) {
					dataPadronizada.set(Calendar.YEAR, year);
					if (day > 0 && day <= 31) {
						dataPadronizada.set(Calendar.DAY_OF_MONTH, day);
						return dataPadronizada;
					} else {
						JOptionPane.showMessageDialog(null, "Dia inválido");
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ano inválido");
				}
			} else {
				JOptionPane.showMessageDialog(null, "Mês inválido");
			}

		} else {
			System.out.println("data nula");
		}
		return null;

	}

	public static boolean verificarData(String dataInicial, String dataFinal) {
		if(!(dataInicial.equals("  /  /    ")||dataFinal.equals("  /  /    ")))
		if (!(dataInicial.equals("  -  -    ") || dataFinal.equals("  -  -    "))) {
			
			String diaInicial;
			String mesInicial;
			String anoInicial;

			String diaFinal;
			String mesFinal;
			String anoFinal;

			diaInicial = dataInicial.substring(0, 2);
			mesInicial = dataInicial.substring(3, 5);
			anoInicial = dataInicial.substring(6, 10);

			diaFinal = dataFinal.substring(0, 2);
			mesFinal = dataFinal.substring(3, 5);
			anoFinal = dataFinal.substring(6, 10);

			int year = Integer.parseInt(anoInicial) ;
			int month = Integer.parseInt(mesInicial);
			int day = Integer.parseInt(diaInicial);

			int yearEnd = Integer.parseInt(anoFinal); 
			int monthEnd = Integer.parseInt(mesFinal);
			int dayEnd = Integer.parseInt(diaFinal);
			
			
			int somaDataFinal = yearEnd +monthEnd+dayEnd;
			int somaDataInicial = year+month+day;
			
			if ((month >= 1 && month <= 12) && (monthEnd >= 1 && monthEnd <= 12)&&(somaDataFinal>somaDataInicial)) {
				if ((year >= 2000) && (yearEnd >= 2000)) {

					if ((day > 0 && day <= 31) && (dayEnd > 0 && dayEnd <= 31)) {
						System.out.println("data válida: " + diaInicial + "-" + mesInicial + "-" + anoInicial);
						System.out.println("data válida: " + diaFinal + "-" + mesFinal + "-" + anoFinal);
						return true;
					} else {

						JOptionPane.showMessageDialog(null, "Dia inválido");
						return false;
					}
				} else {
					JOptionPane.showMessageDialog(null, "Ano inválido");
					return false;
				}
			} else {
				JOptionPane.showMessageDialog(null, "Data incorreta");
				System.out.println("ou as datas não conferem");
				return false;
			}

		} else {
			System.out.println("data nula");
		}
		return false;

	}

	public static String padronizarDatasParaBusca(String data) {
		String dia;
		String mes;
		String ano;
		
		dia = data.substring(0, 2);
		mes = data.substring(3, 5);
		ano = data.substring(6, 10);
		
		int year = Integer.parseInt(ano) + 1;
		int month = Integer.parseInt(mes);
		int day = Integer.parseInt(dia);
		
		return String.valueOf(year) + "-" + String.valueOf(month) + "-" + String.valueOf(day);
	}

	public static String padronizarDatasNoCampo(String data) {
		String dia;
		String mes;
		String ano;

		dia = data.substring(0, 4);
		mes = data.substring(5, 7);
		ano = data.substring(8, 10);

		return ano + "/" + mes + "/" + dia;
	}

	public static String padronizarDatasCampoAtualizacao(String data) {
		String dia;
		String mes;
		String ano;
		if (data.length() >= 10) {
			System.out.println("data tem 10 digitos");
			ano = data.substring(0, 4);
			mes = data.substring(5, 7);
			dia = data.substring(8, 10);

			return dia + "/" + mes + "/" + ano;
		} else {
			System.out.println("data tem 9 digitos");
			ano = data.substring(0, 4);
			mes = data.substring(5, 6);
			dia = data.substring(7, 9);

			return dia + "/" + mes + "/" + ano;
		}
	}

	public static String padronizarDatas(Calendar data) {
		String dataPadronizada = String.valueOf(data.get(Calendar.YEAR)) + "-"
				+ String.valueOf((data.get(Calendar.MONTH) + 1)) + "-"
				+ String.valueOf(data.get(Calendar.DAY_OF_MONTH));
		return dataPadronizada;
	}
}
