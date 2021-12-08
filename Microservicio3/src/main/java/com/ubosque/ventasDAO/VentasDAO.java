package com.ubosque.ventasDAO;

import java.util.ArrayList;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.ubosque.ventasDTO.DetalleVenta;
import com.ubosque.ventasDTO.Ventas;

public class VentasDAO {

	MongoClient mongoClient;
	MongoDatabase database;
	MongoCollection<Document> ventas;
	static MongoCollection<Document> codigo_venta;
	ConnectionString connectionString;
	MongoClientSettings settings;

	public VentasDAO() {
		try {
			connectionString = new ConnectionString(
					"mongodb+srv://admin:admin@cluster0.ykb33.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
			settings = MongoClientSettings.builder().applyConnectionString(connectionString).build();
			mongoClient = MongoClients.create(settings);
			database = mongoClient.getDatabase("db_ventas");

			ventas = database.getCollection("ventas");
			codigo_venta = database.getCollection("consecutivo");
			System.out.println("Conexión exitosa");

		} catch (Exception e) {
			e.getMessage();
		}
	}

	public void cerrar() {
		try {
			mongoClient.close();
			System.out.println("Conexión cerrada");
		} catch (Exception e) {
			e.getMessage();
		}
	}

	public boolean crear(Ventas venta) {

		try {
			Document documento = new Document("_id", new ObjectId());

			documento.append("cedulaCliente", venta.getCedulaCliente());
			documento.append("cedulaUsuario", venta.getCedulaUsuario());
			documento.append("valor_venta", venta.getValor_venta());
			documento.append("ivaVenta", venta.getIvaVenta());
			documento.append("total_venta", venta.getTotal_venta());
			documento.append("ciudad", venta.getCiudad());

			ArrayList<Document> detalles = new ArrayList<Document>();

			for (DetalleVenta ventas : venta.getDetalleVentas()) {
				Document detalle = new Document("_id", new ObjectId());
				detalle.append("codigo_producto", ventas.getCodigoProducto());
				detalle.append("cantidad_producto", ventas.getCantidadProducto());
				detalle.append("valor_total", ventas.getValorTotal());
				detalle.append("valor_venta", ventas.getValorVenta());
				detalle.append("valor_iva", ventas.getValorIva());

				detalles.add(detalle);
			}
			documento.append("detalleVentas", detalles);

			ArrayList<Document> contador = ventas.find().into(new ArrayList<>());
			documento.append("codigo_venta", contador.size() + 1);
			ventas.insertOne(documento);

			this.cerrar();
			System.out.println("Venta registrada.");

		} catch (Exception e) {
			e.getMessage();
			System.out.println("NO se pudo registrar la venta.");
			return false;
		}
		return true;
	}

	public int traerCodigo() {
		try {
			ArrayList<Document> docVentas = ventas.find().into(new ArrayList<>());
			System.out.println(docVentas.size());

			System.out.print("Listando Usuarios");
			this.cerrar();
			return docVentas.size();

		} catch (Exception e) {
			e.getMessage();
			this.cerrar();
		}
		return 0;
	}
}
