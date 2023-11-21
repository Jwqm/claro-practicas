package com.example.javaapp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.example.javaapp.cellulars.CellularClient;
import com.example.javaapp.cellulars.CellularRecharges;
import com.example.javaapp.recharges.Recharge;
import com.example.javaapp.utils.ClientRechargesAllTime;

public class Application {

	public static void main(String[] args) {
		// Lista con todas las recargas realizadas por diferentes lineas
		List<CellularRecharges> cellularRechargesList = new ArrayList<>();

		// Creamos una nueva linea
		CellularClient cellular1 = new CellularClient("1", "test", "test", 123456);
		cellular1.setCellularNumber("123");
		cellular1.setBillNumber("123");

		// Le hacemos una recarga
		Recharge recharge = Recharge.builder()
				.reason("REVPDC")
				.amount(100f)
				.cardId("VTC100")
				.channel("PDC")
				.date(LocalDateTime.now())
				.build();

		// Asociamos una recarga a la linea por su client id
		CellularRecharges cellularRecharges1 = CellularRecharges.builder()
				.clientId(cellular1.getId())
				.recharges(Arrays.asList(recharge))
				.build();

		cellularRechargesList.add(cellularRecharges1);

		// Creamos una nueva linea 2
		CellularClient cellular2 = CellularClient.builder()
				.id("2")
				.billNumber("456")
				.cellularNumber("322")
				.firstName("asds")
				.build();

		// Le hacemos una recarga
		Recharge recharge2 = Recharge.builder()
				.reason("REVPDC")
				.amount(200f)
				.cardId("VTC200")
				.channel("PDC")
				.date(LocalDateTime.now())
				.build();

		// Asociamos una recarga a la linea por su client id
		CellularRecharges cellularRecharges2 = CellularRecharges.builder()
				.clientId(cellular2.getId())
				.recharges(Arrays.asList(recharge, recharge2))
				.build();

		cellularRechargesList.add(cellularRecharges2);

		System.out.println("Recargas realizadas hasta el momento: ");
		cellularRechargesList.forEach(x -> System.out.println(x.toString()));

		// Calculo de las recargas del cliente en el dia de hoy
		ClientRechargesAllTime rechargesAllTime = new ClientRechargesAllTime();
		// Busco el client con id 1
		CellularRecharges cellularRechargeClientId = cellularRechargesList.stream().filter(
				item -> item.getClientId().equalsIgnoreCase("1"))
				.findFirst().get();

		// Actualizo cantidad
		long countRechargesAllTime = rechargesAllTime.countRecharges(cellularRechargeClientId.getRecharges());
		cellularRechargeClientId.setCount(countRechargesAllTime);

		// Objetos cellularRecharges y cellularRechargeClientId1 son iguales apuntan a
		// la misma referencia de memoria.
		System.out.println("Comparo objetos con clientId " + cellularRechargeClientId.getClientId());
		System.out.println(
				cellularRechargeClientId.getClientId().equalsIgnoreCase("1") ? cellularRecharges1 : cellularRecharges2);
		System.out.println(cellularRechargeClientId);
	}

}
