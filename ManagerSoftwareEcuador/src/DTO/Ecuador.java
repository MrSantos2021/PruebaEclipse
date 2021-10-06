package DTO;


public class Ecuador {
	private String[] region = {"Costa", "Sierra", "Oriente", "Insular"};
	
	private String[] provinciaCosta = {"Esmeraldas", "Santo Domingo de los Ts�chilas", "Manab�", "Los R�os", "Guayas", "Santa Elena", "El Oro"};
	private String[] provinciaSierra = {"Carchi", "Imbabura", "Pichincha", "Cotopaxi", "Bol�var", "Tungurahua", "Chimborazo", "Ca�ar","Azuay", "Loja"};
	private String[] provinciaOriente = {"Sucumb�os", "Napo", "Orellana", "Pastaza", "Morona Santiago", "Zamora Chinchipe"};
	private String[] provinciaInsular = {"Gal�pagos"};
	public String[][] cantones = {{"Atacames", "Eloy Alfaro", "Esmeraldas", "Muisne", "Quinind�", "Rioverde", "San Lorenzo"},
									{"La Concordia", "Santo Domingo"},
									{"Portoviejo", "24 de Mayo", "Bol�var", "Chone", "El Carmen", "Flavio Alfaro", "Jama","Jaramij�", "Jipijapa", "Jun�n","Manta", "Montecristi", "Olmedo", "Paj�n", "Pedernales", "Pichincha", "Puerto L�pez", "Rocafuerte", "San Vicente", "Santa Ana", "Sucre", "Tosagua"},
									{"Babahoyo","Baba","San Jacinto de Buena F�","Mocache","Montalvo","Palenque","Puebloviejo", "Quevedo","Quinsaloma","Urdaneta","Valencia", "Ventanas", "Vinces"},
									{"Guayaquil", "Alfredo Baquerizo Moreno", "Balao", "Balzar", "Colimes", "Daule", "Dur�n", "El Empalme", "El Triunfo", "General Antonio Elizalde", "Isidro Ayora", "Lomas de Sargentillo", "Marcelino Maridue�a", "Milagro", "Naranjal", "Naranjito", "Nobol", "Palestina","Pedro Carbo", "Playas", "Salitre", "Samborond�n","Santa Luc�a","Sim�n  Bolivar", "Yaguachi"},
									{"Santa Elena","La Libertad","Salinas"},
									{"Machala", "Arenillas", "Atahualpa", "Balsas", "Chilla", "El Guabo", "Huaquillas", "Las Lajas", "Marcabel�", "Pasaje", "Pi�as", "Portovelo", "Santa Rosa", "Zaruma"},
									{"Tulc�n","Bolivar","Espejo","Mira","Mont�far","San Pedro de Huaca"},
									{"Ibarra", "Antonio Ante", "Cotacahi", "Otavalo", "Pimampiro","San Miguel de Urcuqu�"},
									{"Cayambe", "Mej�a", "Pedro Moncayo","Pedro Vicente Maldonado","Puerto Quito","Quito","Rumi�ahui", "San Miguel de los Bancos"},
									{"Latacunga","La Man�","Pangua","Pujil�","Salcedo","Saquisil�","Sigchos"},
									{"Guaranda","Caluma","Chillanes","Chimbo","Echeand�a","Las Naves","San Miguel"},
									{"Ambato","Ba�os","Cevallos","Mocha","Patate","Pelileo","Quero","Santiago de P�llaro","Tisaleo"},
									{"Riobamba","Alaus�","Chambo","Chunchi","Colta","Cumand�","Guamote","Guano","Pallatanga","Penipe"},
									{"Azogues","Bibli�n","Ca�ar","D�leg","El Tambo","La Troncal","Suscal"},
									{"Chodeleg","Cuenca","El Pan","Gir�n","Guachapala","Gualaceo","Nab�n","O�a","Paute","Ponce Enriquez","Pucar�","San Fernando","Santa Isabel","Sevilla de Oro", "Sigsig"},
									{"Calvas","Catamayo","Celica","Chaguarpamba","Esp�ndola","Gonzanam�","Loja","Macr�","Olmedo","Paltas","Pindal","Puyango","Quilanga","Saraguro","Sozoranga", "Zapotillo"},
									{"Lago Agrio","Cascales","Cuyabeno","Gonzalo Pizarro","Putumayo","Shushufindi","Sucumb�os"},
									{"Tena","Archidona","Carlos Julio Arosemena Tola","El Chaco","Quijos"},
									{"Francisco de Orellana","Aguarico","La Joya de los Sachas","Loreto"},
									{"Pastaza","Arajuno","Mera","Santa Clara"},
									{"Morona","Gualaquiza","Huamboya","Lim�n Indanza","Pablo Sexto","Palora", "San Jua Bosco", "Santiago de M�ndez","Suc�a","Taisha","Tiwintza"},
									{"Zamora","Centinela del C�ndor","Chinchipe","El Pangui","Nangaritza","Palanda","Paquisha","Yacuambi","Yantzaza"},
									{"Isabela","San Cristobal","Santa Cruz"}
	};
	
	private int total = provinciaCosta.length+provinciaSierra.length+provinciaOriente.length+provinciaInsular.length;
	private String[] provinciasEcuador = new String[total];
	
	public Ecuador() {
		
	}
	public String[] list_Regiones() {
		for(int i=0; i<region.length; i++) {
			region[i].toString();
		}
		return region;
	}
	
	public String[] list_Costa() {
		for(int i=0; i<provinciaCosta.length; i++) {
			provinciaCosta[i].toString();
		}
		return provinciaCosta;
	}
	public String[] list_Sierra() {
		for(int i=0; i<provinciaSierra.length; i++) {
			provinciaSierra[i].toString();
		}
		return provinciaSierra;
	}
	public String[] list_Oriente() {
		for(int i=0; i<provinciaOriente.length; i++) {
			provinciaOriente[i].toString();
		}
		return provinciaOriente;
	}
	public String[] list_Insular() {
		for(int i=0; i<provinciaInsular.length; i++) {
			provinciaInsular[i].toString();
		}
		return provinciaInsular;
	}
	

	/*M�todo#2*/
	public String[] mostrarProvincias() {
		System.arraycopy(provinciaCosta, 0, provinciasEcuador, 0, provinciaCosta.length);
		System.arraycopy(provinciaSierra, 0, provinciasEcuador, provinciaCosta.length, provinciaSierra.length);
		System.arraycopy(provinciaOriente, 0, provinciasEcuador, (provinciaCosta.length+provinciaSierra.length), provinciaOriente.length);
		System.arraycopy(provinciaInsular, 0, provinciasEcuador, (provinciaCosta.length+provinciaSierra.length+provinciaOriente.length), provinciaInsular.length);
		return provinciasEcuador;
	}
	


}
