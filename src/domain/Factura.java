package domain;

import java.sql.Timestamp;

public class Factura {
	//ATRIBUTOS
		private int idFactura;
		private Timestamp fechaFactura;
		private int idReserva;
		
		//CONTRUCTORES
		public Factura(){
			super();
		}

		//GETTERS AND SETTERS
		public int getIdFactura() {
			return idFactura;
		}

		public void setIdFactura(int idFactura) {
			this.idFactura = idFactura;
		}

		public Timestamp getFechaFactura() {
			return fechaFactura;
		}

		public void setFechaFactura(Timestamp fechaFactura) {
			this.fechaFactura = fechaFactura;
		}

		public int getIdReserva() {
			return idReserva;
		}

		public void setIdReserva(int idReserva) {
			this.idReserva = idReserva;
		}

		@Override
		public String toString() {
			return "Factura [idFactura=" + idFactura + ", fechaFactura=" + fechaFactura + ", idReserva=" + idReserva + "]";
		}
}
