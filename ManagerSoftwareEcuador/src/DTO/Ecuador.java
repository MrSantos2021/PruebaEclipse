package DTO;


public class Ecuador {
	private String[] region = {"Costa", "Sierra", "Oriente", "Insular"};
	
	private String[] provinciaCosta = {"Esmeraldas", "Santo Domingo de los Tsáchilas", "Manabí", "Los Ríos", "Guayas", "Santa Elena", "El Oro"};
	private String[] provinciaSierra = {"Carchi", "Imbabura", "Pichincha", "Cotopaxi", "Bolívar", "Tungurahua", "Chimborazo", "Cañar","Azuay", "Loja"};
	private String[] provinciaOriente = {"Sucumbíos", "Napo", "Orellana", "Pastaza", "Morona Santiago", "Zamora Chinchipe"};
	private String[] provinciaInsular = {"Galápagos"};
	public String[][] cantones = {{"Atacames", "Eloy Alfaro", "Esmeraldas", "Muisne", "Quinindé", "Rioverde", "San Lorenzo"},
									{"La Concordia", "Santo Domingo"},
									{"Portoviejo", "24 de Mayo", "Bolívar", "Chone", "El Carmen", "Flavio Alfaro", "Jama","Jaramijó", "Jipijapa", "Junín","Manta", "Montecristi", "Olmedo", "Paján", "Pedernales", "Pichincha", "Puerto López", "Rocafuerte", "San Vicente", "Santa Ana", "Sucre", "Tosagua"},
									{"Babahoyo","Baba","San Jacinto de Buena Fé","Mocache","Montalvo","Palenque","Puebloviejo", "Quevedo","Quinsaloma","Urdaneta","Valencia", "Ventanas", "Vinces"},
									{"Guayaquil", "Alfredo Baquerizo Moreno", "Balao", "Balzar", "Colimes", "Daule", "Durán", "El Empalme", "El Triunfo", "General Antonio Elizalde", "Isidro Ayora", "Lomas de Sargentillo", "Marcelino Maridueña", "Milagro", "Naranjal", "Naranjito", "Nobol", "Palestina","Pedro Carbo", "Playas", "Salitre", "Samborondón","Santa Lucía","Simón  Bolivar", "Yaguachi"},
									{"Santa Elena","La Libertad","Salinas"},
									{"Machala", "Arenillas", "Atahualpa", "Balsas", "Chilla", "El Guabo", "Huaquillas", "Las Lajas", "Marcabelí", "Pasaje", "Piñas", "Portovelo", "Santa Rosa", "Zaruma"},
									{"Tulcán","Bolivar","Espejo","Mira","Montúfar","San Pedro de Huaca"},
									{"Ibarra", "Antonio Ante", "Cotacahi", "Otavalo", "Pimampiro","San Miguel de Urcuquí"},
									{"Cayambe", "Mejía", "Pedro Moncayo","Pedro Vicente Maldonado","Puerto Quito","Quito","Rumiñahui", "San Miguel de los Bancos"},
									{"Latacunga","La Maná","Pangua","Pujilí","Salcedo","Saquisilí","Sigchos"},
									{"Guaranda","Caluma","Chillanes","Chimbo","Echeandía","Las Naves","San Miguel"},
									{"Ambato","Baños","Cevallos","Mocha","Patate","Pelileo","Quero","Santiago de Píllaro","Tisaleo"},
									{"Riobamba","Alausí","Chambo","Chunchi","Colta","Cumandá","Guamote","Guano","Pallatanga","Penipe"},
									{"Azogues","Biblián","Cañar","Déleg","El Tambo","La Troncal","Suscal"},
									{"Chodeleg","Cuenca","El Pan","Girón","Guachapala","Gualaceo","Nabón","Oña","Paute","Ponce Enriquez","Pucará","San Fernando","Santa Isabel","Sevilla de Oro", "Sigsig"},
									{"Calvas","Catamayo","Celica","Chaguarpamba","Espíndola","Gonzanamá","Loja","Macrá","Olmedo","Paltas","Pindal","Puyango","Quilanga","Saraguro","Sozoranga", "Zapotillo"},
									{"Lago Agrio","Cascales","Cuyabeno","Gonzalo Pizarro","Putumayo","Shushufindi","Sucumbíos"},
									{"Tena","Archidona","Carlos Julio Arosemena Tola","El Chaco","Quijos"},
									{"Francisco de Orellana","Aguarico","La Joya de los Sachas","Loreto"},
									{"Pastaza","Arajuno","Mera","Santa Clara"},
									{"Morona","Gualaquiza","Huamboya","Limón Indanza","Pablo Sexto","Palora", "San Jua Bosco", "Santiago de Méndez","Sucúa","Taisha","Tiwintza"},
									{"Zamora","Centinela del Cóndor","Chinchipe","El Pangui","Nangaritza","Palanda","Paquisha","Yacuambi","Yantzaza"},
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
	

	/*Método#2*/
	public String[] mostrarProvincias() {
		System.arraycopy(provinciaCosta, 0, provinciasEcuador, 0, provinciaCosta.length);
		System.arraycopy(provinciaSierra, 0, provinciasEcuador, provinciaCosta.length, provinciaSierra.length);
		System.arraycopy(provinciaOriente, 0, provinciasEcuador, (provinciaCosta.length+provinciaSierra.length), provinciaOriente.length);
		System.arraycopy(provinciaInsular, 0, provinciasEcuador, (provinciaCosta.length+provinciaSierra.length+provinciaOriente.length), provinciaInsular.length);
		return provinciasEcuador;
	}
	


}
